package ua.ithillel.work1;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Runner {
    public void run() throws ExecutionException, InterruptedException {
        int arraySize = 1_000_000;
        long[] array = new Random().longs(arraySize, 0, 101).toArray();

        int start = 0;
        int end = array.length;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Long> result = forkJoinPool.submit(new CalcTask(array, start, end));
        System.out.println(result.get());
        forkJoinPool.shutdown();
    }

    public long calculate(long[] array, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res += array[i];
        }
        return res;
    }

    private class CalcTask extends RecursiveTask<Long> {
        private final long[] array;
        private final int start;
        private final int end;

        public CalcTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start < 20) {
                return calculate(array, start, end);
            } else {
                int half = start + (end - start) / 2;
                CalcTask one = new CalcTask(array, start, half);
                CalcTask two = new CalcTask(array, half, end);
                invokeAll(one, two);
                return one.join() + two.join();
            }
        }
    }
}
