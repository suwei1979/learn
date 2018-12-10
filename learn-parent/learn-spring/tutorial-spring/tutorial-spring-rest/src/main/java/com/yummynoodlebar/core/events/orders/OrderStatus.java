/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.yummynoodlebar.core.events.orders;

import java.util.UUID;

public class OrderStatus {

  private UUID key;

  public OrderStatus() {
    key = null;
  }

  public OrderStatus(UUID key) {
    this.key = key;
  }

  public UUID getKey() {
    return key;
  }

  public void setKey(UUID key) {
    this.key = key;
  }
}
