package es.ulpgc.client;

import es.ulpgc.client.interoperability.spotify.ApiException;
import es.ulpgc.client.interoperability.spotify.SpotifyApi;
import es.ulpgc.client.server.Server;

public class Main {
    public static void main(String[] args) {
        try {
            SpotifyApi.init();
            Server.init();



        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}



