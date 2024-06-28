package ihm;

import Univers.Animal;
import Univers.Genre;

import javax.sound.sampled.*;
import java.io.File;

import java.util.Scanner;

public class IHM_console implements IHM {

    @Override
    public  int taille_creation() {
        Scanner scanner = new Scanner(System.in);
        int taille;

        // Boucle pour demander la taille tant qu'elle n'est pas valide
        while (true) {
            System.out.print("Veuillez entrer la taille de votre personnage en cm: ");
            if (scanner.hasNextInt()) { // Vérifie si l'entrée est un entier
                taille = scanner.nextInt();
                if (taille > 100 && taille < 220) { // Vérifie si la taille est positive
                    //scanner.close();
                    return taille;
                } else {
                    System.out.println("La taille doit être supérieure à zéro et inférieure à 220.");
                }
            } else {
                System.out.println("Veuillez entrer un nombre entier valide.");
                scanner.next(); // Consomme l'entrée invalide pour éviter une boucle infinie
            }
        }



    }

    @Override
    public Genre genre_creation() {
        Scanner scanner = new Scanner(System.in);
        Genre genre;

        while (true) {
            System.out.println("Veuillez saisir le genre de votre personnage");
            if (scanner.hasNextLine()) {
                String choix = scanner.next();

                if (choix.equalsIgnoreCase("homme")) {
                    genre = Genre.HOMME;
                    break; // Sort de la boucle une fois que le genre est valide
                } else if (choix.equalsIgnoreCase("femme")) {
                    genre = Genre.FEMME;
                    break; // Sort de la boucle une fois que le genre est valide
                } else {
                    System.out.println("Genre invalide. Veuillez choisir entre 'Homme' ou 'Femme'!");
                }
            } else {
                System.out.println("Aucune entrée détectée. Veuillez saisir une valeur.");
                scanner.nextLine(); // Pour consommer la nouvelle ligne
            }
        }
        //scanner.close(); // Ferme le scanner lorsque vous avez terminé de l'utiliser
        return genre;
    }

    @Override
    public Animal premier_compagnon() {
        return Animal.creerAnimalAleatoire();
    }


    public static void jouer_son(String received) {
        String soundFileName = received;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./" + soundFileName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error while playing sound.");
        }
    }
}
