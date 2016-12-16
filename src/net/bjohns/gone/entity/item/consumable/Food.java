package net.bjohns.gone.entity.item.consumable;

import net.bjohns.gone.entity.item.ItemDef;

/**
 * Created by bjohns on 11/3/16.
 * <p>
 * roguelike
 */
public class Food extends Consumable
{
  public Food(int ilvl)
  {
    super(ilvl);
    consumableType = ItemDef.ConsumableType.FOOD;
    tag = "Ham sandwich";
    info = "Looks tasty!";
    name = tag;
  }
}
