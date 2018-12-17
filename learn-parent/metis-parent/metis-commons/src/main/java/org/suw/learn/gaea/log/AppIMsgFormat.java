/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.gaea.log;

public class AppIMsgFormat extends GaeaLogMsgFormat {

	private static final String APPI_HEAD = "APPI";
	
	public static final String HEAD = APPI_HEAD + GaeaLogMsgFormat.INFO_DIV;

	public static final String ITR_UUID_NEW = "1";
	
	public static final String ITR_UUID_OLD = "0";
	
	public static final String ITR_READ_ACTION = "R";
	
	public static final String ITR_WRITE_ACTION = "W";
	
	public static final String ITR_ACTION_SUCC = "S";
	
	public static final String ITR_ACTION_FAIL = "F";
	
	public static enum MsgStyle {

		/**
		 * 默认记录
		 */
		DEFAULT_LOG(APPI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DEFAULT_LOG"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT),

		/**
		 * 功能错误报告
		 */
		UUID(APPI_HEAD + GaeaLogMsgFormat.INFO_DIV + "UUID"
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT
				+ GaeaLogMsgFormat.INFO_DIV + GaeaLogMsgFormat.LOG_ARGUMENT);

		private final String format;

		private MsgStyle() {
			this.format = APPI_HEAD + GaeaLogMsgFormat.INFO_DIV
					+ GaeaLogMsgFormat.LOG_ARGUMENT;
		}

		private MsgStyle(String format) {
			this.format = format;
		}

		public String getFormat() {
			return format;
		}
		
		public String getFormat(String selfFormat) {
			return APPI_HEAD + GaeaLogMsgFormat.INFO_DIV + "DEFAULT_LOG"
					+ GaeaLogMsgFormat.INFO_DIV + selfFormat;
		}
	}
}
