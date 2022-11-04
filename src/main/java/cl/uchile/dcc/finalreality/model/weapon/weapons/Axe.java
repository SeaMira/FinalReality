package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
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
  public Axe(final String name, final int damage, final int weight)  {
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

  /**
   * Checks if an Engineer can equip an Axe. Because it is
   * possible, this method will equip the Axe to the Engineer.
   *
   * @param character referring to an Engineer.
   *
   * @throws InvalidEquipableWeaponException since an Engineer can use
   *     an Axe, this won't throw an exception.
   */
  @Override
  public void equipEngineer(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a Knight can equip an Axe. Since it is
   * possible, this method will equip the Axe to the Knight.
   *
   * @param character referring to a Knight.
   *
   * @throws InvalidEquipableWeaponException since a Knight can use
   *     an Axe, this won't throw an exception.
   */
  @Override
  public void equipKnight(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a Thief can equip an Axe. Since it is not
   * possible, this method won't equip the Axe to the Thief.
   *
   * @param character referring to a Thief.
   *
   * @throws InvalidEquipableWeaponException since a Thief can't use
   *     an Axe, this will give us a catchable exception for future use.
   */
  @Override
  public void equipThief(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a Black Mage can equip an Axe. Since it is not
   * possible, this method won't equip the Axe to the Black Mage.
   *
   * @param character referring to a Black Mage.
   *
   * @throws InvalidEquipableWeaponException since a Black Mage can't use
   *     an Axe, this will give us a catchable exception for future use.
   */
  @Override
  public void equipBlackMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a White Mage can equip an Axe. Since it is not
   * possible, this method won't equip the Axe to the White Mage.
   *
   * @param character referring to a White Mage.
   *
   * @throws InvalidEquipableWeaponException since a White Mage can't use
   *     an Axe, this will give us a catchable exception for future use.
   */
  @Override
  public void equipWhiteMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }


}
