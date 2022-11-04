/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.commoncharacter;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;




/**
 * A {@link PlayerCharacter} that can equip {@code Axe}s and {@code Bow}s.
 *
 * @author ~Sebastian Mira~
 */
public class Engineer extends AbstractPlayerCharacter {


  /**
   * Creates a new engineer.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public Engineer(final @NotNull String name, final int maxHp, final int defense,
      final @NotNull BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  /**
   * Returns a string with info about the fields of an Engineer.
   *
   * @return a string with info about the Engineer
   */
  @Override
  public String toString() {
    return "Engineer{maxHp=%d, currentHp=%d, defense=%d, name='%s'}"
            .formatted(maxHp, getCurrentHp(), defense, name);
  }

  /**
   * Returns a hash code based on the Engineer's fields.
   *
   * @return an integer representing the hashcode of an Engineer
   */
  @Override
  public int hashCode() {
    return Objects.hash(Engineer.class, name, maxHp, defense);
  }

  /**
   * Checks if two objects are equal engineers or not.
   *
   * @param obj
   *     object which will be compared to the Engineer
   *
   * @return boolean: True if they are equivalent Engineers or otherwise False
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Engineer that)) {
      return false;
    }
    return hashCode() == that.hashCode()
        && name.equals(that.name)
        && maxHp == that.maxHp
        && defense == that.defense;
  }

  /**
   * Way to see if the weapon will be equipped by the Engineer.
   *
   * @param weapon
   *      a {@link Weapon} that'll be equipped to the character
   * @throws InvalidEquipableWeaponException just if the Engineer
   *      can't equip the given weapon.
   */
  public void equip(Weapon weapon) throws InvalidEquipableWeaponException {
    weapon.equipEngineer(this);
  }
}
