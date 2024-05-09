package Univers;

import java.util.Random;

public class Grenouille_Geante extends Animal{

    public Grenouille_Geante(String Nom, int pv_max) {
        super(Nom, pv_max);
        super.type = Element_naturel.EAU;
    }

    public static Grenouille_Geante creerGrenouilleGeanteAleatoire() {
        Random random = new Random();
        String[] noms = {"Croak", "Hopper", "Sauterelle", "Hoppy", "Bond"};

        // Sélection aléatoire d'un nom dans le tableau noms
        String nom = noms[random.nextInt(noms.length)];

        // Génération aléatoire de pv_max entre 30 et 80 pour une grenouille géante
        int pv_max = random.nextInt(51) + 30;

        return new Grenouille_Geante(nom, pv_max);
    }

    @Override
    public boolean attaquer(Element_naturel type_attaque, int degats) {
        if (type_attaque.equals(Element_naturel.AIR)) {
            pv = pv - degats * BONUS_DEGAT_TYPE;
        } else if (type_attaque.equals(Element_naturel.FEU)) {
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
