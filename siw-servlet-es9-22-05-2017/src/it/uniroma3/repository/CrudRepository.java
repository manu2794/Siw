package it.uniroma3.repository;

import java.util.List;

public interface CrudRepository<T> {
	
	public T save(T entity);
	
	public T findOne(Long id);
	
	public List<T> findAll();
	
	public void delete(T entity);
	
	public void deleteAll();
}

//inoltre ci sono dei find che sono specifici dell'applicazione che stiamo costruendo, per rendere piu'efficiente il tutto.
//ad esempio: per trovare tutti gli artisti morti, non carico tutti gli artistim --> fai una classe che estende crudRepository
//ed implemtenta i metodi aggiuntivi che mi servono.