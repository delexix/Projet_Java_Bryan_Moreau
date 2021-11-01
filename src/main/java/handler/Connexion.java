package handler;

import java.util.Optional;

import interfaceGraphique.Choix;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import systeme.BorneCommande;
import systeme.Client;

public class Connexion implements EventHandler<ActionEvent> {
	private BorneCommande borne;
	private TextField id;
	
	/**
	 * Constructeur du Handler pour l'�v�nement de clique sur le bouton de connexion
	 * @param borne : borne de commande
	 * @param id : entr�e contenant l'id de client fourni par l'utilisateur
	 */
	public Connexion(BorneCommande borne, TextField id) {
		this.borne=borne;
		this.id=id;
	}

	/**
	 * Handler de l'�v�nement
	 * @param event : �v�nement de clique sur bouton
	 */
	@Override
	public void handle(ActionEvent event) {
		//r�cup�ration de l'id entr�e
		
		if(this.id.getText().equals("")) {
			//si l'utilisateur n'a rien marqu�, affichage d'une information 
			(new Alert(AlertType.INFORMATION,"Vous devez entrer votre num�ro client",ButtonType.OK)).show();
		}else {
			//s'il a marqu� quelque chose
			Integer idI = Integer.valueOf(this.id.getText());

			Optional<Client> opC = borne.identifier(idI);
			
			if(opC.isPresent()) {
				//le client existe
				new Choix(event,this.borne,opC.get());
			}else {
				//le client n'existe pas, affichage d'une information 
				(new Alert(AlertType.INFORMATION,"Le num�ro client n'est pas valide",ButtonType.OK)).show();
			}
			
		}
		
	}

}
