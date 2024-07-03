package Univers;

/**
 * La classe Personnage représente un personnage avec un genre, une taille et un compagnon animal.
 */
public class Personnage {
    /**
     * Le genre du personnage.
     */
    private Genre genre;

    /**
     * La taille du personnage.
     */
    private int taille;

    /**
     * Le compagnon animal du personnage.
     */
    private Animal compagnon;

    /**
     * Constructeur de la classe Personnage.
     *
     * @param taille            La taille du personnage.
     * @param genre             Le genre du personnage.
     * @param premier_compagnon Le premier compagnon animal du personnage.
     */
    public Personnage(int taille, Genre genre, Animal premier_compagnon) {
        this.taille = taille;
        this.genre = genre;
        this.compagnon = premier_compagnon;
    }

    /**
     * Change le compagnon du personnage.
     *
     * @param compagnon Le nouvel animal compagnon du personnage.
     */
    public void changer_de_compagnon(Animal compagnon) {
        this.compagnon = compagnon;
    }

    /**
     * Obtient le compagnon actuel du personnage.
     *
     * @return L'animal compagnon du personnage.
     */
    public Animal getCompagnon() {
        return compagnon;
    }
}
