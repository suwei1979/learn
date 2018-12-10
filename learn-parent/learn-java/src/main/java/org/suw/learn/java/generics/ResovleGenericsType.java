/*
 * Copyright (C) 2018 Wei Su(suwei1979@139.com). All Rights Reserved.
 */
package org.suw.learn.java.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import lombok.Data;

interface BusinessManager<E> {
    E insert(E entity);
}

/**
 * @author suwei
 */
@Data
public class ResovleGenericsType<E> {
    E genericType;
    Class<E> genericClass;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public ResovleGenericsType(E genericTypeParm) {
        genericType = genericTypeParm;
        genericClass = (Class<E>) genericTypeParm.getClass();
        System.out.println("generic type by cast is " + genericClass);
    }

    public static void main(String[] args) {
        ResovleGenericsType<?> genericsType = new ResovleGenericsType<>("String");
        BusinessManager<String> bizManager = new BusinessManagerImpl<String>();

        System.out.println("generic type by reflect is " + getGenericType(genericsType, 0));

        // TypeVariable<?>[] typeVariables = genericsType.getClass().getTypeParameters();
        // for (TypeVariable<?> typeVariable : typeVariables) {
        // System.out.println(typeVariable.getName());
        // System.out.println(typeVariable.getGenericDeclaration());
        // ResovleGenericsType<?> resovleGenericsType = (ResovleGenericsType<?>) typeVariable.getGenericDeclaration();
        // // System.out.println(resovleGenericsType);
        //
        // }
        new ResovleGenericsType<>(1L);
    }

    public static Class<?> getGenericType(Object type, int index) {
        Type genType = type.getClass().getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class<?>) params[index];
    }
}

class BusinessManagerImpl<E> implements BusinessManager<E> {

    /* (non-Javadoc)
     * @see org.suw.learn.java.generics.BusinessManager#insert(java.lang.Object)
     */
    @Override
    public E insert(E entity) {
        // TODO Auto-generated provider stub
        return null;
    }

}