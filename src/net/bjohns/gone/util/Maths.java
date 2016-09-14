package net.bjohns.gone.util;

import java.util.Random;

/**
 * Created by bjohns on 9/9/16.
 */
public class Maths
{

    public static final long nano = 1000000;
    private static Random random = new Random();

    public static int random(int min, int max)
    {
        return min + random.nextInt(max - min + 1);
    }

    public static int random(int max)
    {
        return random.nextInt(max + 1);
    }

    @SafeVarargs
    public static <T> T randomIndex(T... ary)
    {
        return ary[random(ary.length - 1)];
    }

    public static boolean isEven(int i)
    {
        return i % 2 == 0;
    }

    public static long milisToNano(long mili)
    {
        return mili * nano;
    }
}
