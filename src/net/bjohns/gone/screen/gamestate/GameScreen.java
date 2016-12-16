package net.bjohns.gone.screen.gamestate;

import java.awt.Graphics;
import net.bjohns.gone.world.OverWorld;

/**
 * Created by bjohns on 9/14/16.
 * <p>
 * roguelike - GNU License
 */
public class GameScreen extends Screen
{
  private OverWorld world;

  public GameScreen(OverWorld world, View view)
  {
    super(view);
    this.world = world;
  }

  @Override
  public void draw(Graphics g)
  {
    world.draw(g);
  }
}
