package tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 * Représente les tests sur le JPQL
 */
public class TestJPQL2 {
	public static void main(String[] args) {
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();
		
		try{
			for(Object[] values : getInfosMedecinsService(em, "CARDIOLOGIE")) {
				System.out.println("Médecin : "+values[1]+" "+values[0]+ " "+values[2]+" €");
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
	 * Retourne les noms, prenoms et salaires des médecins d'un service
	 * @param em
	 * @param serviceName
	 * @return 
	 */
	public static List<Object[]> getInfosMedecinsService(EntityManager em, String serviceName) {
        Query query = em.createQuery("SELECT m.nom, m.prenom, m.salaire FROM Medecin m WHERE UPPER(m.service.nom) = :service");
        query.setParameter("service", serviceName.toUpperCase());        
        return query.getResultList();
    }
}