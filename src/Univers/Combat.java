package Univers;


import ihm.IHM_console;

public class Combat implements Action{
    private Animal combatant = Animal.creerAnimalAleatoire();



    public void lancer(Personnage joueur) {
        IHM_console.jouer_son("combat.wav");
        joueur.changer_de_compagnon(joueur.getCompagnon().combattre(combatant));

    }
}
