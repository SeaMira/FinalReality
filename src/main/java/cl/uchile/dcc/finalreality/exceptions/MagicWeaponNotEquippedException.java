package cl.uchile.dcc.finalreality.exceptions;

/**
 * An exception in case a character trying to use magic doesn't have a magic weapon.
 */
public class MagicWeaponNotEquippedException extends Exception {
  public MagicWeaponNotEquippedException() {
    super("The character doesn't have a weapon that let's him use magic!");
  }
}
