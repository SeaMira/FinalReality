package cl.uchile.dcc.finalreality.exceptions;

/**
 * An exception in case a character in the queue is dead.
*/
public class IsParalizedException extends Exception {

  public IsParalizedException() {
    super("Character is Paralized!");
  }
}
