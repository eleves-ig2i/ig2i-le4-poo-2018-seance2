package tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Medecin;

/**
 * Représente les tests sur le JPQL.
 */
public class TestJpql4 {
	/**
	 * TODO.
	 */
	public static void main(String[] args) {
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();
		final EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			for (Medecin m : getMedecinsService(em, "CARDIOLOGIE")) {
				System.out.println("Médecin : " + m.getPrenom() + " "
						+ m.getNom() + " " + m.getSalaire() + " €");
				m.setSalaire(m.getSalaire() + (m.getSalaire() * 0.05));
			}
			et.commit();
			for (Medecin m : getMedecinsService(em, "CARDIOLOGIE")) {
				System.out.println("Médecin : " + m.getPrenom() + " "
						+ m.getNom() + " " + m.getSalaire() + " €");
			}

		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
			if (emf != null && emf.isOpen()) {
				emf.close();
			}
		}
	}

	/**
	 * Retourne la liste des médecins d'un service.
	 * @param em TODO
	 * @param serviceName TODO
	 * @return
	 */
	public static List<Medecin> getMedecinsService(EntityManager em, String serviceName) {
		Query query = em.createQuery("SELECT m FROM Medecin m WHERE UPPER(m.service.nom) = :service");
		query.setParameter("service", serviceName.toUpperCase());
		return query.getResultList();
	}
}
