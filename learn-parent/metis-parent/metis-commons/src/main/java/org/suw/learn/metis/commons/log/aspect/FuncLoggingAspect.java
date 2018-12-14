package org.suw.learn.metis.commons.log.aspect;

import com.alibaba.fastjson.JSON;

import org.apache.commons.lang3.Validate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.suw.learn.gaea.log.FunIMsgFormat;
import org.suw.learn.gaea.log.GaeaLogUtil;
import org.suw.learn.metis.commons.log.LogMsgTemplBuilder;
import org.suw.learn.metis.commons.log.annotation.BusiLog;

import static org.suw.learn.metis.commons.utils.AspectUtils.getAnnotation;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Logging Aspect Configuration.
 */
@Aspect
public class FuncLoggingAspect {

    private static final String TRANS_MSG_START = LogMsgTemplBuilder.log("交易[开始]").add("模块名").add("功能名").add("过程ID").build();
    private static final String TRANS_MSG_END = LogMsgTemplBuilder.log("交易[结束]").add("模块名").add("功能名").add("过程ID").build();
    private static final String TRANS_TIME_CONSUM = LogMsgTemplBuilder.log("处理时间").add("方法名").add("时间(ms)").build();
    private static final String ENTRYVAL_MSG = LogMsgTemplBuilder.log("方法入参").add("方法名").add("入参类型").add("值").build();
    private static final String RETVAL_MSG = LogMsgTemplBuilder.log("方法返回值").add("方法名").add("返回值类型").add("值").build();

    /**
     * 业务日志记录注解.
     * 在所需要记录日志到方法上（非接口）添加注解
     */
    @Pointcut(value = "@annotation(com.bocsoft.metis.commons.log.annotation.BusiLog)")
    private void businessLog() {
        //point cut of business log
    }

    /**
     * 系统日志记录注解.
     */
    @Pointcut(value = "@annotation(com.bocsoft.metis.commons.exception.annotation.ExceptionHandler)")
    private void exceptionHandler() {
        //point cut of system log
    }

    @Around(value = "businessLog()")
    public final Object recordArgsAndRetVal(final ProceedingJoinPoint pjp) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final Logger log = LoggerFactory.getLogger(pjp.getTarget().getClass());
        final BusiLog busiLog = getAnnotation(pjp, BusiLog.class);
        Validate.notNull(busiLog);
        if (isTransInfoLogEnable(busiLog)) {
            log.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat(TRANS_MSG_START), busiLog.module(), busiLog.operation(), GaeaLogUtil.getProcessID());
        }

        if (busiLog.entry()) {
            final Object[] args = pjp.getArgs();
            for (final Object arg : args) {
                if (arg.getClass().isInterface()) {
                    continue;
                }
                if (ServletRequest.class.isAssignableFrom(arg.getClass())) {
                    continue;
                }
                if (ServletResponse.class.isAssignableFrom(arg.getClass())) {
                    continue;
                }
                if (BindingResult.class.isAssignableFrom(arg.getClass())) {
                    continue;
                }
                log.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat(ENTRYVAL_MSG), pjp.getSignature().getName(), arg.getClass().getName(), JSON.toJSONString(arg));
            }
        }
        final Object retVal = pjp.proceed();
        if (busiLog.entry() && retVal != null) {
            log.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat(RETVAL_MSG), pjp.getSignature().getName(), retVal.getClass(), JSON.toJSONString(retVal));
        }
        if (isTransInfoLogEnable(busiLog)) {
            log.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat(TRANS_MSG_END), busiLog.module(), busiLog.operation(), GaeaLogUtil.getProcessID());
        }
        stopWatch.stop();
        log.info(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat(TRANS_TIME_CONSUM), pjp.getSignature().getName(), stopWatch.getTotalTimeMillis());
        return retVal;
    }

    @AfterThrowing(value = "exceptionHandler()", throwing = "cause")
    public final void loggingException(final JoinPoint jp, final Throwable cause) {
        final Logger log = LoggerFactory.getLogger(jp.getTarget().getClass());
        log.error(FunIMsgFormat.MsgStyle.DEFAULT_LOG.getFormat("Exception caused by:\n"), cause);
    }

    private boolean isTransInfoLogEnable(BusiLog busiLog) {
        return !(busiLog.module().isEmpty() || busiLog.operation().isEmpty());
    }
}