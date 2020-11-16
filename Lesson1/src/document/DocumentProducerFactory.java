package document;

public class DocumentProducerFactory {
    private DocumentProducerFactory() {}

    public static DocumentProducer[] create() {
        return new DocumentProducer[] {
                new AsiaDocumentProducer(),
                new EuropeDocumentProducer()
        };
    }
}
