package systeme;

import com.fasterxml.jackson.databind.util.StdConverter;

public class IngredientConverter extends StdConverter<IngredientCuit, Ingredient>{

	/**
	 * Converti les ingrédients froid récupéré dans le JSON en tant qu'ingrédient cuit
	 * @return Ingrédient : ingrédient converti
	 */
	@Override
	public Ingredient convert(IngredientCuit value) {
		if(value.getTempsCuisson() == null) {
			return new IngredientFroid(value.getNom());
		}else {
			return value;
		}
		
	}

}
