package handler;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import systeme.BorneCommande;
import systeme.Client;
import systeme.FileJsoner;
import systeme.HistoriqueCommande;

public class HistoriqueHandler implements EventHandler<ActionEvent> {
	private BorneCommande borne;
	private Client c;

	public HistoriqueHandler(BorneCommande borne, Client c) {
		this.borne=borne;
		this.c=c;
	}

	@Override
	public void handle(ActionEvent event) {
		FileJsoner<HistoriqueCommande> jsoner = new FileJsoner<HistoriqueCommande>("./src/main/resources/"+c.getNumero()+".json");
		List<HistoriqueCommande> commandes = jsoner.readFromFile();
		
		
		
	}
}
