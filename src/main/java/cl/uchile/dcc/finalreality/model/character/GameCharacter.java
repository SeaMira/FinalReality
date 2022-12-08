package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.model.states.State;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author ~Sebastian Mira~
 */
public interface GameCharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's current HP.
   */
  int getCurrentHp();

  /**
   * Returns this character's max HP.
   */
  int getMaxHp();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Sets this character's current HP to {@code newHp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;

  /**
   * Checks if a character is alive or not.
   */
   boolean checkIsAlive();

  /**
   * Sets a new state for the character.
   */
   void setState(State state);

  /**
   * Sets the HP to 0 points.
   */
  void setHpToZero();

  /**
   * Checks the character state and applies its effects.
   */
  void checkState() throws InvalidStatValueException, IsDeadException, IsParalizedException;

  /**
   * A character attacks another character
   *
   * @param victim recieves the attack
   */
  public abstract void physicalAttack(GameCharacter victim);
}
