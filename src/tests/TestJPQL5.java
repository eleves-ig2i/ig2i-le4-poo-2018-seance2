package tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Medecin;

/**
 * Représente les tests sur le JPQL
 */
public class TestJPQL5 {
	public static void main(String[] args) {
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();
		final EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("UPDATE Medecin m SET m.salaire = :salaire");
		query.setParameter("salaire", 2000);

		try{
			List<Medecin> medecins = getMedecins(em);
			for(Medecin m : medecins) {
				System.out.println("Médecin : "+m.getPrenom()+" "+m.getNom()+" "+m.getSalaire()+" €");
			}
			System.out.println("\n\n");
			et.begin();
			// mise à jour en volume
			query.executeUpdate();
			et.commit();

			for(Medecin m : medecins) {
				System.out.println("Médecin : "+m.getPrenom()+" "+m.getNom()+" "+m.getSalaire()+" €");
			}
			System.out.println("\n\n");

			// mise à jour du contexte de persistance
			for(Medecin m : medecins) {
				em.refresh(m);
			}

			for(Medecin m : medecins) {
				System.out.println("Médecin : "+m.getPrenom()+" "+m.getNom()+" "+m.getSalaire()+" €");
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
	 * Retourne la liste des médecins
	 * @param em
	 * @return
	 */
	public static List<Medecin> getMedecins(EntityManager em) {
		Query query = em.createQuery("SELECT m FROM Medecin m");
		return query.getResultList();
	}
}
