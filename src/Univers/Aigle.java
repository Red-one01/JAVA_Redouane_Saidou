package Univers;

import ihm.IHM_console;

import java.util.Random;

public class Aigle extends Animal {
    public Aigle(String Nom, int pv_max,int dammage) {
        super(Nom, pv_max,dammage);
        super.type = Element_naturel.AIR;
    }

    public static Aigle creerAigleAleatoire() {
        Random random = new Random();
        String[] noms = {"Aquila", "Eagle", "Hawk", "Freedom", "Sky"};

        // Sélection aléatoire d'un nom dans le tableau noms
        String nom = noms[random.nextInt(noms.length)];

        // Génération aléatoire de pv_max entre 40 et 90 pour un aigle
        int pv_max = random.nextInt(51) + 40;

        return new Aigle(nom, pv_max,random.nextInt(51) + 15);
    }


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


        if (pv <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
