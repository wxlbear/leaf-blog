package xyz.bbear.common.utils;

import java.util.Arrays;

/**
 * ArrayUtils.
 *
 * @author xiongliu wu 2019-05-01 13:50
 */
public class ArrayUtils {

  /**
   * toString two dim array.
   *
   * @param array array
   */
  public static void toString(double[][] array) {
    for (double[] ts : array) {
      System.out.println(Arrays.toString(ts));
    }
  }
}
