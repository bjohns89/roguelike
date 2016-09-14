package net.bjohns.gone.entity.item.equip.armor;

import net.bjohns.gone.entity.item.equip.Equipment;
import net.bjohns.gone.util.Maths;

import static net.bjohns.gone.Constant.ascii;

/**
 * Created by bjohns on 9/13/16.
 *
 * Gone - GNU License
 */
public class Armor extends Equipment
{
    private ArmorType armorType;
    private ItemType itemType;
    private int armor;

    public Armor(ArmorType armorType, ItemType itemType)
    {
        this.armorType = armorType;
        this.itemType = itemType;
        icon = ascii[8];
        info = armorType.tag + " " + itemType.tag;
    }

    public Armor()
    {
        this.armorType = Maths.randomIndex(ArmorType.values());
        this.itemType = Maths.randomIndex(ItemType.CHEST, ItemType.LEGS);
        icon = ascii[8];
        info = armorType.tag + " " + itemType.tag;
    }

    public Armor createItem(int level)
    {
        setItemLevel(level);

        int v = Maths.random(3);
        int g = Maths.random(3);
        int m = Maths.random(3);
        int b = Maths.random(3);
        int a = Maths.random(3);

        switch (armorType)
        {
            case CLOTH:
                setStats(v + level, g + level - 4, m + level + 2, b + level - 4, a + level - 2);
                break;
            case LEATHER:
                setStats(v + level, g + level + 2, m + level - 4, b + level - 4, a + level - 1);
                break;
            case PLATE:
                setStats(v + level, g + level - 4, m + level - 4, b + level + 2, a + level + 3);
        }

        return this;
    }

    public String toString()
    {
        return info + " [" + stats() + "]";
    }

    public ArmorType getArmorType()
    {
        return armorType;
    }

    public ItemType getItemType()
    {
        return itemType;
    }

    public int getArmor()
    {
        return armor;
    }
}
