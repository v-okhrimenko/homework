package DIP.Good;

public class OutToPrinter implements IOut {
    @Override
    public void out(String txt) {
        System.out.println("out to printer ... " + txt);
    }
}
