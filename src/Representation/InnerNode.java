package Representation;

import java.util.ArrayList;

public abstract class InnerNode extends Node {
    public final static int NB_NODES = 4;
    protected ArrayList<Node> prochains_tab = new ArrayList<>();

    public InnerNode(String descript) {
        super(descript);
    }

    public boolean ajouter_noeud(ArrayList<Node> list_nodes) {
        prochains_tab = list_nodes;
        if (list_nodes.size() != NB_NODES) {
            throw new RuntimeException("Nombre de noeuds ne correspond pas a la " +
                    "constante NB_NODES lors de la création d'un innernode");

        } else {
            for (int i = 0; i < NB_NODES; i++) {
                prochains_tab.add(list_nodes.get(i));
            }
        }
        return true;
    }
}