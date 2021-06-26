package ua.ithillel.work2;

public class Runner {

//    private Semaphore semaphore;
//    private DiningHall d;
//
//    public void run() {
//        semaphore = new Semaphore(10, true);
//        d = new DiningHall();

//        Runnable student = () -> {
//            try {
//                synchronized (d) {
//                    semaphore.acquire();
//                    d.makePizza();
//                    System.out.println("ПИЦЦ ГОТОВО: " + DiningHall.pizzaNum);
//                    d.servePizza();
//                    System.out.println("ПИЦЦ ОСТАЛОСЬ: " + DiningHall.pizzaNum);
//                    semaphore.release();
//
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//        for (int i = 0; i < 20; i++) {
//            new Thread(student).start();
//        }
//    }
//}

    private DiningHall d;
    private int count;

    public void run() {
        d = new DiningHall();

        Runnable pizza = this::makePizza;
        new Thread(pizza).start();

        studentsGo();
    }

    public void studentsGo() {
        for (int i = 0; i < 20; i++) {
            Runnable students = () -> {
                synchronized (d) {
                    while (DiningHall.pizzaNum < 1) {
                        try {
                            d.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    d.servePizza();
                    count++;
                    Thread.currentThread().interrupt();
                    d.notifyAll();
                }
            };
            new Thread(students).start();
        }
    }

    public void makePizza() {

        while (count < 20) synchronized (d) {
            d.makePizza();
            d.notifyAll();
            while (DiningHall.pizzaNum > 9) {
                try {
                    d.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Thread.currentThread().interrupt();
    }
}
