package com.bocsoft.metis.commons.log;

import org.junit.Test;
import org.suw.learn.metis.commons.log.LogMsgTemplBuilder;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by zion on 11/18/14.
 */
public class LogBuilderUT {
    @Test
    public void multiThread() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            new Thread("Thread " + i) {
                public void run() {
                    logContent();
                }
            }.start();
        }
        Thread.sleep(5);
    }

    private void logContent() {
        String log = LogMsgTemplBuilder.log("Connection refused!")
                .add("cardNo")
                .add("transferAmount")
                .build();
        assertThat(log).isEqualTo("Connection refused!-/-cardNo-:-{}-/-transferAmount-:-{}");
    }

    @Test
    public void statementNullReturnNoStatement() {
        String log = LogMsgTemplBuilder.log("")
                .add("cardNo")
                .add("transferAmount")
                .build();
        assertThat(log).isEqualTo("cardNo-:-{}-/-transferAmount-:-{}");

        log = LogMsgTemplBuilder.log(null)
                .add("cardNo")
                .add("transferAmount")
                .build();
        assertThat(log).isEqualTo("cardNo-:-{}-/-transferAmount-:-{}");
    }
}
