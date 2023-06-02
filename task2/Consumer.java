package task2;

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        int number;
        int messageCount = 1;

        while ((number = drop.take()) != -1) {
            String message = "Message#" + messageCount + " - " + number;
            System.out.println("Received: " + message);
            messageCount++;
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
