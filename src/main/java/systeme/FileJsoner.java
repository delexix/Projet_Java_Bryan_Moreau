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
     * @param type : équivalent à T.class
     */
    public FileJsoner(String filename, Class<T> type) {
        this.file = new File(System.getProperty("user.dir"), filename);
        this.type = type;
    }
    
    /**
     * Permet de créer un fichier JSON ou de supprimer les données présent dans un fichier existant
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
     * Permet d'ajouter à un fichier JSON sans effacer les données présents
     * @param object : objet à sauvegarder
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
     * Permet de récupérer les données dans un fichier JSON
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