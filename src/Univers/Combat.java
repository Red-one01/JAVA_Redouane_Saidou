package Univers;

public class Combat implements Action{
    private Animal combatant = Animal.creerAnimalAleatoire();


    @Override
    public void lancer(Personnage joueur) {
        joueur.getCompagnon().combattre(combatant);

    }
}
