package ext;

import document.Document;

public class ExternalDocumentProcessor {
    public void process(Document[] documents) {
        for (Document document : documents) {
            document.doCheck();
            System.out.println("Document has been checked. Successfully");
        }
    }
}
