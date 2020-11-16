package document;

public class EuropeDocument implements Document {
    @Override
    public void doCheck() {
        System.out.println("Europe Contract.");
        System.out.println("Checking...");
        System.out.println("Status OK.");
    }
}
