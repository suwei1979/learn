package com.bocsoft.metis.commons.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.suw.learn.metis.commons.utils.MessageUtils;
import org.suw.learn.metis.commons.utils.SpringUtils;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by zion on 12/19/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:message.xml")
public class MessageUT {
  @Autowired
  SpringUtils springUtils;

  @Test
  public void getMessage() {
    System.out.println(springUtils.toString());
    assertThat(MessageUtils.getMessage("EZTDG.EXCEPTION.ENCODE")).isEqualTo("报文转化UTF-8格式出错");
  }
}
