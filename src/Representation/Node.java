package Representation;

public abstract class Node {
        private String description;
        int id;
        private static int key = 1;

        public void display(){
            System.out.println(this.description);
        }

        public abstract Node choseNext();

        public Node(){
            id = key;
            ++key;
        }

}



