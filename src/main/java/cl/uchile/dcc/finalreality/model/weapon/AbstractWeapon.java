package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;

/**
 * A class that holds all the general information of a weapon.
 *
 * @author ~Sebastian Mira~
 */
public abstract class AbstractWeapon implements Weapon {

  protected final String name;
  protected final int damage;
  protected final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed/weight, and it's type.
   */
  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;

  }

  /**
   * Returns the name Weapon.
   *
   * @return string of the name of the Weapon
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the damage that the Weapon deals.
   *
   * @return integer of the damage of the Weapon
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Checks if two objects are equal Weapons or not.
   *
   * @param o
   *     object which will be compared to the Weapon
   *
   * @return boolean: True if they are equivalent Weapons or otherwise False
   */

  public abstract boolean equals(final Object o);

  /**
   * Returns a hash code based on the Weapon's fields.
   *
   * @return an integer representing the hashcode of a Weapon
   */
  public abstract int hashCode();

  /**
   * Returns a string with info about the fields of a Weapon.
   *
   * @return a string with info about the Weapon
   */
  public abstract String toString();

  /**
   * Equips a weapon to the character only if it is allowed for an Engineer.
   *
   * @param character mainly an engineer
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public abstract void equipEngineer(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Equips a weapon to the character only if it is allowed for a Knight.
   *
   * @param character mainly a knight
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public abstract void equipKnight(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Equips a weapon to the character only if it is allowed for a Thief.
   *
   * @param character mainly a Thief
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public abstract void equipThief(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Equips a weapon to the character only if it is allowed for a Black Mage.
   *
   * @param character mainly an Black mage
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public abstract void equipBlackMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Equips a weapon to the character only if it is allowed for a White Mage.
   *
   * @param character mainly a White Mage
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public abstract void equipWhiteMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Checks if a weapon is magic or not.
   */
  public boolean isMagic() {
    return false;
  }

}
