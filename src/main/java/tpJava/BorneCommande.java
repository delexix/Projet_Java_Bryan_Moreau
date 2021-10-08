package tpJava;

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
	
	//crée l'interface IHM
	public void interfaceCMD() {
		System.out.println("---------------------------------------------");
		System.out.println("identifiez-vous avec votre numéro de client :");
		System.out.print("numéro client : ");
		Integer numero = sc.nextInt();
		Optional<Client> opC = this.identifier(numero);
		
		//cas où le client met un numero non valide
		while(opC.isEmpty()) {
			System.out.println("Le numéro n'est pas valide veuillez recommencer :");
			System.out.print("numéro client : ");
			numero = Integer.parseInt(sc.nextLine());
			opC = this.identifier(numero);
		}
		
		Client c = opC.get();
		System.out.println("-----------------------------------------------");
		System.out.println("Bonjour "+c.getPrenom()+" "+c.getNom());
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1. Passer une commande ");
		System.out.print("Votre choix : ");
		int v = this.getSc().nextInt();
		
		//cas où le client met autre chose que les choix
		while (v!=1) {
			System.out.println("Valeur non valide");
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1. Passer une commande ");
			System.out.print("Votre choix : ");
			v = this.getSc().nextInt();
		}
		
		Commande commande = new Commande("En cours",c);
		this.createCommande(commande);
		
	}
	//crée une commande et permet d'ajouter des menus et produits
	private void createCommande(Commande commande) {
		System.out.println("-----------------------------------------------");
		System.out.println("Que voulez-vous ajouter ?");
		System.out.println("1. Menu");
		System.out.println("2. Produit hors-menu");
		System.out.println("3. Terminer la commande");
		System.out.print("Votre choix : ");
		int v = this.getSc().nextInt();
		
		//cas où le client met autre chose que les choix
		while (!(v==1 || v==2 || v==3)) {
			System.out.println("Valeur non valide");
			System.out.println("Que voulez-vous ajouter ?");
			System.out.println("1. Menu");
			System.out.println("2. Produit hors-menu");
			System.out.println("3. Terminer la commande");
			System.out.print("Votre choix : ");
			v = this.getSc().nextInt();
		}
		if(v==1) {
			this.addMenu(commande);
		}else if(v==2) {
			this.addProduit(commande);
		}else if(v==3){
			this.valideCommande(commande);
		}
	}
	
	//termine une commande
	private void valideCommande(Commande commande) {
		commande.calculPrix();
		commande.nextStatut();
		
		//Thread pour afficher l'avancement de la commande
		ThreadAvancementCommande thread = new ThreadAvancementCommande(commande);
		thread.start();
		
		System.out.println("Votre commande va prendre "+commande.calculTemps()+" pour être finalisé.");
		this.interfaceCMD();
		
	}
	//ajoute un produit (demande lequel)
	private void addProduit(Commande commande) {
		System.out.println("-----------------------------------------------");
		System.out.println("Choisissez le produit à ajouter :");
		System.out.println("1. Nuggets");
		System.out.println("2. Coca-Cola");
		System.out.println("3. Salade composé");
		System.out.println("4. Frites");
		System.out.println("5. Eau");
		System.out.print("Votre choix : ");
		int v = this.getSc().nextInt();
		
		//cas où le client met autre chose que les choix
		while (!(v==1 || v==2 || v==3 || v==4 || v==5)) {
			System.out.println("Valeur non valide");
			System.out.println("Choisissez le produit à ajouter :");
			System.out.println("1. Nuggets");
			System.out.println("2. Coca-Cola");
			System.out.println("3. Salade composé");
			System.out.println("4. Frites");
			System.out.println("5. Eau");
			System.out.print("Votre choix : ");
			v = this.getSc().nextInt();
		}
		
		if(v==1) {
			//ajout des nuggets
			commande.getProduits().add(this.getData().getProduits().get(4));
		}else if(v==2) {
			//ajout du coca
			commande.getProduits().add(this.getData().getProduits().get(0));
		}else if(v==3) {
			//ajout de la salade
			commande.getProduits().add(this.getData().getProduits().get(2));
		}else if(v==4) {
			//ajout des frites
			commande.getProduits().add(this.getData().getProduits().get(3));
		}else if(v==5) {
			//ajout de l'eau
			commande.getProduits().add(this.getData().getProduits().get(5));
		}
		this.createCommande(commande);
		
	}
	//ajoute un menu (demande lequel)
	private void addMenu(Commande commande) {
		System.out.println("-----------------------------------------------");
		System.out.println("Choisissez le menu à ajouter :");
		System.out.println("1. Menu Big Max");
		System.out.println("2. Menu Enfant");
		System.out.print("Votre choix : ");
		int v = this.getSc().nextInt();
		while (!(v==1 || v==2)) {
			System.out.println("Valeur non valide");
			System.out.println("Choisissez le menu à ajouter :");
			System.out.println("1. Menu Big Max");
			System.out.println("2. Menu Enfant");
			System.out.print("Votre choix : ");
			v = this.getSc().nextInt();
		}
		if(v==1) {
			//ajout du menu big max
			commande.getMenus().add(this.getData().getMenus().get(0));
		}else if(v==2) {
			//ajout du menu enfant
			commande.getMenus().add(this.getData().getMenus().get(1));
		}
		this.createCommande(commande);
		
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
