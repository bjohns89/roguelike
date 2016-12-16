package net.bjohns.gone.screen.gamestate;

import java.awt.Graphics;

/**
 * Created by bjohns on 9/14/16.
 * <p>
 * roguelike - GNU License
 */
public class Screen
{
  public static View activeView = View.GAME;

  protected View view;

  public Screen(View view)
  {

  }

  public void update()
  {

  }

  public void draw(Graphics g)
  {

  }

  public enum View
  {
    START, DEAD, INV, SHOP, GAME
  }
}
