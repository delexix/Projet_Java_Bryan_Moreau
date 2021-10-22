package tpJava;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systeme.BorneCommande;
import systeme.Client;
import systeme.Commande;
import systeme.HistoriqueCommande;
import systeme.Menu;

public class CommandeView {

	public CommandeView(ActionEvent event, BorneCommande borne, Client c) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root,600,400);
		
		//création de la commande
		Commande commande = new Commande("En cours",c);
		
		//création des conteneurs
		HBox hb = new HBox();
		hb.setSpacing(150);
		hb.setAlignment(Pos.CENTER);
		
		VBox menuhb = new VBox();
		menuhb.setAlignment(Pos.CENTER);
		VBox produithb = new VBox();
		produithb.setAlignment(Pos.CENTER);
		
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
			produits.getItems().add(borne.getData().getProduits().get(i).getNom());
		}
		
        //création des boutons
		Button ajouterMenu = new Button("Ajouter");
		Button ajouterProduit = new Button("Ajouter");
		Button termine = new Button("Terminer");
		
		//ajout des composants
		menuhb.getChildren().addAll(menu,menus,ajouterMenu);
		produithb.getChildren().addAll(produit,produits,ajouterProduit);
		
		hb.getChildren().addAll(menuhb,produithb);
		
		root.getChildren().addAll(hb,termine);
		
		stage.setScene(scene);
		stage.setTitle("Création de commande");
		stage.show();
	}

}
