/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile;

/**
 *
 * @author Vincent
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if ( args.length != 2 )
            System.err.println("Il faut 2 arguments: entryFile.JSON exitFile.JSON");               
        else if (args[0].endsWith(".json") && args[1].endsWith(".json"))
            System.out.println("Fichier d'entrée: " + args[0] + "\nFichier de sortie: " + args[1]);
        else 
            System.err.println("Les arguments ne sont pas des fichiers .json "); 
    }
}
