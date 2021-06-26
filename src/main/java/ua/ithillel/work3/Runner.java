package ua.ithillel.work3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {

    private final Map<Integer, Integer> collection = new HashMap<>();
    private final Map<Integer, Integer> collectionHashMap = new HashMap<>();
    private final ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    public void run() {

        System.out.println("Map: ");
        Runnable runnableAdd = () -> {
            long start = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                synchronized (collection) {
                }
                collection.put(i, i);
            }
            long end = System.nanoTime();
            System.out.println("MAP WRITE: " + (end - start));
            Thread.currentThread().interrupt();
        };
        Runnable runnableGet = () -> {
            long start = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                collection.get(i);
            }
            long end = System.nanoTime();
//            System.out.println(collection.values() + " MAP VALUES " + Thread.currentThread().getName());
            System.out.println("MAP READ: " + (end - start));
            Thread.currentThread().interrupt();
        };

        new Thread(runnableAdd).start();
        new Thread(runnableGet).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nConcurrentHashMap: ");
        Runnable writeConcurrentHashMap = () -> {
            long start = System.nanoTime();
            for (int j = 0; j < 10; j++) {
                int[] counterJ = new int[1];
                counterJ[0] = j;
                concurrentHashMap.put(counterJ[0], counterJ[0]);
            }
            long end = System.nanoTime();
            System.out.println("concurrentHashMap WRITE: " + (end - start) + " " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        };
        Runnable readConcurrentHashMap = () -> {
            long start = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                int[] counterY = new int[1];
                counterY[0] = i;
                concurrentHashMap.get(counterY[0]);
            }
            long end = System.nanoTime();
//            System.out.println(collection.values() + " concurrentHashMap VALUES " + Thread.currentThread().getName());
            System.out.println("concurrentHashMap READ: " + (end - start) + " " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        };

        for (int i = 0; i < 10; i++) {
            new Thread(writeConcurrentHashMap).start();
            new Thread(readConcurrentHashMap).start();
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nHashMap 10 Threads: ");
        Runnable writeHashMap = () -> {
            long start = System.nanoTime();
            for (int j = 0; j < 10; j++) {
                int[] counterJ = new int[1];
                counterJ[0] = j;
                synchronized (collectionHashMap) {
                    collectionHashMap.put(counterJ[0], counterJ[0]);
                }
            }
            long end = System.nanoTime();
            System.out.println("HashMap WRITE: " + (end - start) + " " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        };
        Runnable readHashMap = () -> {
            long start = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                int[] counterY = new int[1];
                counterY[0] = i;
                synchronized (collectionHashMap) {
                    collectionHashMap.get(counterY[0]);
                }
            }
            long end = System.nanoTime();
//            System.out.println(collection.values() + "HashMap VALUES " + Thread.currentThread().getName());
            System.out.println("HashMap READ: " + (end - start) + " " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        };

        for (int i = 0; i < 10; i++) {
            new Thread(writeHashMap).start();
            new Thread(readHashMap).start();
        }
    }


}
