package cl.uchile.dcc.finalreality.model.character.notplayer;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author ~Sebastian Mira~
 */
public class SimpleEnemy extends Enemies {

  /**
  * Creates a new enemy with a name, a weight and the queue with the characters ready to
  * play.
  */
  public SimpleEnemy(@NotNull final String name, final int weight, int maxHp,
                        int defense, int damage,
                        @NotNull final BlockingQueue<GameCharacter> turnsQueue)
                        throws InvalidStatValueException {
    super(name, weight, maxHp, defense, damage, turnsQueue);

  }

  /**
  * Checks if two objects are equal SimpleEnemies or not.
  *
  * @param o
  *     object which will be compared to the SimpleEnemy
  *
  * @return boolean: True if they are equivalent SimpleEnemies or otherwise False
  */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final SimpleEnemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
           && name.equals(enemy.name)
           && weight == enemy.weight
           && maxHp == enemy.maxHp
           && damage == enemy.damage
           && defense == enemy.defense;
  }

  /**
  * Returns a hash code based on the SimpleEnemy's fields.
  *
  * @return
  *     an integer representing the hashcode of an Enemy
  */
  @Override
  public int hashCode() {
    return Objects.hash(Enemies.class, name, weight, maxHp, damage, defense);
  }

  /**
  * Shows info about the SimpleEnemy's fields.
  *
  * @return
  *      returns a string with info from the simple enemy's fields
  */
  @Override
  public String toString() {
    return "SimpleEnemy{maxHp=%d, currentHp=%d, damage=%d, defense=%d, weight=%d, name='%s'}"
           .formatted(maxHp, getCurrentHp(), damage, defense, weight, name);
  }
}