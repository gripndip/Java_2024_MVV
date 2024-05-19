package lr6;

public class Work4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new NumberPrinters(i), "Thread " + i);
            thread.start();
        }
    }
}

class NumberPrinters implements Runnable {
    private int number;

    public NumberPrinters(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + number);
    }
}
