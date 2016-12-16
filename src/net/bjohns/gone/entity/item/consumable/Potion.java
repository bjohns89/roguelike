package net.bjohns.gone.entity.item.consumable;

import net.bjohns.gone.entity.item.ItemDef;

/**
 * Created by bjohns on 11/3/16.
 * <p>
 * roguelike
 */
public class Potion extends Consumable
{
  public Potion(int ilvl)
  {
    super(ilvl);
    consumableType = ItemDef.ConsumableType.ALCHEMICAL;
    tag = "Potion";
    info = "Bright red and murky.";
    name = tag;
  }
}
