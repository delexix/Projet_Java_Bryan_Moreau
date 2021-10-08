package tpJava;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	private List<Ingredient> ingredients;
	private List<Menu> menus;
	private List<Produit> produits;
	
	//Cette classe permet de stocké tout les objets utilisé dans le projet
	public DataBase() {
		
		//initialisation des listes
		this.ingredients = new ArrayList<Ingredient>();
		this.menus = new ArrayList<Menu>();
		this.produits = new ArrayList<Produit>();
		
		//création des ingrédients
		Ingredient ing1 = new IngredientCuit("Steak","Grill",1.5);
		Ingredient ing2 = new IngredientFroid("Eau");
		Ingredient ing3 = new IngredientFroid("Coca-Cola");
		Ingredient ing4 = new IngredientFroid("Salade");
		Ingredient ing5 = new IngredientFroid("Tomate");
		Ingredient ing6 = new IngredientFroid("Pain à burger");
		Ingredient ing7 = new IngredientFroid("Fromage");
		Ingredient ing8 = new IngredientFroid("Eau");
		Ingredient ing9 = new IngredientFroid("Cornichon");
		Ingredient ing10 = new IngredientFroid("Sauce Secrète");
		Ingredient ing11 = new IngredientCuit("Bacon","Grill",1.0);
		Ingredient ing12 = new IngredientCuit("Frite","Graisse à frites",2.0);
		Ingredient ing13 = new IngredientCuit("Nugget de poulet","Graisse à frites",1.0);
		
		//ajout des ingrédients
		Ingredient[] ings = {ing1,ing2,ing3,ing4,ing5,ing6,ing7,ing8,ing9,ing10,ing11,ing12,ing13};
		for(int i = 0;i<ings.length;i++) {
			this.ingredients.add(ings[i]);
		}
		
		//création des produits
		List<Ingredient> ingres1 = new ArrayList<Ingredient>();
		ingres1.add(ing3);
		Produit coca = new Produit(false,1.60,"Coca-Cola","Boisson",ingres1);
		
		List<Ingredient> ingres2 = new ArrayList<Ingredient>();
		ingres2.add(ing1);
		ingres2.add(ing4);
		ingres2.add(ing5);
		ingres2.add(ing6);
		ingres2.add(ing7);
		ingres2.add(ing9);
		ingres2.add(ing10);
		ingres2.add(ing11);
		Produit bigMax = new Produit(true,4.50,"Big Max","Plat Principal",ingres2);
		
		List<Ingredient> ingres3 = new ArrayList<Ingredient>();
		ingres3.add(ing4);
		ingres3.add(ing5);
		ingres3.add(ing7);
		Produit salade = new Produit(false,1.60,"Salade composé","Accompagnement",ingres3);
		
		List<Ingredient> ingres4 = new ArrayList<Ingredient>();
		ingres4.add(ing12);
		Produit frites = new Produit(false,0.60,"Frites","Accompagnement",ingres4);
		
		List<Ingredient> ingres5 = new ArrayList<Ingredient>();
		ingres5.add(ing13);
		Produit nuggets = new Produit(false,1.0,"Nuggets","Plat Principal",ingres5);
		
		List<Ingredient> ingres6 = new ArrayList<Ingredient>();
		ingres6.add(ing2);
		Produit eau = new Produit(false,0.20,"Eau","Boisson",ingres6);
		
		//ajout des produits
		Produit[] prod = {coca,bigMax,salade,frites,nuggets,eau};
		for(int i = 0;i<prod.length;i++) {
			this.produits.add(prod[i]);
		}
		
		//création des menus
		List<Produit> menu1 = new ArrayList<Produit>();
		menu1.add(bigMax);
		menu1.add(frites);
		menu1.add(coca);
		Menu menuNorm = new Menu("Menu Big Max",5.50,menu1);
		
		List<Produit> menu2 = new ArrayList<Produit>();
		menu2.add(nuggets);
		menu2.add(frites);
		menu2.add(eau);
		Menu menuEnfant = new Menu("Menu Enfant",1.50,menu2);
		
		//ajout des menus
		Menu[] menu = {menuNorm,menuEnfant};
		for(int i = 0;i<menu.length;i++) {
			this.menus.add(menu[i]);
		}
		
	}
	
	//getter et setter
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public List<Produit> getProduits() {
		return produits;
	}
	
}
