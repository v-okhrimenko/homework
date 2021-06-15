package ua.ithillel.work2;

public class Runner {

    public void run() throws InterruptedException {

        MySumCount_1 mySumCount_1 = new MySumCount_1();
        mySumCount_1.setStartIndex(3);
        mySumCount_1.setStopIndex(76);
        mySumCount_1.setMyArray(generateRandomList());

        MySumCount_2 mySumCount_2 = new MySumCount_2();
        mySumCount_2.setStartIndex(0);
        mySumCount_2.setStopIndex(99);
        mySumCount_2.setMyArray(generateRandomList());

        Thread msc2 = new Thread(mySumCount_2);

        mySumCount_1.start();
        mySumCount_1.join();

        msc2.start();
        msc2.join();
    }

    public int[] generateRandomList() {
        int[] list = new int[100];
        for (int i = 0; i < 100; i++) {
            int d = (int) (Math.random() * 1001);
            list[i] = d;
        }
        return list;
    }
}
