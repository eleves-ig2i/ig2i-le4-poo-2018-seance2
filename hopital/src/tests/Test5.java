package tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Adresse;
import modele.Equipe;
import modele.Malade;
import modele.Medecin;
import modele.Participation;
import modele.Personne;
import modele.Service;

/**
 * Représente les tests sur les associations médecins et services
 * @author seb
 */
public class Test5 {
	public static void main(String[] args) {
		System.out.println("----- Toutes les personnes -----");
		findAllPersonnes();
		System.out.println("----- Tous les médecins participant à une équipe -----");
		findMedecinsParticipant();
		System.out.println("----- Tous les médecins ne participant à aucune équipe -----");
		findMedecinsNoParticipant();
	}

	public static void findAllPersonnes()
	{
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();

		try
		{
			final EntityTransaction et = em.getTransaction();
			try{

				Query query = em.createNamedQuery("Personne.findAll");
				List<Personne> personnes = query.getResultList();

				for(Personne p : personnes){
					System.out.println(p.toString());
				}
			}
			catch (Exception ex){
				System.out.println("Exception : "+ex);
				et.rollback();
			}
		}
		finally
		{
			if(em != null && em.isOpen()){
					em.close();
			}
			if(emf != null && emf.isOpen()){
					emf.close();
			}
		}
	}

	public static void findMedecinsParticipant()
	{
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();

		try
		{
			final EntityTransaction et = em.getTransaction();
			try{

				Query query = em.createNamedQuery("Medecin.findParticipantEquipe");
				List<Medecin> medecins = query.getResultList();

				for(Medecin m : medecins){
					System.out.println(m.toString());
				}
			}
			catch (Exception ex){
				System.out.println("Exception : "+ex);
				et.rollback();
			}
		}
		finally
		{
			if(em != null && em.isOpen()){
					em.close();
			}
			if(emf != null && emf.isOpen()){
					emf.close();
			}
		}
	}

	public static void findMedecinsNoParticipant()
	{
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();

		try
		{
			final EntityTransaction et = em.getTransaction();
			try{

				Query query = em.createNamedQuery("Medecin.findParticipantNoEquipe");
				List<Medecin> medecins = query.getResultList();

				for(Medecin m : medecins){
					System.out.println(m.toString());
				}
			}
			catch (Exception ex){
				System.out.println("Exception : "+ex);
				et.rollback();
			}
		}
		finally
		{
			if(em != null && em.isOpen()){
					em.close();
			}
			if(emf != null && emf.isOpen()){
					emf.close();
			}
		}
	}
}
