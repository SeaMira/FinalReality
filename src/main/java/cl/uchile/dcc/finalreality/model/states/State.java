package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;

public abstract class State {

    protected GameCharacter obj;

    public State(GameCharacter obj) {
        this.obj = obj;
    }

    public abstract void apply() throws InvalidStatValueException, IsDeadException, IsParalizedException;


}