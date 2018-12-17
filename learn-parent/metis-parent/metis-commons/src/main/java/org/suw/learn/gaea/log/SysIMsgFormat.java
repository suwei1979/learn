/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.log;

public class SysIMsgFormat extends GaeaLogMsgFormat {

	private static final String SYSI_HEAD = "SYSI";
	
	public static final String HEAD = SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV;
	
	public static enum MsgStyle {

		/**
		 * 默认记录
		 */
		DEFAULT_LOG(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DEFAULT_LOG"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前应用系统占用CPU率
		 */
		CURRENT_AS_TAKE_CPU_RATE(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_AS_TAKE_CPU_RATE" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前操作系统闲置CPU率
		 */
		CURRENT_OS_IDLE_CPU_RATE(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_OS_IDLE_CPU_RATE" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前应用系统使用内存总量
		 */
		CURRENT_AS_TAKE_MEMORY_TOTAL(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_AS_TAKE_MEMORY_TOTAL" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前操作系统可用内存总量
		 */
		CURRENT_OS_AVAILABLE_MEMORY_TOTAL(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_OS_AVAILABLE_MEMORY_TOTAL"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前操作系统进程数
		 */
		CURRENT_OS_PROCESS_NUM(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_OS_PROCESS_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前操作系统进程状态
		 */
		CURRENT_OS_PROCESS_STATUS(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_OS_PROCESS_STATUS" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前文件系统独立硬盘数
		 */
		CURRENT_FS_DISK_NUM(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_FS_DISK_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前文件系统IO负载状态
		 */
		CURRENT_FS_DISK_BUSY_STATUS(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_FS_DISK_BUSY_STATUS" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 应用系统总共可使用的最大内存
		 */
		APPLICATION_TOTAL_MEMORY(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "APPLICATION_TOTAL_MEMORY" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 当前已分配给应用系统使用的内存
		 */
		APPLICATION_ALLOCATE_MEMORY(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "APPLICATION_ALLOCATE_MEMORY" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 应用系统当前使用内存
		 */
		APPLICATION_USE_MEMORY(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "APPLICATION_USE_MEMORY" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 应用系统当前原子运行单元数
		 */
		CURRENT_ACTIVE_RUNNING_UNIT_NUM(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "CURRENT_ACTIVE_RUNNING_UNIT_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 应用系统原子运行单元数峰值
		 */
		TOP_NUM_OF_ACTIVE_RUNNING_UNIT(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "TOP_NUM_OF_ACTIVE_RUNNING_UNIT" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 应用系统自起机始启动的原子运行单元数
		 */
		START_RUNNING_UNIT_NUM(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "START_RUNNING_UNIT_NUM" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 原子运行单元数的最近平均生命时间
		 */
		LAST_AVERAGE_LIFE_TIME_OF_RUNNING_UNIT(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "LAST_AVERAGE_LIFE_TIME_OF_RUNNING_UNIT" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 原子运行单元数的最近平均错误数
		 */
		LAST_AVERAGE_ERROR_NUM_OF_RUNNING_UNIT(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "LAST_AVERAGE_ERROR_NUM_OF_RUNNING_UNIT" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 应用系统自起机始产生的错误数
		 */
		NUM_OF_ERRORS_FROM_START(SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "NUM_OF_ERRORS_FROM_START" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT);
		
		private final String format;

		private MsgStyle() {
			this.format = SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV
					+ GaeaLogMsgFormat.LOG_ARGUMENT;
		}

		private MsgStyle(String format) {
			this.format = format;
		}

		public String getFormat() {
			return format;
		}

		public String getFormat(String selfFormat) {
			return SYSI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DEFAULT_LOG"
					+ GaeaLogMsgFormat.INFO_DIV + selfFormat;
		}
	}
}
