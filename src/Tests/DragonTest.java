package Tests;

import Univers.Animal;
import Univers.Dragon;
import Univers.Element_naturel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    @org.junit.jupiter.api.Test
    void attaquer_same_element() {
        Animal dragon = new Dragon("popov",100,100);
        assertFalse(dragon.attaquer(Element_naturel.FEU,100));

        dragon.revive();
        assertTrue(dragon.attaquer(Element_naturel.FEU,99));

    }

    @org.junit.jupiter.api.Test
    void attaquer_by_strong_element() {
        Animal dragon = new Dragon("popov",100,100);
        assertFalse(dragon.attaquer(Element_naturel.EAU,99));

    }

    @org.junit.jupiter.api.Test
    void attaquer_by_weak_element() {
        Animal dragon = new Dragon("popov",100,100);
        assertTrue(dragon.attaquer(Element_naturel.TERRE,101));//ne meurt pas

    }



}