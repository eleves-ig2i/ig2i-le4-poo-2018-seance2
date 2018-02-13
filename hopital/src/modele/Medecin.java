package modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entité représentant un médecin
 * @author user
 */
@Entity
public class Medecin extends Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(scale = 2, nullable = false)
	private double salaire;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="service")
	private Service service;
	
	@OneToMany(mappedBy="manager",
			cascade=CascadeType.PERSIST)
	private Set<Service> ensServicesDiriges; 
	
	@ManyToOne
	@JoinColumn(name="CHEF")
	private Medecin chef;
	
	@OneToMany(mappedBy="chef",
			cascade=CascadeType.PERSIST)
	private Set<Medecin> subordonnes;
	
	/**
	 * Constructeur par défault
	 */
	public Medecin() {
		super();
		this.ensServicesDiriges = new HashSet<>();
		this.subordonnes = new HashSet<>();
	}

	/**
	 * Constructeur par données
	 * @param nom
	 * @param prenom
	 * @param salaire 
	 */
	public Medecin(String nom, String prenom, double salaire) {
		super(nom, prenom);
		this.ensServicesDiriges = new HashSet<>();
		this.subordonnes = new HashSet<>();
		this.salaire = (salaire > 0) ? ((double)((int)(salaire*100))/100) : 0;
	}

	public double getSalaire() {
		return salaire;
	}
	
	public Service getService() {
		return service;
	}
		
	public Set<Service> getEnsServicesDiriges(){
		return ensServicesDiriges;
	}

	public Set<Medecin> getSubordonnes() {
		return subordonnes;
	}

	public void setSalaire(double salaire) {
		this.salaire = ((double)((int)(salaire*100))/100);
	}

	public void setService(Service service) {
		this.service = service;
	} 

	/**
	 * Ajouter un service à la liste des services dirigés par un médecin
	 * @param s
	 * @return 
	 */
	public boolean addServiceDirige(Service s) {
		Medecin m_old = s.getManager();
		if(ensServicesDiriges.add(s)){
			if(m_old != null){
				m_old.ensServicesDiriges.remove(s);				
			}
			s.setManager(this);
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Définis le médecin en chef
	 * @param m
	 * @return 
	 */
	public boolean setChef(Medecin m) {
		if(m == this) return false;
		else if(m == this.chef) return true;		
		else{
			if(m.subordonnes.add(this)){
				if(this.chef != null) {
					this.chef.subordonnes.remove(this);
				}
				this.chef = m; 
				return true;
			}
			else {
				return false;
			}	 
		}
	}

	@Override
	public String toString() {
		String result = "Médecin "+ super.getId() + " [\n\tNom :" + nom + "\n\tPrénom :" + prenom + 
				"\n\tSalaire :" + salaire + "\n\tDirige les services ";
		for(Service s : ensServicesDiriges){
			result += s.getNom() + " - " + s.getLocalisation();
		}
		return result+"\n]";
	}
	
}
