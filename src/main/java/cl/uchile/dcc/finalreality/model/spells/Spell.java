package cl.uchile.dcc.finalreality.model.spells;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.MagicWeaponNotEquippedException;
import cl.uchile.dcc.finalreality.exceptions.SpellNotEquippedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MagicCharacter;


/**
 * Magic attack that could be used by magic characters.
 */
public abstract class Spell {
  protected MagicCharacter mage;
  protected int cost;

  /**
   * Sets a spell on a character with a defined mana points cost.
   *
   * @param cost mana points cost
   */
  public Spell(int cost) {
    this.cost = cost;
  }

  /**
   * Sets the character that has this Spell.
   */
  public void setCharacter(MagicCharacter mage) {
    this.mage = mage;
  }

  /**
   * Method for using a spell.
   *
   * @param victim character that recieves the spell.
   * @throws IsDeadException In case the character is dead.
   * @throws MagicWeaponNotEquippedException In case there is no magic weapon being used.
   * @throws InvalidStatValueException in case the character dies.
   * @throws SpellNotEquippedException In case there is no spell for
   *     the character to use.
   */
  public abstract void cast(GameCharacter victim) throws IsDeadException,
          MagicWeaponNotEquippedException, InvalidStatValueException, SpellNotEquippedException;
}
