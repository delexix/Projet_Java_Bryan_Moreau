package systeme;

import java.util.Optional;

public class BorneCommande {
	private DataBase data;

	/**
	 * constructeur de la borne de commande
	 */
	public BorneCommande() {
		super();
		this.data= new DataBase();
	}
	
	/**
	 * permet de trouver le client grâce à son numero, s'il n'est pas trouver un Optional empty est renvoyé
	 * @param numero : numero de client
	 * @return Optional<Client> : classe permetant de ne pas avoir de null, si l'utilisateur a mis le bon numéro le Optional aura une valeur
	 */
	public Optional<Client> identifier(Integer numero) {
		boolean trouver = false;
		int i=0;
		Client c = null;
		while ((!trouver) && i<data.getClients().size()) {
			if(data.getClients().get(i).getNumero().compareTo(numero) == 0) {
				trouver = true;
				c=data.getClients().get(i);
			}
			i++;
		}
		return Optional.ofNullable(c);
	}
	
	/**
	 * trouve le menu selon son nom
	 * @param value : nom du menu recherché
	 * @return Menu : menu recherché
	 */
	public Menu findMenu(String value) {
		int i=0;
		boolean trouver = false;
		Menu menu = null;
		while(this.data.getMenus().size()>i && !trouver) {
			if(this.data.getMenus().get(i).getNom().equals(value)) {
				menu = this.data.getMenus().get(i);
				trouver = true;
			}
			i++;
		}
		return menu;
	}
	
	/**
	 * trouve le produit selon son nom
	 * @param value : nom du produit recherché
	 * @return Produit : produit recherché
	 */
	public Produit findProduit(String value) {
		int i=0;
		boolean trouver = false;
		Produit produit = null;
		
		while(this.data.getProduits().size()>i && !trouver) {
			if(this.data.getProduits().get(i).getNom().equals(value)) {
				produit = this.data.getProduits().get(i);
				trouver = true;
			}
			i++;
		}
		return produit;
	}
	

	//getter et setter
	public DataBase getData() {
		return data;
	}

	public void setData(DataBase data) {
		this.data = data;
	}
}
