package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
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

  /**
   * Checks if an Engineer can equip a Sword. Because it is
   * not possible, this method throws an exception.
   *
   * @param character refering to an engineer.
   *
   * @throws InvalidEquipableWeaponException since an engineer can't use
   *     a sword, this will give as a catchable exception for future use.
   */
  @Override
  public void equipEngineer(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a Knight can equip a Sword. Since it is
   * possible, this method will equip the Sword to the Knight.
   *
   * @param character refering to a Knight.
   *
   * @throws InvalidEquipableWeaponException since a Knight can use
   *     a sword, this won't throw an exception.
   */
  @Override
  public void equipKnight(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a Thief can equip a Sword. Since it is
   * possible, this method will equip the Sword to the Thief.
   *
   * @param character refering to a Thief.
   *
   * @throws InvalidEquipableWeaponException since a Thief can use
   *     a Sword, this won't throw an exception.
   */
  @Override
  public void equipThief(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a Black Mage can equip a Sword. Because it is not
   * possible, this method will throw an InvalidEquipableWeaponException.
   *
   * @param character refering to a Black Mage.
   *
   * @throws InvalidEquipableWeaponException since a Black Mage can't use
   *     a Sword, this will give as a catchable exception for future use.
   */
  @Override
  public void equipBlackMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a White Mage can equip a Knife. Because it is
   * not possible, this method throws an exception.
   *
   * @param character refering to a White Mage.
   *
   * @throws InvalidEquipableWeaponException since a White Mage can't use
   *     a knife, this will give as a catchable exception for future use.
   */
  @Override
  public void equipWhiteMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }
}
