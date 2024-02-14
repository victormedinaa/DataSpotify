package es.ulpgc.client.cqrs.events;

import java.time.Instant;

public class VisitPageEvent implements Event {
    private  Instant ts = Instant.now();
    private String url;

    @Override
    public Instant ts() {return ts;}

    public VisitPageEvent ts(Instant ts) {
        this.ts = ts;
        return this;
    }

    public String url() {
        return url;
    }

    public VisitPageEvent url(String url) {
        this.url = url; //hace referencia al objeto actual
        return this;
    }
}
