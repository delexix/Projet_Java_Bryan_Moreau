package tpJava;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Client c = new Client(21,"Bryan","Moreau");
		FileJsoner<Object> jsonner = new FileJsoner<Object>("./src/main/resources/"+c.getNumero()+".json");
		jsonner.writeToFile();
		Client c1 = new Client(01,"Geoffrey","Yozo");
		FileJsoner<Object> jsonner1 = new FileJsoner<Object>("./src/main/resources/"+c1.getNumero()+".json");
		jsonner1.writeToFile();
		List<Client> l = new ArrayList<Client>();
		l.add(c);
		l.add(c1);
		BorneCommande borne = new BorneCommande(l);
		
		borne.interfaceCMD();

	}

}
