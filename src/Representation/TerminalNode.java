package Representation;

import Univers.Action;


import java.util.ArrayList;

public class TerminalNode extends Node {


    @Override
    public Node choseNext() {
        return this;
    }

    @Override
    public boolean ajouter_noeud(ArrayList<Node> list_nodes) {
        return false;
    }

    public TerminalNode(String descriptif, Action action) {
        super(descriptif, action);
    }
}
