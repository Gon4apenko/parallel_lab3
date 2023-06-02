package task2;


import java.util.Random;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;
    private int iterations;
    private int maxNumber;

    public Producer(Drop drop, int iterations, int maxNumber) {
        this.drop = drop;
        this.iterations = iterations;
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < iterations; i++) {
            int number = random.nextInt(maxNumber);
            drop.put(number);
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.put(-1); // Special value to indicate completion
    }
}
