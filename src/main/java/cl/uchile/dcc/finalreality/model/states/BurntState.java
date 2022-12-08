package cl.uchile.dcc.finalreality.model.states;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * State of a burnt character.
 */
public class BurntState extends State {
  protected int burnDamage;

  /**
   * Sets a new burnt character.
   *
   * @param character burnt character.
   * @param damage damage of the burnt.
  */
  public BurntState(GameCharacter character, int damage) {
    super(character);
    this.burnDamage = damage;
  }

  /**
   * Applies burn damage to the character.
   *
   * @throws InvalidStatValueException in case the character dies.
  */
  @Override
  public void apply() throws InvalidStatValueException {

    int hp = obj.getCurrentHp();
    int newHp = hp - burnDamage;
    obj.setCurrentHp(newHp);

  }
}
