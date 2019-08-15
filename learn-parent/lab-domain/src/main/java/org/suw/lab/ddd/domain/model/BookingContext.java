/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.domain.model;

import javax.validation.Valid;

import org.suw.lab.ddd.validation.constraints.TestBookingSequence;

import lombok.Data;

@Data
@TestBookingSequence
public class BookingContext {

    @Valid
    public Object domainObject;
}
