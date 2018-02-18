package tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Medecin;

/**
 * Représente les tests sur le JPQL
 */
public class TestJPQL1 {
	public static void main(String[] args) {
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();

		try{
			for(Medecin m : getMedecinsService(em, "CARDIOLOGIE")) {
				System.out.println("Médecin : "+m.getPrenom()+" "+m.getNom());
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

	/**
	 * Retourne la liste des médecins d'un service
	 * @param em
	 * @param serviceName
	 * @return
	 */
	public static List<Medecin> getMedecinsService(EntityManager em, String serviceName) {
		Query query = em.createQuery("SELECT m FROM Medecin m WHERE UPPER(m.service.nom) = :service");
		query.setParameter("service", serviceName.toUpperCase());
		return query.getResultList();
	}
}
