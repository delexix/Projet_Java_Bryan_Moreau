package systeme;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import javafx.scene.control.Alert.AlertType;

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
			final int index = j;

			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(produits.get(j).calculTemps()), ev -> {
				(new Alert(AlertType.INFORMATION,"le "+produits.get(index).getNom()+" de la commande de "+commande.getClient().getPrenom()+" "+commande.getClient().getNom()+" est terminé.",ButtonType.OK)).show();							

		    }));
		    timeline.setCycleCount(1);
		    timeline.play();
		}

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(commande.calculTemps()), ev -> {
			(new Alert(AlertType.INFORMATION,"La commande de "+commande.getClient().getPrenom()+" "+commande.getClient().getNom()+" est terminé.",ButtonType.OK)).show();
			//FileJsoner<List<Commande>> file = new FileJsoner<List<Commande>>();
	    }));
	    timeline.setCycleCount(1);
	    timeline.play();
	}
}
