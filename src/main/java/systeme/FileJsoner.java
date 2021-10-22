package systeme;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileJsoner <T> {
    File file;

    public FileJsoner(String filename) {
        file = new File(System.getProperty("user.dir"), filename);
    }
//TODO : mettre tout les users dans le même fichier 
    public void writeToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<T> l = new ArrayList<T>();
            mapper.writeValue(file, l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
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

    public List<T> readFromFile() {
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	List<T> l = mapper.readValue(file, new TypeReference<List<HistoriqueCommande>>() {}) ;
            return l;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}