package edu.softserve.zoo.persistence.provider;

import edu.softserve.zoo.persistence.specification.Specification;

import java.util.Collection;

/**
 * Interface that defines the persistent storage interface.
 *
 * @author Bohdan Cherniakh
 * @param <T> the type of the domain objects which are stored.
 */
public interface PersistenceProvider<T> {

    /**
     * Saves the given entity into the persistent storage.
     *
     * @return persisted entity with generated identifier.
     * @param entity an object that should be saved.
     */
    T save(T entity);

    /**
     * Updates a state of the given entity in the persistent storage.
     *
     * @return entity with updated state.
     * @param entity domain object that should be updated.
     */
    T update(T entity);

    /**
     * Deletes the given entity from the persistent storage.
     *
     * @param entity domain object that should be deleted.
     */
    void delete(T entity);

    /**
     * Finds the collection of domain objects in the persistent storage. The search criteria is defined by the
     * Specification object.
     *
     * @param specification the specification object that describes the query that should be performed.
     * @return The collection of domain objects or null if there are no objects in the database that match the query.
     * @see Specification
     */
    Collection<T> find(Specification<T> specification);
}