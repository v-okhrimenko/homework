package DIP.Good;

public class Main {
    public static void main(String[] args) {

        Document document = new Document("Hello world");

        document.setIOut(new OutToConsole());
        document.out();

        document.setIOut(new OutToPrinter());
        document.out();
    }
}
