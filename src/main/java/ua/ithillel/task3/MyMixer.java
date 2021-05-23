package ua.ithillel.task3;

import java.util.ArrayList;
import java.util.Random;

public class MyMixer<T> {

    private final T[] array;

    public MyMixer(T[] array) {
        this.array = array;
    }

    public T[] shuffle() {

        int length = array.length;
        Random rand = new Random();
        ArrayList<Integer> indexArray = new ArrayList<>();
        int tempIndex;
        while (indexArray.size() < length) {
            tempIndex = rand.nextInt(length);
            if (!indexArray.contains(tempIndex)) {
                indexArray.add(tempIndex);
            }
        }

        T temp;
        for (int i = 0; i < length; i++) {
            temp = array[i];
            array[i] = array[indexArray.get(i)];
            array[indexArray.get(i)] = temp;
        }
        return array;
    }
}