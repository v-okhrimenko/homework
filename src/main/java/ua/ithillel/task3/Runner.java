package ua.ithillel.task3;

import java.util.Arrays;

public class Runner {

    public void run() {

        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String[] strings = {"a", "b", "c", "d", "e", "f", "g"};

        MyMixer<Integer> integersMixer = new MyMixer<>(integers);
        MyMixer<String> stringsMixer = new MyMixer<>(strings);

        System.out.println("Integer array: " + Arrays.toString(integersMixer.shuffle()));
        System.out.println("String array: " + Arrays.toString(stringsMixer.shuffle()));
    }
}