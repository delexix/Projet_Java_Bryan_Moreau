package systeme;

import java.util.Date;
import java.util.List;

public class HistoriqueCommande {
	private String dateCommande;
	private Double prix;
	private List<Menu> menus;
	private List<Produit> produitsHorsMenu;
	
	/**
	 * constructeur par défaut
	 */
	public HistoriqueCommande() {
		super();
	}
	
	/**
	 * constructeur de la classe qui va permettre de stocké les informations des commandes dans le fichier
	 * @param dateCommande : date à laquelle la commande a été effectuée
	 * @param prix : prix de la commande
	 * @param menus : liste de menus de la commande
	 * @param produitsHorsMenu : liste de produits hors-menu de la commande
	 */
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
