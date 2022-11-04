package cl.uchile.dcc.finalreality.model.weapon.weapons;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapon.MeleeWeapons;
import java.util.Objects;


/**
 * A class that holds all the general information of a Knife.
 *
 * @author ~Sebastian Mira~
 */
public class Knife extends AbstractWeapon implements MeleeWeapons {

  /**
   * Creates a Knife with a name, a base damage and speed/weight.
   */
  public Knife(final String name, final int damage, final int weight) {
    super(name, damage, weight);
  }

  /**
  * Checks if two objects are equal Knives or not.
  *
  * @param o
  *     object which will be compared to the Knife
  *
  * @return boolean: True if they are equivalent Knives or otherwise False
  */

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Knife knife)) {
      return false;
    }
    return hashCode() == knife.hashCode()
           && this.getDamage() == knife.getDamage()
           && this.getWeight() == knife.getWeight()
           && this.getName().equals(knife.getName());
  }

  /**
  * Returns a hash code based on the Knife's fields.
  *
  * @return an integer representing the hashcode of a Knife
  */
  @Override
  public int hashCode() {

    return Objects.hash(Knife.class, name, damage, weight);
  }

  /**
  * Returns a string with info about the fields of a Knife.
  *
  * @return a string with info about the Knife
  */
  @Override
  public String toString() {
    return "Knife{name='%s', damage=%d, weight=%d}"
          .formatted(name, damage, weight);
  }

  /**
  * Checks if an Engineer can equip a Knife. Because it is
  * not possible, this method won't equip a Knife to the Engineer.
  *
  * @param character referring to an Engineer.
  *
  * @throws InvalidEquipableWeaponException since an Engineer can't use
  *     a knife, this will give us a catchable exception for future use.
  */
  @Override
  public void equipEngineer(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }

  /**
   * Checks if a Knight can equip a Knife. Since it is
   * possible, this method will equip the Knife to the Knight.
   *
   * @param character refering to a Knight.
   *
   * @throws InvalidEquipableWeaponException since a Knight can use
   *     a knife, this won't throw an exception.
   */
  @Override
  public void equipKnight(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a Thief can equip a Knife. Since it is
   * possible, this method will equip the Knife to the Thief.
   *
   * @param character referring to a Thief.
   *
   * @throws InvalidEquipableWeaponException since a Thief can use
   *     a knife, this won't throw an exception.
   */
  @Override
  public void equipThief(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a Black Mage can equip a Knife. Since it is
   * possible, this method will equip the Knife to the Black Mage.
   *
   * @param character referring to a Black Mage.
   *
   * @throws InvalidEquipableWeaponException since a Black Mage can use
   *     a Knife, this won't throw an exception.
   */
  @Override
  public void equipBlackMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    character.setWeapon(this);
  }

  /**
   * Checks if a White Mage can equip a Knife. Because it is
   * not possible, this method won't equip a Knife to the White Mage.
   *
   * @param character referring to a White Mage.
   *
   * @throws InvalidEquipableWeaponException since a White Mage can't use
   *     a knife, this will give us a catchable exception for future use.
   */
  @Override
  public void equipWhiteMage(AbstractPlayerCharacter character)
          throws InvalidEquipableWeaponException {
    throw new InvalidEquipableWeaponException(this.getName(), character.getName());
  }



}
