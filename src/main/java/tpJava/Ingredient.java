package tpJava;

public abstract class Ingredient {
	private String nom;

	//constructeur d'ingrédient
	public Ingredient(String nom) {
		super();
		this.nom = nom;
	}

	//getter et setter
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
