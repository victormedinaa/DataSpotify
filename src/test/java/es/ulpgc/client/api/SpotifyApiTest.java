//package es.ulpgc.spotify.api;
//
//import es.ulpgc.spotify.api.responses.SearchResult;
//import es.ulpgc.spotify.api.responses.SearchType;
//import es.ulpgc.spotify.model.Artist;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//
//public class SpotifyApiTest {
//
//    private static final String ED_SHEERAN_ID = "6eUKZXaKkcviH0Ku9w2n3V";
//
//    static {
//        SpotifyApi.init();
//    }
//
//    @Test
//    public void login() throws Exception {
//        Authorization.Token token = SpotifyApi.POST.token();
//
//        assertNotNull(token);
//        assertEquals("Bearer", token.token_type());
//        assertTrue(token.expires_in() > 0);
//    }
//
//    @Test
//    public void search() throws Exception {
//        SearchResult result = SpotifyApi.GET.search("ed", SearchType.ARTIST);
//
//        assertNotNull(result);
//        assertNotNull(result.artists);
//        assertNotNull(result.artists.items);
//        assertFalse(result.artists.items.isEmpty());
//
//        assertTrue(result.artists.items.stream().anyMatch(a -> a.id.equals(ED_SHEERAN_ID)));
//    }
//
//    @Test
//    public void artist() throws Exception {
//        Artist artist = SpotifyApi.GET.artist(ED_SHEERAN_ID);
//
//        assertNotNull(artist);
//        assertEquals(ED_SHEERAN_ID, artist.id);
//    }
//}
