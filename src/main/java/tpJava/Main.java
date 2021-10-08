package tpJava;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Client c = new Client(21,"Bryan","Moreau");
		List<Client> l = new ArrayList<Client>();
		l.add(c);
		BorneCommande borne = new BorneCommande(l);
		
		borne.interfaceCMD();

	}

}
