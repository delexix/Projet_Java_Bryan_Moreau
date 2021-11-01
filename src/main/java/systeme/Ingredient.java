package systeme;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = IngredientCuit.class,converter=IngredientConverter.class)
public abstract class Ingredient{
	private String nom;

	/**
	 * constructeur par d�faut
	 */
	public Ingredient() {
		super();
	}
		
	/**
	 * constructeur d'ingr�dient
	 * @param nom : nom de l'ingr�dient
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
	 * renvoie le temps de cuisson de l'ingr�dient
	 * @return Double : temps de cuisson de l'ingr�dient
	 */
	public Double getTempsCuisson() {
		return 0.0;
	};
	
}
