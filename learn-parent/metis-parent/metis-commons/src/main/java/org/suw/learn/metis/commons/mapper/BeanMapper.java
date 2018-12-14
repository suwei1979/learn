package org.suw.learn.metis.commons.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.suw.learn.metis.commons.utils.SpringUtils;

/**
 * Bean Mapper Utils.
 * Encapsulate Dozer Mapper
 */
public final class BeanMapper {

    private static Mapper mapper = new DozerBeanMapper();

    /**
     * If used in SpringContext, get dozer bean mapper through bean factory. eg.
     * <bean id="beanMapper" class="org.dozer.spring.DozerBeanMapperFactoryBean">
     *     <property name="mappingFiles" value="classpath*:META-INF/dozer/*Mappings.xml"/>
     * </bean>
     * Otherwise, get a default dozer bean mapper
     */
    static {
        Mapper bean = SpringUtils.getBean(Mapper.class);
        if (bean != null) {
            mapper = bean;
        }
    }

    private BeanMapper() {
    }

    /**
     * Copy from object to object.
     *
     * @param source      source object
     * @param destination destination object
     */
    public static void map(Object source, Object destination) {
        mapper.map(source, destination);
    }

    /**
     * Copy from object to a new instance of object of given type.
     *
     * @param source           source object
     * @param destinationClass destination Class
     * @param <T>              required type
     * @return a new instance
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    /**
     * Copy from object to object using a map id.
     *
     * @param source           source object
     * @param destinationClass destination class
     * @param mapId            map id
     * @param <T>              required type
     * @return a new instance
     */
    public static <T> T map(Object source, Class<T> destinationClass, String mapId) {
        return mapper.map(source, destinationClass, mapId);
    }

    /**
     * Copy from object to object using a map id.
     *
     * @param source      source object
     * @param destination destination object
     * @param mapId       map id
     */
    public static void map(Object source, Object destination, String mapId) {
        mapper.map(source, destination, mapId);
    }
}
