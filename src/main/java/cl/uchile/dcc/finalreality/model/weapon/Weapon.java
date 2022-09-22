package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author ~Sebastian Mira~
 */
public abstract class Weapon {

  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public Weapon(final String name, final int damage, final int weight,
      final WeaponType type) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  /**
   * Returns the name Weapon
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
   * Checks if two objects are equal Weapons or not
   *
   * @param o
   *    object which will be compared to the Weapon
   *
   * @return boolean: True if they are equivalent Weapons or otherwise False
   */

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Weapon weapon)) {
      return false;
    }
    return hashCode() == weapon.hashCode()
        && damage == weapon.damage
        && weight == weapon.weight
        && name.equals(weapon.name);
  }

  /**
   * Returns a hash code based on the Weapon's fields
   *
   * @return an integer representing the hashcode of a Weapon
   */
  @Override
  public int hashCode() {
    return Objects.hash(Weapon.class, name, damage, weight);
  }

  /**
   * Returns a string with info about the fields of a Weapon
   *
   * @return a string with info about the Weapon
   */
  @Override
  public String toString() {
    return "Weapon{name='%s', damage=%d, weight=%d}"
        .formatted(name, damage, weight);
  }
}
