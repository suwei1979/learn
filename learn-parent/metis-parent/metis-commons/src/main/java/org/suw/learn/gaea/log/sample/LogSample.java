package org.suw.learn.gaea.log.sample;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suw.learn.gaea.log.AppIMsgFormat;
import org.suw.learn.gaea.log.FunIMsgFormat;
import org.suw.learn.gaea.log.GaeaLogUtil;
import org.suw.learn.gaea.log.SysIMsgFormat;

public class LogSample {

	private static Logger logger = LoggerFactory.getLogger(LogSample.class);

	public static void test() {

		/*
		 * 系统起机时调用GaeaLogUtil类前,将product,module,node注入SystemProperty
		 */
		System.setProperty("gaea_product_id", "VCP");
		System.setProperty("gaea_module_id", "HomeSit");
		// 从各节点的配置文件获取唯一的标识
		System.setProperty("gaea_node_id", "0F2");

		// ......

		/*
		 * 于某个独立过程（线程）开启时，初始化GaeaLogUtil类就会自动将以上三个要素注入MDC 生成过程ID，注入过程ID
		 */
		String processID = getSimpleUUID();
		GaeaLogUtil.registerProcessID(processID);

		// 注入三要素之后的日志示例
		logger.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG
				.getFormat("new process {} start!"), processID);

		// ......

		/*
		 * 于与某个外部服务发生交互调用时，生成或获取interaction uuid，调用GaeaLogUtil方法注入MDC
		 */
		String uuid = processID;// 当本过程仅为单线程执行（不包含多线程派发），单交互（不包含大于1次交互）时，可用processID作为uuid
		GaeaLogUtil.registerInteractionUUID(uuid);

		// 并以协议规范记录UUID日志，如下例
		logger.info(AppIMsgFormat.MsgStyle.UUID.getFormat(), new Object[] {
				uuid, 1, AppIMsgFormat.ITR_READ_ACTION,
				GaeaLogUtil.GAEA_PRODUCT_NAME, GaeaLogUtil.GAEA_MODULE_NAME,
				GaeaLogUtil.GAEA_NODE_NAME, AppIMsgFormat.ITR_ACTION_SUCC,
				"0000" });

		// ......

		/*
		 * 日常记录日志
		 */

		// 以协议规范记录系统状态信息
		logger.warn(
				SysIMsgFormat.MsgStyle.CURRENT_OS_IDLE_CPU_RATE.getFormat(),
				0.85);

		// 以协议规范报错
		logger.debug(FunIMsgFormat.MsgStyle.ERROR_REPORT.getFormat(), "30004",
				"someThingWrong");

		// 记录一般信息
		logger.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat(),
				"log something");

		// 使用自己的format记录信息
		logger.debug(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat("{} did {}"),
				"who", "something");

		// 记录详细异常堆栈
		Exception e = new RuntimeException("something wrang");
		logger.error(FunIMsgFormat.HEAD + "some environment statement", e);
	}

	private static String getSimpleUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
