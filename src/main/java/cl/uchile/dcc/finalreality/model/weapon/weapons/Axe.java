package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapon.MeleeWeapons;
import java.util.Objects;

/**
 * A class that holds all the general information of an Axe.
 *
 * @author ~Sebastian Mira~
 */
public class Axe extends AbstractWeapon implements MeleeWeapons {
  /**
  * Creates an Axe with a name, a base damage and speed/weight.
  */
  public Axe(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }

  /**
  * Checks if two objects are equal Axes or not.
  *
  * @param o
  *     object which will be compared to the Axe
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
                && this.damage == axe.getDamage()
                && this.weight == axe.getWeight()
                && this.name.equals(axe.getName());
  }

  /**
  * Returns a hash code based on the Axe's fields.
  *
  * @return an integer representing the hashcode of an Axe
  */
  @Override
  public int hashCode() {
    return Objects.hash(Axe.class, name, damage, weight);
  }

  /**
  * Returns a string with info about the fields of an Axe.
  *
  * @return a string with info about the Axe
  */
  @Override
  public String toString() {
    return "Axe{name='%s', damage=%d, weight=%d}"
                .formatted(name, damage, weight);
  }


}
