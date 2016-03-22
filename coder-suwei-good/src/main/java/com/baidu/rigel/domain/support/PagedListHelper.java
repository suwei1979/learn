/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.domain.support;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;

import com.baidu.rigel.domain.PagedList;
import com.baidu.rigel.domain.PagedListImpl;

/**
 * The Helper class for converting the internal object of PagedList. Introducing <br>
 * this class will also introduce the dozer bean mapper frame work. see dozer bean<br>
 * mapper about how to configure the {@link Mapper} in spring container and inject <br>
 * it into PagedListHelper.<br>
 * 
 * @see org.dozer.Mapper
 * @see <a href="http://dozer.sourceforge.net/documentation/usage.html">dozer useage doc</a>
 * @author suwei
 * 
 *
 */
public class PagedListHelper implements BeanFactoryAware, InitializingBean {
    /**
     * Dozer bean mapper
     */
    private static Mapper mapper;

    /**
     * Spring bean factory
     */
    private BeanFactory beanFactory;

    /**
     * Convert the {@code <F>} in the source list to distinctClass, return a new PagedList as results.
     * 
     * @param source the source paged list.
     * @param distinctClass the type of distinct class.
     * @return a new PagedList which generic parameter is binding to {@code distinctClass}
     */
    public static <F, T> PagedList<T> convert(PagedList<F> source, Class<T> distinctClass) {
        List<T> resultContent = new ArrayList<T>();
        mapper.map(source.getContent(), resultContent);
        return new PagedListImpl<T>(resultContent, source.currentPageable(), source.getTotalElements());
    }

    public void afterPropertiesSet() throws Exception {
        mapper = beanFactory.getBean(Mapper.class);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

}
