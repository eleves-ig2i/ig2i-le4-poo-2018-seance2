package modele;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Représente l'adresse
 * @author user
 */
@Embeddable
public class Adresse implements Serializable {

	private int numero;
	private String rue;
	private String ville;

	/**
	 * Contructeur par défault
	 */
	public Adresse() {
	}	
	
	/**
	 * Constructeur par donnés
	 * @param numero
	 * @param rue
	 * @param ville 
	 */
	public Adresse(int numero, String rue, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}	

	@Override
	public String toString() {
		return "Adresse[\n\tNuméro : " + numero + "\n\tRue : " + rue + "\n\tVille : " + ville + "\n]";
	}
	
}