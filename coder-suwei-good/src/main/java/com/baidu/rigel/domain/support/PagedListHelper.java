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
 * 将PagedList内部对象类型进行转换的支持类。引入此类后，<br/>
 * 将自动引入Dozer Bean Mapper框架，因此需要在Spring <br/>
 * 中引入Dozer配置。参见： {@link http://dozer.sourceforge.net/documentation/usage.html}
 *
 * @author suwei
 *
 */
public class PagedListHelper implements BeanFactoryAware, InitializingBean {
    private static Mapper mapper;
    private BeanFactory beanFactory;

    public static <F, T> PagedList<T> convert(PagedList<F> source, Class<T> distinctClass) {
        List<T> resultContent = new ArrayList<T>();
        mapper.map(source.getContent(), resultContent);
        return new PagedListImpl<T>(resultContent, source.currentPageable(), source.getTotalElements());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        mapper = beanFactory.getBean(Mapper.class);

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

}
