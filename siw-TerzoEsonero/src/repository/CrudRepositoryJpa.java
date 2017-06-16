package repository;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CrudRepositoryJpa<T> implements CrudRepository<T> {
	private EntityManager em;
	private Class<T> entityClass; // serve a farci passare la classe dell'oggetto.
	
	public CrudRepositoryJpa(EntityManager em, Class<T> entityClass) {
		this.em = em;
		this.entityClass = entityClass;
		
	}
	
	private String getClassName() {
		String fullClassName = this.entityClass.getCanonicalName(); //ritorna il nome della classe
		String className = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		
		return className;
	}

	//la soluzione fatta da tiziano presupponeva che ci fosse sempre un attributo id, cosa non sempre vera. 
	//Facciamo una cosa più didattica: il metodo getId potrebbe non esistere
	//sfruttiamo il fatto che ogni entità  ha @Id, quindi c'è una qualche informazione che ci dice che quella variabile è la chiave.
	//mi cerco l'attributo che è stato marcato come id. --> ALLA FINE SI USANO DELLE LIBRERIE PER FARE QUESTO
	@Override
	public T save(T entity) {
		Method getId = null;
		T persistentEntity = null;
		try {
			getId = this.entityClass.getMethod("getId");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			if (getId.invoke(entity) == null) {
				em.persist(entity);
				persistentEntity = entity;
			} else {
				persistentEntity = em.merge(entity);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return persistentEntity;
	}

	@Override
	public T findOne(Long id) {
		return em.find(this.entityClass, id);
	}

	@Override
	public List<T> findAll() {
		//passiamo la classe come tipo e lui restituisce una lista(non più di oggetti ma di tipo T)
		TypedQuery<T> query = em.createQuery("SELECT e FROM " + this.getClassName() + " e", this.entityClass);
		return query.getResultList();
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);		
	}

	@Override
	public void deleteAll() {
		Query query = em.createQuery("DELETE FROM " + this.getClassName());
		query.executeUpdate();
	}

	protected EntityManager getEm() {
		return this.em;		//protected cosi lo usano solo per le classi che la estendono
	}
}