package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.states.NormalState;
import cl.uchile.dcc.finalreality.model.states.State;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Sebastian Mira Pacheco~
 */
public abstract class AbstractCharacter implements GameCharacter {

  private int currentHp;
  protected int maxHp;
  protected int defense;
  protected final BlockingQueue<GameCharacter> turnsQueue;
  protected final String name;
  public State state;
  protected ScheduledExecutorService scheduledExecutor;

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
   */
  protected AbstractCharacter(@NotNull String name, int maxHp, int defense,
      @NotNull BlockingQueue<GameCharacter> turnsQueue) throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.state = new NormalState(this);
  }


  public abstract void waitTurn();

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
  }

  /**
   * Changes the life of the character to zero.
   */
  public void setHpToZero() {
    currentHp = 0;
  }

  /**
   * Checks if the character's health points are greater than zero.
   */
  public boolean checkIsAlive() {
    return currentHp > 0;
  }

  /**
   * Sets a new state to the character.
   *
   * @param state if the character is normal, dead, burnt, paralyzed or poisoned.
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * Checks and applies the state effects.
   *
   * @throws InvalidStatValueException the character dies.
   *
   * @throws IsDeadException the character is dead.
   *
   * @throws IsParalizedException the characer is paralyzed.
   */
  @Override
  public void checkState() throws InvalidStatValueException, IsDeadException, IsParalizedException {
    if (!this.checkIsAlive()) {
      throw new IsDeadException();
    }
    this.state.apply();
  }

  /**
   * A character attacks another character.
   *
   * @param victim recieves the attack
   */
  public abstract void physicalAttack(GameCharacter victim);
}
