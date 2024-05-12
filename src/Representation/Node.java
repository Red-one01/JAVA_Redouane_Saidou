package Representation;

import java.util.ArrayList;

public abstract class Node {
        private final String description;
        private final int id;
        private static int key = 1;

        public void display(){
            System.out.println(this.description);
        }

        public abstract Node choseNext();

    // true si opération effectuer sinon false donc terminal
        public abstract boolean ajouter_noeud(ArrayList<Node> list_nodes);

        public Node(String descript){
            id = key;
            ++key;
            description = descript;

        }

        public int getId() {
            return id;
        }
}



