/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.magiccharacter;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MagicCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A BlackMage is a {@link MagicCharacter} that can equip {@code Staff}s and use <i>black magic</i>.
 *
 * @author ~Sebastian Mira~
 */
public class BlackMage extends MagicCharacter {

  /**
   * Creates a new Black Mage.
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
  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);

  }


  // region : UTILITY METHODS

  /**
   * Checks if two objects are equal black mages or not.
   *
   * @param o
   *     object which will be compared to the black mage
   *
   * @return boolean: True if they are equivalent black mages or otherwise False
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense
        && maxMp == that.maxMp;
  }

  /**
   * Returns a string with info about the fields of a Black Mage.
   *
   * @return a string with info about the Black Mage
   */
  @Override
  public String toString() {
    return "BlackMage{maxMp=%d, currentMp=%d, maxHp=%d, currentHp=%d, defense=%d, name='%s'}"
        .formatted(getMaxMp(), getCurrentMp(), getMaxHp(), getCurrentHp(), getDefense(), getName());
  }

  /**
   * Returns a hash code based on the black mages fields.
   *
   * @return an integer representing the hashcode of a Black Mage
   */
  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, getName(), getMaxHp(), getDefense(), getMaxMp());
  }
  // endregion
}
