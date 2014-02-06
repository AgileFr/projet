package projetdlea;

public class EmployeNormal extends Employe {

    public EmployeNormal(int codeEmploye, int compteurMinutesBureau) {
        super(codeEmploye, compteurMinutesBureau);
    }

    
    public void totalHeures(){
        if(super.getCompteurMinutesBureau() >= 2280 && super.getCompteurMinutesBureau() <= 2580) System.out.println("\nl'employe à travaillé le nombre d'heures minimal au bureau durant la semaine");
        if(super.getCompteurMinutesBureau()<2280) System.out.println("\nl'employe n'a pas travaillé le nombre d'heures minimal au bureau durant la semaine");
        if(super.getCompteurMinutesBureau() > 2580) System.out.println("\nl'employe a depassé le nombres d'heures au bureau durant la semaine");
    }
}
