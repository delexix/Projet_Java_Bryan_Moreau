package interfaceGraphique;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systeme.BorneCommande;
import systeme.Client;
import systeme.FileJsoner;
import systeme.HistoriqueCommande;
import systeme.Menu;

public class Historique {
	
	/**
	 * Constructeur cr�ant la page d'historique de commande
	 * @param event : �v�nement lan�ant la page
	 * @param borne : borne de commande
	 * @param c : client identifi� pr�c�demment
	 */
	public Historique(ActionEvent event,BorneCommande borne, Client c) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root,700,450);
		
		//cr�ation de la table pour contenir les historiques
		TableView<HistoriqueCommande> table = new TableView<HistoriqueCommande>();
		
		//cr�ation des colonne
		TableColumn<HistoriqueCommande, String> datCol = new TableColumn<HistoriqueCommande, String>("Date");
		
		TableColumn<HistoriqueCommande, Double> prixCol = new TableColumn<HistoriqueCommande, Double>("Prix");
		
		TableColumn<HistoriqueCommande, Menu> menuCol = new TableColumn<HistoriqueCommande, Menu>("Menus");
		
		TableColumn<HistoriqueCommande, String> produitCol = new TableColumn<HistoriqueCommande, String>("Produits hors-menu");
		
		//liaisons entre les colonnes et les attributs de la classe
		datCol.setCellValueFactory(new PropertyValueFactory<>("dateCommande"));
		prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
		menuCol.setCellValueFactory(new PropertyValueFactory<>("menus"));
		produitCol.setCellValueFactory(new PropertyValueFactory<>("produitsHorsMenu"));
		
		//ajout des donn�es
		FileJsoner<HistoriqueCommande> jsoner = new FileJsoner<HistoriqueCommande>("./src/main/resources/"+c.getNumero()+".json",HistoriqueCommande.class);
		List<HistoriqueCommande> commandes = jsoner.readFromFile();
		ObservableList<HistoriqueCommande> list = FXCollections.observableArrayList(commandes);
	    table.setItems(list);

        //ajout des colonnes
        table.getColumns().addAll(datCol, prixCol,menuCol,produitCol);
        
        //bouton de retour a la page de choix
        Button retour = new Button("Retour");
        retour.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				new Choix(event,borne,c);
				
			}
        	
        });
              
        root.getChildren().addAll(table,retour);
		
		stage.setScene(scene);
		stage.setTitle("Historique des commandes");
		stage.show();
	}
}
