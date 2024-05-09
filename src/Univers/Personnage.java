package Univers;

public class Personnage {
    private Genre genre;
    private int taille;
    //private int pv;

    private Animal compagnon;

    public Personnage(int taille, Genre genre, Animal premier_compagnon) {
        this.taille = taille;
        this.genre = genre;
        compagnon = premier_compagnon;

    }

    public Animal getCompagnon() {
        return compagnon;
    }
}
