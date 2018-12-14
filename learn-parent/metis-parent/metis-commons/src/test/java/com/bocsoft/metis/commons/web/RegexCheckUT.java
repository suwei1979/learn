package com.bocsoft.metis.commons.web;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by zion on 2/27/15.
 */
public class RegexCheckUT {

  @Test
  public void checkProductIdAndModuleId() {
    String pattern = "[A-Za-z0-9 -]+";
    String nullString = null;
    assertThat("app-module").matches(pattern);
    assertThat("app module").matches(pattern);
    assertThat("app_module").doesNotMatch(pattern);
    assertThat("").doesNotMatch(pattern);
  }

  @Test
  public void checkNodeId() {
    String pattern = "[0-9a-fA-F]{3}";
    assertThat("101").matches(pattern);
    assertThat("ABC").matches(pattern);
    assertThat("abc").matches(pattern);
    assertThat("01F").matches(pattern);
    assertThat("01Z").doesNotMatch(pattern);
    assertThat("0123").doesNotMatch(pattern);
  }
}
