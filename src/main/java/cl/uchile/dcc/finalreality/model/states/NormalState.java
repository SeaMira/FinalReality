package cl.uchile.dcc.finalreality.model.states;


import cl.uchile.dcc.finalreality.model.character.GameCharacter;

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
}
