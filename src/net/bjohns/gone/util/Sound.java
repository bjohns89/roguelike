package net.bjohns.gone.util;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 * Created by bjohns on 9/13/16.
 *
 * Gone - GNU License
 */
public class Sound
{
    public static Sound attackOne = new Sound("/sound/attack_1.wav");
    public static Sound attackTwo = new Sound("/sound/attack_2.wav");
    public static Sound explosion = new Sound("/sound/explosion.wav");
    public static Sound select = new Sound("/sound/select.wav");

    private AudioClip clip;

    private Sound(String name)
    {
        try
        {
            clip = Applet.newAudioClip(Sound.class.getResource(name));
        } catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    public void play()
    {
        try
        {
            new Thread()
            {
                public void run()
                {
                    clip.play();
                }
            }.start();
        } catch (Throwable e)
        {
            e.printStackTrace();
        }
    }
}
