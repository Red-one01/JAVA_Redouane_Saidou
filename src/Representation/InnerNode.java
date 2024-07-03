package Representation;

import Univers.Action;
import Univers.Personnage;

import java.util.ArrayList;

/**
 * La classe abstraite {@code InnerNode} représente un nœud interne dans la structure de nœuds.
 * Cette classe contient une liste de nœuds enfants et impose un nombre fixe de nœuds enfants défini par {@code NB_NODES}.
 */
public abstract class InnerNode extends Node {

    /**
     * Nombre constant de nœuds enfants pour chaque {@code InnerNode}.
     */
    public final static int NB_NODES = 4;

    /**
     * Liste des nœuds enfants.
     */
    protected ArrayList<Node> prochains_tab = new ArrayList<>();

    /**
     * Constructeur pour créer une instance de {@code InnerNode}.
     *
     * @param descript La description du nœud.
     * @param action   L'action associée à ce nœud.
     */
    public InnerNode(String descript, Action action) {
        super(descript, action);
    }

    /**
     * Ajoute une liste de nœuds enfants à cet {@code InnerNode}.
     * La taille de la liste doit être égale à {@code NB_NODES}.
     *
     * @param list_nodes La liste des nœuds à ajouter.
     * @return {@code true} si les nœuds sont ajoutés avec succès.
     * @throws RuntimeException si la taille de la liste des nœuds n'est pas égale à {@code NB_NODES}.
     */
    @Override
    public boolean ajouter_noeud(ArrayList<Node> list_nodes) {
        prochains_tab = list_nodes;
        if (list_nodes.size() != NB_NODES) {
            throw new RuntimeException("Nombre de noeuds ne correspond pas à la constante NB_NODES lors de la création d'un innernode");
        } else {
            for (int i = 0; i < NB_NODES; i++) {
                prochains_tab.add(list_nodes.get(i));
            }
        }
        return true;
    }
}
