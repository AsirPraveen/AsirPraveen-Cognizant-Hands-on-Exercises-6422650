public class DocumentManagementTest {
    public static void main(String[] args) {
        try {
            DocumentFactory wordFactory = new WordDocumentFactory();
            DocumentFactory pdfFactory = new PdfDocumentFactory();
            DocumentFactory excelFactory = new ExcelDocumentFactory();

            Document wordDoc = wordFactory.createDocument();
            Document pdfDoc = pdfFactory.createDocument();
            Document excelDoc = excelFactory.createDocument();

            System.out.println("Testing Word Document:");
            testDocument(wordDoc);

            System.out.println("\nTesting PDF Document:");
            testDocument(pdfDoc);

            System.out.println("\nTesting Excel Document:");
            testDocument(excelDoc);

            System.out.println("\nTesting Invalid Factory:");
            testInvalidFactory();

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    private static void testDocument(Document doc) {
        doc.open();
        doc.save();
        doc.close();
    }

    @SuppressWarnings({"unused", "null"})
    private static void testInvalidFactory() {
        try {
            DocumentFactory invalidFactory = null;
            Document doc = invalidFactory.createDocument();
        } catch (NullPointerException e) {
            System.out.println("Caught expected NullPointerException for invalid factory");
        }
    }
}