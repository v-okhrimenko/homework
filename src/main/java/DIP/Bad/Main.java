package DIP.Bad;

public class Main {
    public static void main(String[] args) {
        Document document = new Document("Hello world");
        document.outToPrinter();
        document.outToConsole();
    }
}
