package ua.ithillel.work1;

public class Runner {
    public void run() throws InterruptedException {
        MyTimeBomb_1 myTimeBomb_1 = new MyTimeBomb_1();
        Thread myTimeBomb2 = new Thread(new MyTimeBomb_2());

        myTimeBomb_1.start();
        myTimeBomb_1.join();

        myTimeBomb2.start();
        myTimeBomb2.join();
    }
}
