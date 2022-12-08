package cl.uchile.dcc.finalreality.exceptions;

/**
 * An exception in case a character trying to use magic doesn't have a spell equipped.
 */
public class SpellNotEquippedException extends Exception {
  public SpellNotEquippedException() {
    super("The character doesn't have a spell equipped!");
  }
}
