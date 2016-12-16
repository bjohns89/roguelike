package net.bjohns.gone.entity.item.consumable;

import net.bjohns.gone.entity.item.Item;
import net.bjohns.gone.entity.item.ItemDef;
import net.bjohns.gone.util.Maths;

/**
 * Created by bjohns on 9/13/16.
 */
public class Consumable extends Item
{
  protected int healAmount;
  protected ItemDef.ConsumableType consumableType;

  public Consumable(int ilvl)
  {
    itemLevel = ilvl;
    value = applyValue();
    healAmount = (ilvl + 1) * 2 + Maths.random(4);
  }

  //    public String toString() {
  //        return "Name:"
  //                + tag
  //                + " info:"
  //                + info
  //                + " ilvl"
  //                + itemLevel
  //                + " amount:"
  //                + healAmount
  //                + " value:"
  //                + value;
  //    }

  public int getHealAmount()
  {
    return healAmount;
  }

  public ItemDef.ConsumableType getConsumableType()
  {
    return consumableType;
  }
}
