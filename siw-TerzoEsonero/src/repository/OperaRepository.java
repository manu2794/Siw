package repository;

import javax.persistence.EntityManager;

import model.Opera;

public class OperaRepository extends CrudRepositoryJpa<Opera> {

	public OperaRepository(EntityManager em){
		super(em,Opera.class);
	}
}
