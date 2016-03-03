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

    private SqlSessionFactory sqlSessionFactory;
    private Class<?> entityType;

    /**
     * 构造函数
     *
     * @param entityType 实体类型，对应于PagingRepository的泛型E在运行时绑定的类型
     * @param sqlSessionFactory MyBatis SqlSessionFactory
     */
    public PagingRepositoryProxy(Class<?> entityType, SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.entityType = entityType;
    }

    /**
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
        result.append("List Statement定义规则： \n");
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
     * 根据约定获取StatementName，优先级为：by request, by caller, by type
     *
     * @param configuration
     * @return
     */
    private String getMappedStatementName(Pageable request, Method currentMethod, Configuration configuration) {
        // 第一优先级，By Request：根据参数查找是否有匹配的Statement
        String result = null;
        String nameSpace = entityType.getName();
        // configuration.getMappedStatementNames();
        if (configuration.hasStatement(nameSpace + "." + WordUtils.uncapitalize(request.getClass().getSimpleName()))) {
            result = nameSpace + "." + WordUtils.uncapitalize(request.getClass().getSimpleName());
        } else if (configuration.hasStatement(nameSpace + "." + ReflectionUtils.getCallerMethod())) {
            result = nameSpace + "." + ReflectionUtils.getCallerMethod();
        } else if (configuration.hasStatement(nameSpace + "." + currentMethod.getName())) {
            result = nameSpace + "." + currentMethod.getName();
        }
        Asserts.isTrue((result != null) && configuration.hasStatement(result + "Count"),
                "没找到适合的Statement，请按规则定义SQL语句\n" + printUsageHint(request, currentMethod, configuration));

        return result;
    }

}
