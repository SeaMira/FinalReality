package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.IsParalizedException;
import cl.uchile.dcc.finalreality.exceptions.MagicWeaponNotEquippedException;
import cl.uchile.dcc.finalreality.exceptions.SpellNotEquippedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.notplayer.SimpleEnemy;
import cl.uchile.dcc.finalreality.model.character.player.MagicCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Knight;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magiccharacter.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magiccharacter.WhiteMage;
import cl.uchile.dcc.finalreality.model.spells.Spell;
import cl.uchile.dcc.finalreality.model.states.DeadState;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Driver: connects directly with actions from the graphic interface.
 */
public class GameDriver {

  /**
   * Starting point of a game.
   */
  public static void init() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    // ArrayList<PlayerCharacter> playerCharacters = createPlayerTeam(queue);
    // ArrayList<Enemies> enemyCharacters = createEnemyTeam(queue);
    // ArrayList<Weapon> weaponsBag = createWeaponsBag();
    // FinalReality game = new FinalReality(playerCharacters, enemyCharacters, weaponsBag);
    // playGame(game);
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
    return new SimpleEnemy(name, weight, hp, defense, damage, q);
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
      // playTurn(character);
    }
  }

  /**
   * A character deals an attack to another character.
   *
   * @param attacker the character that deals the damage.
   * @param victim the receiver of the damage.
  */
  public static void playerPhysicalAttack(GameCharacter attacker, GameCharacter victim) {
    // checkear que victima no esté muerta
    attacker.physicalAttack(victim);
  }

  /**
   * Checks the state of a character at the begining of a turn.
   *
   * @param actualCharacter that will get it's state checked and effects applied
  */
  public static void checkingState(GameCharacter actualCharacter) {
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

  /**
   * Equips another spell in the character.
   *
   * @param character will equip the spell.
   * @param spell to be equipped.
   */
  public static void switchSpell(GameCharacter character, Spell spell) {
    MagicCharacter mage = (MagicCharacter) character;
    mage.setSpell(spell);
  }

  /**
   * Tries a magic attack on a victim.
   *
   * @param character magic character that deals a magic attack on a victim if
   *     he has enough magic points and a magic weapon.
   * @param victim the reciever of the attack.
   */
  public static void magicAttack(GameCharacter character, GameCharacter victim)  {
    MagicCharacter mage = (MagicCharacter) character;
    try {
      mage.castSpell(victim);
    } catch (IsDeadException isDead) {
      System.out.println("Victim is already dead!");
      // playTurn(mage);
    } catch (MagicWeaponNotEquippedException noStaff) {
      System.out.println("No magic weapon equipped!");
      //playTurn(mage);
    } catch (InvalidStatValueException noMana) {
      System.out.println("No magic points left for this spell!");
      //playTurn(mage);
    } catch (SpellNotEquippedException noSpell) {
      System.out.println("No spell equipped!");
      //playTurn(mage);
    }

  }

  /**
   * Lets the character play it's turn.
   *
   * @param character currently playing.
   */
  public static void playTurn(GameCharacter character) {
    //Chooses to switch weapon
    //Chooses to switch spell
    //Chooses to do a physical attack or magic attack.
    character.waitTurn();
  }


  /**
   * Plays a game where the characters, weapons and enemies are all set.
   *
   * @param game contains the state and objects of the game.
   * @param queue where we can control the character's turns.
   * @throws InterruptedException in case something fails with the sleeping threads.
   */
  public static void playGame(FinalReality game, BlockingQueue<GameCharacter> queue) throws InterruptedException{
    game.makeTurns();
    while (!game.isEnemyWin() && !game.isPlayerWin()) {
      while (queue.isEmpty()) {
        Thread.sleep(1000);
      }
      GameCharacter actualCharacter = queue.poll();
      checkingState(actualCharacter);
      game.checkIfEnemyLose();
      game.checkIfPlayerLose();
    }
    if (game.isEnemyWin()) {
      System.out.println("Game over");
    } else {
      System.out.println("Winner!");
    }
  }


}
