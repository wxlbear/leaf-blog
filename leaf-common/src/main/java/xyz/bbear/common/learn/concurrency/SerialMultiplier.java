package xyz.bbear.common.learn.concurrency;

import xyz.bbear.common.utils.Clock;

/**
 * SerialMultiplier 矩阵串行计算.
 *
 * @author xiongliu wu 2019-05-01 14:34
 */
public class SerialMultiplier {

  /**
   * 两个矩阵A[m][n] B[n][p] 相乘得到 C[m][p].
   *
   * @param matrixA
   * @param matrixB
   */
  public static double[][] multiply(double[][] matrixA, double[][] matrixB) {
    int aRows = matrixA.length;
    int aColumns = matrixA[0].length;
    int bRows = matrixB.length;
    int bColumns = matrixB[0].length;

    double[][] storeMatrix = new double[aRows][bColumns];

    if (aColumns != bRows) {
      throw new RuntimeException("matrix multiply exception");
    }

    for (int i = 0; i < aRows; i++) {
      for (int j = 0; j < bColumns; j++) {
        storeMatrix[i][j] = 0;
        for (int k = 0; k < aColumns; k++) {
          storeMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
        }
      }
    }

    return storeMatrix;
  }

  /**
   * 矩阵的乘法 设A为m * p的矩阵，B为p * n 的矩阵，那么称 m*n 的矩阵C为矩阵A与B的乘积，记作C=AB，其中矩阵C中的第i行第j列元素可以表示为： (AB)ij =
   * ai1b1j + ai2b2j + ... + aipbpj
   */
  public static void main(String[] args) {
    double[][] matrixA = MatrixGenerator.generate(1000, 2000);
    double[][] matrixB = MatrixGenerator.generate(2000, 4000);

    Clock clock = new Clock();
    multiply(matrixA, matrixB);
    clock.stop();
  }
}
