package net.bjohns.gone.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjohns on 9/14/16.
 */
public class Keyz implements KeyListener
{
  private List<ActualKeys> keyList = new ArrayList<>();

  public Keyz()
  {
    addKey(KeyEvent.VK_Q);
    addKey(KeyEvent.VK_W);
    addKey(KeyEvent.VK_E);
    addKey(KeyEvent.VK_A);
    addKey(KeyEvent.VK_S);
    addKey(KeyEvent.VK_D);
    addKey(KeyEvent.VK_Z);
    addKey(KeyEvent.VK_X);
    addKey(KeyEvent.VK_C);
  }

  public boolean isKeyDown(int keyCode)
  {
    for (ActualKeys keys : keyList)
    {
      if (keys.pressed && keys.amount < 2)
      {
        return true;
      }
    }
    return false;
  }

  public void addKey(int keyCode)
  {
    keyList.add(new ActualKeys(keyCode));
  }

  @Override
  public void keyTyped(KeyEvent e)
  {

  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    for (ActualKeys keys : keyList)
    {
      if (e.getKeyCode() == keys.keyCode)
      {
        keys.pressed = true;
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    for (ActualKeys keys : keyList)
    {
      keys.pressed = false;
      keys.amount = 0;
    }
  }

  public void update()
  {
    for (ActualKeys keyCode : keyList)
    {
      if (keyCode.pressed)
      {
        keyCode.amount++;
      }
    }
  }

  private class ActualKeys
  {
    boolean pressed;
    int amount;
    int keyCode;

    public ActualKeys(int keyCode)
    {
      this.keyCode = keyCode;
      amount = 0;
      pressed = false;
    }
  }
}
