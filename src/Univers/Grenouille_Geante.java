package Univers;

import ihm.IHM_console;

import java.util.Random;

/**
 * La classe Grenouille_Geante représente un type spécifique d'animal avec des caractéristiques uniques.
 * Une grenouille géante a un type élémentaire d'EAU et possède des points de vie et des dégâts.
 */
public class Grenouille_Geante extends Animal {

    /**
     * Constructeur de la classe Grenouille_Geante.
     *
     * @param Nom     Le nom de la grenouille géante.
     * @param pv_max  Les points de vie maximum de la grenouille géante.
     * @param damage  Les dégâts infligés par la grenouille géante.
     */
    public Grenouille_Geante(String Nom, int pv_max, int damage) {
        super(Nom, pv_max, damage);
        super.type = Element_naturel.EAU;
    }

    /**
     * Crée une grenouille géante aléatoire avec un nom et des points de vie générés aléatoirement.
     *
     * @return Une grenouille géante générée aléatoirement.
     */
    public static Grenouille_Geante creerGrenouilleGeanteAleatoire() {
        Random random = new Random();
        String[] noms = {"Croak", "Hopper", "Sauterelle", "Hoppy", "Bond"};

        // Sélection aléatoire d'un nom dans le tableau noms
        String nom = noms[random.nextInt(noms.length)];

        // Génération aléatoire de pv_max entre 30 et 80 pour une grenouille géante
        int pv_max = random.nextInt(51) + 30;

        // Génération aléatoire de damage entre 30 et 80
        int damage = random.nextInt(51) + 30;

        return new Grenouille_Geante(nom, pv_max, damage);
    }

    /**
     * Attaque un autre animal avec un type d'attaque et des dégâts spécifiés.
     *
     * @param type_attaque Le type d'attaque utilisée.
     * @param degats       Les dégâts infligés.
     * @return true si la grenouille géante est encore en vie après l'attaque, sinon false.
     */
    @Override
    public boolean attaquer(Element_naturel type_attaque, int degats) {
        IHM_console.jouer_son("frog.wav");
        if (type_attaque.equals(Element_naturel.AIR)) {
            pv = pv - degats * BONUS_DEGAT_TYPE;
        } else if (type_attaque.equals(Element_naturel.FEU)) {
            pv = pv - degats * REDUCTION_DEGAT_TYPE;
        } else {
            pv = pv - degats;
        }

        return pv > 0;
    }
}
