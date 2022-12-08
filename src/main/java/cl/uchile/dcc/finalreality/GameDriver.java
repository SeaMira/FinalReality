package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.*;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.notplayer.Enemies;
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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;
public class GameDriver {


    public static void main(String args[]) throws InvalidStatValueException, InvalidNameException{
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
//        ArrayList<PlayerCharacter> playerCharacters = createPlayerTeam(queue);
//        ArrayList<Enemies> enemyCharacters = createEnemyTeam(queue);
//        ArrayList<Weapon> weaponsBag = createWeaponsBag();
//        FinalReality game = new FinalReality(playerCharacters, enemyCharacters, weaponsBag);
//        playGame(game, System.out);

    }

    public static Knight createKnight(String name, int hp, int defense, Weapon weapon, BlockingQueue<GameCharacter> q) throws  InvalidStatValueException, InvalidEquipableWeaponException {
        Knight knight = new Knight(name, hp, defense, q);
        knight.equip(weapon);
        return knight;
    }

    public static Thief createThief(String name, int hp, int defense, Weapon weapon, BlockingQueue<GameCharacter> q) throws  InvalidStatValueException, InvalidEquipableWeaponException {
        Thief thief = new Thief(name, hp, defense, q);
        thief.equip(weapon);
        return thief;
    }

    public static Engineer createEngineer(String name, int hp, int defense, Weapon weapon, BlockingQueue<GameCharacter> q) throws  InvalidStatValueException, InvalidEquipableWeaponException {
        Engineer engineer = new Engineer(name, hp, defense, q);
        engineer.equip(weapon);
        return engineer;
    }

    public static BlackMage createBlackMage(String name, int hp, int mp, int defense, Weapon weapon, BlockingQueue<GameCharacter> q) throws  InvalidStatValueException, InvalidEquipableWeaponException {
        BlackMage blackMage = new BlackMage(name, hp, defense, mp, q);
        blackMage.equip(weapon);
        return blackMage;
    }

    public static WhiteMage createWhiteMage(String name, int hp, int mp, int defense, Weapon weapon, BlockingQueue<GameCharacter> q) throws  InvalidStatValueException, InvalidEquipableWeaponException {
        WhiteMage whiteMage = new WhiteMage(name, hp, defense, mp, q);
        whiteMage.equip(weapon);
        return whiteMage;
    }

    public static SimpleEnemy createSimpleEnemy(String name, int weight, int hp, int defense, int damage, BlockingQueue<GameCharacter> q) throws InvalidStatValueException {
        SimpleEnemy enemy = new SimpleEnemy(name, weight, hp, defense, damage, q);
        return enemy;
    }

    public static void switchWeapon(PlayerCharacter character, Weapon weapon) {
        try {
            character.equip(weapon);
        } catch (InvalidEquipableWeaponException notWeapon) {
            // Restarts the characters turn, since he chose an unavailable weapon
        }
    }

    public static void playerPhysicalAttack(GameCharacter attacker, GameCharacter victim) throws InvalidStatValueException{
        attacker.physicalAttack(victim);
    }

    public static void checkingState(GameCharacter actualCharacter) throws InvalidStatValueException, IsDeadException, IsParalizedException {
        try {
            actualCharacter.checkState();
        } catch (IsDeadException isDead) {

        } catch (IsParalizedException isParalized) {
            System.out.println("El personaje está paralizado y no puede hacer nada!");
        } catch (InvalidStatValueException invalidHp) {
            actualCharacter.setHpToZero();
            actualCharacter.setState(new DeadState(actualCharacter));
            System.out.println("El personaje ha muerto!");
        }

    }

//    public static PlayerCharacter createCharacter(BlockingQueue<GameCharacter> q) throws InvalidStatValueException, InvalidNameException{
//        Scanner readline = new Scanner(System.in);
//        Random rand = new Random();
//        String ch, name;
//        System.out.print("Which character: ");
//        ch = readline.nextLine();
//        System.out.print("What's the name of the character?: ");
//        name = readline.nextLine();
//        try {
//            if (name.equals("")) {
//                throw new InvalidNameException();
//            }
//            if (ch.equals("1")) {
//                Knight knight = new Knight(name, rand.nextInt(25) + 75, rand.nextInt(25) + 15, q);
//                return knight;
//            } else if (ch.equals("2")) {
//                Engineer engineer = new Engineer(name,rand.nextInt(25) + 50, rand.nextInt(25) + 20, q);
//                return engineer;
//            } else if (ch.equals("3")) {
//                Thief thief = new Thief(name, rand.nextInt(25) + 50, rand.nextInt(25) + 15, q);
//                return thief;
//            } else if (ch.equals("4")) {
//                WhiteMage whiteMage = new WhiteMage(name,rand.nextInt(25) + 50, rand.nextInt(25) + 15, rand.nextInt(25) + 25, q);
//                return whiteMage ;
//            } else if (ch.equals("5")) {
//                BlackMage blackMage = new BlackMage(name,rand.nextInt(25) + 50, rand.nextInt(25) + 15, rand.nextInt(25) + 25, q);
//            } else {
//                System.out.println("No hay un personaje asociado al valor ingresado.");
//                return createCharacter(q);
//            }
//        } catch (InvalidStatValueException e) {
//            return createCharacter(q);
//        } catch (InvalidNameException in) {
//            System.out.println("Not valid name, try again.");
//            return createCharacter(q);
//        }
//        return createCharacter(q);
//    }
//
//    public static Enemies createEnemy(BlockingQueue<GameCharacter> q, int enemynr) throws InvalidStatValueException, InvalidNameException{
//        Scanner readline = new Scanner(System.in);
//        Random rand = new Random();
//        System.out.print("What's the name enemy number "+enemynr+"?: ");
//        String name = readline.nextLine();
//        try {
//            if (name.equals("")) {
//                throw new InvalidNameException();
//            }
//            SimpleEnemy enemy = new SimpleEnemy(name, rand.nextInt(25) + 50, rand.nextInt(25) + 50, rand.nextInt(25) + 50, rand.nextInt(25) + 50, q);
//            return enemy;
//        } catch (InvalidNameException in) {
//            System.out.println("Not valid name, try again.");
//            return createEnemy(q, enemynr);
//        }
//
//    }
//    public static ArrayList<PlayerCharacter> createPlayerTeam(BlockingQueue<GameCharacter> q) throws InvalidStatValueException, InvalidNameException{
//        ArrayList<PlayerCharacter> playerTeam = new ArrayList<>();
//        for (int i = 0; i<5; i++) {
//            playerTeam.add(createCharacter(q));
//        }
//        return playerTeam;
//    }

//    public static ArrayList<Enemies> createEnemyTeam(BlockingQueue<GameCharacter> q) throws InvalidStatValueException, InvalidNameException{
//        ArrayList<Enemies> enemyTeam = new ArrayList<>();
//        Random rand = new Random();
//        int enemyCharactersTotal = rand.nextInt(9)+1;
//        for (int i = 0; i<enemyCharactersTotal; i++) {
//            Enemies enemy = createEnemy(q, i);
//            enemyTeam.add(enemy);
//        }
//        return enemyTeam;
//    }

    public static void playGame(FinalReality game, PrintStream out) {

    }


}
