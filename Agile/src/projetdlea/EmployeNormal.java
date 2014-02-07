package projetdlea;

public class EmployeNormal extends Employe {
    
    private String json;
    
    public EmployeNormal(int codeEmploye, int compteurMinutesBureau) {
        super(codeEmploye, compteurMinutesBureau);
        json = "";
    }

    
    public String totalHeures(){
        if(super.getCompteurMinutesBureau() >= 2280 && super.getCompteurMinutesBureau() <= 2580) json += "\n \" L'employé à travaillé le nombre d'heures minimal au bureau durant la semaine \" ";
        else if(super.getCompteurMinutesBureau()<2280)  json += "\n \" L'employé n'a pas travaillé le nombre d'heures minimal au bureau durant la semaine \" ";
        else if(super.getCompteurMinutesBureau() > 2580) json += "\n \" L'employé a depassé le nombres d'heures au bureau durant la semaine \" ";
        return json += "\n]";
    }
}
