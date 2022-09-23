package cl.uchile.dcc.finalreality.model.weapon.magicweapon;

import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.Objects;


/**
 * A class that holds all the general information of a Staff.
 *
 * @author ~Sebastian Mira~
 */
public class Staff extends MagicWeapon {
  /**
  * Creates a Staff with a name, a base damage, speed/weight, magic damage and being a staff type.
  */
  public Staff(final String name, final int damage, final int weight, final int magicdamage) {
    super(name, damage, weight, WeaponType.STAFF, magicdamage);
  }

  /**
  * Checks if two objects are equal Staffs or not.
  *
  * @param o
  *     object which will be compared to the Staff
  *
  * @return boolean: True if they are equivalent Staffs or otherwise False
  */

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Staff staff)) {
      return false;
    }
    return hashCode() == staff.hashCode()
          && this.getDamage() == staff.getDamage()
          && this.getWeight() == staff.getWeight()
          && this.getMagicdamage() == staff.getMagicdamage()
          && this.getName().equals(staff.getName())
          && this.getType().equals(staff.getType());
  }

  /**
  * Returns a hash code based on the Staff's fields.
  *
  * @return an integer representing the hashcode of a Staff
  */
  @Override
  public int hashCode() {
    return Objects.hash(Staff.class, name, damage, weight, type, magicdamage);
  }

  /**
  * Returns a string with info about the fields of a Staff.
  *
  * @return a string with info about the Staff
  */
  @Override
  public String toString() {
    return "Staff{name='%s', damage=%d, weight=%d, type=%s, magicdamage=%d}"
           .formatted(name, damage, weight, type, magicdamage);
  }
}
