package Representation;

import Univers.Action;


import java.util.Scanner;


public class DecisionNode extends InnerNode {


    public DecisionNode(String descript, Action action) {
        super(descript, action);
    }

    @Override
    public Node choseNext() {
        Scanner scanner = new Scanner(System.in);

        int choix;

        //on propose les choix
        System.out.println("Que souhaitez-vous faire parmis ces choix ?:");
        for (int i = 0; i < super.NB_NODES; i++) {
            System.out.print((i + 1) + "- ");
            super.prochains_tab.get(i).display();

        }

        //on récup le choix fait gggg


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

        //on traite le choix ge


        //scanner.close();
        return super.prochains_tab.get(choix - 1);
    }

}
