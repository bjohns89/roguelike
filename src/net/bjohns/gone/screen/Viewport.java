package net.bjohns.gone.screen;

import net.bjohns.gone.util.Vector;
import net.bjohns.gone.world.Overworld;
import net.bjohns.gone.world.tile.Tile;

import java.awt.*;

/**
 * Created by bjohns on 9/9/16.
 */
public class Viewport
{
    private final int MAX_W = 25, MAX_H = 25;
    private ScreenTile[][] viewport;
    private int x = 0, y = 0;
    private Overworld overworld;

    public Viewport(Overworld world)
    {
        overworld = world;
        viewport = new ScreenTile[MAX_H][MAX_W];
        moveViewPort();
    }

    public void draw(Graphics g)
    {
        for (int i = 0; i < viewport.length; i++)
        {
            for (int j = 0; j < viewport[0].length; j++)
            {
                viewport[j][i].draw(g);
            }
        }
    }

    public void moveViewPort()
    {
        int space = MAX_W / 2;
        Vector playerVec = overworld.findEntity(overworld.getPlayer());
        x = playerVec.x - space;
        y = playerVec.y - space;
        if (x < 0
                || x > overworld.getOverworld().length - MAX_W
                || y < 0
                || y > overworld.getOverworld()[0].length - MAX_H)
        {
            return;
        }
        for (int i = 0; i < viewport.length; i++)
        {
            for (int j = 0; j < viewport[0].length; j++)
            {
                viewport[i][j] = new ScreenTile(overworld.getOverworld()[x][y],
                        new Vector(6 + (19) * j, 15 + (19) * i));
                x++;
            }
            x = playerVec.x - space;
            y++;
        }
    }

    private class ScreenTile
    {

        private Tile tile;
        private Vector vector;

        public ScreenTile(Tile tile, Vector vector)
        {
            this.tile = tile;
            this.vector = vector;
        }

        void update()
        {
            tile.update();
        }

        void draw(Graphics g)
        {
            update();
            g.setColor(tile.getColor());
            g.drawString(tile.getIcon(), vector.x, vector.y);
            if (tile.getQuery() != null && tile.getQuery().CanQuary())
            {
                g.drawString(overworld.getPlayer().getQuery().getIcon(), vector.x, vector.y);
            }
        }
    }
}
