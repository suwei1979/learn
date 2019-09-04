/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.classloader;

import lombok.Data;

/**
 * Rectangle
 *
 * @author suwei
 * @since 2019/8/15 : 5:32 PM
 **/
@Data
public class Rectangle {
    int width = 0;
    int height = 0;
    Point origin;
    public Rectangle() {
        origin = new Point(0, 0);
    }

    public Rectangle(Point origin) {
        this.origin = origin;
    }

    public Rectangle(int w, int h) {
        origin = new Point(0, 0);
        this.width = w;
        this.height = h;
    }

    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    public int getArea() {
        return width * height;
    }
}
