import Representation.*;
import Univers.Personnage;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Personnage joueur;

    private Node node_courant = new DecisionNode("Bienvenue dans le jeu de chasse de monstre");

    private IHM ihm = new IHM_console();
    // Déclaration et initialisation d'un tableau d'entiers avec des valeurs initiales


    private ArrayList<Node> list_nodes = new ArrayList<>();

    public Game(){



        Personnage test = new Personnage (ihm.taille_creation(), ihm.genre_creation(), ihm.premier_compagnon());
        list_nodes.add(new DecisionNode("Ji gomprend ba"));
        list_nodes.add(new ChanceNode("Ji gomprend pa"));
        list_nodes.add(new DecisionNode("Ji gomprend la"));
        list_nodes.add(new ChanceNode("Ji gomprend ma"));
        list_nodes.add(new DecisionNode("Ji gomprend na"));
        list_nodes.add(new ChanceNode("Ji gomprend ta"));
        list_nodes.add(new DecisionNode("Ji gomprend ra"));





    }


    public void Lancement(){
        ArrayList<Node> remplisseur = new ArrayList<>();
        Random random = new Random();
        boolean IsNotfinish = true;

        //boucle principale du jeu
        while (IsNotfinish) {

            for (int i = 0; i < InnerNode.NB_NODES; i++) {

                if (list_nodes.size() < InnerNode.NB_NODES){
                    for (int z = 0; z < InnerNode.NB_NODES; z++) {
                        remplisseur.add(new TerminalNode("la partie s'arrete ici bravo"));
                    }
                    break;
                }
                else {remplisseur.add(list_nodes.get(random.nextInt(list_nodes.size())));}


            }
            IsNotfinish = node_courant.ajouter_noeud(remplisseur);
            node_courant.display();
            node_courant = node_courant.choseNext();
            remplisseur.clear();
        }


    }

}
