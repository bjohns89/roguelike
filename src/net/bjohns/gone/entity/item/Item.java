package net.bjohns.gone.entity.item;

import net.bjohns.gone.entity.Entity;

/**
 * Created by bjohns on 9/10/16.
 */
public class Item extends Entity
{
  public int value, weight, itemLevel;
  protected String name;

  public Item()
  {
    name = "Nothing.";
  }

  public int applyValue()
  {
    return itemLevel * 5;
  }

  @Override
  public void update()
  {

  }

  public String toString()
  {
    return name;
  }
}
