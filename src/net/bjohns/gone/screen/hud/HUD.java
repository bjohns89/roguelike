package net.bjohns.gone.screen.hud;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import net.bjohns.gone.RogueLike;
import net.bjohns.gone.entity.mob.Player;
import net.bjohns.gone.util.Message;
import net.bjohns.gone.util.Vector;

/**
 * Created by bjohns on 9/10/2016.
 */
public class HUD
{

  public static boolean invActive = false;
  private static List<Message> message;
  private Player player;
  private Vector vector;
  private InventoryHUD inventoryHUD;

  public HUD(Player player, Vector vector)
  {
    message = new ArrayList<>();
    this.player = player;
    this.vector = vector;
    inventoryHUD = new InventoryHUD(this.player, vector);
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
    {
      m.update();
    }
    makeBar(g, 50, 420, 0);
    resourceBar(g, 438, 50);
    // stats(g, 438, 100);
    message(g, 438, 470);
    inventory(g);
  }

  private void resourceBar(Graphics g, int x, int y)
  {
    for (int i = 0; i < player.getCurrentHealth(); i += 5)
    {
      g.drawString("|", x + vector.x + (2) * i, y + vector.y);
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

  private void inventory(Graphics g)
  {
        /*
            make an inventoryHUD class
           2 different objects one with just player inventoryHUD
           and one with player inventoryHUD and npc inventoryHUD
         */
    if (invActive)
    {
      if (RogueLike.input.isKeyPressed('x'))
      {
        invActive = false;
      }
      inventoryHUD.draw(g);
    } else
    {
      if (RogueLike.input.isKeyPressed('x'))
      {
        invActive = true;
      }
    }
  }

  private void stats(Graphics g, int x, int y)
  {
    String[] stats = {player.min_stat(0) + "  " + player.min_stat(1),
        player.min_stat(2) + "  " + player.min_stat(3), player.min_stat(4) + "  "};

    for (int i = 0; i < stats.length; i++)
    {
      g.drawString(stats[i], x + vector.x, y + vector.y + (25) * i);
    }
  }

  private void makeBar(Graphics g, int length, int x, int y)
  {
    for (int i = 0; i < length; i++)
    {
      g.drawString("|", x + vector.x, y + vector.y + (25) * i);
    }
  }

  private void debug()
  {
    if (RogueLike.input.isKeyPressed('z'))
    {
      player.takeDamage(5);
    } else if (RogueLike.input.isKeyPressed('x'))
    {
      player.giveHealth(5);
    }
  }

  public InventoryHUD getInventoryHUD()
  {
    return inventoryHUD;
  }
}
