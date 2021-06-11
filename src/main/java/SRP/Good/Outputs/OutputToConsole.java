package SRP.Good.Outputs;

import SRP.Good.Output;

public class OutputToConsole implements Output {
    @Override
    public void output(int result) {
        System.out.println("Result is " + result);
    }
}
