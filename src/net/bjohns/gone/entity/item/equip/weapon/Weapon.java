package net.bjohns.gone.entity.item.equip.weapon;

import net.bjohns.gone.entity.item.equip.Equipment;
import net.bjohns.gone.util.Maths;

import static net.bjohns.gone.Constant.ascii;

/**
 * Created by bjohns on 9/13/16.
 */
public class Weapon extends Equipment
{
    private ItemType itemType;
    private Effect effect;
    private int damage;

    public Weapon(ItemType itemType, Effect effect)
    {
        this.itemType = itemType;
        this.effect = effect;
        icon = ascii[6];
        info = itemType.tag;
    }

    public Weapon()
    {
        itemType = Maths.randomIndex(ItemType.BOW, ItemType.STAFF, ItemType.AXE);
        effect = Maths.randomIndex(Effect.SHOOT, Effect.MAGIC, Effect.SLASH);
        icon = ascii[6];
        info = itemType.tag;
    }

    public Weapon createItem(int level)
    {
        setItemLevel(level);
        int v = Maths.random(3);
        int g = Maths.random(3);
        int m = Maths.random(3);
        int b = Maths.random(1, 5);

        switch (itemType)
        {
            case BOW:
                setStats(v + level, g + level, m + level, b + level, 0);
                damage = v + level;
                effect = Effect.SHOOT;
                break;
            case STAFF:
                setStats(v + level, g + level, m + level, b + level, 0);
                damage = v + level;
                effect = Effect.MAGIC;
                break;
            case AXE:
                setStats(v + level, g + level, m + level, b + level, 0);
                damage = v + level;
                effect = Effect.SLASH;
                break;
        }
        return this;
    }

    public String toString()
    {
        return info + "{dmg:" + damage + "} [" + stats() + "]";
    }

    public ItemType getItemType()
    {
        return itemType;
    }

    public Effect getEffect()
    {
        return effect;
    }
}
