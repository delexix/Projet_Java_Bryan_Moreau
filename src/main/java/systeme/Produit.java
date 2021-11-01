package systeme;

import java.util.List;

public class Produit implements InterfaceTempsCuisson {
	private boolean exclusifMenu;
	private Double prix;
	private String nom;
	private String type;
	private List<Ingredient> ingredients;
	
	/**
	 * constructeur par défaut
	 */
	public Produit() {
		super();	
	}
	
	/**
	 * constructeur avec liste d'ingrédient
	 * @param exclusifMenu : attribut qui montre si le produit est exclusif aux menus ou non
	 * @param prix : prix du produit
	 * @param nom : nom du produit
	 * @param type : type de produit
	 * @param ingredients : liste d'ingrédients composant le produit
	 */
	public Produit(boolean exclusifMenu, Double prix, String nom,String type, List<Ingredient> ingredients) {
		super();
		this.exclusifMenu = exclusifMenu;
		this.prix = prix;
		this.nom = nom;
		this.type=type;
		this.ingredients = ingredients;
	}
	
	/**
	 * permet de calculer le temps que prendra le produit pour être préparé
	 * @return Double : temps de préparation du produit
	 */
	@Override
	public Double calculTemps() {
		Double temps = 0.0;
		
		for(int i=0;i<ingredients.size();i++) {
			temps+=ingredients.get(i).getTempsCuisson();	
		}
		return temps;
	}
	
	/**
	 * toString pour afficher l'objet
	 * @param String : chaine de caractère représentant le produit
	 */
	@Override
	public String toString() {
		return "\nexclusifMenu=" + exclusifMenu + "\n prix=" + prix + "\n nom=" + nom + "\n type=" + type+"\n";
	}

	//getter et setter
	public boolean isExclusifMenu() {
		return exclusifMenu;
	}

	public void setExclusifMenu(boolean exclusifMenu) {
		this.exclusifMenu = exclusifMenu;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
