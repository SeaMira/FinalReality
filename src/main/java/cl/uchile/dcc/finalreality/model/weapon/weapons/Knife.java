package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import cl.uchile.dcc.finalreality.model.weapon.magicweapon.Staff;

import java.util.Objects;

/**
 * A class that holds all the general information of a Knife.
 *
 * @author ~Sebastian Mira~
 */
public class Knife extends Weapon{

    /**
     * Creates a Knife with a name, a base damage, speed/weight and being a Knife type.
     */
    public Knife(final String name, final int damage, final int weight) {
        super(name, damage, weight, WeaponType.KNIFE);
    }

    /**
     * Checks if two objects are equal Knives or not
     *
     * @param o
     *    object which will be compared to the Knife
     *
     * @return boolean: True if they are equivalent Knives or otherwise False
     */

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Knife knife)) {
            return false;
        }
        return hashCode() == knife.hashCode()
                && this.getDamage() == knife.getDamage()
                && this.getWeight() == knife.getWeight()
                && this.getName().equals(knife.getName())
                && this.getType().equals(knife.getType());
    }

    /**
     * Returns a hash code based on the Knife's fields
     *
     * @return an integer representing the hashcode of a Knife
     */
    @Override
    public int hashCode() {
        return Objects.hash(Knife.class, name, damage, weight, type);
    }

    /**
     * Returns a string with info about the fields of a Knife
     *
     * @return a string with info about the Knife
     */
    @Override
    public String toString() {
        return "Knife{name='%s', damage=%d, weight=%d, type=%s}"
                .formatted(name, damage, weight, type);
    }

}
