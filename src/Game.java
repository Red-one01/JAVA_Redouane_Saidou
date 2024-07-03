import Representation.*;
import Univers.Combat;
import Univers.Personnage;
import ihm.IHM;
import ihm.IHM_console;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe Game représente le cœur logique du jeu de combats de monstres.
 * Elle gère l'initialisation du joueur, la configuration initiale du jeu,
 * la gestion des nœuds de décision et de chance, ainsi que le déroulement de la partie.
 */
public class Game {
    /**
     * Le personnage du joueur.
     */
    private Personnage joueur;

    /**
     * Le nœud courant dans lequel le jeu se trouve.
     */
    private Node node_courant = new DecisionNode("Que le jeu commence et puissiez vous devenir les roi des combats de monstres", new Combat());

    /**
     * Interface de gestion des interactions avec l'utilisateur.
     */
    private IHM ihm = new IHM_console();

    /**
     * Le personnage de test utilisé pour les interactions initiales.
     */
    private Personnage test = new Personnage(ihm.taille_creation(), ihm.genre_creation(), ihm.premier_compagnon());

    /**
     * Liste des nœuds du jeu.
     */
    private ArrayList<Node> list_nodes = new ArrayList<>();

    /**
     * Constructeur de la classe Game.
     * Initialise la liste des nœuds avec des instances de DecisionNode et ChanceNode.
     */
    public Game() {
        list_nodes.add(new DecisionNode("Vous voila plonger dans le bain avec ce combat endiablé", new Combat()));
        list_nodes.add(new ChanceNode("réussirez vous ce comabt ?", new Combat()));
        list_nodes.add(new DecisionNode("voila un combat mythique qui sera inoubliable", new Combat()));
        list_nodes.add(new ChanceNode("ca ne s'est joué à pas grand chose", new Combat()));
        list_nodes.add(new DecisionNode("combat determinant pour votre futur carrière de combatant", new Combat()));
        list_nodes.add(new ChanceNode("combat qui necessité beaucoup d'ingéniosité", new Combat()));
        list_nodes.add(new DecisionNode("combat exceptionnel", new Combat()));
    }

    /**
     * Supprime un nœud de la liste des nœuds en fonction de son identifiant.
     *
     * @param id L'identifiant du nœud à supprimer.
     */
    public void remove_node(int id) {
        for (int i = 0; i < list_nodes.size(); i++) {
            if (list_nodes.get(i).getId() == id) {
                list_nodes.remove(i);
                return;
            }
        }
    }

    /**
     * Lance le déroulement principal du jeu.
     * Cette méthode utilise une boucle principale pour gérer le passage d'un nœud à un autre
     * et exécuter les actions associées à chaque nœud.
     */
    public void Lancement() {
        ArrayList<Node> remplisseur = new ArrayList<>();
        Random random = new Random();
        boolean IsNotfinish = true;

        // Boucle principale du jeu
        while (IsNotfinish) {
            for (int i = 0; i < InnerNode.NB_NODES; i++) {
                if (i < InnerNode.NB_NODES - list_nodes.size()) {
                    remplisseur.add(new TerminalNode("la partie s'arrete ici bravo", new Combat()));
                } else {
                    remplisseur.add(list_nodes.get(random.nextInt(list_nodes.size())));
                }
            }
            IsNotfinish = node_courant.ajouter_noeud(remplisseur);
            node_courant.display();
            node_courant.lancer_action(test);
            node_courant = node_courant.choseNext();
            this.remove_node(node_courant.getId());
            remplisseur.clear();
        }
    }
}
