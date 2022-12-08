package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * State of a Dead character.
*/
public class DeadState extends State {

  /**
   * Sets a new dead character.
   *
   * @param character dead character.
  */
  public DeadState(GameCharacter character) {
    super(character);
  }

  /**
   * Checks that a character is dead.
   *
   * @throws IsDeadException letting know that the character is dead
  */
  @Override
  public void apply() throws  IsDeadException {
    throw new IsDeadException();
  }
}
