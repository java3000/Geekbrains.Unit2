package document;

import java.io.Serializable;

public class AsiaDocument implements Document {
    @Override
    public void doCheck() {
        System.out.println("Asia Contract.");
        System.out.println("Checking...");
        System.out.println("Status ASIA OK.");
    }
}
