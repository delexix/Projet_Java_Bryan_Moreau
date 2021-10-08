package tpJava;

public class IngredientCuit extends Ingredient {
	private String typeCuisson;
	private Double tempsCuisson;
	
	//constructeur pour un ingrédient cuit
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
	
	

}
