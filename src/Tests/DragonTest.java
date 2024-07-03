package Tests;

import Univers.Animal;
import Univers.Dragon;
import Univers.Element_naturel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * La classe de test {@code DragonTest} contient des tests unitaires pour la classe {@link Dragon}.
 * Elle utilise JUnit 5 pour valider le comportement de la classe Dragon dans différents scénarios d'attaque.
 */
class DragonTest {

    /**
     * Teste la méthode {@code attaquer} lorsqu'un dragon attaque avec le même élément.
     * Le dragon ne devrait pas mourir lorsqu'il attaque avec son propre élément naturel.
     */
    @Test
    void attaquer_same_element() {
        Animal dragon = new Dragon("popov", 100, 100);
        assertFalse(dragon.attaquer(Element_naturel.FEU, 100));

        dragon.revive();
        assertTrue(dragon.attaquer(Element_naturel.FEU, 99));
    }

    /**
     * Teste la méthode {@code attaquer} lorsqu'un dragon est attaqué par un élément plus fort (EAU).
     * Le dragon devrait survivre à une attaque avec moins de points de vie que ses PV initiaux.
     */
    @Test
    void attaquer_by_strong_element() {
        Animal dragon = new Dragon("popov", 100, 100);
        assertFalse(dragon.attaquer(Element_naturel.EAU, 99));
    }

    /**
     * Teste la méthode {@code attaquer} lorsqu'un dragon est attaqué par un élément plus faible (TERRE).
     * Le dragon devrait survivre à une attaque avec plus de points de vie que ses PV initiaux.
     */
    @Test
    void attaquer_by_weak_element() {
        Animal dragon = new Dragon("popov", 100, 100);
        assertTrue(dragon.attaquer(Element_naturel.TERRE, 101)); // ne meurt pas
    }
}
