package service;

	//findAll


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Artista;
import repository.ArtistaRepository;
//dovra delegare le operazioni ad un crudRepository funzionante
public class ArtistaService {

	//entity manager come variabile d'istanza
	private EntityManager em;

	//dobbiamo far diventare il nostro Prodotto una entità, per poterlo
	//poi salvare nel database
	public ArtistaService(){
		
	}
	
	//l'entity manager andrebbe creato una volta sola e basta, quindi dovremmo spostarlo nel contesto dell'applicazione
	//così è a disposizione di tutti ed è implementato una volta sola
	public Artista inserisciArtista(Artista a){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		//ProductRepository productRepository = new ProductRepository(this.em);
		//productRepository.save(prodotto); //poi ha fatto il persist da qui dentro a causa di errori --> da risolvere
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(a);
		et.commit();
		em.close();
		emf.close();
		return a;
	}

	public List<Artista> getArtisti() {
		List<Artista> a = new ArrayList<Artista>();
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Artista> query= em.createNamedQuery("findAll", Artista.class);
		a = query.getResultList();
		et.commit();
		em.close();
		emf.close();
		return a;
		
	}

	public Artista getOneArtista(long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Artista a = em.find(Artista.class,id);
		et.commit();
		em.close();
		emf.close();
		return a;
	}
	
	public void delete(Artista a){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(em.contains(a) ? a : em.merge(a)); //operatore condizionale ternario
		et.commit();
		em.close();
		emf.close();
	}
	
}