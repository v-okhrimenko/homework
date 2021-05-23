package ua.ithillel.task1;

public class Runner {

    public Runner() {
    }

    public void run() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};

        int sumInt = MyTestMethod.calcNum(intArray, 2);
        double sumDouble = MyTestMethod.calcNum(doubleArray, 5.2);
        System.out.println("calcNum Integer: " + sumInt +
                "\ncalcNum Double: " + sumDouble);

        System.out.println();
        int calcResultInteger = MyTestMethod.calcSum(intArray, 7).intValue();
        double calcResultDouble = MyTestMethod.calcSum(doubleArray, 8.8).doubleValue();
        System.out.println("calcSum Integer: " + calcResultInteger +
                "\ncalcSum Double: " + calcResultDouble);
    }
}