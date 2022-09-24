package cl.uchile.dcc.finalreality.model.weapon;


/**
 * A class that holds all the general information of a magic weapon.
 *
 * @author ~Sebastian Mira~
 */
public abstract class MagicWeapon extends Weapon {
  protected final int magicdamage;

  /**
  * Creates a magic weapon with a name, a base damage, speed/weight, it's type and magic damage.
  */
  protected MagicWeapon(final String name, final int damage, final int weight,
                     final WeaponType type, final int magicdamage) {
    super(name, damage, weight, type);
    this.magicdamage = magicdamage;
  }

  /**
  * Returns the magic damaga of the magic weapon.
  *
  * @return
  *     an integer that represents the magic damage of the magic weapon
  */
  public int getMagicdamage() {
    return magicdamage;
  }
}
