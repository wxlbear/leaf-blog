package xyz.bbear.common.learn.concurrency;

import java.util.Random;
import xyz.bbear.common.utils.ArrayUtils;

/**
 * MatrixGenerator.
 *
 * @author xiongliu wu 2019-05-01 13:31
 */
public class MatrixGenerator {

  public static double[][] generate(int rows, int columns) {
    double[][] matrix = new double[rows][columns];
    Random random = new Random();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = random.nextDouble() * 10;
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    ArrayUtils.toString(generate(1000, 5000));
  }
}
