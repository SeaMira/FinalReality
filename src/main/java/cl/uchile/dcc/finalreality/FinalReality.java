package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.model.character.notplayer.Enemies;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.util.ArrayList;

public class FinalReality {
    private ArrayList<PlayerCharacter> playerTeam;
    private ArrayList<Enemies> enemyTeam;
    private ArrayList<Weapon> weaponsBag;

    private boolean enemyWins = false;
    private boolean playerWins = false;

    public FinalReality(ArrayList<PlayerCharacter> playerTeam, ArrayList<Enemies> enemyTeam, ArrayList<Weapon> weaponsBag) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
        this.weaponsBag = weaponsBag;
    }

    public void setEnemyWins() {
        enemyWins = true;
    }

    public void setPlayerWins() {
        playerWins = true;
    }

    public void checkIfPlayerWins() {
        int charactersCount = playerTeam.size();
        int deadCharactersCount = 0;
        for(PlayerCharacter p: playerTeam) {
            if (p.getCurrentHp() <= 0) {
                deadCharactersCount += 1;
            }
        }
        if (charactersCount == deadCharactersCount) {
            setEnemyWins();
        }
    }

    public void checkIfEnemyWins() {
        int enemiesCount = enemyTeam.size();
        int deadEnemiesCount = 0;
        for(PlayerCharacter p: playerTeam) {
            if (p.getCurrentHp() <= 0) {
                deadEnemiesCount += 1;
            }
        }
        if (enemiesCount == deadEnemiesCount) {
            setPlayerWins();
        }
    }

}
