import Representation.Node;
import Representation.InnerNode;
import Representation.ChanceNode;
import Representation.DecisionNode;
import Representation.TerminalNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node node1 = new ChanceNode("Bienvenue dans le jeu", new ArrayList<>(4)) {
            public Node choseNext() {
                return null;
            }
        };
        Node node2 = new DecisionNode("Redouane avait mal aux dents", new ArrayList<>(4) ) {
            public Node choseNext() {
                return null;
            }
        };
        Node node3 = new TerminalNode("Vzyy t'as gagné bouffon");
    }
}