package systeme;

import java.util.ArrayList;
import java.util.List;

public class Commande {

	private String statut;
	private Double prix;
	private Client client;
	private List<Produit> produits;
	private List<Menu> menus;
	
	//constructeur sans listes et avec le prix initialisé à 0
	public Commande(String statut, Client client) {
		super();
		this.statut = statut;
		this.prix = 0.0;
		this.client = client;
		this.produits = new ArrayList<Produit>();
		this.menus = new ArrayList<Menu>();
	}
	
	//constructeur sans listes
	public Commande(String statut, Double prix, Client client) {
		super();
		this.statut = statut;
		this.prix = prix;
		this.client = client;
		this.produits = new ArrayList<Produit>();
		this.menus = new ArrayList<Menu>();
	}
	//constructeur avec listes
	public Commande(String statut, Double prix, Client client, List<Produit> produits, List<Menu> menus) {
		super();
		this.statut = statut;
		this.prix = prix;
		this.client = client;
		this.produits = produits;
		this.menus = menus;
	}
	
	//permet de calculer le temps que prendra la commande pour être préparé
	public Double calculTemps() {
		Double temps = 0.0;
		
		for(int i=0;i<menus.size();i++) {
			temps+=menus.get(i).calculTemps();
		}
		for(int i=0;i<produits.size();i++) {
			temps+=produits.get(i).calculTemps();
		}
		return temps;
	}
	
	//change le statut de la commande
	public void nextStatut() {
		if(this.getStatut().equals("En cours")) {
			this.setStatut("Validé");
		}else if(this.getStatut().equals("Validé")) {
			this.setStatut("Terminé");
		}
	}
	//permet de calculer le prix de la commande
	public void calculPrix() {
		Double prix = 0.0;
		
		for(int i=0;i<menus.size();i++) {
			prix+=menus.get(i).getPrix();
		}
		for(int i=0;i<produits.size();i++) {
			prix+=produits.get(i).getPrix();
		}
		this.prix=arrondir(prix,2);
	}
	
	//effectue un arrondie pour les prix
	public double arrondir(double nombre,double nbApVirg){
		return(double)((int)(nombre * Math.pow(10,nbApVirg) + .5)) / Math.pow(10,nbApVirg);
	}
	
	//toString pour afficher l'objet
	@Override
	public String toString() {
		return "Commande [statut=" + statut + ", prix=" + prix + ", client=" + client + ", produits=" + produits
				+ ", menus=" + menus + "]";
	}

	//getter et setter
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
		
}
