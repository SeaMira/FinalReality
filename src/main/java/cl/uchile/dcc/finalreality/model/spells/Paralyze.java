package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.states.ParalizedState;


/**
 *A paralyzing spell.
 */
public class Paralyze extends Spell {

  /**
   * Sets the paralyzing spell on the character. It costs 25 mana points from the character.
   */
  public Paralyze() {
    super(25);
  }

  /**
   * Paralyzes a GameCharacter with this spell.
   *
   * @param victim the character that recieves the attack
   * @throws InvalidStatValueException in case the character doesn't have enough mana.
   */
  @Override
  public void cast(GameCharacter victim) throws InvalidStatValueException {

    int newMana = mage.getCurrentMp() - cost;
    mage.setCurrentMp(newMana);

    victim.setState(new ParalizedState(victim));

  }
}
