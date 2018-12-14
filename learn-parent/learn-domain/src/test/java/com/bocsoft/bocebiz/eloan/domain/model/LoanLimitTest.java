/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanLimit;

public class LoanLimitTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    LoanLimit loanLimit;

    @Before
    public void setUp() {
        loanLimit = new LoanLimit("testPlatformSeqNo");
    }

    @Test
    public void testInitialized() {
    }

    @Test
    public void testLifeCircle() {
        assertThat(loanLimit.getState()).isEqualTo(LoanLimit.State.Intialized);
        loanLimit.precalculate();
        assertThat(loanLimit.getState()).isEqualTo(LoanLimit.State.Inactive);
        loanLimit.activate();
        assertThat(loanLimit.getState()).isEqualTo(LoanLimit.State.Active);
        loanLimit.expire();
        assertThat(loanLimit.getState()).isEqualTo(LoanLimit.State.Expired);
    }

    @Test
    public void testActive() {
        loanLimit.precalculate();
    }

    @Test
    public void testExpire() {
        loanLimit.precalculate();
        loanLimit.activate();
    }

    @Test
    public void testActivateFromInitialize() {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Unsupported state transformation under state: " + LoanLimit.State.Intialized.desc());
        try {
            System.out.println("1111");
            loanLimit.activate();
            fail("Expect an UnsupportedOperationException to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(
                    "Unsupported state transformation under state: " + LoanLimit.State.Intialized.desc());
        }
        try {
            loanLimit.expire();
            System.out.println("2222");
            fail("Expect an UnsupportedOperationException to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(
                    "Unsupported state transformation under state: " + LoanLimit.State.Intialized.desc());
        }
        loanLimit.precalculate();

        try {
            loanLimit.precalculate();
            fail("Expect an UnsupportedOperationException to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(
                    "Unsupported state transformation under state: " + LoanLimit.State.Inactive.desc());
        }
        try {
            loanLimit.expire();
            fail("Expect an UnsupportedOperationException to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(
                    "Unsupported state transformation under state: " + LoanLimit.State.Inactive.desc());
        }

        loanLimit.activate();

        try {
            loanLimit.precalculate();
            fail("Expect an UnsupportedOperationException to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(
                    "Unsupported state transformation under state: " + LoanLimit.State.Active.desc());
        }
        try {
            loanLimit.activate();
            fail("Expect an UnsupportedOperationException to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(
                    "Unsupported state transformation under state: " + LoanLimit.State.Active.desc());
        }

        loanLimit.expire();

        try {
            loanLimit.precalculate();
            fail("Expect an UnsupportedOperationException to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(
                    "Unsupported state transformation under state: " + LoanLimit.State.Expired.desc());
        }
        try {
            loanLimit.expire();
            fail("Expect an UnsupportedOperationException to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(
                    "Unsupported state transformation under state: " + LoanLimit.State.Expired.desc());
        }

    }
}
