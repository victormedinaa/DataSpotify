package es.ulpgc.client.cqrs;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static es.ulpgc.client.cqrs.EventSystem.BROKER_URL;

public class EventSubscriberManager {


    private final Connection connection;
    private final Session session;
    private final Map<String, List<MessageConsumer>> consumers; //se pone lista porque para un mismo topic, pueden haber varios consumers.

    public EventSubscriberManager() {

        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(BROKER_URL);
            factory.setTrustAllPackages(true);
            this.connection = factory.createConnection();
            connection.start();
            this.session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            this.consumers = new HashMap<>();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
    public void register(String eventName,EventSubscriber subscriber) {     //registrar mis consumers,necesitamos el nombre del topic,y la interfaz(consumers)
        if(subscriber ==null) return;                                           //que recibe el mensaje
        try {
            Topic topic =session.createTopic(eventName);
            MessageConsumer consumer = session.createConsumer(topic);
            consumer.setMessageListener(subscriber); //esta linea hace que cuando le llegue un mensaje al producer, ejecute el subscriber

            List<MessageConsumer> consumerList = consumers.computeIfAbsent(eventName, k -> new ArrayList<>());
            consumerList.add(consumer); //cuando llegue el mensaje, se añade a la lista de consumers,despues de haber
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
    public void close() {
        try {
            for(List<MessageConsumer> consumerList : consumers.values())
                for(MessageConsumer consumer : consumerList)
                    consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
}
