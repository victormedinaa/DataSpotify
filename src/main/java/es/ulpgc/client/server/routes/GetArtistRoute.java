package es.ulpgc.client.server.routes;
import es.ulpgc.client.interoperability.spotify.ApiException;
import es.ulpgc.client.interoperability.spotify.view_model.Artist;
import es.ulpgc.client.interoperability.spotify.SpotifyApi;
import es.ulpgc.client.util.Html;
import spark.Request;
import spark.Response;
import spark.Route;

public class GetArtistRoute implements Route { //la aplicación nos pide un artista y nosotros llamamos a esta clase que nos crea la ruta,posteriormente renderizada.
    @Override
    public String handle(Request request, Response response) throws Exception { //request y response de http
        try {
            String artistId = request.params("artistId");
            Artist artist = SpotifyApi.artist(artistId);

            return Html.begin() //construyendo una string
                    + Html.tag("h1", artist.name)
                    + Html.tag("img", "", "src=" + artist.images.get(0).url)
                    + Html.end();
        } catch (ApiException e) {


            return Html.begin()
                    +Html.tag("h1", e.getMessage())
                    + Html.end();
        }


    }
}
