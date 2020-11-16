package ext;

import document.DocumentProducer;
import document.DocumentProducerFactory;

public class ExternalDocumentManager {
    public void manage() {
        ExternalDocumentProcessor processor = new ExternalDocumentProcessor();
        DocumentProducer[] documentProducers = DocumentProducerFactory.create();
        for (DocumentProducer documentProducer : documentProducers) {
            processor.process(documentProducer.createBatch());
        }
    }
}
