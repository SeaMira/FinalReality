package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquipableWeaponException;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.notplayer.SimpleEnemy;
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
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class GameCharacterTest {
    Engineer eng1, eng2, eng3;
    Knight knight1, knight2, knight3;
    Thief thief1, thief2, thief3;
    BlackMage bmage1, bmage2, bmage3;
    WhiteMage wmage1, wmage2, wmage3;
    SimpleEnemy en1, en2, en3;

    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

    @Before
    public void setUp() throws Exception {
        eng1 = new Engineer("eng1", 10, 10, queue);
        eng2 = new Engineer("eng2", 15, 15, queue);
        knight1 = new Knight("knight1", 20, 20, queue);
        knight2 = new Knight("knight2", 25, 25, queue);
        thief1 = new Thief("thief1", 30, 30, queue);
        thief2 = new Thief("thief2", 35, 35, queue);
        bmage1 = new BlackMage("bmage1", 40, 40, 40, queue);
        bmage2 = new BlackMage("bmage2", 45, 45, 45, queue);
        wmage1 = new WhiteMage("wmage1", 50 , 50, 50, queue);
        wmage2 = new WhiteMage("wmage2", 55 , 55, 55, queue);
        en1 = new SimpleEnemy("en1", 60, 60, 60, 60, queue);
        en2  = new SimpleEnemy("en2", 65, 65, 65, 65, queue);
    }

    @Test
    public void testCharacterEquals() throws InvalidStatValueException {
        eng3 = new Engineer("eng1", 10, 10, queue);
        knight3 = new Knight("knight1", 20, 20, queue);
        thief3 = new Thief("thief1", 30, 30, queue);
        bmage3 = new BlackMage("bmage1", 40, 40, 40, queue);
        wmage3 = new WhiteMage("wmage1", 50 , 50, 50, queue);
        en3 = new SimpleEnemy("en1", 60, 60, 60, 60, queue);

        assertEquals("Not equal engineers", eng1, eng1);
        assertEquals("Not equal engineers", eng1, eng3);
        assertFalse(eng1.equals(eng2));
        assertFalse(eng1.equals(knight1));
        assertEquals("Not equal knights", knight1, knight1);
        assertEquals("Not equal engineers", knight1, knight3);
        assertFalse(knight1.equals(knight2));
        assertFalse(knight1.equals(thief1));
        assertEquals("Not equal thieves", thief1, thief1);
        assertEquals("Not equal engineers", thief1, thief3);
        assertFalse(thief1.equals(thief2));
        assertFalse(thief1.equals(bmage1));
        assertEquals("Not equal black-mages", bmage1, bmage1);
        assertEquals("Not equal black-mages", bmage1, bmage3);
        assertFalse(bmage1.equals(bmage2));
        assertFalse(bmage1.equals(wmage1));
        assertEquals("Not equal white-mages", wmage1, wmage1);
        assertEquals("Not equal white-mages", wmage1, wmage3);
        assertFalse(wmage1.equals(wmage2));
        assertFalse(wmage1.equals(en1));
        assertEquals("Not equal enemies", en1, en1);
        assertEquals("Not equal enemies", en1, en3);
        assertFalse(en1.equals(en2));
        assertFalse(en1.equals(eng1));
    }

    @Test
    public void testCharacterGetName() {
        assertEquals("Not engineer name", eng1.getName(), "eng1");
        assertEquals("Not knight1 name", knight1.getName(), "knight1");
        assertEquals("Not thief name", thief1.getName(), "thief1");
        assertEquals("Not black-mage name", bmage1.getName(), "bmage1");
        assertEquals("Not white-mage name", wmage1.getName(), "wmage1");
        assertEquals("Not enemy name", en1.getName(), "en1");
    }

    @Test
    public void testCharacterGetMaxHp() {
        assertEquals("Not engineer maxHp", eng1.getMaxHp(), 10);
        assertEquals("Not knight1 maxHp", knight1.getMaxHp(), 20);
        assertEquals("Not thief maxHp", thief1.getMaxHp(), 30);
        assertEquals("Not black-mage maxHp", bmage1.getMaxHp(), 40);
        assertEquals("Not white-mage maxHp", wmage1.getMaxHp(), 50);
        assertEquals("Not enemy maxHp", en1.getMaxHp(), 60);
    }

    @Test
    public void testCharacterGetDefense() {
        assertEquals("Not engineer defense", eng1.getDefense(), 10);
        assertEquals("Not knight1 defense", knight1.getDefense(), 20);
        assertEquals("Not thief defense", thief1.getDefense(), 30);
        assertEquals("Not black-mage defense", bmage1.getDefense(), 40);
        assertEquals("Not white-mage defense", wmage1.getDefense(), 50);
        assertEquals("Not enemy defense", en1.getDefense(), 60);
    }

    @Test
    public void testMagicCharactersGetMaxMp() {
        assertEquals("Not black-mage maxMp", bmage1.getMaxMp(), 40);
        assertEquals("Not white-mage maxMp", wmage1.getMaxMp(), 50);
    }

    @Test
    public void testEnemiesGetDamage() {
        assertEquals("Not enemy damage", en1.getDamage(), 60);
    }

    @Test
    public void testEnemiesGetWeight() {
        assertEquals("Not enemy's weight", en1.getWeight(), 60);
    }

    @Test
    public void testCharacterHaschCode() throws InvalidStatValueException {
        eng3 = new Engineer("eng1", 10, 10, queue);
        knight3 = new Knight("knight1", 20, 20, queue);
        thief3 = new Thief("thief1", 30, 30, queue);
        bmage3 = new BlackMage("bmage1", 40, 40, 40, queue);
        wmage3 = new WhiteMage("wmage1", 50 , 50, 50, queue);
        en3 = new SimpleEnemy("en1", 60, 60, 60, 60, queue);

        assertEquals("Not eng1.hashCode() doesn't match eng3.hashCode()", eng1.hashCode(), eng3.hashCode());
        assertEquals("Not knight1.hashCode() doesn't match knight3.hashCode()", knight1.hashCode(), knight3.hashCode());
        assertEquals("Not thief1.hashCode() doesn't match thief3.hashCode()", thief1.hashCode(), thief3.hashCode());
        assertEquals("Not bmage1.hashCode() doesn't match bmage3.hashCode()", bmage1.hashCode(), bmage3.hashCode());
        assertEquals("Not wmage1.hashCode() doesn't match wmage3.hashCode()", wmage1.hashCode(), wmage3.hashCode());
        assertEquals("Not en1.hashCode() doesn't match en3.hashCode()", en1.hashCode(), en3.hashCode());
    }

    @Test
    public void testCharacterToString() {
        assertEquals("eng1.toString() is not \"Engineer{maxHp=10, currentHp=10, defense=10, name='eng1'}\"", eng1.toString(), "Engineer{maxHp=10, currentHp=10, defense=10, name='eng1'}");
        assertEquals("knight1.toString() is not \"Knight{maxHp=20, currentHp=20, defense=20, name='knight1'}\"", knight1.toString(), "Knight{maxHp=20, currentHp=20, defense=20, name='knight1'}");
        assertEquals("thief1.toString() is not \"Thief{maxHp=30, currentHp=30, defense=30, name='thief1'}\"", thief1.toString(), "Thief{maxHp=30, currentHp=30, defense=30, name='thief1'}");
        assertEquals("bmage1.toString() is not \"BlackMage{maxMp=40, currentMp=40, maxHp=40, currentHp=40, defense=40, name='bmage1'}\"", bmage1.toString(), "BlackMage{maxMp=40, currentMp=40, maxHp=40, currentHp=40, defense=40, name='bmage1'}");
        assertEquals("wmage1.toString() is not \"WhiteMage{maxMp=50, currentMp=50, maxHp=50, currentHp=50, defense=50, name='wmage1'}\"", wmage1.toString(), "WhiteMage{maxMp=50, currentMp=50, maxHp=50, currentHp=50, defense=50, name='wmage1'}");
        assertEquals("en1.toString() is not \"SimpleEnemy{maxHp=60, currentHp=60, damage=60, defense=60, weight=60, name='en1'}\"", en1.toString(), "SimpleEnemy{maxHp=60, currentHp=60, damage=60, defense=60, weight=60, name='en1'}");
    }

    @Test
    public void testCharacterSetters() throws InvalidStatValueException {
        // Hp setters
        eng1.setCurrentHp(9);
        assertEquals("engineer Hp not set at 9", eng1.getCurrentHp(), 9);
        knight1.setCurrentHp(19);
        assertEquals("knight1 Hp not set at 19", knight1.getCurrentHp(), 19);
        thief1.setCurrentHp(29);
        assertEquals("thief Hp not set at 29", thief1.getCurrentHp(), 29);
        bmage1.setCurrentHp(39);
        assertEquals("black-mage Hp not set at 39", bmage1.getCurrentHp(), 39);
        wmage1.setCurrentHp(49);
        assertEquals("white-mage Hp not set at 49", wmage1.getCurrentHp(), 49);
        en1.setCurrentHp(59);
        assertEquals("enemy Hp not set at 59", en1.getCurrentHp(), 59);

        // Mp setters
        bmage1.setCurrentMp(39);
        assertEquals("black-mage Mp not set at 39", bmage1.getCurrentMp(), 39);
        wmage1.setCurrentMp(49);
        assertEquals("white-mage Mp not set at 49", wmage1.getCurrentMp(), 49);
    }

    @Test
    public void CharacterHpInvalidStatValueExceptionTest() throws InvalidStatValueException {
        boolean engNotAvailableHp = false;
        try {
            eng1.setCurrentHp(-1);
        } catch (InvalidStatValueException e) {
            engNotAvailableHp = true;
        }
        assertTrue("No exception caught", engNotAvailableHp);

        engNotAvailableHp = false;
        try {
            eng1.setCurrentHp(20);
        } catch (InvalidStatValueException e) {
            engNotAvailableHp = true;
        }
        assertTrue("No exception caught", engNotAvailableHp);

    }

    @Test
    public void testCharacterEquippedSword() throws InvalidEquipableWeaponException {
        Sword sword1 = new Sword("sword1", 20, 20);
        assertEquals(null, eng1.getEquippedWeapon());
        assertEquals(null, knight1.getEquippedWeapon());
        assertEquals(null, thief1.getEquippedWeapon());
        assertEquals(null, bmage1.getEquippedWeapon());
        assertEquals(null, wmage1.getEquippedWeapon());

        boolean notEquippedSword1 = false;
        boolean notEquippedSword4 = false;
        boolean notEquippedSword5 = false;

        // engineer
        try {
            eng1.equip(sword1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedSword1 = true;
        }
        assertTrue(notEquippedSword1);

        // knight
        knight1.equip(sword1);
        assertEquals(sword1, knight1.getEquippedWeapon());

        // thief
        thief1.equip(sword1);
        assertEquals(sword1, thief1.getEquippedWeapon());

        // black mage
        try {
            bmage1.equip(sword1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedSword4 = true;
        }
        assertTrue(notEquippedSword4);

        // white mage
        try {
            wmage1.equip(sword1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedSword5 = true;
        }
        assertTrue(notEquippedSword5);

    }

    @Test
    public void testCharacterEquippedAxe() throws InvalidEquipableWeaponException {
        Axe axe1 = new Axe("axe1", 20, 20);
        assertEquals(null, eng1.getEquippedWeapon());
        assertEquals(null, knight1.getEquippedWeapon());
        assertEquals(null, thief1.getEquippedWeapon());
        assertEquals(null, bmage1.getEquippedWeapon());
        assertEquals(null, wmage1.getEquippedWeapon());

        boolean notEquippedAxe3 = false;
        boolean notEquippedAxe4 = false;
        boolean notEquippedAxe5 = false;

        // engineer
        eng1.equip(axe1);
        assertEquals(axe1, eng1.getEquippedWeapon());

        // knight
        knight1.equip(axe1);
        assertEquals(axe1, knight1.getEquippedWeapon());

        // thief
        try {
            thief1.equip(axe1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedAxe3 = true;
        }
        assertTrue(notEquippedAxe3);

        // black mage
        try {
            bmage1.equip(axe1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedAxe4 = true;
        }
        assertTrue(notEquippedAxe4);

        // white mage
        try {
            wmage1.equip(axe1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedAxe5 = true;
        }
        assertTrue(notEquippedAxe5);

    }

    @Test
    public void testCharacterEquippedKnife() throws InvalidEquipableWeaponException {
        Knife knife1 = new Knife("knife", 20, 20);
        assertEquals(null, eng1.getEquippedWeapon());
        assertEquals(null, knight1.getEquippedWeapon());
        assertEquals(null, thief1.getEquippedWeapon());
        assertEquals(null, bmage1.getEquippedWeapon());
        assertEquals(null, wmage1.getEquippedWeapon());

        boolean notEquippedKnife1 = false;
        boolean notEquippedKnife5 = false;

        // engineer
        try {
            eng1.equip(knife1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedKnife1 = true;
        }
        assertTrue(notEquippedKnife1);

        // knight
        knight1.equip(knife1);
        assertEquals(knife1, knight1.getEquippedWeapon());

        // thief
        thief1.equip(knife1);
        assertEquals(knife1, thief1.getEquippedWeapon());

        // black mage
        bmage1.equip(knife1);
        assertEquals(knife1, bmage1.getEquippedWeapon());

        // white mage
        try {
            wmage1.equip(knife1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedKnife5 = true;
        }
        assertTrue(notEquippedKnife5);

    }

    @Test
    public void testCharacterEquippedBow() throws InvalidEquipableWeaponException {
        Bow bow1 = new Bow("bow1", 20, 20);
        assertEquals(null, eng1.getEquippedWeapon());
        assertEquals(null, knight1.getEquippedWeapon());
        assertEquals(null, thief1.getEquippedWeapon());
        assertEquals(null, bmage1.getEquippedWeapon());
        assertEquals(null, wmage1.getEquippedWeapon());

        boolean notEquippedBow2 = false;
        boolean notEquippedBow4 = false;
        boolean notEquippedBow5 = false;

        // engineer
        eng1.equip(bow1);
        assertEquals(bow1, eng1.getEquippedWeapon());

        // knight
        try {
            knight1.equip(bow1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedBow2 = true;
        }
        assertTrue(notEquippedBow2);

        // thief
        thief1.equip(bow1);
        assertEquals(bow1, thief1.getEquippedWeapon());

        // black mage
        try {
            bmage1.equip(bow1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedBow4 = true;
        }
        assertTrue(notEquippedBow4);

        // white mage
        try {
            wmage1.equip(bow1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedBow5 = true;
        }
        assertTrue(notEquippedBow5);

    }

    @Test
    public void testCharacterEquippedStaff() throws InvalidEquipableWeaponException {
        Staff staff1 = new Staff("staff1", 20, 20, 20);
        assertEquals(null, eng1.getEquippedWeapon());
        assertEquals(null, knight1.getEquippedWeapon());
        assertEquals(null, thief1.getEquippedWeapon());
        assertEquals(null, bmage1.getEquippedWeapon());
        assertEquals(null, wmage1.getEquippedWeapon());

        boolean notEquippedStaff1 = false;
        boolean notEquippedStaff2 = false;
        boolean notEquippedStaff3 = false;

        // engineer
        try {
            eng1.equip(staff1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedStaff1 = true;
        }
        assertTrue(notEquippedStaff1);

        // knight
        try {
            knight1.equip(staff1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedStaff2 = true;
        }
        assertTrue(notEquippedStaff2);

        // thief
        try {
            thief1.equip(staff1);
        } catch(InvalidEquipableWeaponException notWeapon) {
            notEquippedStaff3 = true;
        }
        assertTrue(notEquippedStaff3);

        // black mage
        bmage1.equip(staff1);
        assertEquals(staff1, bmage1.getEquippedWeapon());

        // white mage
        wmage1.equip(staff1);
        assertEquals(staff1, wmage1.getEquippedWeapon());

    }

    @Test
    public void testCharacterTurns() throws InterruptedException, InvalidEquipableWeaponException {
        Axe axe1 = new Axe("axe1", 10, 10);
        Sword sword1 = new Sword("sword1", 20, 20);
        Bow bow1 = new Bow("bow1", 30, 30);
        Staff staff1 = new Staff("staff1", 40, 40, 40);

        eng1.equip(axe1);
        knight1.equip(sword1);
        thief1.equip(bow1);
        bmage1.equip(staff1);

        eng1.waitTurn();
        knight1.waitTurn();
        thief1.waitTurn();
        bmage1.waitTurn();
        en1.waitTurn();
        wmage1.waitTurn();

        Thread.sleep(6100);
        assertEquals(queue.poll(), wmage1);
        assertEquals(queue.poll(), eng1);
        assertEquals(queue.poll(), knight1);
        assertEquals(queue.poll(), thief1);
        assertEquals(queue.poll(), bmage1);
        assertEquals(queue.poll(), en1);

    }
}