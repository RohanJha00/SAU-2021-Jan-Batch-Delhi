import java.util.*;

class ConsumerThread extends Thread {
  Queue<Integer> queue;

  public ConsumerThread(Queue<Integer> queue){
    this.queue = queue;
  }

  public void run() {
    while (true) {
      synchronized (queue) {
        while (queue.size() == 0) {
          System.out.println("Waiting for producer to produce.");
          try {
            queue.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        int element = queue.poll();
        System.out.println("Consumed: " + element);
        queue.notifyAll();
      }
    }
  }
}