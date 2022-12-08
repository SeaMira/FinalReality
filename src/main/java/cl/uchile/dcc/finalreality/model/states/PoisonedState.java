package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * State of a poisoned character.
*/
public class PoisonedState extends State {
  protected int poisonDamage;

  /**
   * Sets a new posined character.
   *
   * @param character posined character.
   * @param damage damage of the poison.
   */
  public PoisonedState(GameCharacter character, int damage) {
    super(character);
    this.poisonDamage = damage;
  }

  /**
   * Applies posion damage to the character.
   *
   * @throws InvalidStatValueException in case the character dies.
   */
  @Override
  public void apply() throws InvalidStatValueException, IsDeadException {

    int hp = obj.getCurrentHp();
    int newHp = hp - poisonDamage;
    obj.setCurrentHp(newHp);
  }


}
