package es.ulpgc.client.server;

import es.ulpgc.client.server.routes.GetArtistRoute;
import spark.Spark;
//localhost:8600
public class Server {
    public static void init() {
        Spark.port(8600);       //ponemos un puerto propio
        Spark.get("/artists/:artistId",new GetArtistRoute()); //rutas,y podemos usar más operaciones(POST,PUT,...)
    }
}
