package es.ulpgc.client.interoperability.spotify;

import es.ulpgc.client.serialization.Base64;

public class Authorization {

    public static final String CLIENT_ID = "your_client";
    public static final String CLIENT_SECRET = "your_secret";

    public static String get() {
        return Base64.encode(CLIENT_ID+":"+ CLIENT_SECRET);




    }
}
