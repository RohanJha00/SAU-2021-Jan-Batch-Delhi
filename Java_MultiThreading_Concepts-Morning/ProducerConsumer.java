import java.util.*;

public class ProducerConsumer {

  public static void main(String[] args) {

    Queue<Integer> queue = new LinkedList<>();
    int MAX_SIZE = 5;

    ProducerThread producer = new ProducerThread(queue,MAX_SIZE);
    ConsumerThread consumer = new ConsumerThread(queue);
    producer.start();
    consumer.start();
  }

}