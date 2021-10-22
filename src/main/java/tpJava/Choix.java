package tpJava;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systeme.BorneCommande;
import systeme.Client;

public class Choix {

	public Choix(ActionEvent event,BorneCommande borne, Client c) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(30);
		Scene scene = new Scene(root,600,400);
		
		//création des composants	
		Label l1 = new Label("Bonjour "+c.getPrenom()+" "+c.getNom());
		Label l2 = new Label("Que voulez-vous faire ?");
		
		Button commande = new Button("Passer une commande");
		
		//action effectué quand on appuie sur le bouton commande
		commande.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new CommandeView(event,borne,c);
			}
			
		});
		
		Button historique = new Button("Consulter l'historique des commandes");
		
		//action effectué quand on appuie sur le bouton historique
		historique.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new Historique(event,borne,c);
			}
			
		});
		
		//ajout des composants
		root.getChildren().addAll(l1,l2,commande,historique);
		
		
		stage.setScene(scene);
		stage.setTitle("Ecran de choix");
		stage.show();
	}

}
