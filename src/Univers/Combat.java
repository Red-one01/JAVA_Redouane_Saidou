package Univers;

public class Combat implements Action{
    private Animal combatant = Animal.creerAnimalAleatoire();


    @Override
    public void lancer(Personnage joueur) {
        joueur.changer_de_compagnon(joueur.getCompagnon().combattre(combatant));
    }
}
