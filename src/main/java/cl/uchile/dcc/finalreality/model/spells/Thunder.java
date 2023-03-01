package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Knight;
import cl.uchile.dcc.finalreality.model.states.DeadState;
import cl.uchile.dcc.finalreality.model.states.ParalizedState;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import java.util.Objects;

/**
 *A thunder attack spell.
 */
public class Thunder extends Spell {

  /**
   * Sets the Thunder spell on the character. It costs 15 mana points from the character.
  */
  public Thunder() {
    super(15);
  }

  /**
   * Attacks a GameCharacter with this spell, checking if he gets paralyzed, or if he dies.
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
      if (rand <= 0.3) {
        victim.setState(new ParalizedState(victim));
      }
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(Thunder.class, mage, cost);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Thunder that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && mage.equals(that.mage)
            && cost == that.cost;
  }
}
