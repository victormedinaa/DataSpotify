package es.ulpgc.client.interoperability.spotify;

import es.ulpgc.client.serialization.Base64;

public class Authorization {

    public static final String CLIENT_ID = "9bf63676f0354ecfb8d5bfc4581cb471";
    public static final String CLIENT_SECRET = "3b444ebbe28f40d4af518078bbc50689";

    public static String get() {
        return Base64.encode(CLIENT_ID+":"+ CLIENT_SECRET);




    }
}
