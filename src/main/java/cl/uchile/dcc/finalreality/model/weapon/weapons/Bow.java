package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapon.RangeWeapons;
import java.util.Objects;

/**
 * A class that holds all the general information of a Bow.
 *
 * @author ~Sebastian Mira~
 */
public class Bow extends AbstractWeapon implements RangeWeapons {

  /**
  * Creates a Bow with a name, a base damage and speed/weight.
  */
  public Bow(final String name, final int damage, final int weight)  {
    super(name, damage, weight);
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
            && this.name.equals(bow.getName());
  }

  /**
  * Returns a hash code based on the Bow's fields.
  *
  * @return an integer representing the hashcode of a Bow
  */
  @Override
  public int hashCode() {
    return Objects.hash(Bow.class, name, damage, weight);
  }

  /**
  * Returns a string with info about the fields of a Bow.
  *
  * @return a string with info about the Bow
  */
  @Override
  public String toString() {
    return "Bow{name='%s', damage=%d, weight=%d}"
            .formatted(name, damage, weight);
  }

  /**
   * Checks if an Engineer can equip a Bow. Because it is
   * possible, this will equip the Bow to the Engineer.
   *
   * @param character referring to an Engineer.
   *
   * @throws InvalidEquipableWeaponException since an Engineer can use
   *     a Bow, this won't throw an exception.
   */
  @Override
  public void equipEngineer(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a Knight can equip a Bow. Since it is not
   * possible, this method won't equip a Bow to the Knight.
   *
   * @param character referring to a Knight.
   *
   * @throws InvalidEquipableWeaponException since a Knight can't use
   *     a Bow, this will give us a catchable exception for future use.
   */
  @Override
  public void equipKnight(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a Thief can equip a Bow. Since it is
   * possible, this method will equip the Bow to the Thief.
   *
   * @param character referring to a Thief.
   *
   * @throws InvalidEquipableWeaponException since a Thief can use
   *     a Bow, this won't throw an exception.
   */
  @Override
  public void equipThief(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a Black Mage can equip a Bow. Since it is not
   * possible, this method won't equip a Bow to the Black Mage.
   *
   * @param character referring to a Black Mage.
   *
   * @throws InvalidEquipableWeaponException since a Black Mage can't use
   *     a Bow, this will give as a catchable exception for future use.
   */
  @Override
  public void equipBlackMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a White Mage can equip a Bow. Because it is
   * not possible, this method won't equip a Bow to the White Mage.
   *
   * @param character refering to a White Mage.
   *
   * @throws InvalidEquipableWeaponException since a White Mage can't use
   *     a Bow, this will give as a catchable exception for future use.
   */
  @Override
  public void equipWhiteMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }


}
