/*
 * Copyright (C) 2019 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.primitive;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * LocalPercentageFormat
 *
 * @author suwei
 * @since 2019/6/5 : 6:35 PM
 **/
public class LocalPercentageFormat {

    public static void main(String... args) {
        String numberOfString = "52.25";
        double numberOfDouble = Double.parseDouble(numberOfString)/100;
        NumberFormat format = NumberFormat.getPercentInstance(Locale.CHINA);
        format.setMaximumFractionDigits(2);
        System.out.println(format.format(numberOfDouble));
        StringBuffer stringBuffer = new StringBuffer();
//        format.format(numberOfDouble, stringBuffer, new FieldPosition())


    }
}
