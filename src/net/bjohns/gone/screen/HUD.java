package net.bjohns.gone.screen;

import net.bjohns.gone.Constant;
import net.bjohns.gone.Gone;
import net.bjohns.gone.entity.item.Item;
import net.bjohns.gone.entity.mob.Player;
import net.bjohns.gone.util.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static net.bjohns.gone.util.Maths.isEven;

/**
 * Created by bjohns on 9/10/2016.
 *
 * Gone - GNU License
 */
public class HUD
{

    private static List<Message> message;
    private final int MAX_ITEMS_SHOWN = 5;
    public static boolean inventory;
    private Player player;
    private Vector vector;
    private int paneWidth, paneHeight;
    int index = 0;

    public HUD(Player player, Vector vector)
    {
        message = new ArrayList<>();
        this.player = player;
        this.vector = vector;
        inventory = false;
        paneWidth = 500;
        paneHeight = paneWidth / 5 * 4;
    }

    public static void addMessage(String msg)
    {
        if (message.size() < 10)
        {
            message.add(new Message(msg));
        }
    }

    public void draw(Graphics g)
    {
        for (Message m : message)
            m.update();
        resourceBar(g, 490, 50);
        stats(g, 490, 100);
        message(g, 490, 470);
        inventory(g, player.getInventory(), 60, 42);
    }

    private void resourceBar(Graphics g, int x, int y)
    {
        for (int i = 0; i < player.getHealth(); i += 5)
        {
            String healthToken;
            if (isEven(i))
            {
                healthToken = "{";
            } else
            {
                healthToken = "}";
            }
            g.drawString(healthToken, x + vector.x + (2) * i, y + vector.y);
        }
    }

    private void message(Graphics g, int x, int y)
    {
        for (int i = 0; i < message.size(); i++)
        {
            g.drawString(message.get(i).message, x + vector.x, y + vector.y + 19 * -i);
            if (message.get(i).remove)
            {
                message.remove(i);
            }
        }
    }

    private void inventory(Graphics g, List<Item> inventory, int x, int y)
    {
        /*
            make an inventory class
           2 different objects one with just player inventory
           and one with player inventory and npc inventory
         */
        if (HUD.inventory)
        {
            //  Item[] showItems = new Item[4];
            if (Gone.input.isKeyPressed('x'))
            {
                HUD.inventory = false;
            }
            if (Gone.input.isKeyPressed('s'))
            {
                index++;
                if (index >= inventory.size())
                {
                    index = inventory.size();
                }
            } else if (Gone.input.isKeyPressed('w'))
            {
                index--;
                if (index < 0)
                {
                    index = 0;
                }
            }
            g.setColor(Constant.BLACK);
            g.fillRect(vector.x + x, vector.y + y, paneWidth, paneHeight);
            g.setColor(Constant.WHITE);
            for (int i = 0; i < MAX_ITEMS_SHOWN; i++)
                g.drawString(inventory.get(index + i) + "", 30 + vector.x + x, 50 + vector.y + y + (20) * i);
        } else
        {
            if (Gone.input.isKeyPressed('x'))
            {
                HUD.inventory = true;
                index = 0;
                //  Collections.sort(inventory);
            }
        }
    }

    private void stats(Graphics g, int x, int y)
    {
        for (int i = 0; i < player.getStats().length; i++)
        {
            g.drawString(player.stats(i), x + vector.x, y + vector.y + (16) * i);
        }
    }

    private void debug()
    {
        if (Gone.input.isKeyPressed('z'))
        {
            player.takeDamage(5);
        } else if (Gone.input.isKeyPressed('x'))
        {
            player.giveHealth(5);
        }
    }
}
