package task2;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        int iterations = 100;
        int maxNumber = 1000;

        Thread producerThread = new Thread(new Producer(drop, iterations, maxNumber));
        Thread consumerThread = new Thread(new Consumer(drop));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
