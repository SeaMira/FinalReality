package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author ~Sebastian Mira~
 */
public class Enemy extends AbstractCharacter {

  private final int weight;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense,
      @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
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
   * Checks if two objects are equal Enemies or not.
   *
   * @param o
   *     object which will be compared to the Enemy
   *
   * @return boolean: True if they are equivalent Enemies or otherwise False
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && name.equals(enemy.name)
        && weight == enemy.weight
        && maxHp == enemy.maxHp
        && defense == enemy.defense;
  }

  /**
   * Returns a hash code based on the Enemy's fields.
   *
   * @return
   *     an integer representing the hashcode of an Enemy
   */
  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, weight, maxHp, defense);
  }
}
