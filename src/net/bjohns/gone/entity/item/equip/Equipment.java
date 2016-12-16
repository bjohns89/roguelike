package net.bjohns.gone.entity.item.equip;

import net.bjohns.gone.entity.item.Item;
import net.bjohns.gone.entity.item.ItemDef;

/**
 * Created by bjohns on 9/14/16.
 */
public class Equipment extends Item
{
  protected ItemDef.EquipType equipType;
  protected ItemDef.ItemTier itemTier;

  public Equipment(int ilvl)
  {
    itemLevel = ilvl;
    // applyValue();
  }

  public int applyValue()
  {
    return super.applyValue() * itemTier.tier;
  }
}
