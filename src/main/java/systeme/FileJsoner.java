package systeme;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileJsoner <T> {
    private File file;
    private Class<T> type;
    
    /**
     * Constructeur du FileJsoner
     * @param filename : nom du fichier dans lequel on enregistre
     * @param type : �quivalent � T.class
     */
    public FileJsoner(String filename, Class<T> type) {
        this.file = new File(System.getProperty("user.dir"), filename);
        this.type = type;
    }
    
    /**
     * Permet de cr�er un fichier JSON ou de supprimer les donn�es pr�sent dans un fichier existant
     */
    public void writeToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<T> l = new ArrayList<T>();
            mapper.writeValue(file, l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Permet d'ajouter � un fichier JSON sans effacer les donn�es pr�sents
     * @param object : objet � sauvegarder
     */
    public void writeToFileNotOverwrite(T object) {
    	List<T> l = this.readFromFile();
        try {
        	ObjectMapper mapper = new ObjectMapper();
            l.add(object);
            mapper.writeValue(file, l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Permet de r�cup�rer les donn�es dans un fichier JSON
     * @return List<T> : liste d'objet T
     */
    public List<T> readFromFile() {
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	List<T> l = mapper.readValue(file, TypeFactory.defaultInstance().constructCollectionType(List.class, this.type));
            return l;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}