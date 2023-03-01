package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;

/**
 * Makes a "tag" for every weapon.
 */
public interface Weapon {
  /**
  * Gets the name of the weapon.
  */
  String getName();

  /**
  * Gets the damage of the weapon.
  */
  int getDamage();

  /**
  * Gets the weight of the weapon.
  */
  int getWeight();

  /**
   * Equips a weapon to the character only if it is allowed for an Engineer.
   *
   * @param character mainly an engineer
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public void equipEngineer(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Equips a weapon to the character only if it is allowed for a Knight.
   *
   * @param character mainly a knight
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public void equipKnight(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Equips a weapon to the character only if it is allowed for a Thief.
   *
   * @param character mainly a Thief
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public void equipThief(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Equips a weapon to the character only if it is allowed for a Black Mage.
   *
   * @param character mainly an Black mage
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public void equipBlackMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Equips a weapon to the character only if it is allowed for a White Mage.
   *
   * @param character mainly a White Mage
   *
   * @throws InvalidEquipableWeaponException if it is not allowed
   */
  public void equipWhiteMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException;

  /**
   * Checks if a weapon is magic or not.
   */
  public boolean isMagic();
}
