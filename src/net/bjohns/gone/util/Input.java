package net.bjohns.gone.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjohns on 9/9/16.
 */
public class Input implements KeyListener
{
  public List<Keys> keyList = new ArrayList<>();

  public Input()
  {
    addKey('q');
    addKey('w');
    addKey('e');
    addKey('a');
    addKey('s');
    addKey('d');
    addKey('z');
    addKey('x');
    addKey('c');
  }

  public boolean isKeyPressed(char key)
  {
    for (Keys keyz : keyList)
    {
      if (key == keyz.keyEvent && keyz.pressed && keyz.presses < 2)
      {
        return true;
      }
    }
    return false;
  }

  public void addKey(char keyEvent)
  {
    keyList.add(new Keys(keyEvent));
  }

  @Override
  public void keyTyped(KeyEvent e)
  {

  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    for (Keys keycode : keyList)
    {
      if (e.getKeyChar() == keycode.keyEvent)
      {
        //System.out.println(keycode);
        keycode.pressed = true;
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    for (Keys keyCode : keyList)
    {
      keyCode.pressed = false;
      keyCode.presses = 0;
    }
  }

  public void update()
  {
    for (Keys keyCode : keyList)
    {
      if (keyCode.pressed)
      {
        keyCode.presses++;
      }
    }
  }

  private class Keys
  {
    public char keyEvent;
    public int presses;
    boolean pressed;

    public Keys(char keyEvent)
    {
      this.keyEvent = keyEvent;
      this.pressed = false;
      presses = 0;
    }

    public String toString()
    {
      return "Key:" + keyEvent + " Pressed:" + pressed + " Pressed:" + presses;
    }
  }
}
