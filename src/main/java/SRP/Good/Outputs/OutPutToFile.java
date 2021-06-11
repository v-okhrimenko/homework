package SRP.Good.Outputs;

import SRP.Good.Output;

public class OutPutToFile implements Output {
    @Override
    public void output(int result) {
        System.out.println("Save result (" + result + ") to file...");
    }
}
