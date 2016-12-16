package net.bjohns.gone.screen.hud;

import java.awt.Graphics;
import net.bjohns.gone.Constant;
import net.bjohns.gone.RogueLike;
import net.bjohns.gone.entity.item.Item;
import net.bjohns.gone.entity.mob.Player;
import net.bjohns.gone.util.Vector;

/**
 * Created by bjohns on 9/14/16.
 * <p>
 * roguelike
 */
public class InventoryHUD
{
  private final int MAX_ITEMS = 18;
  private final String SELECTED = ">", USE = " [e]";

  private int index = 0;
  private int paneWidth, paneHeight;
  private Player player;
  private Vector vector;
  private DisplayItem[] itemView;

  public InventoryHUD(Player player, Vector vector)
  {
    this.player = player;
    this.vector = vector;
    itemView = new DisplayItem[18];
    paneWidth = 420;
    paneHeight = 600;
    updateDisplay();
  }

  public void draw(Graphics g)
  {
    if (index % itemView.length - 1 == 0)
    {
      //updateDisplay();
    }
    if (RogueLike.input.isKeyPressed('s'))
    {
      index++;
      if (index >= itemView.length)
      {
        index = itemView.length;
      }
      System.out.println(index);
    } else if (RogueLike.input.isKeyPressed('w'))
    {
      index--;
      if (index < 0)
      {
        index = 0;
      }
      System.out.println(index);
    }
    g.setColor(Constant.BLACK);
    g.fillRect(vector.x, vector.y, paneWidth, paneHeight);
    //drawBox(g, 0, 15, 16, 20);
    //drawBox(g, 240, 15, 16, 20);
    //drawBox(g, 0, 319, 31, 9);
    g.setColor(Constant.WHITE);

    for (int i = 0; i < itemView.length; i++)
    {
      if (itemView[i] != null)
      {
        if (index == i)
        {
          itemView[i].selectionString = SELECTED;
        } else
        {
          itemView[i].selectionString = "";
        }
        // if (itemView[i] != null)
        itemView[i].draw(g, new Vector(vector.x + 15, 30 + vector.y + (16) * i));
      }
    }
  }

  public void updateDisplay()
  {
    int newIndex = index;
    for (int i = 0; i < itemView.length; i++)
    {
        if (newIndex < player.getMobData().getInventory().size())
        {
            itemView[i] = new DisplayItem(player.getMobData().getInventory().get(newIndex));
        }
      newIndex++;
    }
  }

  //private void drawBox(Graphics g, int x, int y, int width, int height) {
  //  g.setColor(Constant.WHITE);
  //  for (int i = 0; i < height; i++) {
  //    for (int j = 0; j < width; j++) {
  //      if (i > 0 && i < height - 1 && j > 0 && j < width - 1) {
  //        g.drawString(" ", x + vector.x + 16 * j, y + vector.y + 16 * i);
  //      } else {
  //        g.drawString("+", x + vector.x + 16 * j, y + vector.y + 16 * i);
  //      }
  //    }
  //  }
  //}

  private class DisplayItem
  {
    private String selectionString, useString;
    private Item item;

    public DisplayItem(Item item)
    {
      this.item = item;
      selectionString = "";
      useString = "";
    }

    public void draw(Graphics g, Vector vector)
    {
      g.drawString(selectionString + item + useString, vector.x, vector.y);
    }
  }
}
