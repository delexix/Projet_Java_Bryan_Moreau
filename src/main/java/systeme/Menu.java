package systeme;

import java.util.List;

public class Menu {
	private String nom;
	private Double prix;
	private List<Produit> produits;
	
	//constructeur par défaut
	public Menu() {
		
	}
	
	//constructeur avec liste
	public Menu(String nom, Double prix, List<Produit> produits) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.produits = produits;
	}
	
	//permet de calculer le temps que prendra le menu pour être préparé
	public Double calculTemps() {
		Double temps = 0.0;

		for(int i=0;i<produits.size();i++) {
			temps+=produits.get(i).calculTemps();
		}
		return temps;
	}
	
	//toString pour afficher l'objet
	@Override
	public String toString() {
		return "Menu [nom=" + nom + ", prix=" + prix + ", produits=" + produits + "]";
	}

	//getter et setter
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
	
}
