package Univers;

import ihm.IHM_console;

import java.util.Random;

/**
 * La classe Dragon représente un type spécifique d'animal avec des caractéristiques uniques.
 * Un dragon a un type élémentaire de FEU et possède des points de vie et des dégâts.
 */
public class Dragon extends Animal {

    /**
     * Constructeur de la classe Dragon.
     *
     * @param Nom     Le nom du dragon.
     * @param pv_max  Les points de vie maximum du dragon.
     * @param damage  Les dégâts infligés par le dragon.
     */
    public Dragon(String Nom, int pv_max, int damage) {
        super(Nom, pv_max, damage);
        super.type = Element_naturel.FEU;
    }

    /**
     * Crée un dragon aléatoire avec un nom et des points de vie générés aléatoirement.
     *
     * @return Un dragon généré aléatoirement.
     */
    public static Dragon creerDragonAleatoire() {
        Random random = new Random();
        String[] noms = {"Flamme", "Incendio", "Braise", "Pyro", "Brûleur"};

        // Sélection aléatoire d'un nom dans le tableau noms
        String nom = noms[random.nextInt(noms.length)];

        // Génération aléatoire de pv_max entre 100 et 150
        int pv_max = random.nextInt(51) + 100;

        // Génération aléatoire de damage entre 20 et 70
        int damage = random.nextInt(51) + 20;

        return new Dragon(nom, pv_max, damage);
    }

    /**
     * Attaque un autre animal avec un type d'attaque et des dégâts spécifiés.
     *
     * @param type_attaque Le type d'attaque utilisée.
     * @param degats       Les dégâts infligés.
     * @return true si le dragon est encore en vie après l'attaque, sinon false.
     */
    @Override
    public boolean attaquer(Element_naturel type_attaque, int degats) {
        IHM_console.jouer_son("dragon.wav");
        if (type_attaque.equals(Element_naturel.EAU)) {
            pv = pv - degats * BONUS_DEGAT_TYPE;
        } else if (type_attaque.equals(Element_naturel.TERRE)) {
            pv = pv - degats * REDUCTION_DEGAT_TYPE;
        } else {
            pv = pv - degats;
        }

        return pv > 0;
    }
}
