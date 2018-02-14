package modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entité représentant une équipe
 * @author seb
 */
@Entity
public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false, unique=true)
	public String nom;
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	public Set<Participation> participe;
	
	/**
	 * Constructeur par défault
	 */
	public Equipe() {
		this.participe = new HashSet<Participation>();
	}
	
	/**
	 * Constructeur par par données
	 * @param nom
	 */
	public Equipe(String nom) {
		this();
		this.nom = nom.toUpperCase();
	}
	
	
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 11 * hash + Objects.hashCode(this.nom);
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
		final Equipe other = (Equipe) obj;
		if (!Objects.equals(this.nom, other.nom.toUpperCase())) {
			return false;
		}
		return true;
	}
	
	/**
	 * Ajoute une participation à une équipe
	 * @param p 
	 */
	public void addParticipation(Participation p){
		this.participe.add(p);
	}

	@Override
	public String toString() {
		return " Equipe [\n\tId : " + id + "\n\tNom : " + nom + "\n]";
	}
	
}