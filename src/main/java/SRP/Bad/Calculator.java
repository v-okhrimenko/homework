package SRP.Bad;

public class Calculator {
    private int result;
    private int x;
    private int y;

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getResult() {
        this.result = this.x + this.y;
        return result;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void outputResultToConsole() {
        System.out.println("Result: " + getResult());
    }

    public void outputResultToFile() {
        System.out.println(getResult() + " ...save to file...");
    }
}
