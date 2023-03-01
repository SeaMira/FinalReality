package cl.uchile.dcc.finalreality.model.states;


import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;

/**
 * State of a normal character.
*/
public class NormalState extends State {

  /**
   * Sets a normal state character.
   *
   * @param character normal character.
  */
  public NormalState(GameCharacter character) {
    super(character);
  }

  /**
   * Since is a normal state, nothing happens to the character.
   */
  @Override
  public void apply() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NormalState that)) {
      return false;
    }
    return obj.equals(that.obj) && hashCode() == that.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(NormalState.class, obj);
  }
}
