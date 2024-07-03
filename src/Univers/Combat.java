package Univers;

import ihm.IHM_console;

/**
 * La classe Combat représente une action de combat entre le compagnon du joueur et un animal aléatoire.
 */
public class Combat implements Action {
    /**
     * L'animal combattant aléatoire.
     */
    private Animal combatant = Animal.creerAnimalAleatoire();

    /**
     * Lance le combat entre le compagnon du joueur et l'animal combattant.
     *
     * @param joueur Le personnage joueur participant au combat.
     */
    public void lancer(Personnage joueur) {
        // Joue le son du combat
        IHM_console.jouer_son("combat.wav");

        // Change le compagnon du joueur en fonction du résultat du combat
        joueur.changer_de_compagnon(joueur.getCompagnon().combattre(combatant));
    }
}
