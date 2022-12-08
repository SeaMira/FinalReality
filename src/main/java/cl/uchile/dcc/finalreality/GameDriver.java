package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.exceptions.MagicWeaponNotEquippedException;
import cl.uchile.dcc.finalreality.exceptions.NoManaLeftException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.exceptions.SpellNotEquippedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.notplayer.SimpleEnemy;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Knight;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magiccharacter.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magiccharacter.WhiteMage;
import cl.uchile.dcc.finalreality.model.states.DeadState;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Driver: connects directly with actions from the graphic interface.
 */
public class GameDriver {

  /**
   * Starting point of a game.
   *
   * @param args from the console.
   * @throws InvalidStatValueException if a character dies.
   */
  public static void main(String args[]) throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    // ArrayList<PlayerCharacter> playerCharacters = createPlayerTeam(queue);
    // ArrayList<Enemies> enemyCharacters = createEnemyTeam(queue);
    // ArrayList<Weapon> weaponsBag = createWeaponsBag();
    // FinalReality game = new FinalReality(playerCharacters, enemyCharacters, weaponsBag);
    // playGame(game, System.out);
  }

  /**
   * Creates a Knight given its parameters and a created weapon.
   *
   * @param name name of the knight
   * @param hp health points of the knight
   * @param defense defense points of the knight
   * @param weapon initial weapon/weight of the knight
   * @param q queue for character turns
   * @return the created Knight
   * @throws InvalidStatValueException in case the given health points are not available
   * @throws InvalidEquipableWeaponException in case the given weapon cannot be
   *     equipped by the knight.
  */
  public static Knight createKnight(String name, int hp, int defense, Weapon weapon,
                                    BlockingQueue<GameCharacter> q)
          throws  InvalidStatValueException, InvalidEquipableWeaponException {
    Knight knight = new Knight(name, hp, defense, q);
    knight.equip(weapon);
    return knight;
  }

  /**
   * Creates a Thief given its parameters and a created weapon.
   *
   * @param name name of the Thief
   * @param hp health points of the Thief
   * @param defense defense points of the Thief
   * @param weapon initial weapon/weight of the Thief
   * @param q queue for character turns
   * @return the created Thief
   * @throws InvalidStatValueException in case the given health points are not available
   * @throws InvalidEquipableWeaponException in case the given weapon cannot be
   *     equipped by the Thief.
  */
  public static Thief createThief(String name, int hp, int defense, Weapon weapon,
                                  BlockingQueue<GameCharacter> q)
          throws  InvalidStatValueException, InvalidEquipableWeaponException {
    Thief thief = new Thief(name, hp, defense, q);
    thief.equip(weapon);
    return thief;
  }

  /**
   * Creates a Engineer given its parameters and a created weapon.
   *
   * @param name name of the Engineer
   * @param hp health points of the Engineer
   * @param defense defense points of the Engineer
   * @param weapon initial weapon/weight of the Engineer
   * @param q queue for character turns
   * @return the created Engineer
   * @throws InvalidStatValueException in case the given health points are not available
   * @throws InvalidEquipableWeaponException in case the given weapon cannot be
   *     equipped by the engineer.
  */
  public static Engineer createEngineer(String name, int hp, int defense, Weapon weapon,
                                        BlockingQueue<GameCharacter> q)
          throws  InvalidStatValueException, InvalidEquipableWeaponException {
    Engineer engineer = new Engineer(name, hp, defense, q);
    engineer.equip(weapon);
    return engineer;
  }

  /**
   * Creates a BlackMage given its parameters and a created weapon.
   *
   * @param name name of the knight
   * @param hp health points of the BlackMage
   * @param mp mana points of the BlackMage
   * @param defense defense points of the BlackMage
   * @param weapon initial weapon/weight of the BlackMage
   * @param q queue for character turns
   * @return the created BlackMage
   * @throws InvalidStatValueException in case the given health points are not available
   * @throws InvalidEquipableWeaponException in case the given weapon cannot be
   *     equipped by the BlackMage.
  */
  public static BlackMage createBlackMage(String name, int hp, int mp, int defense, Weapon weapon,
                                          BlockingQueue<GameCharacter> q)
          throws  InvalidStatValueException, InvalidEquipableWeaponException {
    BlackMage blackMage = new BlackMage(name, hp, defense, mp, q);
    blackMage.equip(weapon);
    return blackMage;
  }

  /**
   * Creates a WhiteMage given its parameters and a created weapon.
   *
   * @param name name of the WhiteMage
   * @param hp health points of the WhiteMage
   * @param mp mana points of the WhiteMage
   * @param defense defense points of the WhiteMage
   * @param weapon initial weapon/weight of the WhiteMage
   * @param q queue for character turns
   * @return the created WhiteMage
   * @throws InvalidStatValueException in case the given health points are not available
   * @throws InvalidEquipableWeaponException in case the given weapon cannot be
   *     equipped by the WhiteMage.
  */
  public static WhiteMage createWhiteMage(String name, int hp, int mp, int defense, Weapon weapon,
                                          BlockingQueue<GameCharacter> q)
          throws  InvalidStatValueException, InvalidEquipableWeaponException {
    WhiteMage whiteMage = new WhiteMage(name, hp, defense, mp, q);
    whiteMage.equip(weapon);
    return whiteMage;
  }

  /**
   * Creates an Enemy given its parameters and a created weapon.
   *
   * @param name name of the WhiteMage
   * @param weight weight of the WhiteMage
   * @param hp health points of the WhiteMage
   * @param defense defense points of the WhiteMage
   * @param damage damage points of the WhiteMage
   * @param q queue for character turns
   * @return the created Enemy
   * @throws InvalidStatValueException in case the given health points are not available
  */
  public static SimpleEnemy createSimpleEnemy(String name, int weight, int hp, int defense,
                                              int damage, BlockingQueue<GameCharacter> q)
          throws InvalidStatValueException {
    SimpleEnemy enemy = new SimpleEnemy(name, weight, hp, defense, damage, q);
    return enemy;
  }

  /**
   * Changes the equipped weapon of character.
   *
   * @param character will have the weapon equipped.
   * @param weapon weapon to equip.
  */
  public static void switchWeapon(PlayerCharacter character, Weapon weapon) {
    try {
      character.equip(weapon);
    } catch (InvalidEquipableWeaponException notWeapon) {
        // Restarts the characters turn, since he chose an unavailable weapon
    }
  }

  /**
   * A character deals an attack to another character.
   *
   * @param attacker the character that deals the damage.
   * @param victim the receiver of the damage.
   * @throws InvalidStatValueException in case the character dies.
  */
  public static void playerPhysicalAttack(GameCharacter attacker, GameCharacter victim) {
    // checkear que victima no esté muerta
    attacker.physicalAttack(victim);
  }

  /**
   * Checks the state of a character at the begining of a turn.
   *
   * @param actualCharacter that will get it's state checked and effects applied
   * @throws InvalidStatValueException in case he dies.
   * @throws IsDeadException in case he is dead.
   * @throws IsParalizedException in case he is paralized.
  */
  public static void checkingState(GameCharacter actualCharacter)
          throws InvalidStatValueException, IsDeadException, IsParalizedException {
    try {
      actualCharacter.checkState();
      // playTurn(actualCharacter);
    } catch (IsDeadException isDead) {
      return;
    } catch (IsParalizedException isParalized) {
      System.out.println("El personaje está paralizado y no puede hacer nada!");
    } catch (InvalidStatValueException invalidHp) {
      actualCharacter.setHpToZero();
      actualCharacter.setState(new DeadState(actualCharacter));
      System.out.println("El personaje ha muerto!");
    }
  }



  public static void playGame(FinalReality game, PrintStream out) {
  }


}
