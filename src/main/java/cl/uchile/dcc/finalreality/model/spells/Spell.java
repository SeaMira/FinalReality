package cl.uchile.dcc.finalreality.model.spells;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.IsDeadException;
import cl.uchile.dcc.finalreality.exceptions.MagicWeaponNotEquippedException;
import cl.uchile.dcc.finalreality.exceptions.NoManaLeftException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.MagicCharacter;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

public abstract class Spell {
    protected MagicCharacter mage;
    protected int cost;
    public Spell(MagicCharacter mage, int cost) {
        this.mage = mage;
        this.cost = cost;
    }

    public abstract void cast(GameCharacter victim) throws IsDeadException, MagicWeaponNotEquippedException, InvalidStatValueException;
}
