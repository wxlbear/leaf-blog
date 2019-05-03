package xyz.bbear.common.learn.concurrency;

/**
 * IndividualMultiplierTask 单个元素的多线程.
 *
 * @author xiongliu wu 2019-05-01 16:20
 */
public class IndividualMultiplierTask implements Runnable {
  private final double[][] result;
  private final double[][] matrixA;
  private final double[][] matrixB;
  private final int row;
  private final int column;

  public IndividualMultiplierTask(
      double[][] result, double[][] matrixA, double[][] matrixB, int row, int column) {
    this.result = result;
    this.matrixA = matrixA;
    this.matrixB = matrixB;
    this.row = row;
    this.column = column;
  }

  @Override
  public void run() {
    result[row][column] = 0;
    for (int k = 0; k < matrixA[row].length; k++) {
      result[row][column] += matrixA[row][k] * matrixB[k][column];
    }
  }
}
