package cl.uchile.dcc.finalreality.model.weapon;

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
}
