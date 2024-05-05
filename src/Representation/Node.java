package Representation;

public abstract class Node {
        private final String description;
        private final int id;
        private static int key = 1;

        public void display(){
            System.out.println(this.description);
        }

        public abstract Node choseNext();

        public Node(String descript){
            id = key;
            ++key;
            description = descript;

        }

        public int getId() {
            return id;
        }
}



