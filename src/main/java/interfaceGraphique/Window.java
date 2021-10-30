package interfaceGraphique;

import java.util.ArrayList;
import java.util.List;

import handler.Connexion;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systeme.BorneCommande;
import systeme.Client;

public class Window extends Application {
	private BorneCommande borne;
	
	public Window(ActionEvent event,BorneCommande borne) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		this.borne=borne;
		this.creationWindow(stage);
	}
	
	public Window() {
		this.borne = new BorneCommande();
	}

	@Override
	public void start(Stage stage) throws Exception {
		//mise du logo sur la fenêtre
		stage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("logo.jpg")));
		this.creationWindow(stage);
	}
	
	//permet de crée la page d'accueil
	public void creationWindow(Stage stage) {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(30);
		Scene scene = new Scene(root,600,400);
		
		//création des composant de la fenêtre
		Label Lid = new Label("identifiez-vous avec votre numéro de client :");
		TextField id = new TextField();
		Button button = new Button("Connexion");
		
		//ajout de l'action qui arrive quand on clique sur le boutton
		button.setOnAction(new Connexion(this.borne,id));
		//ajout des composants
		root.getChildren().addAll(Lid,id,button);
		
		//définition de la fenêtre et affichage
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
