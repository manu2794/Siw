package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.model.Prodotto;

public class ProductService {
	
	private EntityManager em;

	public ProductService() {
		
	}
	
	public Prodotto inserisciProdotto(Prodotto prodotto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(prodotto);
		tx.commit();
		em.close();
		emf.close();
		return prodotto;
	}

}
