package it.uniroma3.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.model.Prodotto;
import it.uniroma3.repository.ProductRepository;
//dovra delegare le operazioni ad un crudRepository funzionante
public class ProductService {

	//entity manager comme variabile d'istanza
	private EntityManager em;

	//dobbiamo far diventare il nostro Prodotto una entit�, per poterlo
	//poi salvare nel database
	public ProductService(){
		
	}
	
	//l'entity manager andrebbe creato una volta sola e basta, quindi dovremmo spostarlo nel contesto dell'applicazione
	//cos� � a disposizione di tutti ed � implementato una volta sola
	public Prodotto inserisciProdotto(Prodotto p){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		//ProductRepository productRepository = new ProductRepository(this.em);
		//productRepository.save(prodotto); //poi ha fatto il persist da qui dentro a causa di errori --> da risolvere
		em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
		em.close();
		emf.close();
		return p;
	}

	public List<Prodotto> getProdotti() {
		List<Prodotto> p = new ArrayList<Prodotto>();
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		TypedQuery<Prodotto> query= em.createNamedQuery("findAll", Prodotto.class);
		p=query.getResultList();
		et.commit();
		em.close();
		emf.close();
		return p;
		
	}

	public Prodotto getOneProduct(long id) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		Prodotto p=em.find(Prodotto.class,id);
		et.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public void delete(Prodotto p){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		et.begin();
		em.remove(em.contains(p) ? p : em.merge(p));
		et.commit();
		em.close();
		emf.close();
	}
	
}
