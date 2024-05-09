import Univers.Personnage;

public class Game {
    Personnage joueur;
    IHM ihm = new IHM_console();

    public Game(){
        Personnage test = new Personnage (ihm.taille_creation(), );

    }
}
