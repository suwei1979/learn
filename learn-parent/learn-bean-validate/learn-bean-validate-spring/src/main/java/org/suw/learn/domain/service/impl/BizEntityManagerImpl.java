/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package org.suw.learn.domain.service.impl;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.suw.learn.domain.repository.EntityRepository;
import org.suw.learn.domain.repository.EventRepository;
import org.suw.learn.domain.service.BizEntityManager;
import org.suw.learn.domain.service.event.EntityEvent;
import org.suw.learn.domain.service.event.InsertEventFactory;

import lombok.RequiredArgsConstructor;

/**
 * @author suwei
 *
 */
@RequiredArgsConstructor
public class BizEntityManagerImpl<E> implements BizEntityManager<E> {
    private EventRepository eventRepository;
//    private EntityRepository entityRep
    private final Class<E> entityClass;
    @Autowired
    private Validator validator;
    /**
     *  (non-Javadoc)
     * @see org.suw.learn.domain.service.BizEntityManager#insert(java.lang.Object)
     */
    @Override
    public E insert(E entity) {
        EntityEvent<E> event = InsertEventFactory.create(entity);
        validator.validate(event);
//        EntityRepository entityRepo = getEntityRepository(event);
        return null;
    }
    /**
     * @param event
     * @return
     */
    private EntityRepository getEntityRepository(EntityEvent event) {
        // TODO Auto-generated method stub
        return null;
    }

}
