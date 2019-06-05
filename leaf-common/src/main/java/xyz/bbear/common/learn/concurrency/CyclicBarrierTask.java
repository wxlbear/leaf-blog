package xyz.bbear.common.learn.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierTask.
 *
 * @author xiongliu wu 2019-06-05 20:00
 */
public class CyclicBarrierTask implements Runnable {

  private CyclicBarrier barrier;

  public CyclicBarrierTask(CyclicBarrier barrier) {
    this.barrier = barrier;
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + " is waiting");
      barrier.await();
      System.out.println(Thread.currentThread().getName() + " is released");
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier =
        new CyclicBarrier(
            3,
            () -> {
              // ...
              System.out.println(
                  Thread.currentThread().getName() + " All previous tasks are completed");
            });

    Thread t1 = new Thread(new CyclicBarrierTask(cyclicBarrier), "T1");
    Thread t2 = new Thread(new CyclicBarrierTask(cyclicBarrier), "T2");
    Thread t3 = new Thread(new CyclicBarrierTask(cyclicBarrier), "T3");

    if (!cyclicBarrier.isBroken()) {
      t1.start();
      t2.start();
      t3.start();
    }
  }
}

/**
 * 集合点，当线程做完相应任务之后，调用await()方法，表示到达了栅栏点，等待其他线程执行await(),当所有线程都到达集合点的时候，最后一个线程执行栅栏的参数动作。
 * 然后所有释放所有线程，所有线程一起开始执行后续操作。
 */
