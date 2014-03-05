package projetdlea;

public class EmployeProduction extends Employe {
    
    private String json;
    
    public EmployeProduction(int codeEmploye, int compteurMinutesBureau) {
        super(codeEmploye, compteurMinutesBureau);
        json = "";
    }

    
    public String totalHeures(){ // heure mini par semaine c'est pas 38 mais comme les normaux avant
        if(super.getCompteurMinutesBureau() >= 2280 && super.getCompteurMinutesBureau() <= 2580) json += "\n \" L'employé de production à travaillé le nombre d'heures minimal au bureau durant la semaine \" ";
        else if(super.getCompteurMinutesBureau()<2280)  json += "\n \" L'employé de production n'a pas travaillé le nombre d'heures minimal au bureau durant la semaine \" ";
        else if(super.getCompteurMinutesBureau() > 2580) json += "\n \" L'employé de production a depassé le nombres d'heures au bureau durant la semaine \" ";
        return json += "\n]";
    }
}
