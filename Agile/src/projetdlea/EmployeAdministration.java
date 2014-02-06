package projetdlea;

public class EmployeAdministration extends Employe{
    private int compteurMinutesTeletravail;
    public EmployeAdministration(int codeEmploye, int compteurMinutesBureau, int compteurMinutesTeletravail) {
        super(codeEmploye, compteurMinutesBureau);
        this.compteurMinutesTeletravail = compteurMinutesTeletravail;
    }

    public void parler(){
        System.out.println("je suis un employe d'administration");
    }
    
    public void totalHeures(){
        if(super.getCompteurMinutesBureau() >= 2160 && super.getCompteurMinutesBureau() <= 2580) System.out.println("\nl'employe à travaillé le nombre d'heures minimal au bureau durant la semaine");
        if(super.getCompteurMinutesBureau()<2160) System.out.println("\nl'employe n'a pas travaillé le nombre d'heures minimal  au bureau durant la semaine");
        if(super.getCompteurMinutesBureau() > 2580) System.out.println("\nl'employe a depassé le nombres d'heures au bureau durant la semaine");
        if(compteurMinutesTeletravail> 600) System.out.println("\nl'employe a depassé le nombres d'heures au teletravail durant la semaine");
    }
}
