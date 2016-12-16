package net.bjohns.gone.entity.mob;

import net.bjohns.gone.RogueLike;
import net.bjohns.gone.entity.item.consumable.Potion;
import net.bjohns.gone.entity.item.equip.armor.Armor;
import net.bjohns.gone.screen.hud.HUD;
import net.bjohns.gone.util.Vector;
import net.bjohns.gone.world.OverWorld;
import net.bjohns.gone.world.Query;

import static net.bjohns.gone.Constant.ascii;

/**
 * Created by bjohns on 9/10/16.
 */
public class Player extends Mob
{
  private Query query = new Query();

  public Player()
  {
    currentHealth = 100;
    icon = ascii[4];
    tag = "player";
    info = "Foolhardy and impatient.";
    //Testing inventory
    mobData.addToInventory(new Potion(5));
    mobData.addToInventory(new Potion(5));
    mobData.addToInventory(new Potion(5));
    mobData.addToInventory(new Potion(5));
    mobData.addToInventory(new Armor(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
    //        mobData.addToInventory(new Potion(5));
  }

  @Override
  public void moveMob(OverWorld world)
  {
    boolean moveWorld = false;

    if (!HUD.invActive)
    {
      if (query.CanQuary())
      {
        if (RogueLike.input.isKeyPressed('c'))
        {
          query.setCanQuary(false);
          Vector v = world.findQuery(query);
          world.getOverworld()[v.x][v.y].setQuery(null);
        } else if (RogueLike.input.isKeyPressed('e'))
        {
          Vector v = world.findQuery(query);
          HUD.addMessage(world.getOverworld()[v.x][v.y] + "");
          System.out.println(world.getOverworld()[v.x][v.y]);
        }

        if (RogueLike.input.isKeyPressed('d'))
        {
          query.moveQueryX(world, 1);
        } else if (RogueLike.input.isKeyPressed('a'))
        {
          query.moveQueryX(world, -1);
        } else if (RogueLike.input.isKeyPressed('w'))
        {
          query.moveQueryY(world, -1);
        } else if (RogueLike.input.isKeyPressed('s'))
        {
          query.moveQueryY(world, 1);
        }
      } else
      {

        if (RogueLike.input.isKeyPressed('d'))
        {
          movePlayerX(world, world.getPlayer(), 1);
          moveWorld = true;
        } else if (RogueLike.input.isKeyPressed('a'))
        {
          movePlayerX(world, world.getPlayer(), -1);
          moveWorld = true;
        } else if (RogueLike.input.isKeyPressed('w'))
        {
          movePlayerY(world, world.getPlayer(), -1);
          moveWorld = true;
        } else if (RogueLike.input.isKeyPressed('s'))
        {
          movePlayerY(world, world.getPlayer(), 1);
          moveWorld = true;
        } else if (RogueLike.input.isKeyPressed('c'))
        {
          query.setCanQuary(true);
          Vector quaryVec = world.findQuery(query);
          Vector playerVec = world.findEntity(world.getPlayer());
          world.getOverworld()[playerVec.x][playerVec.y].setQuery(query);
          System.out.println(quaryVec);
        }

        if (moveWorld)
        {
          for (Mob m : world.getMobs())
          {
            m.moveMob(world);
          }
        }
      }
    }
  }

  public Query getQuery()
  {
    return query;
  }
}