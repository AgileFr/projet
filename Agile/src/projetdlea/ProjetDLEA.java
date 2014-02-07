package projetdlea;

import java.io.IOException;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;




public class ProjetDLEA {
    public static void main(String[] args) throws IOException {
            LectureJson lectureJson = new LectureJson(args[0]);
            Probleme probleme = new Probleme(lectureJson.root());
            System.out.println( probleme.totalesHeuresEmploye() );
    }
}
