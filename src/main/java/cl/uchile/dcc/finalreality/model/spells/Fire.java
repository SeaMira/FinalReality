package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.states.BurntState;
import cl.uchile.dcc.finalreality.model.states.DeadState;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;


/**
 *A Fire attack spell.
*/
public class Fire extends Spell {

  /**
   * Sets the Fire spell on the character. It costs 15 mana points from the character.
  */
  public Fire() {
    super(15);
  }

  /**
   * Attacks a GameCharacter with this spell, checking if he gets burnt, or if he dies.
   *
    * @param victim the character that recieves the attack
   * @throws InvalidStatValueException in case the character doesn't have enough mana.
   */
  @Override
  public void cast(GameCharacter victim) throws InvalidStatValueException {

    MagicWeapon mw = (MagicWeapon) mage.getEquippedWeapon();
    int newMana = mage.getCurrentMp() - cost;
    mage.setCurrentMp(newMana);

    double rand = Math.random();
    int magicdamage = mw.getMagicdamage();
    int victimHp = victim.getCurrentHp();

    if (victimHp - magicdamage <= 0) {
      victim.setState(new DeadState(victim));
      victim.setHpToZero();
    } else {
      victim.setCurrentHp(victimHp - magicdamage);
      if (rand <= 0.2) {
        victim.setState(new BurntState(victim, magicdamage / 2));
      }
    }

  }
}
