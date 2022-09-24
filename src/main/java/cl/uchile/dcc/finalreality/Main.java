package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Knight;
import cl.uchile.dcc.finalreality.model.character.player.commoncharacter.Thief;
import cl.uchile.dcc.finalreality.model.character.player.magiccharacter.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.magiccharacter.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.magicweapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Axe;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Bow;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Knife;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Sword;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
  public static void main(String[] args) throws InterruptedException, InvalidStatValueException {
    // Making all object that will be tested
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    // Characters
      // Non mage characters
    Thief thief1 = new Thief("ladron 1", 50, 60, queue) ;
    Thief thief2 = new Thief("ladron 2", 55, 65, queue) ;
    Thief thief3 = new Thief("ladron 1", 50, 60, queue) ;

    Knight knight1 = new Knight("knight 1", 50, 60, queue) ;
    Knight knight2 = new Knight("knight 2", 55, 65, queue) ;
    Knight knight3 = new Knight("knight 1", 50, 60, queue) ;

    Engineer engineer1 = new Engineer("engineer 1", 50, 60, queue) ;
    Engineer engineer2 = new Engineer("engineer 2", 55, 65, queue) ;
    Engineer engineer3 = new Engineer("engineer 1", 50, 60, queue) ;
      // Non mage characters
    WhiteMage  whitemage1 = new WhiteMage("whitemage 1", 50, 60, 70, queue) ;
    WhiteMage  whitemage2 = new WhiteMage("whitemage 2", 55, 65, 75, queue) ;
    WhiteMage  whitemage3 = new WhiteMage("whitemage 1", 50, 60, 70, queue) ;

    BlackMage  blackmage1 = new BlackMage("blackmage 1", 50, 60, 70, queue) ;
    BlackMage  blackmage2 = new BlackMage("blackmage 2", 55, 65, 75, queue) ;
    BlackMage  blackmage3 = new BlackMage("blackmage 1", 50, 60, 70, queue) ;

    // Weapons
      //Non magic weapons
    Sword sword1 = new Sword("sword 1", 50, 60) ;
    Sword sword2 = new Sword("sword 2", 55, 65) ;
    Sword sword3 = new Sword("sword 1", 50, 60) ;

    Knife knife1 = new Knife("knife 1", 50, 60) ;
    Knife knife2 = new Knife("knife 2", 55, 65) ;
    Knife knife3 = new Knife("knife 1", 50, 60) ;

    Axe axe1 = new Axe("axe 1", 50, 60) ;
    Axe axe2 = new Axe("axe 2", 55, 65) ;
    Axe axe3 = new Axe("axe 1", 50, 60) ;

    Bow bow1 = new Bow("bow 1", 50, 60) ;
    Bow bow2 = new Bow("bow 2", 55, 65) ;
    Bow bow3 = new Bow("bow 1", 50, 60) ;

     //Magic weapons
    Staff staff1 = new Staff("staff 1", 50, 60, 70) ;
    Staff staff2 = new Staff("staff 2", 55, 65, 75) ;
    Staff staff3 = new Staff("staff 1", 50, 60, 70) ;

    //Testing Methods
      //Getters
      System.out.println("Thief name, defense, currentHP and maxHP");
      System.out.println(thief1.getName());
      System.out.println(thief1.getDefense());
      System.out.println(thief1.getCurrentHp());
      System.out.println(thief1.getMaxHp());

      System.out.println("Knight name, defense, currentHP and maxHP");
      System.out.println(knight1.getName());
      System.out.println(knight1.getDefense());
      System.out.println(knight1.getCurrentHp());
      System.out.println(knight1.getMaxHp());

      System.out.println("Engineer name, defense, currentHP and maxHP");
      System.out.println(engineer1.getName());
      System.out.println(engineer1.getDefense());
      System.out.println(engineer1.getCurrentHp());
      System.out.println(engineer1.getMaxHp());

      System.out.println("White mage name, defense, currentHP, maxHP, currentMp, maxMp");
      System.out.println(whitemage1.getName());
      System.out.println(whitemage1.getDefense());
      System.out.println(whitemage1.getCurrentHp());
      System.out.println(whitemage1.getMaxHp());
      System.out.println(whitemage1.getCurrentMp());
      System.out.println(whitemage1.getMaxMp());

      System.out.println("Black mage name, defense, currentHP, maxHP, currentMp, maxMp");
      System.out.println(blackmage1.getName());
      System.out.println(blackmage1.getDefense());
      System.out.println(blackmage1.getCurrentHp());
      System.out.println(blackmage1.getMaxHp());
      System.out.println(blackmage1.getCurrentMp());
      System.out.println(blackmage1.getMaxMp());

      System.out.println("Sword name, weight, damage, type");
      System.out.println(sword1.getName());
      System.out.println(sword1.getWeight());
      System.out.println(sword1.getDamage());
      System.out.println(sword1.getType());

      System.out.println("Knife name, weight, damage, type");
      System.out.println(knife1.getName());
      System.out.println(knife1.getWeight());
      System.out.println(knife1.getDamage());
      System.out.println(knife1.getType());

      System.out.println("Axe name, weight, damage, type");
      System.out.println(axe1.getName());
      System.out.println(axe1.getWeight());
      System.out.println(axe1.getDamage());
      System.out.println(axe1.getType());

      System.out.println("Bow name, weight, damage, type");
      System.out.println(bow1.getName());
      System.out.println(bow1.getWeight());
      System.out.println(bow1.getDamage());
      System.out.println(bow1.getType());

      System.out.println("Staff name, weight, damage, magicdamage, type");
      System.out.println(staff1.getName());
      System.out.println(staff1.getWeight());
      System.out.println(staff1.getDamage());
      System.out.println(staff1.getMagicdamage());
      System.out.println(staff1.getType());

      //Setters
      System.out.println("Thief hp from 50 to 10");
      System.out.println(thief1.getCurrentHp());
      thief1.setCurrentHp(10);
      System.out.println(thief1.getCurrentHp());

      System.out.println("Knight hp from 50 to 10");
      System.out.println(knight1.getCurrentHp());
      knight1.setCurrentHp(10);
      System.out.println(knight1.getCurrentHp());

      System.out.println("Engineer hp from 50 to 10");
      System.out.println(engineer1.getCurrentHp());
      engineer1.setCurrentHp(10);
      System.out.println(engineer1.getCurrentHp());

      System.out.println("White mage hp from 50 to 10, mp from 70 to 10");
      System.out.println(whitemage1.getCurrentHp());
      whitemage1.setCurrentHp(10);
      System.out.println(whitemage1.getCurrentHp());
      System.out.println(whitemage1.getCurrentMp());
      whitemage1.setCurrentMp(10);
      System.out.println(whitemage1.getCurrentMp());

      System.out.println("Black mage hp from 50 to 10, mp from 70 to 10");
      System.out.println(blackmage1.getCurrentHp());
      blackmage1.setCurrentHp(10);
      System.out.println(blackmage1.getCurrentHp());
      System.out.println(blackmage1.getCurrentMp());
      blackmage1.setCurrentMp(10);
      System.out.println(blackmage1.getCurrentMp());

      // Equals
      System.out.println("thief1 should be equal to thief3, but not to thief2 nor knight1");
      System.out.println(thief1.equals(thief3));
      System.out.println(thief1.equals(thief2));
      System.out.println(thief1.equals(knight1));

      System.out.println("knight1 should be equal to knight3, but not to knight2 nor engineer1");
      System.out.println(knight1.equals(knight3));
      System.out.println(knight1.equals(knight2));
      System.out.println(knight1.equals(engineer1));

      System.out.println("engineer1 should be equal to engineer3, but not to engineer2 nor thief1");
      System.out.println(engineer1.equals(engineer3));
      System.out.println(engineer1.equals(engineer2));
      System.out.println(engineer1.equals(thief1));

      System.out.println("whitemage1 should be equal to whitemage3, but not to whitemage2, blackmage1 or thief1");
      System.out.println(whitemage1.equals(whitemage3));
      System.out.println(whitemage1.equals(whitemage2));
      System.out.println(whitemage1.equals(blackmage1));
      System.out.println(whitemage1.equals(thief1));

      System.out.println("blackmage1 should be equal to blackmage3, but not to blackmage2, whitemage1 or thief1");
      System.out.println(blackmage1.equals(blackmage3));
      System.out.println(blackmage1.equals(blackmage2));
      System.out.println(blackmage1.equals(whitemage1));
      System.out.println(blackmage1.equals(thief1));




  }

}