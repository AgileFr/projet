package projetdlea;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;


public final class LectureJson {
    
   private String jsonTxt;

    public LectureJson(String txt) throws IOException{
       try {
           String txtjs = OuvertureFichier.loadFileIntoString(txt, "UTF-8");  
           jsonTxt = txtjs;
       }catch (IOException ex) {
           System.out.println("Erreur lors de l'ouverture du fichier");
       }
    }
   
    public JSONObject root (){
            JSONObject root = (JSONObject) JSONSerializer.toJSON(jsonTxt);
            return root;
    }
}
