package Representation;

public class TerminalNode extends Node{
    @Override
    public Node choseNext(){
        return this;
    }
}
