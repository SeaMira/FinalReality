package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DeadState that)) {
      return false;
    }
    return obj.equals(that.obj) && hashCode() == that.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(DeadState.class, obj);
  }
}
