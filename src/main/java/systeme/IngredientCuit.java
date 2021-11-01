package systeme;

public class IngredientCuit extends Ingredient {
	private String typeCuisson;
	private Double tempsCuisson;
	
	/**
	 * constructeur par défaut
	 */
	public IngredientCuit() {
		super();
	}
	
	/**
	 * constructeur pour un ingrédient cuit
	 * @param nom : nom de l'ingrédient
	 * @param typeCuisson : type de cuisson de l'ingrédient
	 * @param tempsCuisson : temps de cuisson de l'ingrédient
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
	 * Remplace le getTempsCuisson défini dans la classe parent Ingrédient
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
	 * @param String : chaine de caractère représentant l'ingrédient cuit
	 */
	@Override
	public String toString() {
		return "[Nom="+super.getNom()+", typeCuisson=" + typeCuisson + ", tempsCuisson=" + tempsCuisson + "]";
	}
	
	
	

}
