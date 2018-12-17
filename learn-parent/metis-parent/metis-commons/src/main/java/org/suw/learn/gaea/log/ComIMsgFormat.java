/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.log;

public class ComIMsgFormat extends GaeaLogMsgFormat {

	private static final String COMI_HEAD = "COMI";
	
	public static final String HEAD = COMI_HEAD + GaeaLogMsgFormat.INFO_DIV;

	public static enum MsgStyle {

		/**
		 * 默认记录
		 */
		DEFAULT_LOG(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DEFAULT_LOG"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据库CPU占用率
		 */
		DB_CPU_RATE(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DB_CPU_RATE"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据库内存平均占用率
		 */
		DB_AVERAGE_MEMORY_RATE(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "DB_AVERAGE_MEMORY_RATE" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据库硬盘占用率
		 */
		DB_HD_RATE(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DB_HD_RATE"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据库I/O数量
		 */
		DB_IO_NUM(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DB_IO_NUM"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据库网络时延
		 */
		DB_NET_DELAY_TIME(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "DB_NET_DELAY_TIME" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据库I/O等待时间
		 */
		DB_IO_WAIT_TIME(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "DB_IO_WAIT_TIME" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据CACHE命中率
		 */
		DB_CACHE_HIT_RATE(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "DB_CACHE_HIT_RATE" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据库当前会话数
		 */
		DB_CURRENT_SESSION_NUM(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "DB_CURRENT_SESSION_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 数据库会话数峰值
		 */
		DB_SESSION_TOP_NUM(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "DB_SESSION_TOP_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前产生的锁数量
		 */
		DB_CURRENT_LOCK_NUM(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "DB_CURRENT_LOCK_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前产生的锁统计
		 */
		DB_CURRENT_LOCK_STATUS(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "DB_CURRENT_LOCK_STATUS" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * MQ最大内存
		 */
		MQ_MAX_MEMORY(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV + "MQ_MAX_MEMORY"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * MQ当前使用内存
		 */
		MQ_CURRENT_USE_MEMORY(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "MQ_CURRENT_USE_MEMORY" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前MQ中的通道状态数
		 */
		MQ_CURRENT_RUNNING_ACTIVITY_NUM(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "MQ_CURRENT_RUNNING_ACTIVITY_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * MQ中的通道状态数峰值
		 */
		MQ_TOP_NUM_OF_RUNNING_ACTIVITY(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "MQ_TOP_NUM_OF_RUNNING_ACTIVITY" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前MQ中的通道状态异常数
		 */
		MQ_CURRENT_ABNORMAL_STATUS_NUM(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "MQ_CURRENT_ABNORMAL_STATUS_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前MQ中的通道异常状态
		 */
		MQ_CURRENT_ABNORMAL_STATUS(COMI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "MQ_CURRENT_ABNORMAL_STATUS" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT);

		private final String format;

		private MsgStyle(String format) {
			this.format = format;
		}

		public String getFormat() {
			return format;
		}
		
		public String getFormat(String selfFormat) {
			return COMI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DEFAULT_LOG"
					+ GaeaLogMsgFormat.INFO_DIV + selfFormat;
		}
	}
}
