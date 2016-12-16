package net.bjohns.gone.entity.item.equip.weapon;

import net.bjohns.gone.entity.item.ItemDef;
import net.bjohns.gone.entity.item.equip.Equipment;
import net.bjohns.gone.util.Maths;

/**
 * Created by bjohns on 9/13/16.
 */
public class Weapon extends Equipment
{
  private int damage;

  public Weapon(int ilvl)
  {
    super(ilvl);
    itemTier = Maths.randomIndex(ItemDef.ItemTier.values());
    equipType = ItemDef.EquipType.WEAPON;
    name = itemTier.name + " " + equipType.name;
    damage = (ilvl + Maths.random(4)) * itemTier.baseDamage / 8;
    value = applyValue();
  }

  //    public String toString() {
  //        return itemTier.name + " " + equipType.name + " " + damage + " |" + value;
  //    }
}
