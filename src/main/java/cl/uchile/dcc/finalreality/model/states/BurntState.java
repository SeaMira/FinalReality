package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class BurntState extends State {
    protected int burnDamage;

    public BurntState(GameCharacter character, int damage) {
        super(character);
        this.burnDamage = damage;
    }

    @Override
    public void apply() throws InvalidStatValueException, IsDeadException {
        if (!obj.checkIsAlive()){
            throw new IsDeadException();
        }
        int hp = obj.getCurrentHp();
        int newHp = hp-burnDamage;
        obj.setCurrentHp(newHp);

    }
}
