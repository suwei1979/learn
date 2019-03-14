/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.validation;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.suw.learn.domain.Order;
import org.suw.learn.domain.model.BookingContext;
import org.suw.learn.domain.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBeanValidation {

    public static void main(String[] args) {
        String orderId = (String) "orderId";
        String customer = (String) "customer";
        String email = (String) "email";
        String address = (String) "address";
        String status = (String) "status";
        String productName = (String) "productName";
        String productPrice = (String) "123.45";
        // 将 Bean 放入 session 中
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCustomer(customer);
        order.setEmail(email);
        order.setAddress(address);
        order.setStatus(status);
        order.setCreateDate(new Date());

        Product product = new Product();

        product.setProductName(productName);
        if (productPrice != null && productPrice.length() > 0) {
            product.setPrice(Float.valueOf(productPrice));
        }
        order.setProduct(product);

        BookingContext context = new BookingContext();
        context.setDomainObject(order);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<BookingContext>> violations = validator.validate(context);
        log.info("校验出错信息如下：");
        for (ConstraintViolation<BookingContext> violation : violations) {
            log.info(violation.toString());
        }
    }

}
