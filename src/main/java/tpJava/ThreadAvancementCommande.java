package tpJava;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadAvancementCommande extends Thread {
	private Commande commande;

	public ThreadAvancementCommande(Commande commande) {
		super();
		this.commande = commande;
	}
	
	public void run() {
		//ajout des produit dans une liste pour suivre leurs préparations
		List<Produit> produits = new ArrayList<Produit>();
		for(int i=0;i<commande.getMenus().size();i++) {
			produits.addAll(commande.getMenus().get(i).getProduits());
		}
		produits.addAll(commande.getProduits());
		
		//simule le temps de préparation des produits
		for(int j = 0; j<produits.size();j++) {
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis((produits.get(j).calculTemps()).longValue()));
				System.out.println("\n-----------------------------------------------");
				System.out.println("[INFO] le "+produits.get(j).getNom()+" de la commande de "+commande.getClient().getPrenom()+" "+commande.getClient().getNom()+" est terminé.");
				System.out.println("-----------------------------------------------");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		System.out.println("\n-----------------------------------------------");
		System.out.println("[INFO] la commande de "+commande.getClient().getPrenom()+" "+commande.getClient().getNom()+" est terminé.");
		System.out.println("-----------------------------------------------");
		//met la commande en terminé
		commande.nextStatut();
		
		//enregistrement de la commande dans un historique
		FileJsoner<HistoriqueCommande> jsoner = new FileJsoner<HistoriqueCommande>("./src/main/resources/"+commande.getClient().getNumero()+".json");
		jsoner.writeToFileNotOverwrite(new HistoriqueCommande(Date.from(Instant.now()),commande.getPrix(),commande.getMenus(),commande.getProduits()));
	}
}
