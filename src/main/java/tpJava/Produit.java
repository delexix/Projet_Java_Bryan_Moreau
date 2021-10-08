package tpJava;

import java.util.List;

public class Produit {
	private boolean exclusifMenu;
	private Double prix;
	private String nom;
	private String type;
	private List<Ingredient> ingredients;
	
	//constructeur par défaut
	public Produit() {
			
	}
	
	//constructeur avec liste d'ingrédient
	public Produit(boolean exclusifMenu, Double prix, String nom,String type, List<Ingredient> ingredients) {
		super();
		this.exclusifMenu = exclusifMenu;
		this.prix = prix;
		this.nom = nom;
		this.type=type;
		this.ingredients = ingredients;
	}
	
	//permet de calculer le temps que prendra le produit pour être préparé
	public Double calculTemps() {
		Double temps = 0.0;
		
		for(int i=0;i<ingredients.size();i++) {
			if(ingredients.get(i) instanceof IngredientCuit) {
				temps+=((IngredientCuit)(ingredients.get(i))).getTempsCuisson();
			}		
		}
		return temps;
	}

	//toString pour afficher l'objet
	@Override
	public String toString() {
		return "Produit [exclusifMenu=" + exclusifMenu + ", prix=" + prix + ", nom=" + nom + ", type=" + type
				+ ", ingredients=" + ingredients + "]";
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
