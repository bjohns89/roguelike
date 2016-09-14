package net.bjohns.gone.world;

import net.bjohns.gone.entity.Entity;
import net.bjohns.gone.entity.mob.Goblin;
import net.bjohns.gone.entity.mob.Mob;
import net.bjohns.gone.entity.mob.Player;
import net.bjohns.gone.screen.HUD;
import net.bjohns.gone.screen.Query;
import net.bjohns.gone.screen.Viewport;
import net.bjohns.gone.util.Maths;
import net.bjohns.gone.util.Vector;
import net.bjohns.gone.world.tile.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static net.bjohns.gone.Constant.ascii;

/**
 * Created by bjohns on 9/9/16.
 */
public class Overworld
{

    private Tile[][] overworld;

    private Player player;
    private List<Mob> mobs;
    private Viewport viewport;
    private HUD hud;

    public Overworld(int size)
    {
        overworld = new Tile[size][size];
        mobs = new ArrayList<>();
        player = new Player();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                overworld[j][i] = new Tile(Maths.random(3), new Vector());
            }
        }
        smooth();
        for (int m = 0; m < 20; m++)
        {
            int x = Maths.random(overworld.length - 1);
            int y = Maths.random(overworld[0].length - 1);
            mobs.add(new Goblin());
            overworld[y][x].setEntity(mobs.get(m));
        }
        //placeEntity(player);
        overworld[50][50].setEntity(player);
        viewport = new Viewport(this);
        hud = new HUD(player, new Vector());
    }

    public void update()
    {
        player.moveMob(this);
    }

    public void draw(Graphics g)
    {
        update();
        viewport.draw(g);
        hud.draw(g);
    }

    public void placeEntity(Mob mob)
    {
        int x = Maths.random(overworld[0].length - 1);
        int y = Maths.random(overworld.length - 1);
        while (overworld[x][y].isPassable())
        {
            x = Maths.random(overworld[0].length - 1);
            y = Maths.random(overworld.length - 1);
            System.out.println(overworld[x][y].isPassable());
        }
        overworld[x][y].setEntity(mob);
    }

    private void smooth()
    {
        Tile[][] smoothedWorld = overworld;

        for (int j = 0; j < overworld.length; j++)
        {
            for (int k = 0; k < overworld[0].length; k++)
            {
                int w = checkNeighbor(0, k, j);
                int g = checkNeighbor(1, k, j);
                int t = checkNeighbor(2, k, j);
                int m = checkNeighbor(3, k, j);

                if ((g + t + m) - 3 > w && overworld[k][j].getHeight() == 0)
                {
                    smoothedWorld[k][j].setHeight(1);
                }
                if (m <= 2 && overworld[k][j].getHeight() == 3)
                {
                    smoothedWorld[k][j].setHeight(1);
                }
                if (t > 3 && m < 3 && overworld[k][j].getHeight() != 2)
                {
                    smoothedWorld[k][j].setHeight(2);
                }
                if (m > 3 && overworld[k][j].getHeight() != 3)
                {
                    smoothedWorld[k][j].setHeight(3);
                }
            }
        }

        overworld = smoothedWorld;
    }

    private int checkNeighbor(int type, int x, int y)
    {
        int count = 0;

        for (int j = -1; j < 2; j++)
        {
            for (int k = -1; k < 2; k++)
            {
                int xx = x + k;
                int yy = y + j;

                if (inBounds(xx, yy))
                {
                    if (k != 0 || j != 0)
                    {
                        if (overworld[xx][yy].getHeight() == type)
                        {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean inBounds(int x, int y)
    {
        return (x >= 0 && x < overworld.length) && (y >= 0 && y < overworld[0].length);
    }

    public void dump()
    {
        for (int i = 0; i < overworld.length; i++)
        {
            for (int j = 0; j < overworld[0].length; j++)
            {
                System.out.print(ascii[overworld[j][i].getHeight()] + " ");
            }
            System.out.println();
        }
    }

    public Vector findEntity(Mob mob)
    {
        Vector vector = new Vector();
        for (int i = 0; i < overworld.length; i++)
        {
            for (int j = 0; j < overworld[0].length; j++)
            {
                if (overworld[i][j].getEntity() == mob)
                {
                    vector.x = i;
                    vector.y = j;
                }
            }
        }
        return vector;
    }

    public Vector findQuery(Query query)
    {
        Vector vector = new Vector();
        for (int i = 0; i < overworld.length; i++)
        {
            for (int j = 0; j < overworld[0].length; j++)
            {
                if (overworld[i][j].getQuery() == query)
                {
                    vector.x = i;
                    vector.y = j;
                }
            }
        }
        return vector;
    }

    public void moveEntity(Entity entity, int x, int y)
    {
        overworld[x][y].setEntity(entity);
    }

    public void moveQuery(Query query, int x, int y)
    {
        overworld[x][y].setQuery(query);
    }


    public Tile[][] getOverworld()
    {
        return overworld;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Viewport getViewport()
    {
        return viewport;
    }

    public HUD getHud()
    {
        return hud;
    }

    public List<Mob> getMobs()
    {
        return mobs;
    }
}
