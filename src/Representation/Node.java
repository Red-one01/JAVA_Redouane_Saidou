package Representation;

import Univers.Action;
import Univers.Personnage;

import java.util.ArrayList;

/**
 * La classe abstraite {@code Node} représente un nœud dans une structure hiérarchique.
 * Chaque nœud a une description, un identifiant unique et une action associée.
 */
public abstract class Node {
    private final String description;
    private final int id;
    private static int key = 1;
    private Action action_en_cours;

    /**
     * Affiche la description de ce nœud.
     */
    public void display() {
        System.out.println(this.description);
    }

    /**
     * Choisit le prochain nœud.
     *
     * @return Le prochain {@code Node}.
     */
    public abstract Node choseNext();

    /**
     * Ajoute une liste de nœuds enfants à ce nœud.
     *
     * @param list_nodes La liste des nœuds à ajouter.
     * @return {@code true} si l'opération est effectuée avec succès, sinon {@code false}.
     */
    public abstract boolean ajouter_noeud(ArrayList<Node> list_nodes);

    /**
     * Lance l'action associée à ce nœud pour un personnage donné.
     *
     * @param persso Le personnage pour lequel l'action est lancée.
     */
    public void lancer_action(Personnage persso) {
        action_en_cours.lancer(persso);
    }

    /**
     * Constructeur pour créer une instance de {@code Node}.
     *
     * @param descript La description du nœud.
     * @param action   L'action associée à ce nœud.
     */
    public Node(String descript, Action action) {
        id = key;
        ++key;
        description = descript;
        this.action_en_cours = action;
    }

    /**
     * Retourne l'identifiant unique de ce nœud.
     *
     * @return L'identifiant de ce nœud.
     */
    public int getId() {
        return id;
    }
}
