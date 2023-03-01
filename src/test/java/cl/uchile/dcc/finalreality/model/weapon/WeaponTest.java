package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.weapon.magicweapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Axe;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Bow;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Knife;
import cl.uchile.dcc.finalreality.model.weapon.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {
    Axe axe1, axe2, axe3 ;
    Sword sword1, sword2, sword3;
    Bow bow1, bow2, bow3;
    Knife knife1, knife2, knife3;
    Staff staff1, staff2, staff3;

    @Before
    public void setUp() {
        axe1 =  new Axe("axe1", 50, 50);
        axe2 = new Axe("axe2", 55, 55);
        axe3 =  new Axe("axe1", 50, 50);
        sword1 = new Sword("sword1", 40, 40);
        sword2 = new Sword("sword2", 45, 45);
        sword3 = new Sword("sword1", 40, 40);
        bow1 = new Bow("bow1", 30, 30);
        bow2 = new Bow("bow2", 35, 35);
        bow3 = new Bow("bow1", 30, 30);
        knife1 = new Knife("knife1", 60, 60);
        knife2 = new Knife("knife2", 65, 65);
        knife3 = new Knife("knife1", 60, 60);
        staff1 = new Staff("staff1", 70, 70, 70);
        staff2 = new Staff("staff2", 75, 75, 75);
        staff3 = new Staff("staff1", 70, 70, 70);
    }
    @Test
    public void testWeaponEquals() {
        assertEquals("Not equal axes", axe1, axe1);
        assertEquals("Not equal axes", axe1, axe3);
        assertFalse(axe1.equals(axe2));
        assertFalse(axe1.equals(sword1));
        assertEquals("Not equal swords", sword1, sword1);
        assertEquals("Not equal swords", sword1, sword3);
        assertFalse(sword1.equals(sword2));
        assertFalse(sword1.equals(bow1));
        assertEquals("Not equal bows", bow1, bow1);
        assertEquals("Not equal bows", bow1, bow3);
        assertFalse(bow1.equals(bow2));
        assertFalse(bow1.equals(knife1));
        assertEquals("Not equal knives", knife1, knife1);
        assertEquals("Not equal knives", knife1, knife3);
        assertFalse(knife1.equals(knife2));
        assertFalse(knife1.equals(staff1));
        assertEquals("Not equal staffs", staff1, staff1);
        assertEquals("Not equal staffs", staff1, staff3);
        assertFalse(staff1.equals(staff2));
        assertFalse(staff1.equals(axe1));
    }

    @Test
    public void testWeaponGetName() {
        assertEquals("Not axe1 name", axe1.getName(), "axe1");
        assertEquals("Not sword1 name", sword1.getName(), "sword1");
        assertEquals("Not bow1 name", bow1.getName(), "bow1");
        assertEquals("Not knife1 name", knife1.getName(), "knife1");
        assertEquals("Not staff1 name", staff1.getName(), "staff1");
    }

    @Test
    public void testWeaponGetDamage() {
        assertEquals("Not axe1 damage", axe1.getDamage(), 50);
        assertEquals("Not sword1 damage", sword1.getDamage(), 40);
        assertEquals("Not bow1 damage", bow1.getDamage(), 30);
        assertEquals("Not knife1 damage", knife1.getDamage(), 60);
        assertEquals("Not staff1 damage", staff1.getDamage(), 70);
    }

    @Test
    public void testWeaponGetMagicDamage() {
        assertEquals("Not staff1 magic damage", staff1.getMagicdamage(), 70);
    }

    @Test
    public void testWeaponGetWeight() {
        assertEquals("Not axe1 weight", axe1.getWeight(), 50);
        assertEquals("Not sword1 weight", sword1.getWeight(), 40);
        assertEquals("Not bow1 weight", bow1.getWeight(), 30);
        assertEquals("Not knife1 weight", knife1.getWeight(), 60);
        assertEquals("Not staff1 weight", staff1.getWeight(), 70);
    }

    @Test
    public void testWeaponHashCode() {
        assertEquals("axe1.hashCode() doesn't equal axe3.hashCode()", axe1.hashCode(), axe3.hashCode());
        assertEquals("sword1.hashCode() doesn't equal sword3.hashCode()", sword3.hashCode(), sword3.hashCode());
        assertEquals("bow1.hashCode() doesn't equal bow3.hashCode()", bow1.hashCode(), bow3.hashCode());
        assertEquals("knife1.hashCode() doesn't equal knife3.hashCode()", knife1.hashCode(), knife3.hashCode());
        assertEquals("staff1.hashCode() doesn't equal staff3.hashCode()", staff1.hashCode(), staff3.hashCode());
    }

    @Test
    public void testWeaponToString() {
        assertEquals("axe1.toString() is not \"Axe{name='axe1', damage=50, weight=50}\"", axe1.toString(), "Axe{name='axe1', damage=50, weight=50}");
        assertEquals("sword1.toString() is not \"Sword{name='sword1', damage=40, weight=40}\"", sword1.toString(), "Sword{name='sword1', damage=40, weight=40}");
        assertEquals("bow1.toString() is not \"Bow{name='bow1', damage=30, weight=30}\"", bow1.toString(), "Bow{name='bow1', damage=30, weight=30}");
        assertEquals("knife1.toString() is not \"Knife{name='knife1', damage=60, weight=60}\"", knife1.toString(), "Knife{name='knife1', damage=60, weight=60}");
        assertEquals("staff1.toString() is not \"Staff{name='staff1', damage=70, weight=70, magicdamage=70}\"", staff1.toString(), "Staff{name='staff1', damage=70, weight=70, magicdamage=70}");
    }



}