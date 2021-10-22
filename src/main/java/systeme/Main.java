package systeme;

import java.util.ArrayList;
import java.util.List;

import tpJava.Window;

public class Main {

	public static void main(String[] args) {
		Client c = new Client(21,"Bryan","Moreau");
		
		/* Pour supprimer/crée les fichiers clients
		 * FileJsoner<Object> jsonner = new FileJsoner<Object>("./src/main/resources/"+c.getNumero()+".json");
		 * jsonner.writeToFile();
		 * */
		
		Client c1 = new Client(01,"Geoffrey","Yozo");
		
		/* Pour supprimer/crée les fichiers clients
		 * FileJsoner<Object> jsonner1 = new FileJsoner<Object>("./src/main/resources/"+c1.getNumero()+".json");
		 * jsonner1.writeToFile();
		 * */
		
		List<Client> l = new ArrayList<Client>();
		l.add(c);
		l.add(c1);
		BorneCommande borne = new BorneCommande(l);
		
		//borne.interfaceCMD();
		Window.main(args);

	}

}
