package modele;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entité représentant une personne
 * @author user
 */
@NamedQueries({
     @NamedQuery(name="Personne.findAll", 
            query="SELECT p FROM Personne p "
    )
})
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(uniqueConstraints = {
		@UniqueConstraint (
			columnNames={"NOM", "PRENOM"}
		)
})
public abstract class Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50,nullable = false)
	protected String nom;
	
	@Column(length = 50,nullable = false)
	protected String prenom;
	
	/**
	 * Constructeur par défault
	 */
	public Personne() {
	}
	
	/**
	 * Constructeur par données
	 * @param nom
	 * @param prenom 
	 */
	public Personne(String nom, String prenom) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom.toUpperCase();
	}

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + Objects.hashCode(this.nom);
		hash = 97 * hash + Objects.hashCode(this.prenom);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Personne other = (Personne) obj;
		if (!Objects.equals(this.nom, other.nom.toUpperCase())) {
			return false;
		}
		if (!Objects.equals(this.prenom, other.prenom)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Personne [\n\tId : " + id + "\n\tNom : " + nom + "\n\tPrénom : " + prenom + "\n]";
	}
	
}