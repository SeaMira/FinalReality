package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class NormalState extends State{

    public NormalState(GameCharacter character) {
        super(character);
    }

    @Override
    public void apply() throws IsDeadException {
        if (!obj.checkIsAlive()){
            throw new IsDeadException();
        }

    }
}
