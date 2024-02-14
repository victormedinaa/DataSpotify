package es.ulpgc.client.cqrs;

import es.ulpgc.client.cqrs.events.VisitPageEvent;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

public class EventSystem { //event publisher y eventSubscriberManager las vamos a tener instaciadas en esta clase
    public static final String BROKER_URL = "tcp://localhost:61616";
    private static EventPublisher publisher;
    private static EventSubscriberManager subscriberManager;
    //Runtime.getRunTime().addShutdownHook(new Thread(EventSystem::shutdown));



    public static void main(String[] args) {
        init();

        subscriberManager.register(VisitPageEvent.class.getSimpleName(), message -> {
            try {
                ObjectMessage objectMessage = (ObjectMessage) message;
                VisitPageEvent event = (VisitPageEvent) objectMessage.getObject();
                System.out.println(event.url());
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        });
        publisher.publish(new VisitPageEvent().url("OKEY"));
    }


    public static void init() {
        publisher = new EventPublisher();
        subscriberManager = new EventSubscriberManager();
        Runtime.getRuntime().addShutdownHook(new Thread(EventSystem::init));
    }

    private static void shutdown() { //cuando salgas de la maquina virtual se utiliza este método
        publisher.close();
        subscriberManager.close();
    }
}



