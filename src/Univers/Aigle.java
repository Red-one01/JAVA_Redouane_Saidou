package Univers;

import ihm.IHM_console;

import java.util.Random;

/**
 * La classe {@code Aigle} représente un aigle, qui est un type spécifique d'Animal.
 * Un aigle a un nom, un nombre maximum de points de vie (pv_max), et des dégâts.
 * L'élément naturel associé à un aigle est {@code AIR}.
 */
public class Aigle extends Animal {

    /**
     * Constructeur pour créer une instance d'{@code Aigle}.
     *
     * @param Nom     Le nom de l'aigle.
     * @param pv_max  Le nombre maximum de points de vie de l'aigle.
     * @param damage  Les dégâts de l'aigle.
     */
    public Aigle(String Nom, int pv_max, int damage) {
        super(Nom, pv_max, damage);
        super.type = Element_naturel.AIR;
    }

    /**
     * Crée un aigle avec des attributs aléatoires.
     *
     * @return Un {@code Aigle} avec un nom, des points de vie maximum et des dégâts générés aléatoirement.
     */
    public static Aigle creerAigleAleatoire() {
        Random random = new Random();
        String[] noms = {"Aquila", "Eagle", "Hawk", "Freedom", "Sky"};

        // Sélection aléatoire d'un nom dans le tableau noms
        String nom = noms[random.nextInt(noms.length)];

        // Génération aléatoire de pv_max entre 40 et 90 pour un aigle
        int pv_max = random.nextInt(51) + 40;

        return new Aigle(nom, pv_max, random.nextInt(51) + 15);
    }

    /**
     * Effectue une attaque sur l'aigle en tenant compte du type de l'élément de l'attaque.
     *
     * @param type_attaque Le type de l'élément de l'attaque.
     * @param degats       Les dégâts infligés par l'attaque.
     * @return {@code true} si l'aigle survit à l'attaque, sinon {@code false}.
     */
    @Override
    public boolean attaquer(Element_naturel type_attaque, int degats) {
        IHM_console.jouer_son("aigle.wav");

        if (type_attaque.equals(Element_naturel.TERRE)) {
            pv = pv - degats * BONUS_DEGAT_TYPE;
        } else if (type_attaque.equals(Element_naturel.EAU)) {
            pv = pv - degats * REDUCTION_DEGAT_TYPE;
        } else {
            pv = pv - degats;
        }

        return pv > 0;
    }
}
