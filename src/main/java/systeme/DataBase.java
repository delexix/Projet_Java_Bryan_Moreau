package systeme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {
	private List<Ingredient> ingredients;
	private List<Menu> menus;
	private List<Produit> produits;
	private List<Client> clients;
	
	//Cette classe permet de stocké tout les objets utilisé dans le projet
	public DataBase() {
		
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
		this.ingredients = new ArrayList<Ingredient>(Arrays.asList(ing1,ing2,ing3,ing4,ing5,ing6,ing7,ing8,ing9,ing10,ing11,ing12,ing13));
		
		//création des produits
		Produit coca = new Produit(false,1.60,"Coca-Cola","Boisson",new ArrayList<Ingredient>(Arrays.asList(ing3)));
		
		Produit bigMax = new Produit(true,4.50,"Big Max","Plat Principal",new ArrayList<Ingredient>(Arrays.asList(ing1,ing4,ing5,ing6,ing7,ing9,ing10,ing11)));
		
		Produit salade = new Produit(false,1.60,"Salade composé","Accompagnement",new ArrayList<Ingredient>(Arrays.asList(ing4,ing5,ing7)));
		
		Produit frites = new Produit(false,0.60,"Frites","Accompagnement",new ArrayList<Ingredient>(Arrays.asList(ing12)));

		Produit nuggets = new Produit(false,1.0,"Nuggets","Plat Principal",new ArrayList<Ingredient>(Arrays.asList(ing13)));
		
		Produit eau = new Produit(false,0.20,"Eau","Boisson",new ArrayList<Ingredient>(Arrays.asList(ing2)));
		
		//ajout des produits
		this.produits = new ArrayList<Produit>(Arrays.asList(coca,bigMax,salade,frites,nuggets,eau));
		
		//création des menus
		List<Produit> menu1 = new ArrayList<Produit>(Arrays.asList(bigMax,frites,coca));
		Menu menuNorm = new Menu("Menu Big Max",5.50,menu1);
		
		List<Produit> menu2 = new ArrayList<Produit>(Arrays.asList(nuggets,frites,eau));
		Menu menuEnfant = new Menu("Menu Enfant",1.50,menu2);
		
		//ajout des menus
		this.menus = new ArrayList<Menu>(Arrays.asList(menuNorm,menuEnfant));
		
		//Ajout des clients
		Client c = new Client(21,"Bryan","Moreau");
		Client c1 = new Client(01,"Geoffrey","Yozo");

		this.clients = new ArrayList<Client>(Arrays.asList(c,c1));
		
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

	public List<Client> getClients() {
		return clients;
	}
	
}
