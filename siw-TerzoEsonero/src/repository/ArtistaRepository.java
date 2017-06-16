package repository;

import javax.persistence.EntityManager;

import model.Artista;

public class ArtistaRepository extends CrudRepositoryJpa<Artista> {

	public ArtistaRepository(EntityManager em){
		super(em, Artista.class);
	}
}
