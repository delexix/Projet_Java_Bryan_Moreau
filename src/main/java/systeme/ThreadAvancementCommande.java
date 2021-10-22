package systeme;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class ThreadAvancementCommande extends Thread {
	private Commande commande;

	public ThreadAvancementCommande(Commande commande) {
		super();
		this.commande = commande;
	}
	
	public void run() {
		//ajout des produit dans une liste pour suivre leurs pr�parations
		List<Produit> produits = new ArrayList<Produit>();
		for(int i=0;i<commande.getMenus().size();i++) {
			produits.addAll(commande.getMenus().get(i).getProduits());
		}
		produits.addAll(commande.getProduits());
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		//simule le temps de pr�paration des produits
		for(int j = 0; j<produits.size();j++) {
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis((produits.get(j).calculTemps()).longValue()));
				(new Alert(AlertType.INFORMATION,"le "+produits.get(j).getNom()+" de la commande de "+commande.getClient().getPrenom()+" "+commande.getClient().getNom()+" est termin�.",ButtonType.OK)).show();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		(new Alert(AlertType.INFORMATION,"La commande de "+commande.getClient().getPrenom()+" "+commande.getClient().getNom()+" est termin�.",ButtonType.OK)).show();

		//met la commande en termin�
		commande.nextStatut();
		
		service.shutdown();
		//enregistrement de la commande dans un historique
		FileJsoner<HistoriqueCommande> jsoner = new FileJsoner<HistoriqueCommande>("./src/main/resources/"+commande.getClient().getNumero()+".json");
		jsoner.writeToFileNotOverwrite(new HistoriqueCommande(Date.from(Instant.now()),commande.getPrix(),commande.getMenus(),commande.getProduits()));
	}
}
