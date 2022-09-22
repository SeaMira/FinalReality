package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A MagicCharacter is a {@link AbstractPlayerCharacter} that can equip {@code Staff}s and use <i>magic</i> "paying" with magic mana points .
 *
 * @author ~Sebastian Mira~
 * @version 2.0
 */
public abstract class MagicCharacter extends AbstractPlayerCharacter{
    protected int currentMp;
    protected final int maxMp;

    /**
     * Creates a new Magic Character.
     *
     * @param name
     *     the character's name
     * @param maxHp
     *     the character's max hp
     * @param defense
     *     the character's defense
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     * @param maxMp
     *     the maximum amount of mana the character can have
     */
    protected MagicCharacter(final @NotNull String name, final int maxHp, final int defense,
                             int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
            throws InvalidStatValueException  {
        super(name, maxHp, defense, turnsQueue);
        Require.statValueAtLeast(0, maxMp, "Max MP");
        this.maxMp = maxMp;
        this.currentMp = maxMp;
    }

}
