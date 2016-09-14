package net.bjohns.gone.entity.mob;

import net.bjohns.gone.entity.Entity;
import net.bjohns.gone.entity.item.Item;
import net.bjohns.gone.entity.item.equip.Equipment;
import net.bjohns.gone.entity.item.food.Food;
import net.bjohns.gone.util.Maths;
import net.bjohns.gone.util.Vector;
import net.bjohns.gone.world.Overworld;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjohns on 9/10/16.
 */
public class Mob extends Entity
{
    protected final int CHEST = 0, LEGS = 1, WEAPON = 3;
    protected int health, secondary;
    protected List<Item> inventory;
    protected Equipment[] equipment;
    protected State state;
    private Path path;

    public Mob()
    {
        inventory = new ArrayList<>();
        equipment = new Equipment[3];
        path = Maths.randomIndex(Path.WARRIOR, Path.MAGE, Path.ARCHER);
        if (path.tag.equals(Path.WARRIOR.tag))
        {
            setStats(1, 1, 1, 1, 1);
        } else if (path.tag.equals(Path.MAGE.tag))
        {
            setStats(1, 1, 1, 1, 1);
        } else if (path.tag.equals(Path.ARCHER.tag))
        {
            setStats(1, 1, 1, 1, 1);
        } else if (path.tag.equals(Path.BOSS.tag))
        {
            setStats(1, 1, 1, 1, 1);
        }
        itemLevel = itemLevel();
    }

    @Override
    public void update()
    {

    }

    public void moveMob(Overworld world)
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

    public void movePlayerX(Overworld world, Mob mob, int dir)
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

    public void movePlayerY(Overworld world, Mob mob, int dir)
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
        if (health <= 0.0)
        {
            return;
        }
        health -= dmg;
    }

    public void giveHealth(int hp)
    {
        if (health >= 100.0)
        {
            return;
        }
        health += hp;
    }

    public void giveHealth(Food food)
    {
        if (health >= 100.0)
        {
            return;
        }
        health += food.getHealing();
    }

    public void addEquipment(Equipment equipment)
    {

        itemLevel();
    }

    public int itemLevel()
    {
        int level = 0;

        for (Equipment e : equipment)
        {
            if (e != null)
            {
                level += e.getItemLevel();
            }
        }

        return level / equipment.length;
    }

    @Override
    public String toString()
    {
        return tag + " " + path.tag;
    }

    public boolean isAlive()
    {
        return health > 0;
    }

    public int getHealth()
    {
        return health;
    }

    public int getSecondary()
    {
        return secondary;
    }

    public List<Item> getInventory()
    {
        return inventory;
    }

    public enum State
    {
        WANDER, FIGHT, RUN
    }

    public enum Path
    {
        WARRIOR("warrior"), MAGE("mage"), ARCHER("rogue"), BOSS("boss");

        String tag;

        Path(String tag)
        {
            this.tag = tag;
        }

    }

    public State getState()
    {
        return state;
    }

    public Path getPath()
    {
        return path;
    }
}
