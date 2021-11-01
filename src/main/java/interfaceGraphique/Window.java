package interfaceGraphique;

import handler.Connexion;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import systeme.BorneCommande;

public class Window extends Application {
	private BorneCommande borne;
	
	/**
	 * Constructeur de la page d'accueil
	 * @param event : �v�nement lan�ant la page
	 * @param borne : borne de commande
	 */
	public Window(ActionEvent event,BorneCommande borne) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		this.borne=borne;
		this.creationWindow(stage);
	}
	
	/**
	 * Constructeur par d�faut
	 */
	public Window() {
		this.borne = new BorneCommande();
	}

	/**
	 * Lanceur de la page d'accueil
	 * @param stage : fenetre JavaFX
	 */
	@Override
	public void start(Stage stage) throws Exception {
		//mise du logo sur la fen�tre
		stage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("logo.jpg")));
		this.creationWindow(stage);
	}
	
	/**
	 * permet de cr�e la page d'accueil
	 * @param stage : fenetre JavaFX
	 */
	public void creationWindow(Stage stage) {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(30);
		Scene scene = new Scene(root,600,400);
		
		//cr�ation des composant de la fen�tre
		Label Lid = new Label("identifiez-vous avec votre num�ro de client :");
		TextField id = new TextField();
		Button button = new Button("Connexion");
		
		//ajout de l'action qui arrive quand on clique sur le boutton
		button.setOnAction(new Connexion(this.borne,id));
		//ajout des composants
		root.getChildren().addAll(Lid,id,button);
		
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
