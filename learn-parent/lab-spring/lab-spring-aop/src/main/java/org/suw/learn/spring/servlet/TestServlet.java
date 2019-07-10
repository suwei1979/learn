/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.suw.learn.spring.propertyeditor.Contact;

import org.suw.learn.spring.DatabaseConfig;
import org.suw.learn.spring.aop.ITarget;

/**
 * Servlet implementation class for Servlet: TestServlet
 */
public class TestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
     *
     */
    private static final long serialVersionUID = 621130547111020145L;
    private Log LOGGER = LogFactory.getLog(TestServlet.class);

    /*
     * (non-Java-doc)
     *
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

    /*
     * (non-Java-doc)
     *
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
     * HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String cmd = request.getParameter("command");
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession()
                .getServletContext());
        if (cmd != null && cmd.trim().length() != 0) {
            if (cmd.equals("databaseConfig")) {
                DatabaseConfig dbConfig = (DatabaseConfig) context.getBean("databaseConfig");
                LOGGER.info("database url: " + dbConfig.getUrl());
                LOGGER.info("database driver: " + dbConfig.getDriverClassName());
                LOGGER.info("database user: " + dbConfig.getUserName());
                LOGGER.info("database password: " + dbConfig.getPassword());
            } else if (cmd.equals("propertyEditor")) {
                Contact contact = (Contact) context.getBean("contact");
                LOGGER.info(contact.getPhoneNumber().getAreaCode());
                LOGGER.info(contact.getPhoneNumber().getPrefix());
                LOGGER.info(contact.getPhoneNumber().getNumber());
            } else if (cmd.equals("testAOP")) {
                ITarget target = (ITarget) context.getBean("target");
                target.doSomething();
                target.doA();
                target.otherThing();
            }
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /*
     * (non-Java-doc)
     *
     * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
     * HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doGet(request, response);
    }
}