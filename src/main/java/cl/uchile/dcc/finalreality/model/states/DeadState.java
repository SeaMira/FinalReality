package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

public class DeadState extends State {
    public DeadState(GameCharacter character) {
        super(character);
    }

    @Override
    public void apply() throws InvalidStatValueException, IsDeadException, IsParalizedException {
        throw new IsDeadException();
    }
}
