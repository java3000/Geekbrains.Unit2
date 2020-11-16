package document;

public class AsiaDocumentProducer implements DocumentProducer {
    @Override
    public Document[] createBatch() {
        return new Document[]{
                new ToyotaContract(),
                new AsiaDocument(),
                new ToyotaContract()
        };
    }
}
