package xyz.bbear.leaf.crawler.bear;

/**
 * Crawler.
 *
 * @author xiongliu wu 2019-05-08 14:37
 */
public class Crawler implements Runnable {

  private volatile boolean run;

  public Crawler() {
    on();
  }

  public void on() {
    this.run = true;
  }

  public void off() {
    this.run = false;
  }

  @Override
  public void run() {
    while (this.run) {
      System.out.println("running");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Crawler crawler = new Crawler();
    for (int i = 0; i < 10; i++) {
      new Thread(crawler).start();
    }
    Thread.sleep(5000);
    crawler.off();
  }
}
