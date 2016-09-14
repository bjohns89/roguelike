package net.bjohns.gone.entity.item;

import net.bjohns.gone.entity.Entity;

/**
 * Created by bjohns on 9/10/16.
 */
public class Item extends Entity implements Comparable<Item>, ItemDef
{
    public Item createItem(int itemlevel)
    {
        return this;
    }

    @Override
    public void update()
    {

    }

    @Override
    public int compareTo(Item o)
    {
        return tag.compareTo(o.tag);
    }

}
