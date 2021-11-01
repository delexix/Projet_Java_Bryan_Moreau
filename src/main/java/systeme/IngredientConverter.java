package systeme;

import com.fasterxml.jackson.databind.util.StdConverter;

public class IngredientConverter extends StdConverter<IngredientCuit, Ingredient>{

	/**
	 * Converti les ingr�dients froid r�cup�r� dans le JSON en tant qu'ingr�dient cuit
	 * @return Ingr�dient : ingr�dient converti
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
