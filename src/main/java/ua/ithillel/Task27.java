package ua.ithillel;

import ua.ithillel.task12.Runner;

public class Task27 {
    public static void main(String[] args) {

        System.out.println("Runner 1\n");
        Runner r1 = new Runner();
        r1.run();
        System.out.println("__________________________");
        System.out.println("\nRunner 2\n");

        ua.ithillel.task3.Runner r2 = new ua.ithillel.task3.Runner();
        r2.run();

        System.out.println("__________________________");
        System.out.println("\nRunner 3\n");
        ua.ithillel.task4.Runner r3 = new ua.ithillel.task4.Runner();
        r3.run();
    }
}
