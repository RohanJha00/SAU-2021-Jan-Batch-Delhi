import java.util.*;

public class ProducerThread extends Thread {
  Random random = new Random();
  int MAX_SIZE;
  Queue<Integer> queue;

  public ProducerThread(Queue<Integer> queue,int size){
    this.queue = queue;
    this.MAX_SIZE = size;
  }

  public void run() {
    while (true) {
      synchronized (queue) {
        while (queue.size() == MAX_SIZE) {
          System.out.println("Waiting for consumer to consume.");
          try {
            queue.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        int i = random.nextInt(MAX_SIZE);
        System.out.println("Producer " + i);
        queue.add(i);
        queue.notifyAll();
      }
    }
  }
}
