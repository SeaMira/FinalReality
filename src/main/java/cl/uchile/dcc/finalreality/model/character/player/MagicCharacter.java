package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.MagicWeaponNotEquippedException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.exceptions.SpellNotEquippedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.spells.NullSpell;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;



/**
 * A MagicCharacter is an {@link AbstractPlayerCharacter} that can use <i>magic</i> "paying"
 * with magic mana points .
 *
 * @author ~Sebastian Mira~
 */
public abstract class MagicCharacter extends AbstractPlayerCharacter {
  protected int currentMp;
  protected final int maxMp;
  private Spell spell;

  /**
  * Creates a new Magic Character.
  *
  * @param name
  *     the character's name
  * @param maxHp
  *     the character's max hp
  * @param defense
  *     the character's defense
  * @param turnsQueue
  *     the queue with the characters waiting for their turn
  * @param maxMp
  *     the maximum amount of mana the character can have
  */
  protected MagicCharacter(final @NotNull String name, final int maxHp, final int defense,
                           int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
            throws InvalidStatValueException  {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
    this.setSpell(new NullSpell());
  }

  // region : ACCESSORS
  /**
  * Returns the current MP of the character.
  */
  public int getCurrentMp() {
    return currentMp;
  }

  /**
  * Sets the current MP of the character to {@code newMp}.
  *
  * @param newMp
  *     new value for current MP
  */
  public void setCurrentMp(final int newMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, newMp, "Current MP");
    Require.statValueAtMost(maxMp, newMp, "Current MP");
    this.currentMp = newMp;
  }

  /**
   * Tries to equip a weapon to the character.
   *
   * @param weapon
   *      a {@link Weapon} that'll be equipped to the character
   * @throws InvalidEquipableWeaponException in case the character can't use that weapon.
   */
  public abstract void equip(Weapon weapon) throws InvalidEquipableWeaponException;

  /**
  * Returns the max MP of the character.
  */
  public int getMaxMp() {
    return maxMp;
  }
  // endregion

  /**
   * Sets a new spell for the magic character.
  */
  public void setSpell(Spell spell) {
    spell.setCharacter(this);
    this.spell = spell;
  }

  /**
   * castSpell uses the equipped spell to attack an enemy with magic.
   *
   * @param victim is the attacked GameCharacter
  */
  public void castSpell(GameCharacter victim) throws IsDeadException,
          MagicWeaponNotEquippedException, InvalidStatValueException, SpellNotEquippedException  {
    if (!victim.checkIsAlive()) {
      throw new IsDeadException();
    }
    if (!this.getEquippedWeapon().isMagic()) {
      throw new MagicWeaponNotEquippedException();
    }
    this.spell.cast(victim);
  }

  /**
   * Gets the equipped spell.
   *
   * @return the equipped spell.
   */
  public Spell getSpell() {
    return this.spell;
  }
}
