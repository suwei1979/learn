package org.suw.learn.beanvalidation.java;

import javax.validation.Valid;

import lombok.Data;

@Data
@TestBookingSequence
public class BookingContext {

    @Valid
    public Object domainObject;
}
