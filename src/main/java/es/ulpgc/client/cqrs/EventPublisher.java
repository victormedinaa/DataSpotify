package es.ulpgc.client.cqrs;
import org.apache.activemq.ActiveMQConnectionFactory;
import es.ulpgc.client.cqrs.events.VisitPageEvent;
import es.ulpgc.client.cqrs.events.Event;

import java.util.HashMap;
import javax.jms.*;
import java.util.Map;

import static es.ulpgc.client.cqrs.EventSystem.BROKER_URL;

public class EventPublisher {
    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();
        publisher.publish(new VisitPageEvent());
        publisher.close();
    }

    private final Connection connection;        //al broker
    private final Session session;                  //al broker
    private final Map<String,MessageProducer> producers;    //creamos un mapa que por cada tipo de topic,tendriamos nuestro producto
    public EventPublisher() {

        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(BROKER_URL);

            factory.setTrustAllPackages(true);
            this.connection = factory.createConnection(); //conexión
            connection.start();
                                                                                                            //con esto ya tendriamos inicializado nuestro eventpublisher
            this.session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE); //sesión
            this.producers =new HashMap<>(); //inicializa el mapa
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
    public void publish(Event event) {
        if (event == null) return;
        try {

            String eventName =event.getClass().getSimpleName();

            MessageProducer producer = producerOf(eventName); //publica los mensajes al destino

            ObjectMessage message = session.createObjectMessage(event); //mandar el mensaje(evento serializado) por el producer
            producer.send(message);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
    private MessageProducer producerOf(String eventName) { //creamos este método para que nuestro producer  este contenido en el mapa.
        if(producers.containsKey(eventName)) return producers.get(eventName); //si ya esta creado el "producer", se devuelve

        try { //y si no esta creado;Creamos el topic para ese Event Name,
            Topic topic = session.createTopic(eventName);
            MessageProducer producer = session.createProducer(topic);   //creamos despues el producer para el topic
            producers.put(eventName,producer); //lo metemos en el mapa, para no volver a crearlo
            return producer;

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
    public void close() { //las dos clases(connection y session) y producer tienen este método para CERRAR la conexión

        try {
            for(MessageProducer producer : producers.values()) producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
