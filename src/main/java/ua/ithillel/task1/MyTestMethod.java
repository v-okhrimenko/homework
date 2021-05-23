package ua.ithillel.task1;

public class MyTestMethod {

    public static <T extends Comparable<? super T>> int calcNum(T[] list, T value) {
        int counter = 0;
        for (T t : list) {
            if (t.compareTo(value) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public static <N extends Number> Number calcSum(N[] list, N value) {
        Number summa = 0.0;
        for (N number : list) {
            if (number.doubleValue() > value.doubleValue()) {
                summa = summa.doubleValue() + number.doubleValue();
            }
        }
        return summa;
    }
}