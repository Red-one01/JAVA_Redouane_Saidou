package Univers;

import java.util.Random;
import java.util.Scanner;

/**
 * La classe abstraite Animal représente un animal dans le jeu.
 * Elle définit les attributs et les comportements communs à tous les types d'animaux.
 */
public abstract class Animal {
    /**
     * Bonus de dégâts pour le type d'attaque.
     */
    protected final double BONUS_DEGAT_TYPE = 1.2;

    /**
     * Réduction de dégâts pour le type de défense.
     */
    protected final double REDUCTION_DEGAT_TYPE = 0.95;

    /**
     * Le nom de l'animal.
     */
    protected String Nom;

    /**
     * Les dégâts infligés par l'animal.
     */
    protected int damage;

    /**
     * Les points de vie maximum de l'animal.
     */
    protected int pv_max;

    /**
     * Les points de vie actuels de l'animal.
     */
    protected double pv;

    /**
     * Le type élémentaire de l'animal.
     */
    protected Element_naturel type;

    /**
     * Revive l'animal en réinitialisant ses points de vie au maximum.
     */
    public void revive() {
        pv = pv_max;
    }

    /**
     * Constructeur de la classe Animal.
     *
     * @param Nom    Le nom de l'animal.
     * @param pv_max Les points de vie maximum de l'animal.
     * @param damage Les dégâts infligés par l'animal.
     */
    public Animal(String Nom, int pv_max, int damage) {
        this.Nom = Nom;
        this.pv_max = pv_max;
        this.damage = damage;
        this.pv = this.pv_max;
    }

    /**
     * Crée un animal aléatoire.
     *
     * @return Un animal aléatoire parmi les sous-classes de Animal.
     */
    public static Animal creerAnimalAleatoire() {
        Random random = new Random();
        int choix = random.nextInt(4);

        switch (choix) {
            case 0:
                return Dragon.creerDragonAleatoire();
            case 1:
                return Grenouille_Geante.creerGrenouilleGeanteAleatoire();
            case 2:
                return Lion.creerLionAleatoire();
            default:
                return Aigle.creerAigleAleatoire();
        }
    }

    /**
     * Attaque un autre animal avec un type d'attaque et des dégâts spécifiés.
     *
     * @param type_attaque Le type d'attaque utilisée.
     * @param degats       Les dégâts infligés.
     * @return true si l'animal attaqué est encore en vie après l'attaque, sinon false.
     */
    public abstract boolean attaquer(Element_naturel type_attaque, int degats);

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'animal.
     *
     * @return Une chaîne de caractères représentant l'animal.
     */
    @Override
    public String toString() {
        return this.Nom + "(dégats: " + this.damage + " PV: " + this.pv + " type: " + this.type + ")";
    }

    /**
     * Combat un autre animal et décide du vainqueur.
     * Le vainqueur a la possibilité de remplacer son compagnon actuel par l'opposant.
     *
     * @param opposant L'animal opposant dans le combat.
     * @return Le vainqueur du combat.
     */
    public Animal combattre(Animal opposant) {
        if (opposant.pv <= 0)
            System.out.println("grosse galere");

        while (true) {
            if (!opposant.attaquer(this.type, this.damage)) {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String reponse;
                    opposant.revive();
                    System.out.println("Vous avez gagner voulez-vous echanger votre compagnon actuel avec "
                            + opposant + "? (oui/non)");

                    reponse = scanner.nextLine().trim().toLowerCase();

                    if (reponse.equals("oui")) {
                        System.out.println("Super, vous avez un nouveau compagnon !");
                        return opposant;
                    } else if (reponse.equals("non")) {
                        System.out.println("D'accord, vous conservez votre compagnon actuel !");
                        return this;
                    } else {
                        System.out.println("Veuillez répondre par 'oui' ou 'non'.");
                    }
                }
            }
            if (!this.attaquer(opposant.type, opposant.damage)) {
                System.out.println("Vous avez perdu le combat");
                this.revive();
                opposant.revive();
                return this;
            }
        }
    }

    /**
     * Obtient les points de vie actuels de l'animal.
     *
     * @return Les points de vie actuels.
     */
    public double getPv() {
        return pv;
    }
}
