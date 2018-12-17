/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.utils;

import com.google.common.base.Strings;

/**
 * uuid generator.
 * 全局UUID
 * 毫秒级时间 47bit，机器ID 4bit，毫秒内序列12bit
 * 理论上每秒生成序列号4096000个
 */
public class UUIDUtils {

  private static IdWorker idWorker;

  public UUIDUtils(int workerId) {
    idWorker = new IdWorker(workerId);
  }

  /**
   * 返回长整型uuid，最长长度19位
   *
   * @return uuid of long type
   */
  public static long nextIdNumeric() {
    return idWorker.nextId();
  }

  /**
   * 返回字符串uuid，最长长度19位
   *
   * @return uuid of java.lang.String type
   */
  public static String nextIdString() {
    return String.valueOf(idWorker.nextId());
  }

  /**
   * 返回定长uuid
   *
   * @param length  返回字符串长度，不小于19
   * @param padding 填充字符
   * @param isRight 是否为右补齐
   * @return 填充字符串
   */
  public static String nextFixedLenId(int length, char padding, boolean isRight) {
    if (length < 19) {
      throw new IllegalArgumentException("The length cannot be less than 19 in case of exception");
    }
    if (isRight) {
      return Strings.padEnd(String.valueOf(idWorker.nextId()), length, padding);
    } else {
      return Strings.padStart(String.valueOf(idWorker.nextId()), length, padding);
    }
  }

  /**
   * 生成组合
   *
   * @param prefix 前缀
   * @param suffix 后缀
   * @param length 总长度
   * @return 组合uuid
   */
  public static String nextCombinedId(String prefix, String suffix, int length) {
    prefix = Strings.nullToEmpty(prefix);
    suffix = Strings.nullToEmpty(suffix);
    if (length < prefix.length() + suffix.length() + 19) {
      throw new IllegalArgumentException("The length cannot be less than 19 in case of exception");
    }
    return prefix + nextFixedLenId(length - prefix.length() - suffix.length(), '0', false) + suffix;
  }

  private class IdWorker {
    private final int workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    private final static long twepoch = 1391184000000L;  //2014年1月1日毫秒数
    private final static long workerIdBits = 4L;
    private final static long maxWorkerId = ~(-1L << workerIdBits);
    private final static long sequenceBits = 10L;
    private final static long workerIdShift = sequenceBits;
    private final static long timestampLeftShift = sequenceBits + workerIdBits;
    private final static long sequenceMask = ~(-1L << sequenceBits);


    public IdWorker(final int workerId) {
      super();
      if (workerId > maxWorkerId || workerId < 0) {
        throw new IllegalArgumentException(String.format("Worker Id can't be greater than %d or less than 0", maxWorkerId));
      }
      this.workerId = workerId;
    }

    public synchronized long nextId() {
      long now = getTimeStamp();
      if (now < lastTimestamp) {
        throw new IllegalStateException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - now));
      }
      /**
       * 在当前毫秒内，序列+1
       */
      if (lastTimestamp == now) {
        sequence = (sequence + 1) & sequenceMask;
        /**
         * 当前毫秒计数满了，等待下一毫秒
         */
        if (this.sequence == 0) {
          now = tilNextMillis(lastTimestamp);
        }
      } else {
        sequence = 0;
      }
      lastTimestamp = now;
      return (((now - twepoch) << timestampLeftShift)) | (workerId << workerIdShift) | sequence;
    }

    /**
     * 等待下一毫秒
     *
     * @param lastTimestamp 当前缓存时间戳
     * @return 下一毫秒时间戳
     */
    private long tilNextMillis(final long lastTimestamp) {
      long timestamp = getTimeStamp();
      while (timestamp <= lastTimestamp) {
        timestamp = getTimeStamp();
      }
      return timestamp;
    }

    /**
     * 系统当前时间
     *
     * @return 系统当前时间戳
     */
    private long getTimeStamp() {
      return System.currentTimeMillis();
    }
  }
}
