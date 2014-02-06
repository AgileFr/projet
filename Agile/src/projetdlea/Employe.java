package projetdlea;

public abstract class Employe {

    private int codeEmploye;
    private int compteurMinutesBureau;
    private int compteurMinutesTeletravail;

    public Employe(int codeEmploye, int compteurMinutesBureau) {
        this.codeEmploye = codeEmploye;
        this.compteurMinutesBureau = compteurMinutesBureau;
    }

    public int getCompteurMinutesBureau() {
        return compteurMinutesBureau;
    }

    public int getCompteurMinutesTeletravail() {
        return compteurMinutesTeletravail;
    }
    
    public abstract void totalHeures();
}
