package Univers;


import java.util.Random;

public class Dragon extends Animal {


    public Dragon(String Nom, int pv_max) {
        super(Nom, pv_max);
        super.type = Element_naturel.FEU;
    }

    public static Dragon creerDragonAleatoire() {
        Random random = new Random();
        String[] noms = {"Flamme", "Incendio", "Braise", "Pyro", "Brûleur"};

        // Sélection aléatoire d'un nom dans le tableau noms
        String nom = noms[random.nextInt(noms.length)];

        // Génération aléatoire de pv_max entre 50 et 100
        int pv_max = random.nextInt(51) + 100;//nombre magique a retirer

        return new Dragon(nom, pv_max);
    }

    @Override
    public boolean attaquer(Element_naturel type_attaque, int degats) {
        if (type_attaque.equals(Element_naturel.EAU)) {
            pv = pv - degats * BONUS_DEGAT_TYPE;
        } else if (type_attaque.equals(Element_naturel.TERRE)) {
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
