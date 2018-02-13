package modele;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entité représentant une participation
 * @author seb
 */
@Entity
public class Participation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fonction",length = 50, nullable = false)
	private String fonction;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="medecin")
	private Medecin medecin;
	 
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="equipe")
	private Equipe equipe;

	/**
	 * Constructeur par défault
	 */
	public Participation() {
	}
	
	/**
	 * Constructeur par données
	 * @param medecin
	 * @param equipe
	 * @param fonction 
	 */
	public Participation(Medecin medecin, Equipe equipe, String fonction) {
		this.medecin = medecin;
		medecin.addParticipant(this);
		this.equipe = equipe;
		equipe.addParticipation(this);
		this.fonction = fonction.toUpperCase();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction.toUpperCase();
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 29 * hash + Objects.hashCode(this.fonction);
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
		final Participation other = (Participation) obj;
		if (!Objects.equals(this.fonction, other.fonction.toUpperCase())) {
			return false;
		}
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Participation [\n\tFonction=" + fonction + "\n\tMédecin=" + medecin + "\n\tEquipe=" + equipe + "\n]";
	}
	
}