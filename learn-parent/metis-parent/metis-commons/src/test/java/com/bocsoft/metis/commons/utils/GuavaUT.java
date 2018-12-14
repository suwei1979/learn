package com.bocsoft.metis.commons.utils;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by zion on 1/28/15.
 */
public class GuavaUT {
    @Test
    public void padingLengthShorterThanGivenStringNotWork() {
        String given = "12345678";
        String nString = Strings.padEnd(given, 5, 'x');
        assertThat(nString).isEqualTo(given);
    }

    @Test
    public void padingLengthLongerThanGivenStringWorks() {
        String given = "12345678";
        String nString = Strings.padEnd(given, 10, 'x');
        assertThat(nString).hasSize(10);
        assertThat(nString).endsWith("x");
        assertThat(nString).isEqualTo("12345678xx");
    }
}
