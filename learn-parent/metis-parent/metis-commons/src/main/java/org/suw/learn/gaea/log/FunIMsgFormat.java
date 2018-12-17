/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.log;

public class FunIMsgFormat extends GaeaLogMsgFormat {

	private static final String FUNI_HEAD = "FUNI";
	
	public static final String HEAD = FUNI_HEAD + GaeaLogMsgFormat.INFO_DIV;

	public static enum MsgStyle {

		/**
		 * 默认记录
		 */
		DEFAULT_LOG(FUNI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DEFAULT_LOG"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 功能错误报告
		 */
		ERROR_REPORT(FUNI_HEAD + GaeaLogMsgFormat.INFO_DIV + "ERROR_REPORT"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 应用系统自起机始产生的错误统计状态
		 */
		STATUS_OF_ERRORS_FROM_START(FUNI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "STATUS_OF_ERRORS_FROM_START" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 应用系统最近产生的错误统计状态
		 */
		STATUS_OF_LAST_ERRORS(FUNI_HEAD + GaeaLogMsgFormat.INFO_DIV
				+ "STATUS_OF_LAST_ERRORS" + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT + GaeaLogMsgFormat.INFO_DIV
				+ GaeaLogMsgFormat.LOG_ARGUMENT);

		private final String format;

		private MsgStyle() {
			this.format = FUNI_HEAD + GaeaLogMsgFormat.INFO_DIV
					+ GaeaLogMsgFormat.LOG_ARGUMENT;
		}

		private MsgStyle(String format) {
			this.format = format;
		}

		public String getFormat() {
			return format;
		}
		
		public String getFormat(String selfFormat) {
			return FUNI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DEFAULT_LOG"
					+ GaeaLogMsgFormat.INFO_DIV + selfFormat;
		}
	}
}
