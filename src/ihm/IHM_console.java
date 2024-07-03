package ihm;

import Univers.Animal;
import Univers.Genre;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

/**
 * Implémentation de l'interface IHM pour une interface utilisateur console.
 */
public class IHM_console implements IHM {

    /**
     * Demande à l'utilisateur de saisir la taille du personnage en centimètres.
     *
     * @return La taille du personnage saisie par l'utilisateur.
     */
    @Override
    public int taille_creation() {
        Scanner scanner = new Scanner(System.in);
        int taille;

        // Boucle pour demander la taille tant qu'elle n'est pas valide
        while (true) {
            System.out.print("Veuillez entrer la taille de votre personnage en cm: ");
            if (scanner.hasNextInt()) { // Vérifie si l'entrée est un entier
                taille = scanner.nextInt();
                if (taille > 100 && taille < 220) { // Vérifie si la taille est dans la plage valide
                    return taille;
                } else {
                    System.out.println("La taille doit être supérieure à 100 cm et inférieure à 220 cm.");
                }
            } else {
                System.out.println("Veuillez entrer un nombre entier valide.");
                scanner.next(); // Consomme l'entrée invalide pour éviter une boucle infinie
            }
        }
    }

    /**
     * Demande à l'utilisateur de saisir le genre du personnage.
     *
     * @return Le genre du personnage (HOMME ou FEMME).
     */
    @Override
    public Genre genre_creation() {
        Scanner scanner = new Scanner(System.in);
        Genre genre;

        while (true) {
            System.out.println("Veuillez saisir le genre de votre personnage (Homme ou Femme): ");
            if (scanner.hasNextLine()) {
                String choix = scanner.nextLine().trim();

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
        return genre;
    }

    /**
     * Retourne un animal compagnon aléatoire pour le personnage.
     *
     * @return Un animal compagnon généré aléatoirement.
     */
    @Override
    public Animal premier_compagnon() {
        return Animal.creerAnimalAleatoire();
    }

    /**
     * Joue un fichier audio spécifié.
     *
     * @param soundFileName Le nom du fichier audio à jouer.
     */
    public static void jouer_son(String soundFileName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./" + soundFileName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du son.");
        }
    }
}
