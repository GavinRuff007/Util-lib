import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class ECDSAUtilTest {

    @Test
    public void testGenerateKeyPair() throws Exception {
        KeyPair keyPair = ECDSAUtil.generateKeyPair();
        assertNotNull(keyPair);
        assertNotNull(keyPair.getPrivate());
        assertNotNull(keyPair.getPublic());
    }

    @Test
    public void testSignAndVerify() throws Exception {
        KeyPair keyPair = ECDSAUtil.generateKeyPair();
        String data = "Hello, ECDSA!";
        String signature = ECDSAUtil.sign(data, keyPair.getPrivate());

        assertTrue(ECDSAUtil.verify(data, signature, keyPair.getPublic()));
    }

    @Test
    public void testGetPublicKeyAndPrivateKey() throws Exception {
        KeyPair keyPair = ECDSAUtil.generateKeyPair();

        String encodedPublicKey = ECDSAUtil.encodePublicKey(keyPair.getPublic());
        String encodedPrivateKey = ECDSAUtil.encodePrivateKey(keyPair.getPrivate());

        PublicKey decodedPublicKey = ECDSAUtil.getPublicKey(Base64.getDecoder().decode(encodedPublicKey));
        PrivateKey decodedPrivateKey = ECDSAUtil.getPrivateKey(Base64.getDecoder().decode(encodedPrivateKey));

        assertEquals(keyPair.getPublic(), decodedPublicKey);
        assertEquals(keyPair.getPrivate(), decodedPrivateKey);
    }
}
