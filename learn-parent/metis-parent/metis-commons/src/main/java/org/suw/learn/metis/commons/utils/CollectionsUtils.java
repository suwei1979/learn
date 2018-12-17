/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.metis.commons.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.beanutils.PropertyUtils;
import org.suw.learn.gaea.log.FunIMsgFormat;

/**
 * Collection Utils
 * The extension of the apache common collections and guava collections
 */
@Slf4j
public final class CollectionsUtils {

  /**
   * Extract two properties from objects in collections and set to a map.
   * If the types of key/value in the map doesn't correspond to those in collections
   * throws java.lang.ClassCastException
   *
   * @param source        source
   * @param keyName       key of Map
   * @param requiredTypeK key type in the collection
   * @param valueName     value of Map
   * @param requiredTypeV value type in the collection
   * @return map
   */
  public static <K, V> Map<K, V> extractToMap(final Collection<?> source, final String keyName, Class<K> requiredTypeK, final String valueName, Class<V> requiredTypeV) {
    Map<K, V> map = new HashMap<>(source.size());
    try {
      for (Object obj : source) {
        map.put(requiredTypeK.cast(PropertyUtils.getProperty(obj, keyName)),
            requiredTypeV.cast(PropertyUtils.getProperty(obj, valueName)));
      }
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      log.error(FunIMsgFormat.MsgStyle.ERROR_REPORT.getFormat("extractToMap Method invoke failed, exception type :[{}]"), e.getClass(), e);
      throw new CollectionsException(e.getClass().getName());
    }
    return map;
  }

  /**
   * Extract two properties from objects in collections and set to a map.
   * If the types of key/value in the map doesn't correspond to those in collections
   * throws java.lang.ClassCastException
   *
   * @param source       source
   * @param propertyName key of Map
   * @param requiredType key type in the collection
   * @return list
   */
  public static <T> List<T> extractToList(final Collection<?> source, final String propertyName, Class<T> requiredType) {
    List<T> list = new ArrayList<>(source.size());
    try {
      for (Object obj : source) {
        list.add(requiredType.cast(PropertyUtils.getProperty(obj, propertyName)));
      }
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      log.error(FunIMsgFormat.MsgStyle.ERROR_REPORT.getFormat("extractToList Method invoke failed, exception type :[{}]"), e.getClass(), e);
      throw new CollectionsException(e.getClass().getName());
    }
    return list;
  }

  private CollectionsUtils() {
  }
}