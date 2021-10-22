package systeme;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BorneCommande {
	private List<Client> clients;
	private DataBase data;
	private Scanner sc;

	//constructeur de la borne de commande
	public BorneCommande(List<Client> clients) {
		super();
		this.clients = clients;
		this.data= new DataBase();
		this.sc = new Scanner(System.in);
	}
	
	//permet de trouver le client grâce à son numero, s'il n'est pas trouver un Optional empty est renvoyé
	public Optional<Client> identifier(Integer numero) {
		boolean trouver = false;
		int i=0;
		Client c = null;
		while ((!trouver) && i<clients.size()) {
			if(clients.get(i).getNumero().compareTo(numero) == 0) {
				trouver = true;
				c=clients.get(i);
			}
			i++;
		}
		return Optional.ofNullable(c);
	}
	
	//trouve le menu selon son nom
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
	
	//trouve le produit selon son nom
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
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public DataBase getData() {
		return data;
	}

	public void setData(DataBase data) {
		this.data = data;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
	
}
