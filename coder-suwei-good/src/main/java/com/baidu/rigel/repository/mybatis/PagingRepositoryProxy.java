/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.baidu.rigel.domain.Pageable;
import com.baidu.rigel.domain.PagedList;
import com.baidu.rigel.domain.PagedListImpl;
import com.baidu.rigel.util.Asserts;
import com.baidu.rigel.util.ReflectionUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * PagingRepository动态代理
 *
 * @author suwei
 *
 */
@Slf4j
public class PagingRepositoryProxy implements InvocationHandler {

    /**
     * Delimiter for name space and statement name
     */
    private static final String NAMESPACE_DELIM = ".";
    
    private SqlSessionFactory sqlSessionFactory;
    private Class<?> entityType;

    /**
     * Constructor
     *
     * @param entityType Entity type that corresponds to the binded type of E in the PagingRepository
     * @param sqlSessionFactory MyBatis SqlSessionFactory
     */
    PagingRepositoryProxy(Class<?> entityType, SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.entityType = entityType;
    }

    /**
     * Perform the common list logic.
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // The RepositoryInterface must have only one parameter and the parameter type must be subclass of the Pageable
        // interface.
        Asserts.notNull(args);
        Asserts.isTrue(args.length == 1);
        Asserts.isTrue(Pageable.class.isAssignableFrom(args[0].getClass()));

        Pageable request = Pageable.class.cast(args[0]);

        String listStatement = getMappedStatementName(request, method, sqlSessionFactory.getConfiguration());
        String countStatement = listStatement + "Count";
        log.debug("执行ListStatement：" + listStatement);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<?> content = sqlSession.selectList(listStatement, request);
        if (!content.isEmpty()) {
            Asserts.isTrue(entityType.isAssignableFrom(content.get(0).getClass()));
        }
        log.debug("执行CountStatement：" + listStatement);
        Long total = sqlSession.selectOne(countStatement, request);
        @SuppressWarnings({ "rawtypes", "unchecked" })
        PagedList<?> result = new PagedListImpl(content, request, total);

        return result;
    }

    /**
     * @param request
     * @param method
     * @param configuration
     */
    private String printUsageHint(Pageable request, Method method, Configuration configuration) {
        String namespace = entityType.getName();
        StringBuffer result = new StringBuffer("");
        result.append("Could not find approriate SQL statement，"
                + "please define statement according the following rules:\n");
        // result.append(" Definition Rule of List Statement： \n");
        result.append("Namespace: " + namespace + " \n");
        result.append("List Statement Name: \n");
        result.append(" 1. By Request: " + WordUtils.uncapitalize(request.getClass().getSimpleName()) + "\n");
        result.append(" 2. By Caller: " + ReflectionUtils.getCallerMethod() + "\n");
        result.append(" 3. By Type: " + method.getName() + "\n");
        result.append("Count List Statement：\n");
        result.append(" 1. By Request: " + WordUtils.uncapitalize(request.getClass().getSimpleName()) + "Count\n");
        result.append(" 2. By Caller: " + ReflectionUtils.getCallerMethod() + "Count\n");
        result.append(" 3. By Type: " + method.getName() + "Count\n");

        return result.toString();
    }

    /**
     * Get the sql statement name according to the follow priority:by request, by caller, by type
     *
     * @param request the request object.
     * @param currentMethod the current method be called.
     * @param configuration the sql session configuration.
     * @return the statement name or throw an runtime exception if none found.
     */
    private String getMappedStatementName(Pageable request, Method currentMethod, Configuration configuration) {
        String result = null;
        String nameSpace = entityType.getName();

        if (configuration.hasStatement(nameSpace + NAMESPACE_DELIM + WordUtils.uncapitalize(request.getClass().getSimpleName()))) {
            // First Priority，By Request：find whether there is a matching statement according to the parameters
            result = nameSpace + NAMESPACE_DELIM + WordUtils.uncapitalize(request.getClass().getSimpleName());
        } else if (configuration.hasStatement(nameSpace + NAMESPACE_DELIM + ReflectionUtils.getCallerMethod())) {
            // Second Priority，By Caller：find whether there is a matching statement according to the last caller method
            // of the outer class
            result = nameSpace + NAMESPACE_DELIM + ReflectionUtils.getCallerMethod();
        } else if (configuration.hasStatement(nameSpace + NAMESPACE_DELIM + currentMethod.getName())) {
            // Third Priority，By Default：find whether there is a matching statement according to method been called
            result = nameSpace + NAMESPACE_DELIM + currentMethod.getName();
        }
        Asserts.isTrue((result != null) && configuration.hasStatement(result + "Count"),
                printUsageHint(request, currentMethod, configuration));

        return result;
    }

}
