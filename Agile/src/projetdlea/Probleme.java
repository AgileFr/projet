package projetdlea;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author Julien
 */
public class Probleme {
          
    private int numeroEmploye;
    private int cptMinutesBureau;
    private int cptMinutesTeletravail;
    private int numProjet;
    int minutes;
    private Employe employe;
    private String json;
    
    public Probleme(JSONObject root){
        json = "[";
        numeroEmploye = Integer.parseInt(root.getString("numero_employe"));
        int debut = 1, fin = 5;
        String jourSemaine = "jour";
        boolean jourDeLaSemaine = true;
        while(debut<=fin){
            int cptMinutesJourBureau = 0;
            int cptMinutesJourTeletravail = 0;
            JSONArray test = (JSONArray) JSONSerializer.toJSON(root.getString(jourSemaine+debut));
            int docCount = test.size();
            for(int j=0; j<docCount; j++){
                JSONObject document = test.getJSONObject(j);
                numProjet = Integer.parseInt(root.getString("projet"));
                minutes = Integer.parseInt(document.getString("minutes"));
                if(projetBureau(numProjet)){
                    ajoutMinutesBureau(minutes);
                    if(jourDeLaSemaine) cptMinutesJourBureau += minutes;
                }
                else if ()
               else {
                    ajoutMinutesTeletravail(minutes);
                    cptMinutesJourTeletravail += minutes;
                }
           }
           if(jourDeLaSemaine == true && !respectMaxJour(cptMinutesJourBureau+cptMinutesJourTeletravail)) json += " \n \" L'employé a travaillé plus de 24 heures "+ debut + "\", ";
           if(jourDeLaSemaine == true && respectMinutesMiniBureau(cptMinutesJourBureau)) json += " \n \" L'employé n'à travaillé le nombre d'heures minimal pour le jour "+ debut + "\", ";
           if(debut == 5){debut = 1; fin = 2; jourSemaine="weekend"; jourDeLaSemaine = false;}
           debut++;
       }
    }
    
    public boolean projetBureau(int numProjet){
        return (numProjet <= 900);
    }
    
    public boolean projetTeletravail(int numProjet){
        return (numProjet >900 && !congeMaladie(numProjet) && !congeFerie(numProjet));
    }
    
    public boolean congeMaladie(int numProjet){
        return (numProjet == 999);
    }
    
    public boolean congeFerie(int numProjet){
        return (numProjet == 998);
    }
    
    public boolean employeExploitation(){
        return (numeroEmploye >= 2000);
    }
    public boolean employeProduction(){
        return (numeroEmploye >= 1000  && numeroEmploye < 2000);
    }
    
    public void ajoutMinutesBureau(int heuresBureau){
        cptMinutesBureau += heuresBureau;
    }
    
    public void ajoutMinutesTeletravail(int heuresTeletravail){
        cptMinutesTeletravail += heuresTeletravail;
    }
    
    public boolean respectMinutesMiniBureau(int minutes){
        if((employeExploitation() || employeProduction()) && minutes < 360) return true;
        if(!employeExploitation() && !employeProduction() && minutes < 240) return true;
        return false;
    }
    
    public boolean respectMaxJour ( int minutes ){
        return minutes > 1440 ;
    }
    
    
    public String totalesHeuresEmploye(){
        if(employeExploitation()){
           employe =  new EmployeExploitation(numeroEmploye, cptMinutesBureau);
           return json += employe.totalHeures();
       }
       if(employeProduction()){
           employe =  new EmployeProduction(numeroEmploye, cptMinutesBureau);
           return json += employe.totalHeures();
       } 
       else{
            employe = new EmployeAdministration(numeroEmploye, cptMinutesBureau, cptMinutesTeletravail);
            return json += employe.totalHeures();
       }
    }
}
