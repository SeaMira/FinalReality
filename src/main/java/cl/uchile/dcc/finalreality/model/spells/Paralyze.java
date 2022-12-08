package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.MagicWeaponNotEquippedException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MagicCharacter;
import cl.uchile.dcc.finalreality.model.states.BurntState;
import cl.uchile.dcc.finalreality.model.states.DeadState;
import cl.uchile.dcc.finalreality.model.states.ParalizedState;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;

public class Paralyze extends Spell {
    public Paralyze(MagicCharacter character) {
        super(character, 25);
    }

    @Override
    public void cast(GameCharacter victim) throws IsDeadException, MagicWeaponNotEquippedException, InvalidStatValueException {
        if (!victim.checkIsAlive()){
            throw new IsDeadException();
        }
        if (!mage.getEquippedWeapon().isMagic()) {
            throw new MagicWeaponNotEquippedException();
        }

        int newMana = mage.getCurrentMp() -cost;
        mage.setCurrentMp(newMana);

        victim.setState(new ParalizedState(victim));
        
    }
}
