package net.bjohns.gone.entity.mob;

import static net.bjohns.gone.Constant.ascii;

/**
 * Created by bjohns on 9/11/2016.
 */
public class Goblin extends Mob
{
    public Goblin()
    {
        health = 100;
        secondary = 100;
        icon = ascii[15];
        // inventory = new Item[4];
        // state = State.WANDER;
        tag = "goblin";
        info = "Green and curious.";
    }
}
