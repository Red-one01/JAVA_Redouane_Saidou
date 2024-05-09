import Representation.*;
import Univers.Personnage;

import java.util.ArrayList;

public class Game {
    Personnage joueur;
    IHM ihm = new IHM_console();
    ArrayList<Node> list_nodes = new ArrayList<>();

    public Game(){
        Personnage test = new Personnage (ihm.taille_creation(), ihm.genre_creation(), ihm.premier_compagnon());
        list_nodes.add(new DecisionNode("Ji gomprend ba"));
        list_nodes.add(new DecisionNode("Ji gomprend ba"));
        list_nodes.add(new DecisionNode("Ji gomprend ba"));
        list_nodes.add(new DecisionNode("Ji gomprend ba"));
        list_nodes.add(new DecisionNode("Ji gomprend ba"));
        list_nodes.add(new DecisionNode("Ji gomprend ba"));
        list_nodes.add(new DecisionNode("Ji gomprend ba"));
        list_nodes.add(new DecisionNode("Ji gomprend ba"));




    }


    public void Lancement(){

}
