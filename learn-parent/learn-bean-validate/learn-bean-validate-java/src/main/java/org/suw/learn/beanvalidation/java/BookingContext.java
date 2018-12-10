/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.beanvalidation.java;

import javax.validation.Valid;

import lombok.Data;

@Data
@TestBookingSequence
public class BookingContext {

    @Valid
    public Object domainObject;
}
