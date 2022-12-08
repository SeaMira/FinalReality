package cl.uchile.dcc.finalreality.exceptions;

/**
 * An exception in case a character trying to use magic doesn't have magic points left.
 */
public class NoManaLeftException extends Exception {
  public NoManaLeftException() {
    super("The character doesn't have enough mana!");
  }
}
