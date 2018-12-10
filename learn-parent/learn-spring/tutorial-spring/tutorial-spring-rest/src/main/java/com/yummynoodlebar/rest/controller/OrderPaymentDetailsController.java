/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.yummynoodlebar.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yummynoodlebar.core.services.OrderService;
import com.yummynoodlebar.rest.domain.PaymentDetails;

@Controller
@RequestMapping("/aggregators/orders/{id}/paymentdetails")
public class OrderPaymentDetailsController {

  private OrderService orderService;

  public void setOrderService(OrderService orderService) {
    this.orderService = orderService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public
  @ResponseBody
  PaymentDetails getPaymentDetails(@PathVariable String id) {
    //TODO obtain the order
    //TODO ensure payment details mapping is correct

    return null;
  }

  @RequestMapping(method = RequestMethod.PUT)
  public
  @ResponseBody
  PaymentDetails updatePaymentDetails(@PathVariable String id) {
    //TODO use a command object?
    //TODO obtain the order
    //TODO update the order payment details.
    //TODO ensure payment details mapping is correct

    return null;
  }
}
