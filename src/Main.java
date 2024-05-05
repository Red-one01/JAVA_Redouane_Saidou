import Representation.Node;

import Representation.ChanceNode;
import Representation.DecisionNode;
import Representation.TerminalNode;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<Node> list_nodes = new ArrayList<>();

        Node finish = new TerminalNode("t'es mort");

        list_nodes.add(finish);
        list_nodes.add(finish);
        list_nodes.add(finish);


        list_nodes.add(new ChanceNode("le choix du choix", new ArrayList<Node>() {{
            add(finish);
            add(finish);
            add(finish);
            add(finish);
        }}));


        Node racine = new DecisionNode("Je suis le point de départ", list_nodes);

        racine.display();
        Node nv_node = racine.choseNext();

        nv_node.display();
        Node autre_node = nv_node.choseNext();
        autre_node.display();
    }
}