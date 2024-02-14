package es.ulpgc.client.cqrs.events;
import java.io.Serializable;
import java.time.Instant;
public interface Event extends Serializable {    //los objetos de esta clase se pueden serializar
    Instant ts();
}
