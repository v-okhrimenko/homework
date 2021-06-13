package DIP.Good;

public class Document {
    private String txt;
    private IOut iOut;

    public Document(String txt) {
        this.txt = txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setIOut(IOut iOut) {
        this.iOut = iOut;
    }

    public void out() {
        iOut.out(txt);
    }
}
