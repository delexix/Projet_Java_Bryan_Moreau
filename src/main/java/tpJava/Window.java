package tpJava;

import java.util.ArrayList;
import java.util.List;

import handler.Connexion;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systeme.BorneCommande;
import systeme.Client;

public class Window extends Application {
	private BorneCommande borne;
	
	public Window(BorneCommande borne) {
		this.borne=borne;
	}
	
	public Window() {
		//cr�e les donn�es de l'application
		Client c = new Client(21,"Bryan","Moreau");
		Client c1 = new Client(01,"Geoffrey","Yozo");
		
		List<Client> l = new ArrayList<Client>();
		l.add(c);
		l.add(c1);
		this.borne = new BorneCommande(l);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//cr�ation de la fenetre
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,600,400);
		
		//cr�ation des composant de la fen�tre
		VBox vbox = new VBox();
		Label Lid = new Label("identifiez-vous avec votre num�ro de client :");
		TextField id = new TextField();
		Button button = new Button("Connexion");
		
		//ajout de l'action qui arrive quand on clique sur le boutton
		button.setOnAction(new Connexion(this.borne,stage,id));
		//ajout des composants
		vbox.getChildren().add(Lid);
		vbox.getChildren().add(id);
		vbox.getChildren().add(button);
		
		BorderPane.setAlignment(vbox,Pos.CENTER_RIGHT);
		root.setCenter(vbox);
		
		//d�finition de la fen�tre et affichage
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setTitle("Accueil");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	//getter et setter
	public BorneCommande getBorne() {
		return borne;
	}

	public void setBorne(BorneCommande borne) {
		this.borne = borne;
	}
}
