package ua.ithillel.work1;

public class Counter implements Runnable {
    private Storage storage;

    public Counter(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void add() throws InterruptedException {
        synchronized (storage) {
            for (int i = 0; i < 1000; i++) {
                while (storage.getStorageCounter() != i) {
                    storage.setHasChange(true);
                    storage.setStorageCounter(i);
                    storage.notifyAll();
                }
                storage.wait();
            }
            storage.setHasChange(false);
            storage.notifyAll();
            Thread.currentThread().interrupt();
        }
    }
}
