package net.bjohns.gone.entity.mob;

import net.bjohns.gone.entity.Entity;
import net.bjohns.gone.entity.item.consumable.Consumable;
import net.bjohns.gone.util.Maths;
import net.bjohns.gone.util.Vector;
import net.bjohns.gone.world.OverWorld;

/**
 * Created by bjohns on 9/10/16.
 */
public class Mob extends Entity
{
  public final int MAX_WEIGHT = 30;
  protected int currentHealth, maxHealth;
  protected double invWeight;
  protected State state;
  protected MobData mobData;

  public Mob()
  {
    mobData = new MobData(this);
    invWeight = 0.0d;
  }

  @Override
  public void update()
  {

  }

  public void moveMob(OverWorld world)
  {
    if (state == State.WANDER)
    {
      int dir = Maths.random(3);
      if (dir == 0)
      {
        movePlayerY(world, this, -1);
      } else if (dir == 1)
      {
        movePlayerY(world, this, 1);
      } else if (dir == 2)
      {
        movePlayerX(world, this, -1);
      } else if (dir == 3)
      {
        movePlayerX(world, this, 1);
      }
    }
  }

  public void search(int range)
  {

  }

  public void movePlayerX(OverWorld world, Mob mob, int dir)
  {
    Vector playerVec = world.findEntity(mob);
    if (playerVec.x + dir >= 0 && playerVec.x + dir <= world.getOverworld().length - 1)
    {
      if (world.getOverworld()[playerVec.x + dir][playerVec.y].isPassable())
      {
        world.moveEntity(mob, playerVec.x + dir, playerVec.y);
        world.getOverworld()[playerVec.x][playerVec.y].setEntity(null);
        world.getViewport().moveViewPort();
      }
      //System.out.println(playerVec + " " + dir);
    }
  }

  public void movePlayerY(OverWorld world, Mob mob, int dir)
  {
    Vector playerVec = world.findEntity(mob);
    if (playerVec.y + dir >= 0 && playerVec.y + dir <= world.getOverworld()[0].length - 1)
    {
      if (world.getOverworld()[playerVec.x][playerVec.y + dir].isPassable())
      {
        world.moveEntity(mob, playerVec.x, playerVec.y + dir);
        world.getOverworld()[playerVec.x][playerVec.y].setEntity(null);
        world.getViewport().moveViewPort();
      }
      // System.out.println(playerVec + " " + dir);
    }
  }

  public void takeDamage(int dmg)
  {
    if (currentHealth <= 0.0)
    {
      return;
    }
    currentHealth -= dmg;
  }

  public void giveHealth(int amount)
  {
    if (currentHealth >= maxHealth)
    {
      return;
    }
    currentHealth += amount;
  }

  public void giveHealth(Consumable consumable)
  {
    if (currentHealth >= maxHealth)
    {
      return;
    }
    currentHealth += consumable.getHealAmount();
  }

  public String toString()
  {
    return tag;
  }

  public int getCurrentHealth()
  {
    return currentHealth;
  }

  public int getMaxHealth()
  {
    return maxHealth;
  }

  public double getInvWeight()
  {
    return invWeight;
  }

  public State getState()
  {
    return state;
  }

  public MobData getMobData()
  {
    return mobData;
  }

  public enum State
  {
    WANDER, FIGHT, RUN
  }
}
