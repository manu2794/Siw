package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import repository.OperaRepository;
import model.Opera;


//dovra delegare le operazioni ad un crudRepository funzionante
public class OperaService {

	//entity manager come variabile d'istanza
	private EntityManager em;

	//dobbiamo far diventare il nostro Prodotto una entità, per poterlo
	//poi salvare nel database
	public OperaService(){
		
	}
	
	//l'entity manager andrebbe creato una volta sola e basta, quindi dovremmo spostarlo nel contesto dell'applicazione
	//così è a disposizione di tutti ed è implementato una volta sola
	public Opera inserisciOpera(Opera o){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		//ProductRepository productRepository = new ProductRepository(this.em);
		//productRepository.save(prodotto); //poi ha fatto il persist da qui dentro a causa di errori --> da risolvere
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(o);
		et.commit();
		em.close();
		emf.close();
		return o;
	}

	public List<Opera> getOpere() {
		List<Opera> o = new ArrayList<Opera>();
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Opera> query= em.createNamedQuery("findAll", Opera.class);
		o = query.getResultList();
		et.commit();
		em.close();
		emf.close();
		return o;
		
	}

	public Opera getOneOpera(long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Opera o = em.find(Opera.class,id);
		et.commit();
		em.close();
		emf.close();
		return o;
	}
	
	public void delete(Opera p){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazioneCompleta-unit");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(em.contains(p) ? p : em.merge(p)); //operatore condizionale ternario
		et.commit();
		em.close();
		emf.close();
	}
	
}
