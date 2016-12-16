package net.bjohns.gone.util;

/**
 * Created by bjohns on 9/9/16.
 */
public class Vector
{
  public int x, y;

  public Vector(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public Vector()
  {
    this(0, 0);
  }

  public String toString()
  {
    return "[" + x + "," + y + "]";
  }
}
