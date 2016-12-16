package net.bjohns.gone.util;

/**
 * Created by bjohns on 9/13/16.
 */
public class Message
{
  public String message;
  public boolean remove;
  private long start;

  public Message(String message)
  {
    this.message = message;
    this.start = System.nanoTime();
  }

  public void update()
  {
    long current = System.nanoTime();
    if (current - start > Maths.milisToNano(10000))
    {
      start = current;
      remove = true;
    }
  }
}
