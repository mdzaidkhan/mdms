package mdms.jpa.entity.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EntityManagerBean {
	@PersistenceContext
	private	EntityManager em;
	
	private EntityManagerFactory emf;
	
	public EntityManager getEntityManager(){		
		emf = Persistence.createEntityManagerFactory("showcase");
		em = emf.createEntityManager();
		return em;		
	}	
	
	public void closeEntityManager(){
		if(em != null){
			em.close();
			if(emf != null){
				emf.close();
			}
		}
		else if(emf != null){
			emf.close();
		}
	}
}

