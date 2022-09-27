package cl.uchile.dcc.finalreality.model.character.notplayer;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the general information of a single enemy of the game.
 *
 * @author ~Sebastian Mira~
 */
public abstract class Enemies extends AbstractCharacter {

  protected final int weight;
  protected final int damage;

  /**
   * Cosntructor of a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  protected Enemies(@NotNull final String name, final int weight, int maxHp,
                    int defense, int damage,
                    @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
    this.damage = damage;
  }

  /**
   * Returns the weight of this enemy.
   *
   * @return
   *     the weight of the Enemy
   *
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the weight of this enemy.
   *
   * @return
   *     the weight of the Enemy
   *
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Checks if two objects are equal Enemies or not.
   *
   * @param o
   *     object which will be compared to the Enemy
   *
   * @return boolean: True if they are equivalent Enemies or otherwise False
   */
  public abstract boolean equals(final Object o);

  /**
  * Returns a hash code based on the Enemy's fields.
  *
  * @return
  *     an integer representing the hashcode of an Enemy
  */
  public abstract int hashCode();

  /**
  * Shows info about the Enemy's fields.
  *
  * @return
  *      returns a string with info from the enemy's fields
  */
  public abstract String toString();

}
