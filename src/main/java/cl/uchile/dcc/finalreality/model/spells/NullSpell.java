package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.SpellNotEquippedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 *A Null spell.
 */
public class NullSpell extends Spell {

  /**
   * Sets the Null spell on the character without mana cost.
   */
  public NullSpell() {
    super(0);
  }

  /**
   * Indicates that there is no spell to use.
   *
   * @param victim the character that recieves the spell.
   * @throws SpellNotEquippedException if the character wants to use
   *     magic without an equipped spell.
   */
  @Override
  public void cast(GameCharacter victim) throws SpellNotEquippedException {
    throw new SpellNotEquippedException();
  }
}
