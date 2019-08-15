/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.lab.ddd.event;

import java.util.Date;

public class CustomsNotificationGateway {
    EventProcessor processor;

    public void notify(Date occurred, Ship ship, Port port) {
        if (processor.isActive()) {
            sendToCustoms(buildArrivalMessage(occurred, ship, port));
        }
    }

    private void sendToCustoms(Object buildArrivalMessage) {

    }

    private Object buildArrivalMessage(Date occurred, Ship ship, Port port) {
        return null;
    }

}
