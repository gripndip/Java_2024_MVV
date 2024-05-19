package lr6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Work6 {
    private static AtomicLong sum = new AtomicLong(0);

    public static long calculateSum(int[] array) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int chunkSize = array.length / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? array.length : (i + 1) * chunkSize;
            executor.execute(new SumCalculator(array, startIndex, endIndex));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sum.get();
    }

    private static class SumCalculator implements Runnable {
        private int[] array;
        private int startIndex;
        private int endIndex;

        public SumCalculator(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            long partialSum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                partialSum += array[i];
            }
            sum.addAndGet(partialSum);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long totalSum = calculateSum(array);
        System.out.println("Total sum: " + totalSum);
    }
}
