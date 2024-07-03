package Representation;

import Univers.Action;

import java.util.Scanner;

/**
 * La classe {@code DecisionNode} représente un nœud interne où l'utilisateur choisit le nœud suivant.
 * Cette classe hérite de {@link InnerNode} et surcharge la méthode {@code choseNext()} pour permettre à l'utilisateur de choisir le prochain nœud.
 */
public class DecisionNode extends InnerNode {

    /**
     * Constructeur pour créer une instance de {@code DecisionNode}.
     *
     * @param descript La description du nœud.
     * @param action   L'action associée à ce nœud.
     */
    public DecisionNode(String descript, Action action) {
        super(descript, action);
    }

    /**
     * Affiche les options disponibles et permet à l'utilisateur de choisir le prochain nœud.
     *
     * @return Le prochain {@code Node} choisi par l'utilisateur.
     */
    @Override
    public Node choseNext() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        // Propose les choix disponibles
        System.out.println("Que souhaitez-vous faire parmi ces choix ?:");
        for (int i = 0; i < super.NB_NODES; i++) {
            System.out.print((i + 1) + "- ");
            super.prochains_tab.get(i).display();
        }

        // Récupère le choix de l'utilisateur
        while (true) {
            System.out.print("Veuillez saisir un entier entre 1 et " + NB_NODES + " : ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                if (choix >= 1 && choix <= super.NB_NODES) {
                    System.out.println("Vous avez saisi : " + choix);
                    break;
                } else {
                    System.out.println("Veuillez saisir un entier entre 1 et " + NB_NODES + ".");
                    scanner.next();
                }
            } else {
                System.out.println("Veuillez saisir un entier valide.");
                scanner.nextLine();
            }
        }

        return super.prochains_tab.get(choix - 1);
    }
}
