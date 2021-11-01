package systeme;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = IngredientCuit.class,converter=IngredientConverter.class)
public abstract class Ingredient{
	private String nom;

	/**
	 * constructeur par défaut
	 */
	public Ingredient() {
		super();
	}
		
	/**
	 * constructeur d'ingrédient
	 * @param nom : nom de l'ingrédient
	 */
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
	/**
	 * renvoie le temps de cuisson de l'ingrédient
	 * @return Double : temps de cuisson de l'ingrédient
	 */
	public Double getTempsCuisson() {
		return 0.0;
	};
	
}
