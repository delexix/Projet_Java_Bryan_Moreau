package tpJava;

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

    public void writeToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode rootNode = mapper.createObjectNode();
            ArrayNode arr = rootNode.putArray("Commandes");
            mapper.writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeToFileNotOverwrite(T object) {
    	List<T> l = this.readFromFile();
        try {
        	ObjectMapper mapper = new ObjectMapper();
            ObjectNode rootNode = mapper.createObjectNode();
            ArrayNode arr = rootNode.putArray("Commandes");
            l.add(object);
            
            for(int i=0;i<l.size();i++) {
            	arr.addPOJO(l.get(i));
            }
            mapper.writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> readFromFile() {
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	JsonNode js = mapper.readTree(file);
        	String listJson = js.withArray("Commandes").toString();
        	List<T> l = mapper.readValue(listJson, new TypeReference<List<T>>() {}) ;
            return l;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}