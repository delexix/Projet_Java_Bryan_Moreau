package tpJava;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import handler.TerminerCommande;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systeme.BorneCommande;
import systeme.Client;
import systeme.Commande;
import systeme.HistoriqueCommande;
import systeme.Menu;
import systeme.Produit;
import systeme.ThreadAvancementCommande;

public class CommandeView {

	public CommandeView(ActionEvent event, BorneCommande borne, Client c) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(30);
		Scene scene = new Scene(root,600,400);
		
		//création de la commande
		Commande commande = new Commande("En cours",c);
		c.getCommandes().add(commande);
		
		//création des conteneurs
		HBox hb = new HBox();
		hb.setSpacing(150);
		hb.setAlignment(Pos.CENTER);
		
		HBox hb2 = new HBox();
		hb2.setSpacing(50);
		hb2.setAlignment(Pos.CENTER);
		
		VBox menuhb = new VBox();
		menuhb.setAlignment(Pos.CENTER);
		menuhb.setSpacing(30);
		VBox produithb = new VBox();
		produithb.setAlignment(Pos.CENTER);
		produithb.setSpacing(30);
		
		//création des composants
		Label menu = new Label("Menu :");
		Label produit = new Label("Produit hors-menu :");
		
		//création de la choicebox des menus
		ChoiceBox<String> menus =  new ChoiceBox<String>();
		
		for(int i=0;i<borne.getData().getMenus().size();i++) {
			menus.getItems().add(borne.getData().getMenus().get(i).getNom());
		}
		
		//création de la choicebox des produit hors menu
		ChoiceBox<String> produits =  new ChoiceBox<String>();
		
		for(int i=0;i<borne.getData().getProduits().size();i++) {
			if(!borne.getData().getProduits().get(i).isExclusifMenu()) {
				produits.getItems().add(borne.getData().getProduits().get(i).getNom());
			}

		}
		
        //création des boutons
		Button ajouterMenu = new Button("Ajouter");
		
		ajouterMenu.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//trouve le menu selectionné et l'ajoute
				if(menus.getValue().equals("")) {
					//cas où l'on a rien selectionner
					(new Alert(AlertType.INFORMATION,"Aucun menu selectionné",ButtonType.OK)).show();
				}else {
					Menu m = borne.findMenu(menus.getValue());
					commande.getMenus().add(m);
				}
				
			}
			
		});
		
		Button ajouterProduit = new Button("Ajouter");
		
		ajouterProduit.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//trouve le produit selectionné et l'ajoute
				if(produits.getValue().equals("")) {
					//cas où l'on a rien selectionner
					(new Alert(AlertType.INFORMATION,"Aucun produit selectionné",ButtonType.OK)).show();
				}else {
					Produit m = borne.findProduit(produits.getValue());
					commande.getProduits().add(m);
				}
				
				
			}
			
		});
		
		Button termine = new Button("Terminer");
		termine.setOnAction(new TerminerCommande(commande,borne));
		
		//bouton de retour a la page de choix
        Button retour = new Button("Retour");
        retour.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				new Choix(event,borne,c);
				
			}
        	
        });
		
		//ajout des composants
		menuhb.getChildren().addAll(menu,menus,ajouterMenu);
		produithb.getChildren().addAll(produit,produits,ajouterProduit);
		
		hb.getChildren().addAll(menuhb,produithb);
		
		hb2.getChildren().addAll(retour,termine);
		
		root.getChildren().addAll(hb,hb2);
		
		stage.setScene(scene);
		stage.setTitle("Création de commande");
		stage.show();
	}

}
