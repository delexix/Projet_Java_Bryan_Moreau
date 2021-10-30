package systeme;

public class IngredientFroid extends Ingredient {
	
	//constructeur par défaut
	public IngredientFroid() {
				
	}
	
	//constructeur utilisant le constructeur parent
	public IngredientFroid(String nom) {
		super(nom);
	}

	@Override
	public Double getTempsCuisson() {
		return 0.0;
	}

}
