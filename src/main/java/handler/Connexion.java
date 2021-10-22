package handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import systeme.BorneCommande;
import systeme.Client;
import tpJava.Choix;

public class Connexion implements EventHandler<ActionEvent> {
	private BorneCommande borne;
	private TextField id;
	
	
	public Connexion(BorneCommande borne, TextField id) {
		this.borne=borne;
		this.id=id;
	}

	@Override
	public void handle(ActionEvent event) {
		//r�cup�ration de l'id entr�e
		
		if(this.id.getText().equals("")) {
			//si l'utilisateur n'a rien marqu�, affichage d'une information 
			(new Alert(AlertType.INFORMATION,"Vous devez entrer votre num�ro client",ButtonType.OK)).show();
		}else {
			//s'il a marqu� quelque chose
			Integer idI = Integer.valueOf(this.id.getText());

			int i=0;
			boolean trouver = false;
			Client c = null;
			while(i<borne.getClients().size() && !trouver ) {
				if(borne.getClients().get(i).getNumero().equals(idI)) {
					trouver=true;
					c=borne.getClients().get(i);
				}
				i++;
			}
			
			if(trouver) {
				//le client existe
				new Choix(event,this.borne,c);
			}else {
				//le client n'existe pas, affichage d'une information 
				(new Alert(AlertType.INFORMATION,"Le num�ro client n'est pas valide",ButtonType.OK)).show();
			}
			
		}
		
	}

}
