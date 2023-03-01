package cl.uchile.dcc.finalreality.exceptions;

/**
 * Exceptions for unequippable weapons depending on the character.
 *
 *@author ~Sebastian Mira~
 */
public class InvalidEquipableWeaponException extends Exception {

  /**
   * Constructor for a new exception where a weapon can't be used by a character.
   *
   * @param weaponName name of the weapon that can't be used by the character.
   * @param characterName name of the character that can't use the weapon.
   */
  public InvalidEquipableWeaponException(String weaponName, String characterName) {
    super("Character %s can't equip weapon %s.".formatted(characterName, weaponName));
  }
}
