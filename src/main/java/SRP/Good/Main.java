package SRP.Good;

import SRP.Good.Outputs.OutPutToFile;
import SRP.Good.Outputs.OutputToConsole;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(1, 3);

        OutputToConsole print = new OutputToConsole();
        print.output(calculator.getResult());

        OutPutToFile toFile = new OutPutToFile();
        toFile.output(calculator.getResult());
    }
}
