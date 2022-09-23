/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.commoncharacter;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;


/**
 * A {@link PlayerCharacter} that can equip {@code Sword}s,{@code Knife}s and
 * {@code Axe}s.
 */
public class Knight extends AbstractPlayerCharacter {

  /**
   * Creates a new Knight.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's maximum health points
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public Knight(@NotNull final String name, int maxHp, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  /**
   * Returns a string with info about the fields of a Knight.
   *
   * @return a string with info about the Knight
   */
  @Override
  public String toString() {
    return "Knight{maxHp=%d, defense=%d, name='%s'}".formatted(maxHp, defense, name);
  }

  /**
   * Returns a hash code based on the Knight's fields.
   *
   * @return an integer representing the hashcode of a Knight
   */
  @Override
  public int hashCode() {
    return Objects.hash(Knight.class, name, maxHp, defense);
  }

  /**
   * Checks if two objects are equal Knights or not.
   *
   * @param obj
   *     object which will be compared to the Knight
   *
   * @return boolean: True if they are equivalent Knight or otherwise False
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Knight that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }
}
