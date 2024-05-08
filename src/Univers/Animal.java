package Univers;

import java.awt.Color;
import java.util.Scanner;

public abstract class Animal {
    protected String Nom;

    protected int damage;
    protected int pv_max;
    protected int pv;


    protected Element_naturel type;

    public void revive(){
        pv = pv_max;
    }

    public Animal(String Nom, int pv_max){
        this.Nom = Nom;
        this.pv_max = pv_max;
    }

    //renvoie true si encore en vie apres attaque sinon false
    public abstract boolean attaquer(Element_naturel type_attaque);

    @Override
    public String toString() {
        return this.Nom+"(dégats: "+this.damage+" PV:"+this.pv+" type: "+this.type+")";
    }

    public Animal combattre(Animal opposant){

        while(true){
            if (!opposant.attaquer(this.type)){
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String reponse;
                    System.out.println("Vous avez gagner voulez-vous echanger votre compagnon actuel avec"
                            +opposant +"? (oui/non)");

                    reponse = scanner.nextLine().trim().toLowerCase();
                    scanner.close();

                    if (reponse.equals("oui")) {
                        System.out.println("Super, vous avez un nouveau compagnon !");
                        opposant.revive();
                        return opposant;
                    } else if (reponse.equals("non")) {
                        System.out.println("D'accord, vous conservez votre compagnon actuel !");
                        this.revive();
                        return this;
                    } else {
                        System.out.println("Veuillez répondre par 'oui' ou 'non'.");
                    }
                }

            }
            if (!this.attaquer(opposant.type)){
                System.out.println("Vous avez perdu le combat");
                this.revive();
                return this;
            }
        }
    }

    public int getPv() {
        return pv;
    }
}
