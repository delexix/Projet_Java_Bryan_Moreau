package tpJava;

import handler.HistoriqueHandler;
import handler.PasserCommandeHandler;
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
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,600,400);
		
		//création des composants
		VBox vbox = new VBox();
		Label l1 = new Label("Bonjour "+c.getPrenom()+" "+c.getNom());
		Label l2 = new Label("Que voulez-vous faire ?");
		Button commande = new Button("Passer une commande");
		
		commande.setOnAction(new PasserCommandeHandler());
		
		Button historique = new Button("Consulter l'historique des commandes");
		
		//action effectué quand on appuie sur le bouton
		historique.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				new Historique(event,borne,c);
				
			}
			
		});
		
		//ajout des composants
		vbox.getChildren().add(l1);
		vbox.getChildren().add(l2);
		vbox.getChildren().add(commande);
		vbox.getChildren().add(historique);
		
		BorderPane.setAlignment(vbox,Pos.CENTER_RIGHT);
		root.setCenter(vbox);
		
		stage.setScene(scene);
		stage.setTitle("Ecran de choix");
		stage.show();
	}

}
