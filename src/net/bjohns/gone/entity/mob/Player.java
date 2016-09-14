package net.bjohns.gone.entity.mob;

import net.bjohns.gone.Gone;
import net.bjohns.gone.entity.item.equip.armor.Armor;
import net.bjohns.gone.entity.item.equip.weapon.Weapon;
import net.bjohns.gone.entity.item.food.Food;
import net.bjohns.gone.screen.HUD;
import net.bjohns.gone.screen.Query;
import net.bjohns.gone.util.Vector;
import net.bjohns.gone.world.Overworld;

import static net.bjohns.gone.Constant.ascii;

/**
 * Created by bjohns on 9/10/16.
 */
public class Player extends Mob
{
    private Query query = new Query();

    public Player()
    {
        health = 100;
        secondary = 100;
        icon = ascii[4];
        tag = "player";
        info = "Foolhardy and impatient.";
        inventory.add(new Food().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Food().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Weapon().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Armor().createItem(5));
        inventory.add(new Food().createItem(5));
    }

    @Override
    public void moveMob(Overworld world)
    {
        boolean moveWorld = false;

        if (!HUD.inventory)
        {
            if (query.CanQuary())
            {
                if (Gone.input.isKeyPressed('c'))
                {
                    query.setCanQuary(false);
                    Vector v = world.findQuery(query);
                    world.getOverworld()[v.x][v.y].setQuery(null);
                } else if (Gone.input.isKeyPressed('e'))
                {
                    Vector v = world.findQuery(query);
                    HUD.addMessage(world.getOverworld()[v.x][v.y] + "");
                    System.out.println(world.getOverworld()[v.x][v.y]);
                }

                if (Gone.input.isKeyPressed('d'))
                {
                    query.moveQueryX(world, 1);
                } else if (Gone.input.isKeyPressed('a'))
                {
                    query.moveQueryX(world, -1);
                } else if (Gone.input.isKeyPressed('w'))
                {
                    query.moveQueryY(world, -1);
                } else if (Gone.input.isKeyPressed('s'))
                {
                    query.moveQueryY(world, 1);
                }

            } else
            {

                if (Gone.input.isKeyPressed('d'))
                {
                    movePlayerX(world, world.getPlayer(), 1);
                    moveWorld = true;
                } else if (Gone.input.isKeyPressed('a'))
                {
                    movePlayerX(world, world.getPlayer(), -1);
                    moveWorld = true;
                } else if (Gone.input.isKeyPressed('w'))
                {
                    movePlayerY(world, world.getPlayer(), -1);
                    moveWorld = true;
                } else if (Gone.input.isKeyPressed('s'))
                {
                    movePlayerY(world, world.getPlayer(), 1);
                    moveWorld = true;
                } else if (Gone.input.isKeyPressed('c'))
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