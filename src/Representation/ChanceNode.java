package Representation;

import java.util.ArrayList;
import java.util.Random;

public  class ChanceNode extends InnerNode{


    public ChanceNode(String descript) {
        super(descript);
    }

    @Override
    public Node choseNext(){
        Random random = new Random();
        int randomInt = random.nextInt(super.NB_NODES);


        return super.prochains_tab.get(randomInt);
    }
}
