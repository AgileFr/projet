package projetdlea;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;


public final class LectureJson {
    
    private int numeroEmploye;
    private int cptMinutesBureau;
    private int cptMinutesTeletravail;
    private int numProjet;
    private Employe employe;

    public LectureJson(String txt) throws IOException{
       try {
           String jsonTxt = OuvertureFichier.loadFileIntoString(txt, "UTF-8");
           JSONObject root = (JSONObject) JSONSerializer.toJSON(jsonTxt);
           numeroEmploye = Integer.parseInt(root.getString("numero_employe"));
          
                      int debut = 1, fin = 5;
           String jourSemaine = "jour";
           boolean jourDeLaSemaine = true;
           while(debut<=fin){
                int cptMinutesJourBureau = 0;
                JSONArray test = (JSONArray) JSONSerializer.toJSON(root.getString(jourSemaine+debut));
                int docCount = test.size();
                for(int j=0; j<docCount; j++){
                   JSONObject document = test.getJSONObject(j);
                   if(projetBureau(Integer.parseInt(document.getString("projet")))){
                       ajoutMinutesBureau(Integer.parseInt(document.getString("minutes")));
                       if(jourDeLaSemaine) cptMinutesJourBureau += Integer.parseInt(document.getString("minutes"));
                       
                   }
                   else ajoutMinutesTeletravail(Integer.parseInt(document.getString("minutes")));
               }
               if(jourDeLaSemaine == true && RespectMinutesMiniBureau(cptMinutesJourBureau)) System.out.println("L'employé n'à travaillé le nombre d'heures minimal pour le jour"+debut);
               if(debut == 5){debut = 1; fin = 2; jourSemaine="weekend"; jourDeLaSemaine = false;}
               debut++;
           }
           if(EmployeNormal()){
               employe =  new EmployeNormal(numeroEmploye, cptMinutesBureau);
               employe.totalHeures();
           }
           else{
                employe = new EmployeAdministration(numeroEmploye, cptMinutesBureau, cptMinutesTeletravail);
                employe.totalHeures();
           }
              
       }catch (IOException ex) {
           System.out.println("Erreur lors de l'ouverture du fichier");
       }
    }
    public boolean projetBureau(int numProjet){
        return (numProjet <= 900);
    }
    public boolean EmployeNormal(){
        return (numeroEmploye >= 1000);
    }
    
    public void ajoutMinutesBureau(int heuresBureau){
        cptMinutesBureau += heuresBureau;
    }
    
    public void ajoutMinutesTeletravail(int heuresTeletravail){
        cptMinutesTeletravail += heuresTeletravail;
    }
    
    public boolean RespectMinutesMiniBureau(int minutes){
        if(EmployeNormal() && minutes < 360) return true;
        if(!EmployeNormal() && minutes < 240) return true;
        return false;
    }
}
