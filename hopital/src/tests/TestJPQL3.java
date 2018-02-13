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
public class TestJPQL3 {
	public static void main(String[] args) {
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();
		
		try{
			for(Medecin m : getMedecinsChef(em, "Trancen", "Jean")) {
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
	 * @param chefName
	 * @param chefFirstName
	 * @return 
	 */
	public static List<Medecin> getMedecinsChef(EntityManager em, String chefName, String chefFirstName) {
		Query query = em.createNamedQuery("Medecin.findMedecinByChef");
		query.setParameter("nomChef", chefName.toUpperCase()); 
		query.setParameter("prenomChef", chefFirstName.toUpperCase());
		return query.getResultList();
	}
}