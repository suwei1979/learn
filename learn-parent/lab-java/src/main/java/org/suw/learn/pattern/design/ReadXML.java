/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.pattern.design;

import org.suw.learn.pattern.design.adapter.sample.Motor;
import org.suw.learn.xml.XMLReader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * ReadXML
 *
 * @author suwei
 * @since 2019/12/16 : 2:06 PM
 **/
public class ReadXML {
    private static String XML_CONF = "/pattern/config.xml";

//    public static Motor getObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Document document = XMLReader.readXML("/config.xml");
//        NodeList nodeList = document.getElementsByTagName("className");
//        Node node = nodeList.item(0).getFirstChild();
//        String className = node.getNodeValue();
//        Motor motor = (Motor) Class.forName(className).newInstance();
//        return motor;
//    }

    public static <T> T getObject(Class<T> clazz, String tagName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Document document = XMLReader.readXML(XML_CONF);
        NodeList nodeList = document.getElementsByTagName(tagName);
        Node node = nodeList.item(0).getFirstChild();
        String className = node.getNodeValue();
        return clazz.cast(Class.forName(className).newInstance());
    }
}
