package net.bjohns.gone.test;

import java.util.ArrayList;
import java.util.List;
import net.bjohns.gone.util.Vector;

/**
 * Created by bjohns on 10/24/16.
 * <p>
 * roguelike
 */
public class Test
{
  private final int AMOUNT = 50, MAX = 4;
  int[] stats = new int[4];
  private List<Vector> segment = new ArrayList<>();

  public static void main(String[] args)
  {
    new Test().run();
  }

  public void run()
  {
    //for (int i = 0; i < AMOUNT; i++)
    //{
    //  System.out.println(i);
    //}

    //Player player = new Player();
    //Armor chest = new Armor(ItemDef.ArmorType.PLATE, ItemDef.ItemType.CHEST).createItem(5);
    //Armor legs = new Armor(ItemDef.ArmorType.PLATE, ItemDef.ItemType.LEGS).createItem(9);
    //Weapon weapon = new Weapon(ItemDef.ItemType.AXE, ItemDef.Effect.SLASH).createItem(2);
    //
    //System.out.println(player.debug());
    //System.out.println(player.itemLevel());
    //System.out.println();
    //player.getMobData().addToEquipment(chest, CHEST);
    //player.getMobData().addToEquipment(legs, LEGS);
    //player.getMobData().addToEquipment(weapon, WEAPON);
    //System.out.println(player.debug());
    //System.out.println(player.itemLevel());

    //        Food food = new Food(100);
    //        Potion potion = new Potion(10);
    //
    //        System.out.println(food);
    //        System.out.println(potion);
    //
    //        System.out.println();
    //
    //        Armor armor = new Armor(5);
    //        Weapon weapon = new Weapon(5);
    //        System.out.println(weapon);
    //        System.out.println(armor);
    //
    //        System.out.println();
    //
    //        for (int i = 0; i < 10; i++) {
    //            System.out.println(new Weapon(10));
    //        }

    System.out.println(stats.length);
  }
}
