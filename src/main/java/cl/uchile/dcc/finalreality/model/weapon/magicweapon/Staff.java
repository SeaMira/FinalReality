package cl.uchile.dcc.finalreality.model.weapon.magicweapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.RangeWeapons;
import java.util.Objects;


/**
 * A class that holds all the general information of a Staff.
 *
 * @author ~Sebastian Mira~
 */
public class Staff extends MagicWeapon implements RangeWeapons {
  /**
  * Creates a Staff with a name, a base damage, speed/weight, magic damage and being a staff type.
  */
  public Staff(final String name, final int damage, final int weight, final int magicdamage) {
    super(name, damage, weight, magicdamage);
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
          && this.getName().equals(staff.getName());
  }

  /**
  * Returns a hash code based on the Staff's fields.
  *
  * @return an integer representing the hashcode of a Staff
  */
  @Override
  public int hashCode() {
    return Objects.hash(Staff.class, name, damage, weight, magicdamage);
  }

  /**
  * Returns a string with info about the fields of a Staff.
  *
  * @return a string with info about the Staff
  */
  @Override
  public String toString() {
    return "Staff{name='%s', damage=%d, weight=%d, magicdamage=%d}"
           .formatted(name, damage, weight, magicdamage);
  }

  /**
   * Checks if an Engineer can equip a Staff. Because it is
   * not possible, this method won't equip a Staff to the Engineer.
   *
   * @param character referring to an Engineer.
   *
   * @throws InvalidEquipableWeaponException since an Engineer can't use
   *     a Staff, this will give us a catchable exception for future use.
   */
  @Override
  public void equipEngineer(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a Knight can equip a Staff. Since it is not
   * possible, this method won't equip a Staff to the Knight.
   *
   * @param character referring to a Knight.
   *
   * @throws InvalidEquipableWeaponException since a Knight can't use
   *     a Staff, this will give us a catchable exception for future use.
   */
  @Override
  public void equipKnight(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a Thief can equip a Staff. Since it is not
   * possible, this method won't equip a Staff to the Thief.
   *
   * @param character referring to a Thief.
   *
   * @throws InvalidEquipableWeaponException since a Thief can't use
   *     a Staff, this will give us a catchable exception for future use.
   */
  @Override
  public void equipThief(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a Black Mage can equip a Staff. Since it is
   * possible, this method will equip the Staff to the Black Mage.
   *
   * @param character referring to a Black Mage.
   *
   * @throws InvalidEquipableWeaponException since a Black Mage can use
   *     a Staff, this won't throw an exception.
   */
  @Override
  public void equipBlackMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a White Mage can equip a Staff. Since it is
   * possible, this method will equip the Staff to the White Mage.
   *
   * @param character referring to a White Mage.
   *
   * @throws InvalidEquipableWeaponException since a White Mage can use
   *     a Staff, this won't throw an exception.
   */
  @Override
  public void equipWhiteMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }
}
