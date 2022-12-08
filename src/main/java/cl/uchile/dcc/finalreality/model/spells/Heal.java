package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;



/**
 *A Healing spell.
 */
public class Heal extends Spell {

  /**
   * Sets the Healing spell on the character. It costs 15 mana points from the character.
   *
  */
  public Heal() {
    super(15);
  }

  /**
   * Heals a GameCharacter with this spell, rising his health points.
   *
   * @param victim the character that recieves the spell.
   * @throws InvalidStatValueException in case the character doesn't have enough mana.
   */
  @Override
  public void cast(GameCharacter victim) throws InvalidStatValueException {

    int newMana = mage.getCurrentMp() - cost;
    mage.setCurrentMp(newMana);

    int victimHp = victim.getCurrentHp();
    int victimMaxHp = victim.getMaxHp();
    int newHp = victimHp + (int) (victimMaxHp * 0.3);
    victim.setCurrentHp(Math.max(victimMaxHp, newHp));

  }
}
