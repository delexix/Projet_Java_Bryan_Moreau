package tpJava;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systeme.BorneCommande;
import systeme.Client;
import systeme.FileJsoner;
import systeme.HistoriqueCommande;
import systeme.Menu;

public class Historique {
	
	public Historique(ActionEvent event,BorneCommande borne, Client c) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root,600,400);
		
		//création de la table pour contenir les historiques
		TableView<HistoriqueCommande> table = new TableView<HistoriqueCommande>();
		
		//création des colonne
		TableColumn<HistoriqueCommande, String> datCol = new TableColumn<HistoriqueCommande, String>("Date");
		
		TableColumn<HistoriqueCommande, Double> prixCol = new TableColumn<HistoriqueCommande, Double>("Prix");
		
		TableColumn<HistoriqueCommande, Menu> menuCol = new TableColumn<HistoriqueCommande, Menu>("Menus");
		
		TableColumn<HistoriqueCommande, String> produitCol = new TableColumn<HistoriqueCommande, String>("Produits hors-menu");
		
		//liaisons entre les colonnes et les attributs de la classe
		datCol.setCellValueFactory(new PropertyValueFactory<>("dateCommande"));
		prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
		menuCol.setCellValueFactory(new PropertyValueFactory<>("menus"));
		produitCol.setCellValueFactory(new PropertyValueFactory<>("produitsHorsMenu"));
		
		//ajout des données
		FileJsoner<HistoriqueCommande> jsoner = new FileJsoner<HistoriqueCommande>("./src/main/resources/"+c.getNumero()+".json");
		List<HistoriqueCommande> commandes = jsoner.readFromFile();
		ObservableList<HistoriqueCommande> list = FXCollections.observableArrayList(commandes);
	    table.setItems(list);

        //ajout des colonnes
        table.getColumns().addAll(datCol, prixCol,menuCol,produitCol);
              
        root.getChildren().add(table);
		
		stage.setScene(scene);
		stage.setTitle("Historique des commandes");
		stage.show();
	}
}
