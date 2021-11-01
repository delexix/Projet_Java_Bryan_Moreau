package systeme;

import java.util.List;

public class Menu implements InterfaceTempsCuisson{
	private String nom;
	private Double prix;
	private List<Produit> produits;
	
	/**
	 * constructeur par d�faut
	 */
	public Menu() {
		super();
	}
	
	/**
	 * constructeur avec liste
	 * @param nom : nom du menu
	 * @param prix : prix du menu
	 * @param produits : liste des produits du menu
	 */
	public Menu(String nom, Double prix, List<Produit> produits) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.produits = produits;
	}
	
	/**
	 * permet de calculer le temps que prendra le menu pour �tre pr�par�
	 * @return Double : temps de pr�paration du menu
	 */
	@Override
	public Double calculTemps() {
		Double temps = 0.0;

		for(int i=0;i<produits.size();i++) {
			temps+=produits.get(i).calculTemps();
		}
		return temps;
	}
	
	/**
	 * toString pour afficher l'objet
	 * @param String : chaine de caract�re repr�sentant le menu
	 */
	@Override
	public String toString() {
		return "nom=" + nom + ", prix=" + prix + ", produits=" + produits+"\n";
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
