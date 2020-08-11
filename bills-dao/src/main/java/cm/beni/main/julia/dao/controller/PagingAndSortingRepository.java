package cm.beni.main.julia.dao.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

abstract interface PagingAndSortingRepository extends CrudRepository<Object, Object> {

	public abstract Iterable<?> findAll(Sort arg0);

	public abstract Page<?> findAll(Pageable arg0);

}