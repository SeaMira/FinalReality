package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;

import java.util.Objects;

/**
 * A class that holds all the general information of an Axe.
 *
 * @author ~Sebastian Mira~
 */
public class Axe extends Weapon{

    /**
     * Creates an Axe with a name, a base damage, speed/weight and being an Axe type.
     */
    public Axe(final String name, final int damage, final int weight) {
        super(name, damage, weight, WeaponType.AXE);
    }

    /**
     * Checks if two objects are equal Axes or not
     *
     * @param o
     *    object which will be compared to the Axe
     *
     * @return boolean: True if they are equivalent Axes or otherwise False
     */

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Axe axe)) {
            return false;
        }
        return hashCode() == axe.hashCode()
                && this.getDamage() == axe.getDamage()
                && this.getWeight() == axe.getWeight()
                && this.getName().equals(axe.getName())
                && this.getType().equals(axe.getType());
    }

    /**
     * Returns a hash code based on the Axe's fields
     *
     * @return an integer representing the hashcode of an Axe
     */
    @Override
    public int hashCode() {
        return Objects.hash(Axe.class, name, damage, weight, type);
    }

    /**
     * Returns a string with info about the fields of an Axe
     *
     * @return a string with info about the Axe
     */
    @Override
    public String toString() {
        return "Axe{name='%s', damage=%d, weight=%d, type=%s}"
                .formatted(name, damage, weight, type);
    }


}
