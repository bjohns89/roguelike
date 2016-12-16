package net.bjohns.gone.world;

import net.bjohns.gone.util.Vector;

/**
 * Created by bjohns on 9/13/16.
 */
public class Query
{
  private boolean canQuary = false;
  private String icon;

  public Query()
  {
    icon = "_";
  }

  public void moveQueryX(OverWorld world, int dir)
  {
    Vector playerVec = world.findQuery(this);
    if (playerVec.x + dir >= 0 && playerVec.x + dir <= world.getOverworld().length - 1)
    {
      // if (world.getOverworld()[playerVec.x + dir][playerVec.y].isPassable())
      {
        world.moveQuery(this, playerVec.x + dir, playerVec.y);
        world.getOverworld()[playerVec.x][playerVec.y].setQuery(null);
        //world.getViewport().moveViewPort();
      }
      // System.out.println(playerVec + " " + dir);
    }
  }

  public void moveQueryY(OverWorld world, int dir)
  {
    Vector playerVec = world.findQuery(this);
    if (playerVec.y + dir >= 0 && playerVec.y + dir <= world.getOverworld()[0].length - 1)
    {
      //  if (playerVec.y > playerVec.y + 10)
      {
        world.moveQuery(this, playerVec.x, playerVec.y + dir);
        world.getOverworld()[playerVec.x][playerVec.y].setQuery(null);
        //  world.getViewport().moveViewPort();
      }
      // System.out.println(playerVec + " " + dir);
    }
  }

  public boolean CanQuary()
  {
    return canQuary;
  }

  public void setCanQuary(boolean canQuary)
  {
    this.canQuary = canQuary;
  }

  public String getIcon()
  {
    return icon;
  }

  public void setIcon(String icon)
  {
    this.icon = icon;
  }
}
