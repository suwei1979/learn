/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.spring.beans.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.suw.learn.spring.beans.model.EntityFactory;

/**
 * @author suwei
 *
 */
public class GenericServiceInjector implements BeanFactoryPostProcessor {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.
     * beans.factory.config.ConfigurableListableBeanFactory)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, EntityTypeResolvable> genericServices = beanFactory.getBeansOfType(EntityTypeResolvable.class);
        for (EntityTypeResolvable entityTypeResovlable : genericServices.values()) {
            System.out.println("Service: " + entityTypeResovlable);
            Class<?> entityType = entityTypeResovlable.getEntityType();
            System.out.println("EntityType: " + entityType.getName());
            String factoryName = entityType.getSimpleName().toLowerCase() + "Factory";
            System.out.println("EntityFactory To Find: " + factoryName);
            EntityFactory<?> entityFactory = beanFactory.getBean(factoryName, EntityFactory.class);
            System.out.println("EntityFactory Founded: " + entityFactory.getClass());
            for (Type type : entityFactory.getClass().getGenericInterfaces()) {
                ParameterizedType parameteridedType = (ParameterizedType) type;
                System.out.println("EntityType inFactory: " + parameteridedType.getActualTypeArguments()[0]);
                if (entityType.equals(parameteridedType.getActualTypeArguments()[0])) {
                    System.out.println("EntityType Matched: " + entityType.equals(parameteridedType.getActualTypeArguments()[0]));
                    entityTypeResovlable.setEntityFactory(entityFactory);

                }
            }
        }
    }

}
