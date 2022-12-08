package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.model.character.notplayer.Enemies;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.ArrayList;

/**
 * Saves the state of a game.
 */
public class FinalReality {
  private ArrayList<PlayerCharacter> playerTeam;
  private ArrayList<Enemies> enemyTeam;
  private ArrayList<Weapon> weaponsBag;

  private boolean enemyWins = false;
  private boolean playerWins = false;


  /**
   * Starts a game with the given characters, the given enemies and the given weapons.
   *
   * @param playerTeam has 5 controllable characters by the user.
   * @param enemyTeam has a random quantity of Enemy characters.
   * @param weaponsBag has a bag of Weapons.
  */
  public FinalReality(ArrayList<PlayerCharacter> playerTeam, ArrayList<Enemies> enemyTeam,
                      ArrayList<Weapon> weaponsBag) {
    this.playerTeam = playerTeam;
    this.enemyTeam = enemyTeam;
    this.weaponsBag = weaponsBag;
  }

  /**
   * Sets the enemy team as the winner of the game.
  */
  public void setEnemyWins() {
    enemyWins = true;
  }

  /**
   * Sets the player team as the winner of the game.
  */
  public void setPlayerWins() {
    playerWins = true;
  }

  /**
   * Checks if the player team lost, same as saying
   * that checks if the entire player team is dead.
  */
  public void checkIfPlayerLose() {
    int charactersCount = playerTeam.size();
    int deadCharactersCount = 0;
    for (PlayerCharacter p : playerTeam) {
      if (p.getCurrentHp() <= 0) {
        deadCharactersCount += 1;
      }
    }
    if (charactersCount == deadCharactersCount) {
      setEnemyWins();
    }
  }

  /**
   * Checks if the enemies team lost, same as saying
   * that checks if the entire enemies team is dead.
  */
  public void checkIfEnemyLose() {
    int enemiesCount = enemyTeam.size();
    int deadEnemiesCount = 0;
    for (PlayerCharacter p : playerTeam) {
      if (p.getCurrentHp() <= 0) {
        deadEnemiesCount += 1;
      }
    }
    if (enemiesCount == deadEnemiesCount) {
      setPlayerWins();
    }
  }

}
