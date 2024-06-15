import Representation.*;
import Univers.Combat;
import Univers.Personnage;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Personnage joueur;

    private Node node_courant = new DecisionNode("Betise aux eechecs de saikou",new Combat());

    private IHM ihm = new IHM_console();
    // Déclaration et initialisation d'un tableau d'entiers avec des valeurs initiales

    Personnage test = new Personnage (ihm.taille_creation(), ihm.genre_creation(), ihm.premier_compagnon());
    private ArrayList<Node> list_nodes = new ArrayList<>();

    public Game(){


        list_nodes.add(new DecisionNode("combat avec combrend pas ",new Combat()));
        list_nodes.add(new ChanceNode("combat avec combrend tas", new Combat()));
        list_nodes.add(new DecisionNode("combat d'echec avec mamalou",new Combat()));
        list_nodes.add(new ChanceNode("tabassage aux echecs de saisou",new Combat()));
        list_nodes.add(new DecisionNode("la mort de saifou aux echecs",new Combat()));
        list_nodes.add(new ChanceNode("nullité de saihou aux echecs",new Combat()));
        list_nodes.add(new DecisionNode("aneantissement de saijou aux echecs",new Combat()));



    }


    public void Lancement(){
        ArrayList<Node> remplisseur = new ArrayList<>();
        Random random = new Random();
        boolean IsNotfinish = true;

        //boucle principale du jeu
        while (IsNotfinish) {

            for (int i = 0; i < InnerNode.NB_NODES; i++) {

                if (list_nodes.size() < InnerNode.NB_NODES){
                    for (int z = 0; z < InnerNode.NB_NODES; z++) {//à surveiller la condition
                        remplisseur.add(new TerminalNode("la partie s'arrete ici bravo",new Combat()));
                    }
                    break;
                }
                else {remplisseur.add(list_nodes.get(random.nextInt(list_nodes.size())));}


            }
            IsNotfinish = node_courant.ajouter_noeud(remplisseur);
            node_courant.display();
            node_courant.lancer_action(test);
            node_courant = node_courant.choseNext();
            remplisseur.clear();
        }


    }

}
