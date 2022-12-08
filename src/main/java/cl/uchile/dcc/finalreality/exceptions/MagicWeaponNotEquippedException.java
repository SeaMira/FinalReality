package cl.uchile.dcc.finalreality.exceptions;

public class MagicWeaponNotEquippedException extends Exception{
    public MagicWeaponNotEquippedException() {
        super("The character doesn't have a weapon that let's him use magic!");
    }
}
