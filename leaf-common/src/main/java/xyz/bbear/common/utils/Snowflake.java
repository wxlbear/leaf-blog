package xyz.bbear.common.utils;

/**
 * Snowflake.
 *
 * @author xiongliu wu 2019-04-18 18:54
 */
public class Snowflake {

  private final long twepoch = 1288834974657L;
  private final long workerIdBits = 5L;
  private final long datacenterIdBits = 5L;
  private final long maxWorkerId = 31L;
  private final long maxDatacenterId = 31L;
  private final long sequenceBits = 10L;
  private final long workerIdShift;
  private final long datacenterIdShift;
  private final long timestampLeftShift;
  private final long sequenceMask;
  private long workerId = 1;
  private long datacenterId = 2;
  private long sequence;
  private long lastTimestamp;

  /** snowflake constructor. */
  public Snowflake() {
    this.getClass();
    this.workerIdShift = 10L - 2L;
    this.getClass();
    this.datacenterIdShift = 10L + 5L - 2L;
    this.getClass();
    this.timestampLeftShift = 10L + 5L + 5L - 2L;
    this.sequenceMask = 1023L;
    this.sequence = 0L;
    this.lastTimestamp = -1L;
    this.getClass();
    Object[] var10003;
    if (workerId <= 31L && workerId >= 0L) {
      this.getClass();
      if (datacenterId <= 31L && datacenterId >= 0L) {
        this.workerId = workerId;
        this.datacenterId = datacenterId;
      } else {
        var10003 = new Object[1];
        this.getClass();
        var10003[0] = 31L;
        throw new IllegalArgumentException(
            String.format("datacenter Id can't be greater than {} or less than 0", var10003));
      }
    } else {
      var10003 = new Object[1];
      this.getClass();
      var10003[0] = 31L;
      throw new IllegalArgumentException(
          String.format("worker Id can't be greater than {} or less than 0", var10003));
    }
  }

  /**
   * nextId.
   *
   * @return nextId
   */
  public synchronized long nextId() {
    long timestamp = this.genTime();
    if (timestamp < this.lastTimestamp) {
      throw new IllegalStateException(
          String.format(
              "Clock moved backwards. Refusing to generate id for {}ms",
              this.lastTimestamp - timestamp));
    } else {
      if (this.lastTimestamp == timestamp) {
        long var10001 = this.sequence + 1L;
        this.getClass();
        this.sequence = var10001 & 1023L;
        if (this.sequence == 0L) {
          timestamp = this.tilNextMillis(this.lastTimestamp);
        }
      } else {
        this.sequence = 0L;
      }

      this.lastTimestamp = timestamp;
      return timestamp - 1288834974657L << (int) this.timestampLeftShift
          | this.datacenterId << (int) this.datacenterIdShift
          | this.workerId << (int) this.workerIdShift
          | this.sequence;
    }
  }

  /**
   * next millis.
   *
   * @param lastTimestamp lastTimestamp
   * @return long
   */
  private long tilNextMillis(long lastTimestamp) {
    long timestamp;
    for (timestamp = this.genTime(); timestamp <= lastTimestamp; timestamp = this.genTime()) {}

    return timestamp;
  }

  /**
   * gen time.
   *
   * @return currentTimeMillis
   */
  private long genTime() {
    return System.currentTimeMillis();
  }
}
