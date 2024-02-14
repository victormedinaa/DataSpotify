package es.ulpgc.client.serialization;

public class Base64 {

    public static String encode(String str) {
        return java.util.Base64.getEncoder().encodeToString(str.getBytes());

    }

    public static String decode(String base64) {
        return new String(java.util.Base64.getDecoder().decode(base64));

    }
}
