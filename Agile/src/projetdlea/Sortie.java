package projetdlea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Vincent
 */
public class Sortie {
    public void writeJson (String resultat, String fichierSortie){
       
	
		File file = new File(fichierSortie);

		try {
			if (!file.exists())
				file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(resultat);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Erreur: impossible de créer le fichier '"
					+ fichierSortie + "'");
		}
    }
}
