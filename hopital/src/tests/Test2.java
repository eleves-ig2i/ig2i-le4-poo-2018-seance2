package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modele.Medecin;

/**
 * Représente les tests sur les médecins
 * @author user
 */
public class Test2 {
	public static void main(String[] args) {
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();

		try{
			final EntityTransaction et = em.getTransaction();
			try{
				et.begin();
				// création d’entités persistantes
				Medecin med1 = new Medecin("Trancen", "Jean", 2135.23);
				Medecin med2 = new Medecin("Gator", "Coralie", 3156.00);
				Medecin med3 = new Medecin("Gator", "Magalie", 2545.3723);
				em.persist(med1);
				em.persist(med2);
				em.persist(med3);
				et.commit();

			} catch (Exception ex) {
				et.rollback();
			}
		} finally {
			if(em != null && em.isOpen()){
				em.close();
			}
			if(emf != null && emf.isOpen()){
				emf.close();
			}
		}
	}
}
