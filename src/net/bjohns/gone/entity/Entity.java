package net.bjohns.gone.entity;

import java.awt.*;

/**
 * Created by bjohns on 9/9/16.
 */
public abstract class Entity
{
    public static final int VITALITY = 0, GUILE = 1, MIND = 2, BRAWN = 3, ARMOR = 4;

    protected int stats[] = {0, 0, 0, 0, 0};
    protected int itemLevel;
    protected String icon, tag, info;
    protected Color color;
    protected boolean passable;

    public abstract void update();

    public String stats(int index)
    {
        switch (index)
        {
            case 0:
                return "Vitality:" + stats[0];
            case 1:
                return "Guile:" + stats[1];
            case 2:
                return "Mind:" + stats[2];
            case 3:
                return "Brawn:" + stats[3];
            case 4:
                return "Armor:" + stats[4];
        }

        return "!!BUG!!";
    }

    public String stats()
    {
        return "vitality:"
                + stats[VITALITY]
                + " guile:" + stats[GUILE]
                + " mind:" + stats[MIND]
                + " brawn:" + stats[BRAWN]
                + " armor:" + stats[ARMOR];
    }

    public void setStats(int v, int g, int m, int b, int a)
    {
        stats[VITALITY] = v;
        stats[GUILE] = g;
        stats[MIND] = m;
        stats[BRAWN] = b;
        stats[ARMOR] = a;
    }

    public int[] getStats()
    {
        return stats;
    }

    public void setStats(int[] stats)
    {
        this.stats = stats;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public boolean isPassable()
    {
        return passable;
    }

    public void setPassable(boolean passable)
    {
        this.passable = passable;
    }

    public int getItemLevel()
    {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel)
    {
        this.itemLevel = itemLevel;
    }
}
