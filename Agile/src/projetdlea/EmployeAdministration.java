package projetdlea;

public class EmployeAdministration extends Employe{
    private int compteurMinutesTeletravail;
    private String json;
    
    public EmployeAdministration(int codeEmploye, int compteurMinutesBureau, int compteurMinutesTeletravail) {
        super(codeEmploye, compteurMinutesBureau);
        this.compteurMinutesTeletravail = compteurMinutesTeletravail;
        json = "";
    }

    
    public String totalHeures(){
        
        if(super.getCompteurMinutesBureau() >= 2160 && super.getCompteurMinutesBureau() <= 2580) json += "\n \" L'employé d'administration à travaillé le nombre d'heures minimal au bureau durant la semaine \"";
        if(super.getCompteurMinutesBureau()<2160) json += "\n \" L'employé d'administration n'a pas travaillé le nombre d'heures minimal  au bureau durant la semaine \"";
        if(super.getCompteurMinutesBureau() > 2580) json += "\n \" L'employé d'administration a depassé le nombres d'heures au bureau durant la semaine \"";
        if(compteurMinutesTeletravail> 600) json += ",\n \" L'employé d'administration a depassé le nombres d'heures au teletravail durant la semaine \" ";
        return json += "\n]";
    }
}
