package handler;

import interfaceGraphique.Choix;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import systeme.BorneCommande;
import systeme.Commande;
import systeme.ThreadAvancementCommande;

public class TerminerCommande implements EventHandler<ActionEvent> {
	private Commande commande;
	private BorneCommande borne;
	
	public TerminerCommande(Commande commande,BorneCommande borne) {
		this.commande=commande;
		this.borne=borne;
	}


	@Override
	public void handle(ActionEvent event) {
		if(commande.getMenus().isEmpty() && commande.getProduits().isEmpty()) {
			//cas où l'utilisateur n'a rien mis dans sa commande
			(new Alert(AlertType.INFORMATION,"Vous devez ajouter au moins un menu ou un produit hors-menu dans votre commande pour la terminer",ButtonType.OK)).show();
		}else {
			//calcul du prix de la commande et changement du statut
			commande.calculPrix();
			commande.nextStatut();
			
			//Thread pour afficher l'avancement de la commande
			ThreadAvancementCommande thread = new ThreadAvancementCommande(commande);
			Service<Void> service = new Service<Void>() {

				@Override
				protected Task<Void> createTask() {
					return new Task<Void>() {

						@Override
						protected Void call() throws Exception {
							Platform.runLater(thread);
							return null;
						}
						
					};
				}
				
			};
			service.start();
			
			(new Alert(AlertType.INFORMATION,"Votre commande va prendre environ "+Math.round(commande.calculTemps())+" secondes pour être finalisé.",ButtonType.OK)).show();
			new Choix(event,borne,commande.getClient());
		}
		
	}

}
