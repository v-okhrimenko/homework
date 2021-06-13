package DIP.Bad;

public class OutToConsole {
    String txt;

    public OutToConsole() {
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void outToConsole() {
        System.out.println("out to console ... " + txt);
    }
}
