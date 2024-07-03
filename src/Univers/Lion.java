package Univers;

import ihm.IHM_console;

import java.util.Random;

/**
 * La classe Lion représente un type spécifique d'animal avec des caractéristiques uniques.
 * Un lion a un type élémentaire de TERRE et possède des points de vie et des dégâts.
 */
public class Lion extends Animal {

    /**
     * Constructeur de la classe Lion.
     *
     * @param Nom     Le nom du lion.
     * @param pv_max  Les points de vie maximum du lion.
     * @param damage  Les dégâts infligés par le lion.
     */
    public Lion(String Nom, int pv_max, int damage) {
        super(Nom, pv_max, damage);
        super.type = Element_naturel.TERRE;
    }

    /**
     * Crée un lion aléatoire avec un nom et des points de vie générés aléatoirement.
     *
     * @return Un lion généré aléatoirement.
     */
    public static Lion creerLionAleatoire() {
        Random random = new Random();
        String[] noms = {"Simba", "Leo", "Aslan", "Roi", "Mufasa"};

        // Sélection aléatoire d'un nom dans le tableau noms
        String nom = noms[random.nextInt(noms.length)];

        // Génération aléatoire de pv_max entre 70 et 120 pour un lion
        int pv_max = random.nextInt(51) + 70;

        // Génération aléatoire de damage entre 25 et 75
        int damage = random.nextInt(51) + 25;

        return new Lion(nom, pv_max, damage);
    }

    /**
     * Attaque un autre animal avec un type d'attaque et des dégâts spécifiés.
     *
     * @param type_attaque Le type d'attaque utilisée.
     * @param degats       Les dégâts infligés.
     * @return true si le lion est encore en vie après l'attaque, sinon false.
     */
    @Override
    public boolean attaquer(Element_naturel type_attaque, int degats) {
        IHM_console.jouer_son("tigre.wav");
        if (type_attaque.equals(Element_naturel.FEU)) {
            pv = pv - degats * BONUS_DEGAT_TYPE;
        } else if (type_attaque.equals(Element_naturel.AIR)) {
            pv = pv - degats * REDUCTION_DEGAT_TYPE;
        } else {
            pv = pv - degats;
        }

        return pv > 0;
    }
}
