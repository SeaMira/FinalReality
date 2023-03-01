package cl.uchile.dcc.finalreality.model.driverTest;

import cl.uchile.dcc.finalreality.FinalReality;
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
import cl.uchile.dcc.finalreality.model.spells.*;
import cl.uchile.dcc.finalreality.model.states.*;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.magicweapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Axe;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Bow;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Knife;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Sword;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static cl.uchile.dcc.finalreality.GameDriver.*;
import static org.junit.Assert.*;


public class GameDriverTest {
    Engineer eng1;
    Knight knight1;
    Thief thief1;
    BlackMage bmage1;
    WhiteMage wmage1;
    SimpleEnemy en1;

    Axe axe1;
    Sword sword1;
    Bow bow1;
    Knife knife1;
    Staff staff1;
    // Spells
    NullSpell nullspell;
    Fire fire;
    Heal heal;
    Paralyze paralyze;
    Poison poison;
    Thunder thunder;
    // State
    BurntState burn;
    DeadState dead;
    NormalState normal;
    ParalizedState paralyzed;
    PoisonedState poisoned;

    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

    @Before
    public void setUp() throws Exception {
        eng1 = new Engineer("eng1", 10, 10, queue);
        knight1 = new Knight("knight1", 20, 20, queue);
        thief1 = new Thief("thief1", 30, 30, queue);
        bmage1 = new BlackMage("bmage1", 40, 40, 40, queue);
        wmage1 = new WhiteMage("wmage1", 50 , 50, 50, queue);
        en1 = new SimpleEnemy("en1", 60, 60, 60, 60, queue);

        axe1 =  new Axe("axe1", 50, 50);
        sword1 = new Sword("sword1", 40, 40);
        bow1 = new Bow("bow1", 30, 30);
        knife1 = new Knife("knife1", 60, 60);
        staff1 = new Staff("staff1", 70, 70, 70);

        nullspell = new NullSpell();
        fire = new Fire();
        heal = new Heal();
        paralyze = new Paralyze();
        poison = new Poison();
        thunder = new Thunder();

    }

    @Test
    public void createCharacter() throws  InvalidEquipableWeaponException, InvalidStatValueException {
        knight1.equip(sword1);
        Knight knight = createKnight("knight1", 20, 20, sword1, queue);
        assertEquals(knight, knight1);

        thief1.equip(knife1);
        Thief thief = createThief("thief1", 30, 30, knife1, queue);
        assertEquals(thief, thief1);

        eng1.equip(axe1);
        Engineer engineer = createEngineer("eng1", 10, 10, axe1, queue);
        assertEquals(engineer, eng1);

        bmage1.equip(staff1);
        BlackMage blackmage = createBlackMage("bmage1", 40, 40, 40, staff1, queue);
        assertEquals(blackmage, bmage1);

        wmage1.equip(staff1);
        WhiteMage whitemage = createWhiteMage("wmage1", 50 , 50, 50, staff1, queue);
        assertEquals(whitemage, wmage1);

        SimpleEnemy enemy = createSimpleEnemy("en1", 60, 60, 60, 60, queue);
        assertEquals(enemy, en1);
    }

    @Test
    public void switchWeaponTest() throws InvalidStatValueException, InvalidEquipableWeaponException {
        knight1.equip(sword1);
        assertEquals(sword1, knight1.getEquippedWeapon());
        switchWeapon(knight1, axe1);
        assertEquals(axe1, knight1.getEquippedWeapon());
    }

    @Test
    public void switchSpellTest() {
        nullspell.setCharacter(bmage1);
        assertEquals(nullspell, bmage1.getSpell());

        Fire f = new Fire();
        fire.setCharacter(bmage1);
        switchSpell(bmage1, f);
        assertEquals(fire, f);

        Paralyze par = new Paralyze();
        paralyze.setCharacter(bmage1);
        switchSpell(bmage1, par);
        assertEquals(paralyze, par);

        Poison poi = new Poison();
        poison.setCharacter(bmage1);
        switchSpell(bmage1, poi);
        assertEquals(poison, poi);

        Thunder t = new Thunder();
        thunder.setCharacter(bmage1);
        switchSpell(bmage1, t);
        assertEquals(thunder, t);

        Heal h = new Heal();
        heal.setCharacter(bmage1);
        switchSpell(bmage1, h);
        assertEquals(heal, h);
    }

