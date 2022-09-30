package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapon.MeleeWeapons;
import java.util.Objects;


/**
 * A class that holds all the general information of a Sword.
 *
 * @author ~Sebastian Mira~
 */
public class Sword extends AbstractWeapon implements MeleeWeapons {

  /**
  * Creates a Sword with a name, a base damage and speed/weight.
  */
  public Sword(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }

  /**
  * Checks if two objects are equal swords or not.
  *
  * @param o
  *     object which will be compared to the Sword
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
           && this.getName().equals(sword.getName());
  }

  /**
  * Returns a hash code based on the Sword's fields.
  *
  * @return an integer representing the hashcode of a Sword
  */
  @Override
  public int hashCode() {
    return Objects.hash(Sword.class, name, damage, weight);
  }

  /**
  * Returns a string with info about the fields of a Sword.
  *
  * @return a string with info about the Sword
  */
  @Override
  public String toString() {
    return "Sword{name='%s', damage=%d, weight=%d}"
           .formatted(name, damage, weight);
  }


}
