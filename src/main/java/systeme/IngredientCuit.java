package systeme;

public class IngredientCuit extends Ingredient {
	private String typeCuisson;
	private Double tempsCuisson;
	
	//constructeur par d�faut
	public IngredientCuit() {
				
	}
	
	//constructeur pour un ingr�dient cuit
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

	public Double getTempsCuisson() {
		return tempsCuisson;
	}

	public void setTempsCuisson(Double tempsCuisson) {
		this.tempsCuisson = tempsCuisson;
	}

	@Override
	public String toString() {
		return "[Nom="+super.getNom()+", typeCuisson=" + typeCuisson + ", tempsCuisson=" + tempsCuisson + "]";
	}
	
	
	

}
