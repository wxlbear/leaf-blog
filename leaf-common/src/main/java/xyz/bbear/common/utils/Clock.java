package xyz.bbear.common.utils;

/**
 * Clock.
 *
 * @author xiongliu wu 2019-05-01 16:08
 */
public class Clock {
  private final long start;

  public Clock() {
    start = System.currentTimeMillis();
  }

  public void stop() {
    System.out.println("cost: " + (System.currentTimeMillis() - this.start));
  }
}
