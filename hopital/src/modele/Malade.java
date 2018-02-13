package modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entité représentant un malade
 * @author user
 */
@Entity
public class Malade extends Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Constructeur par défault
	 */
	public Malade(){		
	}

	/**
	 * Constructeur par données
	 * @param nom
	 * @param prenom 
	 */
	public Malade(String nom, String prenom) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom.toUpperCase();
	}	
	
	@Override
	public String toString() {
		return "Malade "+ super.getId() + " [\n\tNom :" + nom + "\n\tPrénom :" + prenom + 
				"\n]";
	}
	
}