/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.yummynoodlebar.rest.domain;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.yummynoodlebar.core.events.orders.OrderDetails;
import com.yummynoodlebar.rest.controller.OrderQueriesController;

// {!begin import}
// {!end import}

//TODOCUMENT This is added so that we can do jaxb serialisation.
//this type of annotation is fine here, as this
//Order implementation is made for integration with things like this.

@XmlRootElement
// {!begin resourceSupport}
public class Order extends ResourceSupport implements Serializable {
    // {!end resourceSupport}

    private Date dateTimeOfSubmission;

    private Map<String, Integer> items;

    private UUID key;

    // {!begin fromOrderDetails}
    public static Order fromOrderDetails(OrderDetails orderDetails) {
        Order order = new Order();

        order.dateTimeOfSubmission = orderDetails.getDateTimeOfSubmission();
        order.key = orderDetails.getKey();
        order.setItems(orderDetails.getOrderItems());

        //TODOCUMENT.  Adding the library, the above extends ResourceSupport and
        //this section is all that is actually needed in our model to add hateoas support.

        //Much of the rest of the framework is helping deal with the blending of domains that happens in many spring apps
        //We have explicitly avoided that.
        // {!begin selfRel}
        order.add(linkTo(OrderQueriesController.class).slash(order.key).withSelfRel());
        // {!end selfRel}
        // {!begin status}
        order.add(linkTo(OrderQueriesController.class).slash(order.key).slash("status").withRel("Order Status"));
        // {!end status}
        order.add(linkTo(OrderQueriesController.class).slash(order.key).slash("paymentdetails").withRel("Payment Details"));

        return order;
    }

    public Date getDateTimeOfSubmission() {
        return dateTimeOfSubmission;
    }

    public void setDateTimeOfSubmission(Date dateTimeOfSubmission) {
        this.dateTimeOfSubmission = dateTimeOfSubmission;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        if (items == null) {
            this.items = Collections.emptyMap();
        } else {
            this.items = Collections.unmodifiableMap(items);
        }
    }

    public OrderDetails toOrderDetails() {
        OrderDetails details = new OrderDetails();

        details.setOrderItems(items);
        details.setKey(key);
        details.setDateTimeOfSubmission(dateTimeOfSubmission);

        return details;
    }
    // {!end fromOrderDetails}
}
