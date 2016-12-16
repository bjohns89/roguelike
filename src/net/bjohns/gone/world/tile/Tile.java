package net.bjohns.gone.world.tile;

import java.awt.Color;
import net.bjohns.gone.Constant;
import net.bjohns.gone.entity.Entity;
import net.bjohns.gone.util.Vector;
import net.bjohns.gone.world.Query;

import static net.bjohns.gone.Constant.WHITE;

/**
 * Created by bjohns on 9/9/16.
 */
public class Tile
{

  private boolean passable, uncovered;
  private Vector vector;
  private String icon, tag;
  private Color color;
  private int height;
  private Entity entity;
  private Query query;

  public Tile(int height, Vector vector)
  {
    this.height = height;
    this.vector = vector;
    passable = true;
    entity = null;
    query = null;
    icon = "?";
    tag = "";
    color = WHITE;
  }

  public void update()
  {
    if (entity == null)
    {
      icon = Constant.ascii[height];
      if (height == 0)
      {
        passable = false;
        tag = "water";
      } else if (height == 1)
      {
        passable = true;
        tag = "ground";
      } else if (height == 2)
      {
        passable = true;
        tag = "tree";
      } else if (height == 3)
      {
        passable = false;
        tag = "rock";
      } else if (height == 4)
      {
        passable = false;
        tag = "wall";
      }
    } else
    {
      icon = entity.getIcon();
      passable = false;
    }
  }

  public boolean isPassable()
  {
    return passable;
  }

  public void setPassable(boolean passable)
  {
    this.passable = passable;
  }

  public String toString()
  {
    if (entity != null)
    {
      return /*"[ilevel" + entity.getItemLevel() +
                    "]" +*/ entity + "";
    }

    return tag;
  }

  public boolean isUncovered()
  {
    return uncovered;
  }

  public void setUncovered(boolean uncovered)
  {
    this.uncovered = uncovered;
  }

  public Vector getVector()
  {
    return vector;
  }

  public void setVector(Vector vector)
  {
    this.vector = vector;
  }

  public String getIcon()
  {
    return icon;
  }

  public void setIcon(String icon)
  {
    this.icon = icon;
  }

  public String getTag()
  {
    return tag;
  }

  public void setTag(String tag)
  {
    this.tag = tag;
  }

  public Color getColor()
  {
    return color;
  }

  public void setColor(Color color)
  {
    this.color = color;
  }

  public int getHeight()
  {
    return height;
  }

  public void setHeight(int height)
  {
    this.height = height;
  }

  public Entity getEntity()
  {
    return entity;
  }

  public void setEntity(Entity entity)
  {
    this.entity = entity;
  }

  public Query getQuery()
  {
    return query;
  }

  public void setQuery(Query query)
  {
    this.query = query;
  }
}