    @Test
    public void attackTest() throws InvalidStatValueException, InvalidEquipableWeaponException {
        Knight knight = createKnight("knight1", 40, 40, sword1, queue);
        SimpleEnemy enemy = createSimpleEnemy("en1", 60, 60, 30, 60, queue);
        SimpleEnemy deadenemy = createSimpleEnemy("ent", 60, 1, 30, 60, queue);

        physicalAttack(knight, enemy);
        assertEquals(50, enemy.getCurrentHp());

        physicalAttack(knight, deadenemy);
        assertEquals(0, deadenemy.getCurrentHp());
        dead = new DeadState(deadenemy);
        assertEquals(dead, deadenemy.getState());

        physicalAttack(enemy, knight);
        assertEquals(20, knight.getCurrentHp());

        physicalAttack(enemy, knight);
        assertEquals(0, knight.getCurrentHp());
        dead = new DeadState(knight);
        assertEquals(dead, knight.getState());

        SimpleEnemy enemy2 = createSimpleEnemy("en2", 60, 90, 30, 60, queue);
        bmage1.setSpell(fire);
        switchWeapon(bmage1, staff1);
        magicAttack(bmage1, enemy2);
        assertEquals(20, enemy2.getCurrentHp());

        enemy2.setCurrentHp(90);
        switchSpell(bmage1, thunder);
        magicAttack(bmage1, enemy2);
        assertEquals(20, enemy2.getCurrentHp());

        wmage1.setSpell(heal);
        switchWeapon(wmage1, staff1);
        magicAttack(wmage1, enemy2);
        assertEquals(47, enemy2.getCurrentHp());
    }

    @Test
    public void checkStateTest() {
        normal = new NormalState(en1);
        assertEquals(normal, en1.getState());
        checkingState(en1);

        burn = new BurntState(en1, 70/3);
        en1.setState(new BurntState(en1, 70/3));
        assertEquals(burn, en1.getState());
        checkingState(en1);
        assertEquals(37, en1.getCurrentHp());

        paralyzed = new ParalizedState(en1);
        en1.setState(new ParalizedState(en1));
        assertEquals(paralyzed, en1.getState());
        checkingState(en1);
        assertEquals(normal, en1.getState());

        poisoned = new PoisonedState(en1, 70/3);
        en1.setState(new PoisonedState(en1, 70/3));
        assertEquals(poisoned, en1.getState());
        checkingState(en1);
        assertEquals(14, en1.getCurrentHp());

        checkingState(en1);
        dead = new DeadState(en1);
        assertEquals(0, en1.getCurrentHp());
        assertEquals(dead, en1.getState());

        boolean isDead = false;
        try {
            dead.apply();
        } catch (IsDeadException d) {
            isDead = true;
        }
        assertTrue(isDead);
    }

