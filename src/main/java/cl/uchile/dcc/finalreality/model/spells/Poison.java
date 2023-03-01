package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.states.PoisonedState;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import java.util.Objects;


/**
 *A Poisoning attack spell.
 */
public class Poison extends Spell {

  /**
   * Sets the poisoning spell on the character. It costs 40 mana points from the character.
   */
  public Poison() {
    super(40);
  }

  /**
   * Attacks a GameCharacter with this spell, poisoning him.
   *
   * @param victim the character that recieves the attack
   * @throws InvalidStatValueException in case the character doesn't have enough mana.
   */
  @Override
  public void cast(GameCharacter victim) throws InvalidStatValueException {

    MagicWeapon mw = (MagicWeapon) mage.getEquippedWeapon();

    int newMana = mage.getCurrentMp() - cost;
    mage.setCurrentMp(newMana);

    int magicdamage = mw.getMagicdamage();

    victim.setState(new PoisonedState(victim, magicdamage / 3));

  }

  @Override
  public int hashCode() {
    return Objects.hash(Poison.class, mage, cost);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Poison that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && mage.equals(that.mage)
            && cost == that.cost;
  }
}
