import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombre = 0;
        boolean entierValide = false;

        while (!entierValide) {
            System.out.print("Veuillez saisir un entier : ");
            if (scanner.hasNextInt())  {
                nombre = scanner.nextInt();
                entierValide = true;
            } else {
                System.out.println("Ce n'est pas un entier valide. Veuillez réessayer.");
                scanner.next(); // Pour vider la ligne incorrecte dans le scanner
            }
        }
    }
}