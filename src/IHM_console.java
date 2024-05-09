import java.util.Scanner;

public class IHM_console implements IHM{

    @Override
    public  int taille_creation() {
        Scanner scanner = new Scanner(System.in);
        int taille;

        // Boucle pour demander la taille tant qu'elle n'est pas valide
        while (true) {
            System.out.print("Veuillez entrer la taille de votre personnage en cm: ");
            if (scanner.hasNextInt()) { // Vérifie si l'entrée est un entier
                taille = scanner.nextInt();
                if (taille > 0 && taille < 220) { // Vérifie si la taille est positive
                    scanner.close();
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
}
