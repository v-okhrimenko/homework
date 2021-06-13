package DIP.Good;

public class OutToConsole implements IOut {
    @Override
    public void out(String txt) {
        System.out.println("out to console: " + txt);
    }
}
