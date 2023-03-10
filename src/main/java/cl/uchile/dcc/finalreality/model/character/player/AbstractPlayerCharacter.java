/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.states.DeadState;
import cl.uchile.dcc.finalreality.model.weapon.AbstractWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;


/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link AbstractWeapon}.
 *
 * @author ~Sebastian Mira~
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements
    PlayerCharacter {

  private Weapon equippedWeapon = null;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
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
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp,
      final int defense, @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  /**
   * Tries to equip a weapon to the character.
   *
   * @param weapon
   *      a {@link Weapon} that'll be equipped to the character
   * @throws InvalidEquipableWeaponException in case the character can't use that weapon.
   */
  public abstract void equip(Weapon weapon) throws InvalidEquipableWeaponException;

  /**
   * Sets an allowed weapon to the character.
   *
   * @param weapon will be equipped to the character
   */
  public void setWeapon(Weapon weapon) {
    equippedWeapon = weapon;
  }

  /**
   *  Gets the weapon the character has equipped.
   *
   * @return
   *     the {@link Weapon} that the character is equipped with
   */
  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * Inserts a character in a queue x seconds later based on his weapon's weight.
   */
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    Weapon weapon = this.getEquippedWeapon();
    if (weapon == null) {
      scheduledExecutor.schedule(
          /* command = */ this::addToQueue,
          /* delay = */ 0,
          /* unit = */  TimeUnit.SECONDS);

    } else {
      scheduledExecutor.schedule(
              /* command = */ this::addToQueue,
              /* delay = */ weapon.getWeight() / 10,
              /* unit = */  TimeUnit.SECONDS);

    }

  }

  /**
   *The player character attacks his victim (GameCharacter).
   *
   * @param victim GameCharacter that gets attacked
   */
  public void physicalAttack(GameCharacter victim) {
    int damage = this.getEquippedWeapon().getDamage();
    int def = victim.getDefense();
    int doneDamage = Math.max(0, damage - def);
    int currentHp = victim.getCurrentHp();
    int newHp = currentHp - doneDamage;
    try {
      victim.setCurrentHp(newHp);
      if (newHp == 0) {
        victim.setHpToZero();
        victim.setState(new DeadState(victim));
      }
    } catch (InvalidStatValueException e) {
      victim.setHpToZero();
      victim.setState(new DeadState(victim));
    }
  }

}
