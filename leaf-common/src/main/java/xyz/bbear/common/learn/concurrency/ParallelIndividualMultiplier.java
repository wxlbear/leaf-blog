package xyz.bbear.common.learn.concurrency;

import java.util.ArrayList;
import java.util.List;

import xyz.bbear.common.utils.Clock;

/**
 * ParallelIndividualMultiplier.
 *
 * @author xiongliu wu 2019-05-01 16:34
 */
public class ParallelIndividualMultiplier {
  public static double[][] multiply(double[][] matrixA, double[][] matrixB) {
    int aRows = matrixA.length;
    int aColumns = matrixA[0].length;
    int bRows = matrixB.length;
    int bColumns = matrixB[0].length;

    double[][] result = new double[aRows][bColumns];
    List<Thread> list = new ArrayList<>();
    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < bColumns; j++) {
        IndividualMultiplierTask individualMultiplierTask =
            new IndividualMultiplierTask(result, matrixA, matrixB, i, j);
        Thread thread = new Thread(individualMultiplierTask);
        thread.start();
        list.add(thread);
        if (list.size() % 10 == 0) {
          wait(list);
        }
      }
    }

    return result;
  }

  /**
   * wait.
   *
   * @param threads threads
   */
  public static void wait(List<Thread> threads) {
    threads.forEach(
        item -> {
          try {
            item.join();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
    threads.clear();
  }

  public static void main(String[] args) {
    double[][] matrixA = MatrixGenerator.generate(100, 100);
    double[][] matrixB = MatrixGenerator.generate(100, 100);

    Clock clock = new Clock();
    multiply(matrixA, matrixB);
    clock.stop();
  }
}
