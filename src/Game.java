import Representation.*;
import Univers.Combat;
import Univers.Personnage;
import ihm.IHM;
import ihm.IHM_console;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Personnage joueur;

    private Node node_courant = new DecisionNode("Que le jeu commence et puissiez vous devenir les roi des combats de monstres",new Combat());

    private IHM ihm = new IHM_console();
    // Déclaration et initialisation d'un tableau d'entiers avec des valeurs initiales

    Personnage test = new Personnage (ihm.taille_creation(), ihm.genre_creation(), ihm.premier_compagnon());
    private ArrayList<Node> list_nodes = new ArrayList<>();

    public Game(){


        list_nodes.add(new DecisionNode("Vous voila plonger dans le bain avec ce combat endiablé ",new Combat()));
        list_nodes.add(new ChanceNode("réussirez vous ce comabt ?", new Combat()));
        list_nodes.add(new DecisionNode("voila un combat mythique qui sera inoubliable",new Combat()));
        list_nodes.add(new ChanceNode("ca ne s'est joué à pas grand chose",new Combat()));
        list_nodes.add(new DecisionNode("combat determinant pour votre futur carrière de combatant",new Combat()));
        list_nodes.add(new ChanceNode("combat qui necessité beaucoup d'ingéniosité",new Combat()));
        list_nodes.add(new DecisionNode("combat exceptionnel",new Combat()));

    }

    public void remove_node(int id){
        for (int i = 0; i < list_nodes.size(); i++) {
            if (list_nodes.get(i).getId()== id){
                list_nodes.remove(i);
                return;
            }
        }
    }

    public void Lancement(){
        ArrayList<Node> remplisseur = new ArrayList<>();
        Random random = new Random();
        boolean IsNotfinish = true;

        //boucle principale du jeu
        while (IsNotfinish) {

            for (int i = 0; i < InnerNode.NB_NODES; i++) {

                if (i <  InnerNode.NB_NODES - list_nodes.size()){

                    remplisseur.add(new TerminalNode("la partie s'arrete ici bravo",new Combat()));
                }
                else {remplisseur.add(list_nodes.get(random.nextInt(list_nodes.size())));}


            }
            IsNotfinish = node_courant.ajouter_noeud(remplisseur);
            node_courant.display();
            node_courant.lancer_action(test);
            node_courant = node_courant.choseNext();
            this.remove_node(node_courant.getId());
            remplisseur.clear();
        }


    }

}
