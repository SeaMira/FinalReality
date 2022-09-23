package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;

import java.util.Objects;

/**
 * A class that holds all the general information of a Sword.
 *
 * @author ~Sebastian Mira~
 */
public class Sword extends Weapon{

    /**
     * Creates a Sword with a name, a base damage, speed/weight and being an Sword type.
     */
    public Sword(final String name, final int damage, final int weight) {
        super(name, damage, weight, WeaponType.SWORD);
    }

    /**
     * Checks if two objects are equal swords or not
     *
     * @param o
     *    object which will be compared to the Sword
     *
     * @return boolean: True if they are equivalent Swords or otherwise False
     */

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Sword sword)) {
            return false;
        }
        return hashCode() == sword.hashCode()
                && this.getDamage() == sword.getDamage()
                && this.getWeight() == sword.getWeight()
                && this.getName().equals(sword.getName())
                && this.getType().equals(sword.getType());
    }

    /**
     * Returns a hash code based on the Sword's fields
     *
     * @return an integer representing the hashcode of a Sword
     */
    @Override
    public int hashCode() {
        return Objects.hash(Sword.class, name, damage, weight, type);
    }

    /**
     * Returns a string with info about the fields of a Sword
     *
     * @return a string with info about the Sword
     */
    @Override
    public String toString() {
        return "Sword{name='%s', damage=%d, weight=%d, type=%s}"
                .formatted(name, damage, weight, type);
    }


}
