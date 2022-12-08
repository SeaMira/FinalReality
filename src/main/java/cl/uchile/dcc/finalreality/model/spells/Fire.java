package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.MagicWeaponNotEquippedException;
import cl.uchile.dcc.finalreality.exceptions.NoManaLeftException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MagicCharacter;
import cl.uchile.dcc.finalreality.model.states.BurntState;
import cl.uchile.dcc.finalreality.model.states.DeadState;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.util.Random;

public class Fire extends Spell {
    public Fire(MagicCharacter character) {
        super(character, 15);
    }

    @Override
    public void cast(GameCharacter victim) throws IsDeadException, MagicWeaponNotEquippedException, InvalidStatValueException {
        if (!victim.checkIsAlive()){
            throw new IsDeadException();
        }
        if (!mage.getEquippedWeapon().isMagic()) {
            throw new MagicWeaponNotEquippedException();
        }
        MagicWeapon mw = (MagicWeapon) mage.getEquippedWeapon();

        int newMana = mage.getCurrentMp() -cost;
        mage.setCurrentMp(newMana);

        double rand = Math.random();
        int magicdamage = mw.getMagicdamage();
        int victimHP = victim.getCurrentHp();

        if (victimHP-magicdamage <= 0) {
            victim.setState(new DeadState(victim));
            victim.setHpToZero();
        } else {
            victim.setCurrentHp(victimHP-magicdamage);
            if (rand <= 0.2) {
               victim.setState(new BurntState(victim,magicdamage/2));
            }
        }

    }
}
