package net.bjohns.gone.entity.item.equip.armor;

import net.bjohns.gone.entity.item.ItemDef;
import net.bjohns.gone.entity.item.equip.Equipment;
import net.bjohns.gone.util.Maths;

/**
 * Created by bjohns on 9/13/16.
 */
public class Armor extends Equipment
{

  public Armor(int ilvl)
  {
    super(ilvl);

    itemTier = Maths.randomIndex(ItemDef.ItemTier.values());
    equipType =
        Maths.randomIndex(ItemDef.EquipType.CHEST, ItemDef.EquipType.LEGS);
    name = itemTier.name + " " + equipType.name;
    super.applyValue();
    stats[VITALITY] = (ilvl + Maths.random(4)) + itemTier.tier;
    stats[GUILE] = (ilvl + Maths.random(4)) + itemTier.tier;
    stats[MIND] = (ilvl + Maths.random(4)) + itemTier.tier;
    stats[BRAWN] = (ilvl + Maths.random(4)) + itemTier.tier;
    stats[ARMOR] = (ilvl + Maths.random(4)) + itemTier.tier;
  }

  //    public String toString() {
  //        return "Name:" + itemTier.name + " " + equipType.name + " " + stats();
  //    }
}
