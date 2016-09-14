package net.bjohns.gone.screen;

import net.bjohns.gone.util.Maths;

/**
 * Created by bjohns on 9/13/16.
 *
 * Gone - GNU License
 */
public class Message
{
    public String message;
    public long start;
    public boolean remove;

    public Message(String message)
    {
        this.message = message;
        this.start = System.nanoTime();
    }

    public void update()
    {
        long current = System.nanoTime();
        if (current - start > Maths.milisToNano(5000))
        {
            start = current;
            remove = true;
        }
    }
}
