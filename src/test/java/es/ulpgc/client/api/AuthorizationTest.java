package es.ulpgc.client.api;

import es.ulpgc.client.interoperability.spotify.Authorization;
import es.ulpgc.client.serialization.Base64;
import org.junit.Test;

import static es.ulpgc.client.interoperability.spotify.Authorization.CLIENT_ID;
import static es.ulpgc.client.interoperability.spotify.Authorization.CLIENT_SECRET;
import static org.junit.Assert.*;

public class AuthorizationTest {

    @Test
    public void should_return_authorization_base64() {
        String auth = Authorization.get();

        assertNotNull("Authorization string is null", auth);

        String authDecoded = Base64.decode(auth);
        String[] authComponents = authDecoded.split(":", -1);

        assertEquals("Authorization is not well formed", 2, authComponents.length);

        String clientId = authComponents[0];
        String clientSecret = authComponents[1];

        assertFalse( "clientId is empty", clientId.isBlank());
        assertEquals( "Client ID is not valid", CLIENT_ID, clientId);

        assertFalse( "clientSecret is empty", clientSecret.isBlank());
        assertEquals( "Client secret is not valid", CLIENT_SECRET, clientSecret);
    }
}