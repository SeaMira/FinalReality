package cl.uchile.dcc.finalreality.model.states;


import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;

/**
 * State of a paralyzed character.
*/
public class ParalizedState extends State {

  /**
   * Sets a new paralyzed character.
   *
   * @param character paralyzed character.
  */
  public ParalizedState(GameCharacter character) {
    super(character);
  }

  /**
   * Skip a turn of the character.
   *
   * @throws IsParalizedException to know when to skip the turn.
  */
  @Override
  public void apply() throws IsParalizedException {
    obj.setState(new NormalState(obj));
    throw new IsParalizedException();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ParalizedState that)) {
      return false;
    }
    return obj.equals(that.obj) && hashCode() == that.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(ParalizedState.class, obj);
  }


}
