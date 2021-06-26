package ua.ithillel.work1;

public class Printer implements Runnable {
    private Storage storage;

    public Printer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            printToConsole();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printToConsole() throws InterruptedException {
        synchronized (storage) {
            while (storage.isHasChange()) {
                System.out.println(storage.getStorageCounter());
                storage.notifyAll();
                storage.wait();
            }
            Thread.currentThread().interrupt();
        }
    }
}
