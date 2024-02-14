package es.ulpgc.client.interoperability.spotify;

public class ApiException extends Exception {

    public ApiException(int code, String body) {
        super(code + ":"+ body);
    }
}
