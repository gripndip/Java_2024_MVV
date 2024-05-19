package lr6;

public class Work5 {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 7, 4, 6, 3, 8};
        int maxElement = MaxElementFinder.findMaxElement(array);
        System.out.println("Maximum element: " + maxElement);
    }
}

class MaxElementFinder {
    private static int maxElement = Integer.MIN_VALUE;

    public static int findMaxElement(int[] array) {
        int numThreads = Math.min(Runtime.getRuntime().availableProcessors(), array.length);
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * (array.length / numThreads);
            int endIndex = (i == numThreads - 1) ? array.length : (i + 1) * (array.length / numThreads);

            threads[i] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = startIndex; j < endIndex; j++) {
                    if (array[j] > localMax) {
                        localMax = array[j];
                    }
                }
                synchronized (MaxElementFinder.class) {
                    maxElement = Math.max(maxElement, localMax);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return maxElement;
    }
}
