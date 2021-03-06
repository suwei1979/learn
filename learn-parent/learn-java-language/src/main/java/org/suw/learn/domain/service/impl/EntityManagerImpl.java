/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.domain.service.impl;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.suw.learn.domain.model.UpdateEvent;
import org.suw.learn.domain.repository.EventRepository;
import org.suw.learn.domain.service.EntityManager;
import org.suw.learn.domain.service.event.EntityEvent;
import org.suw.learn.domain.service.event.InsertEventFactory;

import lombok.RequiredArgsConstructor;

/**
 * @author suwei
 */
@RequiredArgsConstructor
public class EntityManagerImpl<E> implements EntityManager<E> {
    //    private EntityRepository entityRep
    private final Class<E> entityClass;
    private EventRepository eventRepository;
    @Autowired
    private Validator validator;

    /**
     * (non-Javadoc)
     *
     * @see org.suw.learn.domain.service.EntityManager#insert(java.lang.Object)
     */
    @Override
    public E insert(E entity) {
        System.out.println("--------------insert entity begin");
        EntityEvent<E> event = InsertEventFactory.create(entity);
        Set<ConstraintViolation<E>> constraintViolations = validator.validate(entity, Default.class, UpdateEvent.class);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
        System.out.println("--------------insert entity end");
        //        EntityRepository entityRepo = getEntityRepository(event);
        return null;
    }

    /* (non-Javadoc)
     * @see org.suw.learn.domain.service.EntityManager#update(java.lang.Object)
     */
    @Override
    public E update(E entity) {
        validator.validate(entity, UpdateEvent.class);
        return null;
    }
    //    /**
    //     * @param event
    //     * @return
    //     */
    //    private EntityRepository getEntityRepository(EntityEvent event) {
    //        // TODO Auto-generated provider stub
    //        return null;
    //    }

}
