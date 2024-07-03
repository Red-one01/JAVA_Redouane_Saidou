package Representation;

import Univers.Action;

import java.util.ArrayList;

/**
 * La classe {@code TerminalNode} représente un nœud terminal dans une structure de nœuds.
 * Un nœud terminal n'a pas de nœuds enfants et ne peut pas en ajouter.
 */
public class TerminalNode extends Node {

    /**
     * Constructeur pour créer une instance de {@code TerminalNode}.
     *
     * @param descriptif La description du nœud.
     * @param action     L'action associée à ce nœud.
     */
    public TerminalNode(String descriptif, Action action) {
        super(descriptif, action);
    }

    /**
     * Retourne ce nœud lui-même car il s'agit d'un nœud terminal.
     *
     * @return Ce même {@code TerminalNode}.
     */
    @Override
    public Node choseNext() {
        return this;
    }

    /**
     * Ne permet pas d'ajouter des nœuds enfants car il s'agit d'un nœud terminal.
     *
     * @param list_nodes La liste des nœuds à ajouter (ignorée).
     * @return {@code false} car les nœuds enfants ne peuvent pas être ajoutés à un nœud terminal.
     */
    @Override
    public boolean ajouter_noeud(ArrayList<Node> list_nodes) {
        return false;
    }
}
