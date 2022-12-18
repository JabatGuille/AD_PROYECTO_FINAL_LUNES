package ClasesCustom;

import javax.crypto.SecretKey;
import java.security.PrivateKey;
import java.security.PublicKey;

public final class Singleton {
    private static Singleton instance;
    public String codigo_proveedor;
    public String codigo_pieza;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
