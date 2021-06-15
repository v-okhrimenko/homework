package ua.ithillel.work1;

public class MyTimeBomb_1 extends Thread {
    @Override
    public void run() {
        System.out.print("MyTimeBomb_1 (" + Thread.currentThread().getName() + "): ");
        for (int i = 10; i >= 0; i--) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i);
            animate();
            if (i == 0) {
                System.out.println("Boom!!!");
            }
        }
    }

    private void animate() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.print(".");
                Thread.sleep(125);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