    @Test
    public void PoisonSpellTest() throws InvalidStatValueException, InvalidEquipableWeaponException {
        Poison poi = new Poison();
        bmage1.equip(knife1);
        en1.setHpToZero();

        boolean cantCastIfDead = false;
        boolean cantCastIfNoStaff = false;
        boolean cantCastIfNoMana = false;
        boolean cantCastIfNoSpell = false;

        try {
            bmage1.castSpell(en1);
        } catch (IsDeadException d) {
            cantCastIfDead = true;
        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {

        } catch (SpellNotEquippedException noSpell) {

        }
        assertTrue(cantCastIfDead);
        en1.setCurrentHp(60);

        try {
            bmage1.castSpell(en1);
        } catch (IsDeadException d) {
            cantCastIfDead = true;
        } catch (MagicWeaponNotEquippedException mw) {
            cantCastIfNoStaff = true;
        } catch (InvalidStatValueException nomana) {

        } catch (SpellNotEquippedException noSpell) {

        }
        assertTrue(cantCastIfNoStaff);
        switchWeapon(bmage1, staff1);

        bmage1.setCurrentMp(1);
        switchSpell(bmage1, poi);
        try {
            bmage1.castSpell(en1);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {
            cantCastIfNoMana = true;
        } catch (SpellNotEquippedException noSpell) {

        }
        assertTrue(cantCastIfNoMana);

        switchSpell(bmage1, nullspell);
        bmage1.setCurrentMp(40);
        try {
            bmage1.castSpell(en1);
        } catch (IsDeadException d) {
            cantCastIfDead = true;
        } catch (MagicWeaponNotEquippedException mw) {
            cantCastIfNoStaff = true;
        } catch (InvalidStatValueException nomana) {
            cantCastIfNoMana = true;
        } catch (SpellNotEquippedException noSpell) {
            cantCastIfNoSpell = true;
        }
        assertTrue(cantCastIfNoSpell);
        switchSpell(bmage1, poi);

        try {
            bmage1.castSpell(en1);
        } catch (IsDeadException d) {
            cantCastIfDead = true;
        } catch (MagicWeaponNotEquippedException mw) {
            cantCastIfNoStaff = true;
        } catch (InvalidStatValueException nomana) {
            cantCastIfNoMana = true;
        } catch (SpellNotEquippedException noSpell) {
            cantCastIfNoSpell = true;
        }

        poisoned = new PoisonedState(en1, 70/3);
        assertEquals(poisoned, en1.getState());
    }

    @Test
    public void ThunderSpellTest() throws InvalidStatValueException, InvalidEquipableWeaponException {
        Thunder th = new Thunder();
        SimpleEnemy enemy = createSimpleEnemy("en1", 60, 80, 30, 60, queue);

        boolean cantCastIfNoMana = false;


        switchWeapon(bmage1, staff1);

        bmage1.setCurrentMp(1);
        switchSpell(bmage1, th);
        try {
            bmage1.castSpell(enemy);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {
            cantCastIfNoMana = true;
        } catch (SpellNotEquippedException noSpell) {

        }
        assertTrue(cantCastIfNoMana);

        bmage1.setCurrentMp(40);

        try {
            bmage1.castSpell(enemy);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {

        } catch (SpellNotEquippedException noSpell) {

        }
        assertEquals(10, enemy.getCurrentHp());

        try {
            bmage1.castSpell(enemy);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {

        } catch (SpellNotEquippedException noSpell) {

        }
        assertEquals(0, enemy.getCurrentHp());
    }

    @Test
    public void ParalyzeSpellTest() throws InvalidStatValueException, InvalidEquipableWeaponException {
        Paralyze th = new Paralyze();
        SimpleEnemy enemy = createSimpleEnemy("en1", 60, 80, 30, 60, queue);

        boolean cantCastIfNoMana = false;


        switchWeapon(bmage1, staff1);

        bmage1.setCurrentMp(1);
        switchSpell(bmage1, th);
        try {
            bmage1.castSpell(enemy);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {
            cantCastIfNoMana = true;
        } catch (SpellNotEquippedException noSpell) {

        }
        assertTrue(cantCastIfNoMana);

        bmage1.setCurrentMp(40);

        try {
            bmage1.castSpell(enemy);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {

        } catch (SpellNotEquippedException noSpell) {

        }
        paralyzed = new ParalizedState(enemy);
        assertEquals(paralyzed, enemy.getState());

    }

    @Test
    public void FireSpellTest() throws InvalidStatValueException, InvalidEquipableWeaponException {
        Fire th = new Fire();
        SimpleEnemy enemy = createSimpleEnemy("en1", 60, 80, 30, 60, queue);

        boolean cantCastIfNoMana = false;


        switchWeapon(bmage1, staff1);

        bmage1.setCurrentMp(1);
        switchSpell(bmage1, th);
        try {
            bmage1.castSpell(enemy);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {
            cantCastIfNoMana = true;
        } catch (SpellNotEquippedException noSpell) {

        }
        assertTrue(cantCastIfNoMana);

        bmage1.setCurrentMp(40);

        try {
            bmage1.castSpell(enemy);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {

        } catch (SpellNotEquippedException noSpell) {

        }
        assertEquals(10, enemy.getCurrentHp());

        try {
            bmage1.castSpell(enemy);
        } catch (IsDeadException d) {

        } catch (MagicWeaponNotEquippedException mw) {

        } catch (InvalidStatValueException nomana) {

        } catch (SpellNotEquippedException noSpell) {

        }
        assertEquals(0, enemy.getCurrentHp());
    }

    @Test
    public void GameTest() throws InvalidStatValueException, InvalidEquipableWeaponException {
        ArrayList<Enemies> enemyTeam = new ArrayList<>();
        ArrayList<PlayerCharacter> playerTeam = new ArrayList<>();
        ArrayList<Weapon> weaponsBag = new ArrayList<>();

        SimpleEnemy enemy = createSimpleEnemy("en", 20, 40, 30, 60, queue);
        enemyTeam.add(enemy);
        SimpleEnemy enemy1 = createSimpleEnemy("en1", 30, 50, 30, 60, queue);
        enemyTeam.add(enemy1);
        SimpleEnemy enemy2 = createSimpleEnemy("en2", 40, 60, 30, 60, queue);
        enemyTeam.add(enemy2);
        SimpleEnemy enemy3 = createSimpleEnemy("en3", 50, 70, 30, 60, queue);
        enemyTeam.add(enemy3);
        SimpleEnemy enemy4 = createSimpleEnemy("en4", 60, 80, 30, 60, queue);
        enemyTeam.add(enemy4);

        Knight knight = createKnight("knight1", 20, 20, sword1, queue);
        playerTeam.add(knight);
        Thief thief = createThief("thief1", 30, 30, knife1, queue);
        playerTeam.add(thief);
        Engineer engineer = createEngineer("eng1", 10, 10, axe1, queue);
        playerTeam.add(engineer);
        BlackMage blackmage = createBlackMage("bmage1", 40, 40, 40, staff1, queue);
        playerTeam.add(blackmage);
        WhiteMage whitemage = createWhiteMage("wmage1", 50 , 50, 50, staff1, queue);
        playerTeam.add(whitemage);

        weaponsBag.add(sword1);
        weaponsBag.add(axe1);
        weaponsBag.add(bow1);
        weaponsBag.add(knife1);
        weaponsBag.add(staff1);

        FinalReality game = new FinalReality(playerTeam, enemyTeam, weaponsBag);

        for (PlayerCharacter p : playerTeam) {
            p.setHpToZero();
        }

        game.checkIfPlayerLose();
        assertTrue(game.isEnemyWin());

        for (Enemies e : enemyTeam) {
            e.setHpToZero();
        }
        game.checkIfEnemyLose();
        assertTrue(game.isPlayerWin());
    }

    @Test
    public void GameTurnsTest() throws InvalidStatValueException, InvalidEquipableWeaponException, InterruptedException {
        ArrayList<Enemies> enemyTeam = new ArrayList<>();
        ArrayList<PlayerCharacter> playerTeam = new ArrayList<>();
        ArrayList<Weapon> weaponsBag = new ArrayList<>();

        SimpleEnemy enemy = createSimpleEnemy("en", 20, 40, 30, 60, queue);
        enemyTeam.add(enemy);
        SimpleEnemy enemy1 = createSimpleEnemy("en1", 30, 50, 30, 60, queue);
        enemyTeam.add(enemy1);
        SimpleEnemy enemy2 = createSimpleEnemy("en2", 40, 1, 30, 60, queue);
        enemyTeam.add(enemy2);
        SimpleEnemy enemy3 = createSimpleEnemy("en3", 50, 1, 30, 60, queue);
        enemyTeam.add(enemy3);
        SimpleEnemy enemy4 = createSimpleEnemy("en4", 60, 1, 30, 60, queue);
        enemyTeam.add(enemy4);

        Knight knight = createKnight("knight1", 20, 20, sword1, queue);
        playerTeam.add(knight);
        Thief thief = createThief("thief1", 30, 30, knife1, queue);
        playerTeam.add(thief);
        Engineer engineer = createEngineer("eng1", 1, 10, axe1, queue);
        playerTeam.add(engineer);
        BlackMage blackmage = createBlackMage("bmage1", 1, 40, 40, staff1, queue);
        playerTeam.add(blackmage);
        WhiteMage whitemage = createWhiteMage("wmage1", 1 , 50, 50, staff1, queue);
        playerTeam.add(whitemage);

        weaponsBag.add(sword1);
        weaponsBag.add(axe1);
        weaponsBag.add(bow1);
        weaponsBag.add(knife1);
        weaponsBag.add(staff1);

        FinalReality game = new FinalReality(playerTeam, enemyTeam, weaponsBag);

        enemy2.setHpToZero();
        enemy3.setHpToZero();
        enemy4.setHpToZero();

        engineer.setHpToZero();
        blackmage.setHpToZero();
        whitemage.setHpToZero();

        game.makeTurns();
        Thread.sleep(6100);

        assertEquals(enemy, queue.poll());
        assertEquals(enemy1, queue.poll());
        assertEquals(knight, queue.poll());
        assertEquals(thief, queue.poll());
    }

    @Test
    public void SpellsEqualsTest() {

        nullspell.setCharacter(bmage1);
        heal.setCharacter(bmage1);
        fire.setCharacter(bmage1);
        paralyze.setCharacter(bmage1);
        poison.setCharacter(bmage1);
        thunder.setCharacter(bmage1);

        NullSpell nullSpell2 = new NullSpell();
        nullSpell2.setCharacter(bmage1);
        NullSpell nullSpell3 = new NullSpell();
        nullSpell3.setCharacter(wmage1);

        assertEquals(nullspell, nullspell);
        assertEquals(nullspell, nullSpell2);
        assertFalse(nullspell.equals(heal));



        Heal heal2 = new Heal();
        heal2.setCharacter(bmage1);
        Heal heal3 = new Heal();
        heal3.setCharacter(wmage1);

        assertEquals(heal, heal);
        assertEquals(heal, heal2);
        assertFalse(heal.equals(fire));



        Fire fire2 = new Fire();
        fire2.setCharacter(bmage1);
        Fire fire3 = new Fire();
        fire3.setCharacter(wmage1);

        assertEquals(fire, fire);
        assertEquals(fire, fire2);
        assertFalse(fire.equals(thunder));




        Paralyze paralyze2 = new Paralyze();
        paralyze2.setCharacter(bmage1);
        Paralyze paralyze3 = new Paralyze();
        paralyze3.setCharacter(wmage1);

        assertEquals(paralyze, paralyze);
        assertEquals(paralyze, paralyze2);
        assertFalse(paralyze.equals(poison));



        Poison poison2 = new Poison();
        poison2.setCharacter(bmage1);
        Poison poison3 = new Poison();
        poison3.setCharacter(wmage1);

        assertEquals(poison, poison);
        assertEquals(poison, poison2);
        assertFalse(poison.equals(nullspell));



        Thunder thunder2 = new Thunder();
        thunder2.setCharacter(bmage1);
        Thunder thunder3 = new Thunder();
        thunder3.setCharacter(wmage1);

        assertEquals(thunder, thunder);
        assertEquals(thunder, thunder2);
        assertFalse(thunder.equals(paralyze));


    }

    @Test
    public void StateEqualsTest() {


        burn = new BurntState(bmage1, 10);
        dead = new DeadState(bmage1);
        normal = new NormalState(bmage1);
        paralyzed = new ParalizedState(bmage1);
        poisoned = new PoisonedState(bmage1, 10);

        BurntState burn2 = new BurntState(bmage1, 10);
        BurntState burn3 = new BurntState(wmage1, 20);

        assertEquals(burn, burn);
        assertEquals(burn, burn2);
        assertFalse(burn.equals(dead));



        DeadState dead2 = new DeadState(bmage1);
        DeadState dead3 = new DeadState(wmage1);

        assertEquals(dead, dead);
        assertEquals(dead, dead2);
        assertFalse(dead.equals(normal));



        NormalState normal2 = new NormalState(bmage1);
        NormalState normal3 = new NormalState(wmage1);

        assertEquals(normal, normal);
        assertEquals(normal, normal2);
        assertFalse(normal.equals(paralyzed));



        ParalizedState paralyzed2 = new ParalizedState(bmage1);
        ParalizedState paralyzed3 = new ParalizedState(wmage1);

        assertEquals(paralyzed, paralyzed);
        assertEquals(paralyzed, paralyzed2);
        assertFalse(paralyzed.equals(poisoned));



        PoisonedState poisoned2 = new PoisonedState(bmage1, 10);
        PoisonedState poisoned3 = new PoisonedState(wmage1, 20);

        assertEquals(poisoned, poisoned);
        assertEquals(poisoned, poisoned2);
        assertFalse(poisoned.equals(burn));


    }
}