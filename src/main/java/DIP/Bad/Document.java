package DIP.Bad;

public class Document {
    String txt;
    OutToPrinter outToPrinter;
    OutToConsole outToConsole;

    public Document(String txt) {
        this.txt = txt;
        outToPrinter = new OutToPrinter();
        outToConsole = new OutToConsole();
    }

    public void outToConsole() {
        outToConsole.setTxt(txt);
        outToConsole.outToConsole();
    }

    public void outToPrinter() {
        outToPrinter.setTxt(txt);
        outToPrinter.outToPrinter();
    }
}
