package tpJava;

import java.util.Date;
import java.util.List;

public class HistoriqueCommande {
	private String dateCommande;
	private Double prix;
	private List<Menu> menus;
	private List<Produit> produitsHorsMenu;
	
	//constructeur de la classe qui va permettre de stocké les informations des commandes dans le fichier
	public HistoriqueCommande(Date dateCommande, Double prix, List<Menu> menus, List<Produit> produitsHorsMenu) {
		super();
		this.dateCommande = dateCommande.toString();
		this.prix = prix;
		this.menus = menus;
		this.produitsHorsMenu = produitsHorsMenu;
	}

	//getter et setter
	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Produit> getProduitsHorsMenu() {
		return produitsHorsMenu;
	}

	public void setProduitsHorsMenu(List<Produit> produitsHorsMenu) {
		this.produitsHorsMenu = produitsHorsMenu;
	}
	
	
	
}
