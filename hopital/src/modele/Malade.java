package modele;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "rue",column = @Column(name="rue",nullable = false)),
		@AttributeOverride(name = "ville",column = @Column(name="ville",nullable = false))
	})
	private Adresse adresse;
	
	/**
	 * Constructeur par défault
	 */
	public Malade(){		
	}

	/**
	 * Constructeur par données
	 * @param nom
	 * @param prenom 
	 * @param adresse 
	 */
	public Malade(String nom, String prenom, Adresse adresse) {
		super(nom, prenom);
		this.adresse = new Adresse(adresse.getNumero(), adresse.getRue(), adresse.getVille());
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Malade "+ super.getId() + " [\n\tNom :" + nom + "\n\tPrénom :" + prenom + 
				"\n]";
	}
	
}