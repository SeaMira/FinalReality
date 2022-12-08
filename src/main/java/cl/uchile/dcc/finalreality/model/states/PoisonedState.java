package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class PoisonedState extends State {
    protected int poisonDamage;

    public PoisonedState(GameCharacter character, int damage) {
        super(character);
        this.poisonDamage = damage;
    }

    @Override
    public void apply() throws InvalidStatValueException, IsDeadException {
        if (!obj.checkIsAlive()){
            throw new IsDeadException();
        }
        int hp = obj.getCurrentHp();
        int newHp = hp-poisonDamage;
        obj.setCurrentHp(newHp);

    }


}
