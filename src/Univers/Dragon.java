package Univers;



public class Dragon extends Animal {


    public Dragon(String Nom, int pv_max) {
        super(Nom, pv_max);
        super.type = Element_naturel.FEU;
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
