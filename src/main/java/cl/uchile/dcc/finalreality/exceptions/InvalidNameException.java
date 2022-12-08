package cl.uchile.dcc.finalreality.exceptions;

public class InvalidNameException extends Exception{

    public InvalidNameException() {
        super("Missing name");
    }
}
