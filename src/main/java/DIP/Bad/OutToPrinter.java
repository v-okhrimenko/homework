package DIP.Bad;

public class OutToPrinter {
    private String txt;

    public OutToPrinter() {
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void outToPrinter() {
        System.out.println("out to printer ... " + txt);
    }
}
