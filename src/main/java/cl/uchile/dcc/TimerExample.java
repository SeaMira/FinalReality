package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Thief;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Knife;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *Example on how to use an scheduler and a queue to make characters turns.
 *
 */
public class TimerExample {

  /**
  * Example that makes 10 Thief characters to show how to get their turns on the queue.
  *@param args
  *
  *@throws InterruptedException
  *
  *@throws InvalidStatValueException
  *     when the maxHp is not on the available interval
  */
  public static void main(String[] args)
      throws InterruptedException, InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Random rng = new Random();
    for (int i = 0; i < 10; i++) {
      // Gives a random speed to each character to generate different waiting times
      var weapon = new Knife("", 0, rng.nextInt(50));
      var character = new Thief(Integer.toString(i), 10, 10, queue);
      character.equip(weapon);
      character.waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(queue.poll().toString());
    }
  }
}
