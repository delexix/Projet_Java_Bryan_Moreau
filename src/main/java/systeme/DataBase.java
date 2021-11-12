package systeme;

import java.util.List;

public class DataBase {
	private List<Ingredient> ingredients;
	private List<Menu> menus;
	private List<Produit> produits;
	private List<Client> clients;
	
	/**
	 * Cette classe permet de stocker tout les objets utilisés dans le projet
	 */
	public DataBase() {
		FileJsoner<Ingredient> json = new FileJsoner<Ingredient>("./src/main/resources/Data/ingredient.json",Ingredient.class);
		
		//ajout des ingrédients
		this.ingredients = json.readFromFile();
		
		//ajout des produits
		FileJsoner<Produit> json2 = new FileJsoner<Produit>("./src/main/resources/Data/produit.json",Produit.class);
		this.produits = json2.readFromFile();
		
		//ajout des menus
		FileJsoner<Menu> json3 = new FileJsoner<Menu>("./src/main/resources/Data/menu.json",Menu.class);
		this.menus = json3.readFromFile();
		
		//Ajout des clients
		FileJsoner<Client> json4 = new FileJsoner<Client>("./src/main/resources/Data/client.json",Client.class);
		this.clients = json4.readFromFile();
		
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
