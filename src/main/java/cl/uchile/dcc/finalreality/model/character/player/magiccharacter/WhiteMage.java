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
 * A White Mage is a {@link MagicCharacter} that can use <i>white magic</i>.
 *
 * @author ~Sebastian Mira~
 */
public class WhiteMage extends MagicCharacter {



  /**
   * Creates a new character.
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
  public WhiteMage(final @NotNull String name, final int maxHp, final int defense,
      int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }


  // region : UTILITY METHODS
  /**
   * Checks if two objects are equal white mages or not.
   *
   * @param o
   *     object which will be compared to the white mage
   *
   * @return Bool: True if they are equivalent white mages or otherwise False
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WhiteMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && maxMp == that.maxMp
            && name.equals(that.name)
            && maxHp == that.maxHp
            && defense == that.defense;
  }

  /**
   * Returns a hash code based on the white mages fields.
   *
   * @return an integer representing the hashcode of a white mage
   */
  @Override
  public int hashCode() {
    return Objects.hash(WhiteMage.class, name, maxHp, defense, maxMp);
  }


  /**
   * Returns a string with info about the fields of a White Mage.
   *
   * @return a string with info about the White Mage
   */
  @Override
  public String toString() {
    return "WhiteMage{maxMp=%d, currentMp=%d, maxHp=%d, currentHp=%d, defense=%d, name='%s'}"
            .formatted(maxMp, getCurrentMp(), maxHp, getCurrentHp(), defense, name);
  }
}
