/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.classloader;

import lombok.Data;

/**
 * Point
 *
 * @author suwei
 * @since 2019/8/15 : 5:32 PM
 **/
@Data
public class Point {
    int x = 0;
    int y = 0;

    public Point(int a, int b) {
        this.x = a;
        this.y = b;
    }

}
