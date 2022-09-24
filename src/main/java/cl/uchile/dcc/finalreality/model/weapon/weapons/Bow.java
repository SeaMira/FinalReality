package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.Objects;

/**
 * A class that holds all the general information of a Bow.
 *
 * @author ~Sebastian Mira~
 */
public class Bow extends Weapon {

  /**
  * Creates a Bow with a name, a base damage, speed/weight and being an Bow type.
  */
  public Bow(final String name, final int damage, final int weight) {
    super(name, damage, weight, WeaponType.BOW);
  }

  /**
  * Checks if two objects are equal Bows or not.
  *
  * @param o
  *     object which will be compared to the Bow
  *
  * @return boolean: True if they are equivalent Bows or otherwise False
  */

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Bow bow)) {
      return false;
    }
    return hashCode() == bow.hashCode()
            && this.damage == bow.getDamage()
            && this.weight == bow.getWeight()
            && this.name.equals(bow.getName())
            && this.type.equals(bow.getType());
  }

  /**
  * Returns a hash code based on the Bow's fields.
  *
  * @return an integer representing the hashcode of a Bow
  */
  @Override
  public int hashCode() {
    return Objects.hash(Bow.class, name, damage, weight, type);
  }

  /**
  * Returns a string with info about the fields of a Bow.
  *
  * @return a string with info about the Bow
  */
  @Override
  public String toString() {
    return "Bow{name='%s', damage=%d, weight=%d, type=%s}"
            .formatted(name, damage, weight, type);
  }


}
