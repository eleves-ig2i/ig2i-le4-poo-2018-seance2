package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import modele.Adresse;
import modele.Equipe;
import modele.Malade;
import modele.Medecin;
import modele.Participation;
import modele.Service;

/**
 * Représente les tests sur les associations médecins et services.
 * @author seb
 */
public class Test4 {
	/**
	 * TODO.
	 */
	public static void main(String[] args) {
		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopitalPU");
		final EntityManager em = emf.createEntityManager();

		try {
			final EntityTransaction et = em.getTransaction();
			try {
				et.begin();
				// création d’entités persistantes
				Service serv1 = new Service("Cardiologie", "Bat A, 1er étage");
				Service serv2 = new Service("Pneumologie", "Bat B, 1er étage");
				Service serv3 = new Service("Urgence", "Bat C, 1er étage");
				Medecin med1 = new Medecin("Trancen", "Jean", 2135.23);
				Medecin med2 = new Medecin("Gator", "Coralie", 3156.00);
				Medecin med3 = new Medecin("Gator", "Magalie", 2545.37);
				Medecin med4 = new Medecin("Hitmieu", "Helmer", 1873.30);
				Medecin med5 = new Medecin("Cambronne", "Maude", 3765.20);
				Medecin med6 = new Medecin("Haybon", "Sylvain", 2980.00);
				Malade mal1 = new Malade("Proviste", "Alain",new Adresse(5, "Rue Jean Souvraz", "LENS"));
				Malade mal2 = new Malade("Trahuil", "Phil",new Adresse(35, "Avenue De Gaulle", "LILLE"));
				Malade mal3 = new Malade("Aœncieux", "Cecile",new Adresse(2, "Route de la gare", "ARRAS"));
				Malade mal4 = new Malade("Conda", "Anna",new Adresse(23, "Route nationale", "CALAIS"));
				Equipe eq1 = new Equipe("equipe 1");
				Equipe eq2 = new Equipe("equipe 2");
				Participation part1 = new Participation(med1,eq1,"chirurgien");
				Participation part2 = new Participation(med1,eq2,"assistant chirurgien");
				Participation part3 = new Participation(med2,eq1,"anesthésiste");
				Participation part4 = new Participation(med3,eq2,"cardiologue");
				Participation part5 = new Participation(med4,eq1,"interne");
				Participation part6 = new Participation(med4,eq2,"interne");

				serv1.addMedecin(med1);
				serv1.addMedecin(med2);
				serv1.addMedecin(med3);
				serv2.addMedecin(med4);
				serv3.addMedecin(med5);
				serv3.addMedecin(med6);
				med4.addServiceDirige(serv2);
				med5.addServiceDirige(serv1);
				med5.addServiceDirige(serv3);
				med2.setChef(med1); // Ajout du médecin 1 comme chef du médecin 2
				med3.setChef(med1);
				med5.setChef(med6);

				em.persist(serv1);
				em.persist(serv2);
				em.persist(serv3);

				em.persist(mal1);
				em.persist(mal2);
				em.persist(mal3);
				em.persist(mal4);
				et.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				et.rollback();
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
}
