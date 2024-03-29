package systeme;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String nom;
	private String prenom;
	private Integer numero;
	private List<Commande> commandes;

	/**
	 * constructeur par d�faut
	 */
	public Client() {
		super();
	}
	
	/**
	 * constructeur sans liste de commande
	 * @param numero : numero de client
	 * @param prenom : prenom du client
	 * @param nom : nom du client
	 */
	public Client(Integer numero,String prenom, String nom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.commandes = new ArrayList<Commande>();
	}
	
	/**
	 * constructeur avec liste de commande
	 * @param numero : numero de client
	 * @param prenom : prenom du client
	 * @param nom : nom du client
	 * @param commandes : liste des commandes du client
	 */
	public Client(Integer numero,String prenom, String nom, List<Commande> commandes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.commandes = commandes;
	}

	//getter et setter
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
