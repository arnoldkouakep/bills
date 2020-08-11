package cm.beni.main.julia.dao.controller;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

public interface DaoFactory<T, ID extends Serializable> extends Repository<T, ID> {

	<S extends T> S save(S entity);

	<S extends T> S merge(S entity);

	T findOne(ID primaryKey);

	Iterable<T> findAll();

	Long count();

	void delete(T entity);

	boolean exists(ID primaryKey);

// … more functionality omitted.

}
