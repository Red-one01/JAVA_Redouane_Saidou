package Representation;

import java.util.ArrayList;

public abstract class InnerNode extends Node {
    protected final int NB_NODES = 4;
    protected ArrayList<Node> prochains_tab = new ArrayList<>();


    public InnerNode(String descript, ArrayList<Node> tab) {
        super(descript);
        if (tab.size() != NB_NODES) {
            throw new RuntimeException("Nombre de noeuds ne correspond pas a la " +
                    "constante NB_NODES lors de la création d'un innernode");

        } else {
            for (int i = 0; i < NB_NODES; i++) {
                prochains_tab.add(tab.get(i));
            }
        }
    }
}
