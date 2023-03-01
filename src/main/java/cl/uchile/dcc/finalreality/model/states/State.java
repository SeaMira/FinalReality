package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * Defines the state of a character.
 */
public abstract class State {

  protected GameCharacter obj;

  /**
   * Sets a state on a target character.
   *
   * @param obj character in the indicated state.
  */
  public State(GameCharacter obj) {
    this.obj = obj;
  }

  /**
   * Apply the effects of the state on the character.
   *
   * @throws InvalidStatValueException in case he dies because of the effects.
   * @throws IsDeadException in case he is already dead.
   * @throws IsParalizedException in case is paralyzed.
  */
  public abstract void apply() throws InvalidStatValueException,
          IsDeadException, IsParalizedException;

}