package lr6;

public class Work3 {
    public static void main(String[] args) {
        Thread evenThread = new Thread(new NumberPrinter(true), "Even Thread");
        Thread oddThread = new Thread(new NumberPrinter(false), "Odd Thread");

        evenThread.start();
        oddThread.start();
    }
}

class NumberPrinter implements Runnable {
    private boolean isEven;

    public NumberPrinter(boolean isEven) {
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int start = isEven ? 2 : 1;
        int end = 10;
        int step = 2;

        for (int i = start; i <= end; i += step) {
            System.out.println(Thread.currentThread().getName() + ": " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}