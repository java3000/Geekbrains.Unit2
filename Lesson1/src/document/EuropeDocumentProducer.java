package document;

public class EuropeDocumentProducer implements DocumentProducer {
    @Override
    public Document[] createBatch() {
        return new Document[] {
                new EuropeDocument(),
                new EuropeDocument(),
                new EuropeDocument(),
        };
    }
}
