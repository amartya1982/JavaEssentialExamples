import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Solve the producer-consumer problem using Java's BlockingQueue.
 */
public class ProducerConsumer{
    public static void main(String[] args) {
        // Create a BlockingQueue with a fixed capacity

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Create and start Producer and Consumer threads
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Produced: " + i);
                queue.put(i); // Adds an item to the queue, waits if the queue is full
                Thread.sleep(500); // Simulate some delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted");
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.take(); // Retrieves and removes an item from the queue, waits if the queue is empty
                System.out.println("Consumed: " + item);
                Thread.sleep(1000); // Simulate some delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consumer interrupted");
        }
    }
}
