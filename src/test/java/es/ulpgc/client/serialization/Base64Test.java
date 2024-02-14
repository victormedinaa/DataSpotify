package es.ulpgc.client.serialization;

import org.junit.Test;

import static org.junit.Assert.*;

public class Base64Test {

    private static final String BASE64_PATTERN = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$";

    private final String text = "¡¡Hello Base64!!\n\t * --> This is a test with id := 12345.,_&% 09876??; :)";

    @Test
    public void should_encode_correctly() {
        String base64 = Base64.encode(text);
        assertNotNull(base64);
        assertFalse(base64.isBlank());
        assertTrue("Base64 is not well formed", base64.matches(BASE64_PATTERN));
    }

    @Test
    public void should_decode_correctly() {
        String base64 = Base64.encode(text);
        String decoded = Base64.decode(base64);
        assertEquals(text, decoded);
    }
}