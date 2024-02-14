package es.ulpgc.client.interoperability.spotify;
import es.ulpgc.client.interoperability.spotify.view_model.Artist;
import es.ulpgc.client.serialization.Json;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SpotifyApi {
    
    public static final int HTTP_OK = 200;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_NOT_FOUND = 404;
    public static final String API_BASE_URI = "https://api.spotify.com/v1/";

    private static HttpClient client;
    private static Token token;
    

    public static void init() throws ApiException{
         client = HttpClient.newHttpClient(); //me da un "navegador"

         requestAuthToken();

    }
    public static Artist artist(String id) throws ApiException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/artists/" + id))
                .header("Authorization","Bearer"+ token.accessToken)
                .header("Content-Type","application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200) throw new ApiException(response.statusCode(),response.body());

            return Json.fromJson(response.body(), Artist.class);

        } catch (IOException | InterruptedException e) {
            throw new ApiException(500,e.getMessage());

        }
    }



    private static void requestAuthToken() throws ApiException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .header("Authorization","Basic"+ Authorization.get())
                .header("Content-Type","application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200) throw new ApiException(response.statusCode(),response.body());

            token = Json.fromJson(response.body(), Token.class);

        } catch (IOException | InterruptedException e) {
            throw new ApiException(500,e.getMessage());

        }
    }
}
