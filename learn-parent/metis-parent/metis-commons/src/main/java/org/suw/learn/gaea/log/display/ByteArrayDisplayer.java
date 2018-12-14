package org.suw.learn.gaea.log.display;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suw.learn.gaea.log.FunIMsgFormat;

public class ByteArrayDisplayer extends LogDisplayer {

	private final static Logger logger = LoggerFactory
			.getLogger(ByteArrayDisplayer.class);

	private byte[] toLogByteArray;

	private final static String ENTER = System.getProperty("line.separator");

	private final static String CHARSET = System.getProperty(
			"gaea.log.print.charset", "utf-8");

	private final static String DIV = "|";

	private final static String LONG_SPACE = "   ";

	private final static String SHORT_SPACE = " ";

	private final static String LONG_HURDLE = "===";

	private final static String SHORT_HURDLE = "=";

	ByteArrayDisplayer(byte[] toLogData) {
		toLogByteArray = toLogData;
	}

	@Override
	public String toString() {

		StringBuffer displayBuffer = new StringBuffer();
		final int columnNum = 32;
		final int rowNum = toLogByteArray.length / columnNum + 1;

		// 换行
		displayBuffer.append(ENTER);

		// 设置二进制序号栏
		for (int c = 0; c < columnNum; c++) {
			displayBuffer.append(DIV).append(format(String.valueOf(c), 2));
		}
		displayBuffer.append(LONG_SPACE);

		// 设置数据序号栏, 0-9 循环显示
		for (int c = 0; c < columnNum; c++) {
			displayBuffer.append(String.valueOf(c % 10));
		}
		displayBuffer.append(ENTER);

		// 设置分隔栏
		for (int c = 0; c < columnNum; c++) {
			displayBuffer.append(LONG_HURDLE);
		}
		displayBuffer.append(LONG_SPACE);
		for (int c = 0; c < columnNum; c++) {
			displayBuffer.append(SHORT_HURDLE);
		}
		displayBuffer.append(ENTER);

		// 打印二进制数据
		for (int r = 0; r < rowNum; r++) {
			int existedColumnNum = (r == rowNum - 1 ? toLogByteArray.length - r
					* columnNum : columnNum);
			for (int c = 0; c < existedColumnNum; c++) {
				displayBuffer.append(SHORT_SPACE).append(
						format(Integer.toHexString(toLogByteArray[r * columnNum
								+ c] & 0xff), 2));
			}

			for (int c = existedColumnNum; c < columnNum; c++) {
				displayBuffer.append(LONG_SPACE);
			}
			displayBuffer.append(LONG_SPACE);

			String dataStr = null;
			try {
				dataStr = new String(toLogByteArray, r * columnNum,
						existedColumnNum, CHARSET);
			} catch (UnsupportedEncodingException e) {
				logger.error(FunIMsgFormat.HEAD, e);
				dataStr = new String(toLogByteArray, r * columnNum,
						existedColumnNum);
			}
			dataStr = dataStr.replaceAll("\r", ".").replaceAll("\n", ".");
			displayBuffer.append(dataStr).append(ENTER);
		}

		return displayBuffer.toString();
	}

	private static String format(String sourceStr, int length) {
		StringBuffer strBuffer = new StringBuffer(sourceStr);
		for (; strBuffer.length() < length; strBuffer.insert(0, '0'))
			;
		return strBuffer.toString();
	}

}
