package net.bjohns.gone.entity.mob;

import java.util.ArrayList;
import java.util.List;
import net.bjohns.gone.entity.item.Item;
import net.bjohns.gone.entity.item.equip.Equipment;
import net.bjohns.gone.screen.hud.HUD;

import static net.bjohns.gone.entity.Entity.ARMOR;
import static net.bjohns.gone.entity.Entity.BRAWN;
import static net.bjohns.gone.entity.Entity.GUILE;
import static net.bjohns.gone.entity.Entity.MIND;
import static net.bjohns.gone.entity.Entity.VITALITY;

/**
 * Created by bjohns on 9/18/16.
 * <p>
 * roguelike
 */
public class MobData
{
  public static final int CHEST = 0, LEGS = 1, WEAPON = 2;
  private List<Item> inventory;
  private Equipment[] equipment;
  private Mob mob;

  public MobData(Mob mob)
  {
    this.mob = mob;
    inventory = new ArrayList<>();
    equipment = new Equipment[3];
  }

  public int gearScore()
  {
    int total = 0;
    for (int i = 0; i < equipment.length; i++)
    {
      total += equipment[i].itemLevel;
    }
    return total / equipment.length;
  }

  public void addToInventory(Item item)
  {
    if (mob.invWeight + item.weight <= mob.MAX_WEIGHT)
    {
      inventory.add(item);
    } else
    {
      HUD.addMessage("Can't carry anymore things.");
    }
  }

  public void addToEquipment(Equipment equipment, int slot)
  {
    this.equipment[slot] = equipment;
    updateStats(equipment, true);
    gearScore();
  }

  public void removeFromEquipment(Equipment equipment, int slot)
  {
    updateStats(equipment, false);
    this.equipment[slot] = null;
    gearScore();
  }

  private void updateStats(Equipment equipment, boolean addingEquipment)
  {
    if (addingEquipment)
    {
      mob.getStats()[VITALITY] += equipment.getStats()[VITALITY];
      mob.getStats()[GUILE] += equipment.getStats()[GUILE];
      mob.getStats()[MIND] += equipment.getStats()[MIND];
      mob.getStats()[BRAWN] += equipment.getStats()[BRAWN];
      mob.getStats()[ARMOR] += equipment.getStats()[ARMOR];
    } else
    {
      mob.getStats()[VITALITY] -= equipment.getStats()[VITALITY];
      mob.getStats()[GUILE] -= equipment.getStats()[GUILE];
      mob.getStats()[MIND] -= equipment.getStats()[MIND];
      mob.getStats()[BRAWN] -= equipment.getStats()[BRAWN];
      mob.getStats()[ARMOR] -= equipment.getStats()[ARMOR];
    }
  }

  public List<Item> getInventory()
  {
    return inventory;
  }

  public Equipment[] getEquipment()
  {
    return equipment;
  }
}
