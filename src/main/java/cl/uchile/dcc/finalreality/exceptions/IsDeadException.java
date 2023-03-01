package cl.uchile.dcc.finalreality.exceptions;


/**
 * An exception in case a character in the queue is dead.
 */
public class IsDeadException extends Exception {
  public IsDeadException() {
    super("Character is dead!");
  }

}
