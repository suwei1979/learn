package com.bocsoft.metis.commons.utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;
import org.suw.learn.metis.commons.utils.UUIDUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by zion on 1/27/15.
 */
public class UUIDUtilsUT {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private UUIDUtils uuidUtils = new UUIDUtils(3);
  private volatile static Logger logger = LoggerFactory.getLogger(UUIDUtils.class);

  @Test
  public void worderIdLessThan0OrThrowExecption() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Worker Id can't be greater than 15 or less than 0");
    UUIDUtils uuidUtils = new UUIDUtils(-1);
  }

  @Test
  public void workerIdGreaterThat15ThrowException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Worker Id can't be greater than 15 or less than 0");
    UUIDUtils uuidUtils = new UUIDUtils(16);
  }

  @Test
  public void getFixedLengthUUIDEndsWithSpace() {
    String id = UUIDUtils.nextFixedLenId(21, ' ', true);
    assertThat(id).hasSize(21);
    assertThat(id).endsWith(" ");
  }

  @Test
  public void getFixedLengthUUIDStartsWith0() {
    String id = UUIDUtils.nextFixedLenId(21, '0', false);
    assertThat(id).hasSize(21);
    assertThat(id).startsWith("0");
  }

  @Test
  public void getFixedLengthLessThan19WillThrowException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The length cannot be less than 19 in case of exception");
    UUIDUtils.nextFixedLenId(17, '0', true);
  }

  @Test
  public void lastGeneratedUUIDIsGreater() {
    long uuid1 = UUIDUtils.nextIdNumeric();
    long uuid2 = UUIDUtils.nextIdNumeric();
    assertThat(uuid2).isGreaterThan(uuid1);
  }

  @Test
  public void getStringId() {
    assertThat(UUIDUtils.nextIdString().length()).isLessThan(20);
  }

  @Test
  public void getCombinedLessThan19ThrowException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The length cannot be less than 19 in case of exception");
    UUIDUtils.nextCombinedId("", null, 18);
  }

  @Test
  public void getCombinedLessThanRequiredThrowException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The length cannot be less than 19 in case of exception");
    UUIDUtils.nextCombinedId("BOC", "S", 23 - 1);//required >= 3+1+19
  }

  @Test
  public void getCombinedGreaterOrEqualRequiredThrowException() {
    UUIDUtils.nextCombinedId("BOC", "S", 23);//required >= 3+1+19
    UUIDUtils.nextCombinedId("BOC", "S", 24);//required >= 3+1+19
  }

  @Test
  public void getCombinedWithNullPrefix() {
    String id = UUIDUtils.nextCombinedId(null, "S", 20);
    assertThat(id).matches(Pattern.compile("\\d{19}S"));
  }

  @Test
  public void getCombinedEmptySuffix() {
    String id = UUIDUtils.nextCombinedId("OP", "", 21);
    assertThat(id).matches(Pattern.compile("OP\\d{19}"));
  }

  @Test
  public void getCombinedWithPrefixAndSuffix() {
    String id = UUIDUtils.nextCombinedId("OP", "S", 22);
    assertThat(id).matches(Pattern.compile("OP\\d{19}S"));
  }

  @Test
  public void waitTillNextMillis() throws IllegalAccessException, InvocationTargetException, InstantiationException {
    Class<?> target = UUIDUtils.class.getDeclaredClasses()[0];
    Field targetField = UUIDUtils.class.getDeclaredFields()[0];
    Field inner = ReflectionUtils.findField(target, "sequence");
    ReflectionUtils.makeAccessible(inner);
    ReflectionUtils.makeAccessible(targetField);

    Constructor<?> constructor = target.getDeclaredConstructors()[0];
    Object obj = constructor.newInstance(uuidUtils, 3);
    ReflectionUtils.setField(inner, obj, 1023L);
    ReflectionUtils.setField(targetField, uuidUtils, obj);
    UUIDUtils.nextIdNumeric();
  }

  @Test
  public void nowEarlierThanLastTimestamp() throws IllegalAccessException, InstantiationException, InvocationTargetException {
    thrown.expect(IllegalStateException.class);
    Class<?> target = UUIDUtils.class.getDeclaredClasses()[0];
    Field targetField = UUIDUtils.class.getDeclaredFields()[0];
    Field inner = ReflectionUtils.findField(target, "lastTimestamp");
    ReflectionUtils.makeAccessible(inner);
    ReflectionUtils.makeAccessible(targetField);

    Constructor<?> constructor = target.getDeclaredConstructors()[0];
    Object obj = constructor.newInstance(uuidUtils, 3);
    ReflectionUtils.setField(inner, obj, new GregorianCalendar(2025, 1, 1).getTimeInMillis());
    ReflectionUtils.setField(targetField, uuidUtils, obj);

    UUIDUtils.nextIdNumeric();
    ReflectionUtils.setField(inner, obj, new GregorianCalendar().getTimeInMillis());
    ReflectionUtils.setField(targetField, uuidUtils, obj);
  }
}
