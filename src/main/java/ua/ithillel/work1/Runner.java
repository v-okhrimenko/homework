package ua.ithillel.work1;

public class Runner {

    public void run() {
        Storage storage = new Storage();

        Thread counter = new Thread(new Counter(storage));
        counter.start();

        Thread printer = new Thread(new Printer(storage));
        printer.start();


    }
}
