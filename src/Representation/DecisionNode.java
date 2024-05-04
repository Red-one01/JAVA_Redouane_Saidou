package Representation;
import java.util.Scanner;


public abstract class DecisionNode extends InnerNode{

    @Override
    public Node choseNext(){
        Scanner scanner = new Scanner (System.in);
        int choix;

        while (true) {
            System.out.print("Veuillez saisir un entier entre 1 et 4 : ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                if (choix >= 1 && choix <= 4) {
                    System.out.println("Vous avez saisi : " + choix);
                    break;
                } else {
                }
            } else {
                System.out.println("Veuillez saisir un entier valide.");
                scanner.next();
            }
        }
        scanner.close();


    }

}
