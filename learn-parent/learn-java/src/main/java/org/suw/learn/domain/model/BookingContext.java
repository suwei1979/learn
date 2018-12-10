/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.model;

import javax.validation.Valid;

import org.suw.learn.validation.TestBookingSequence;

import lombok.Data;

@Data
@TestBookingSequence
public class BookingContext {

    @Valid
    public Object domainObject;
}
