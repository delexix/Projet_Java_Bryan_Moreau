package systeme;

public class IngredientCuit extends Ingredient {
	private String typeCuisson;
	private Double tempsCuisson;
	
	/**
	 * constructeur par d�faut
	 */
	public IngredientCuit() {
		super();
	}
	
	/**
	 * constructeur pour un ingr�dient cuit
	 * @param nom : nom de l'ingr�dient
	 * @param typeCuisson : type de cuisson de l'ingr�dient
	 * @param tempsCuisson : temps de cuisson de l'ingr�dient
	 */
	public IngredientCuit(String nom, String typeCuisson, Double tempsCuisson) {
		super(nom);
		this.typeCuisson = typeCuisson;
		this.tempsCuisson = tempsCuisson;
	}

	//getter et setter
	public String getTypeCuisson() {
		return typeCuisson;
	}

	public void setTypeCuisson(String typeCuisson) {
		this.typeCuisson = typeCuisson;
	}
	
	/**
	 * Remplace le getTempsCuisson d�fini dans la classe parent Ingr�dient
	 * @return Double : temps de cuisson
	 */
	@Override
	public Double getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(Double tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}
	/**
	 * toString pour afficher l'objet
	 * @param String : chaine de caract�re repr�sentant l'ingr�dient cuit
	 */
	@Override
	public String toString() {
		return "[Nom="+super.getNom()+", typeCuisson=" + typeCuisson + ", tempsCuisson=" + tempsCuisson + "]";
	}
	
	
	

}
