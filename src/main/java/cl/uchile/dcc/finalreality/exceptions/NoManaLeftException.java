package cl.uchile.dcc.finalreality.exceptions;

public class NoManaLeftException extends Exception {
    public NoManaLeftException() {
        super("The character doesn't have enough mana!");
    }
}
