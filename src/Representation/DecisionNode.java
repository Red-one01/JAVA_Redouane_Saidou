package Representation;
import java.util.ArrayList;
import java.util.Scanner;


public  class DecisionNode extends InnerNode{


    public DecisionNode(String descript, ArrayList<Node> tab) {
        super(descript, tab);
    }

    @Override
    public Node choseNext(){
        Scanner scanner = new Scanner (System.in);
        int choix;

        //on propose les choix
        System.out.println("Que souhaitez-vous faire parmis ces choix ?:");
        for (int i = 0; i < super.NB_NODES; i++) {
            System.out.print((i+1)+"- ");
            super.prochains_tab.get(i).display();

        }

        //on récup le choix fait
        while (true) {
            System.out.print("Veuillez saisir un entier entre 1 et "+ NB_NODES +" : ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                if (choix >= 1 && choix <= super.NB_NODES) {
                    System.out.println("Vous avez saisi : " + choix);
                    break;
                } else {
                }
            } else {
                System.out.println("Veuillez saisir un entier valide.");
                scanner.next();
            }
        }

        //on traite le choix


        scanner.close();
        return super.prochains_tab.get(choix-1);
    }

}
