package systeme;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import javafx.scene.control.Alert.AlertType;

public class ThreadAvancementCommande extends Thread {
	private Commande commande;

	/**
	 * Constructeur du Thread de pr�paration de commande
	 * @param commande : commande � pr�parer
	 */
	public ThreadAvancementCommande(Commande commande) {
		super();
		this.commande = commande;
	}
	
	/**
	 * fonction de lancement de Thread
	 */
	public void run() {
		//ajout des produit dans une liste pour suivre leurs pr�parations
		List<Produit> produits = new ArrayList<Produit>();
		for(int i=0;i<commande.getMenus().size();i++) {
			produits.addAll(commande.getMenus().get(i).getProduits());
		}
		produits.addAll(commande.getProduits());
		Double time = 0.0;
		//simule le temps de pr�paration des produits
		for(int j = 0; j<produits.size();j++) {
			String produitNom = produits.get(j).getNom();
			time += produits.get(j).calculTemps();
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(time), ev -> {
				(new Alert(AlertType.INFORMATION,"le "+produitNom+" de la commande de "+commande.getClient().getPrenom()+" "+commande.getClient().getNom()+" est termin�.",ButtonType.OK)).show();							

		    }));
		    timeline.setCycleCount(1);
		    timeline.play();
		}

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(commande.calculTemps()), ev -> {
			(new Alert(AlertType.INFORMATION,"La commande de "+commande.getClient().getPrenom()+" "+commande.getClient().getNom()+" est termin�.",ButtonType.OK)).show();
			//enregistrement de la commande dans un historique
			FileJsoner<HistoriqueCommande> jsoner = new FileJsoner<HistoriqueCommande>("./src/main/resources/"+commande.getClient().getNumero()+".json",HistoriqueCommande.class);
			jsoner.writeToFileNotOverwrite(new HistoriqueCommande(Date.from(Instant.now()),commande.getPrix(),commande.getMenus(),commande.getProduits()));
			commande.nextStatut();
	    }));
	    timeline.setCycleCount(1);
	    timeline.play();
	}
}
