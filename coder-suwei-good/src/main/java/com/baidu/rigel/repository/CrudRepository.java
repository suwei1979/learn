/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.repository;

import java.io.Serializable;

/**
 * Repository interface of Create/Retrieve/Update/Delete operations for the given entity.
 * 
 * @author suwei
 *
 * @param <E> the domain entity that the repository manages, usually corresponding to aggregate root[Eric Evans] .
 * @param <ID> the identification of the domain entity.
 */
public interface CrudRepository<E, ID extends Serializable> extends Repository<E, ID> {

    /**
     * Insert the give entity to under level data store, use the returned entity for further operations.
     *
     * @param entity
     * @return the entity have been inserted to the storage.
     */
    public E insert(E entity);

    /**
     * Retrieve the entity from under level data storage according to given id.
     *
     * @param id
     * @return the entity with the given id or null if none found.
     */
    public E retrieve(ID id);

    /**
     * 
     * Find and return an entity with all the values carried on the entity as conditions. If multiple entity are found,
     * only the first entity is returned.
     *
     * @param entity
     * @return the first entity of the result set or null if none found.
     */
    public E retrieve(E entity);

    /**
     * Update the entity in the under level storage according to the id or unique business key of the entity as
     * condition, take the updated object as the return value.
     *
     * @param entity
     * @return the entity updated or null if the none is matched by the condition.
     */
    public E update(E entity);

    /**
     * delete the entity in the under level storage according to the given id, and taking the deleted object as return
     * value.
     * 
     * @param id
     * @return the entity has been deleted or null if none is deleted.
     */
    public E delete(ID id);
}
