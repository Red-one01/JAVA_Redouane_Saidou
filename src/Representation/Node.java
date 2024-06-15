package Representation;

import Univers.Action;
import Univers.Personnage;

import java.util.ArrayList;

public abstract class Node {
    private final String description;
    private final int id;
    private static int key = 1;
    private Action action_en_cours;

    public void display() {
        System.out.println(this.description);
    }

    public abstract Node choseNext();

    // true si opération effectuer sinon false donc terminal
    public abstract boolean ajouter_noeud(ArrayList<Node> list_nodes);

    public void lancer_action(Personnage persso) {
        action_en_cours.lancer(persso);
    }

    public Node(String descript, Action action) {
        id = key;
        ++key;
        description = descript;
        this.action_en_cours = action;

    }

    public int getId() {
        return id;
    }
}



