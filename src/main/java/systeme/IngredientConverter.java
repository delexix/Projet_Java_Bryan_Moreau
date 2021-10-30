package systeme;

import com.fasterxml.jackson.databind.util.StdConverter;

public class IngredientConverter extends StdConverter<IngredientCuit, Ingredient>{

	@Override
	public Ingredient convert(IngredientCuit value) {
		if(value.getTempsCuisson() == null) {
			return new IngredientFroid(value.getNom());
		}else {
			return value;
		}
		
	}

}
