package Univers;

import java.util.Random;

public class Lion extends Animal {

    public Lion(String Nom, int pv_max,int dammage) {
        super(Nom, pv_max,dammage);
        super.type = Element_naturel.TERRE;
    }
    public static Lion creerLionAleatoire() {
        Random random = new Random();
        String[] noms = {"Simba", "Leo", "Aslan", "Roi", "Mufasa"};

        // Sélection aléatoire d'un nom dans le tableau noms
        String nom = noms[random.nextInt(noms.length)];

        // Génération aléatoire de pv_max entre 70 et 120 pour un lion
        int pv_max = random.nextInt(51) + 70;

        return new Lion(nom, pv_max,random.nextInt(51) + 25);
    }


    @Override
    public boolean attaquer(Element_naturel type_attaque, int degats) {
        if (type_attaque.equals(Element_naturel.FEU)) {
            pv = pv - degats * BONUS_DEGAT_TYPE;
        } else if (type_attaque.equals(Element_naturel.AIR)) {
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
