package Representation;

import Univers.Action;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe {@code ChanceNode} représente un nœud interne avec une action de choix aléatoire du nœud suivant.
 * Cette classe hérite de {@link InnerNode} et surcharge la méthode {@code choseNext()} pour retourner un nœud aléatoire.
 */
public class ChanceNode extends InnerNode {

    /**
     * Constructeur pour créer une instance de {@code ChanceNode}.
     *
     * @param descript La description du nœud.
     * @param action   L'action associée à ce nœud.
     */
    public ChanceNode(String descript, Action action) {
        super(descript, action);
    }

    /**
     * Choisit aléatoirement le prochain nœud parmi les nœuds disponibles.
     *
     * @return Le prochain {@code Node} choisi aléatoirement.
     */
    @Override
    public Node choseNext() {
        Random random = new Random();
        int randomInt = random.nextInt(super.NB_NODES);
        return super.prochains_tab.get(randomInt);
    }
}
