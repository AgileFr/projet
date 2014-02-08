package projetdlea;

import java.io.IOException;

public class ProjetDLEA {
    public static void main(String[] args) throws IOException {
            LectureJson lectureJson = new LectureJson(args[0]);
            Probleme probleme = new Probleme(lectureJson.root());
            Sortie s = new Sortie ();
            s.writeJson(probleme.totalesHeuresEmploye());
    }
}
