package net.bjohns.gone;

import net.bjohns.gone.util.Input;
import net.bjohns.gone.world.Overworld;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static net.bjohns.gone.Constant.NAME;
import static net.bjohns.gone.Constant.VERSION;

/**
 * Created by bjohns on 9/8/16.
 *
 * 0.4.0 -> HUD: 1:inspection,2:health-stats,3:use_from_inv/equip
 * 0.5.0 -> Entity: 1:pathfinding,2:fight,3:take_items,4:talk{quest}
 * 0.6.0 -> Dungeon generation: 1:have_faith ;)
 * 0.7.0 -> SaveFile: 1:save_world_load_into,2:bone_files
 */
public class RogueLike extends JPanel implements ActionListener
{

    public static Input input = new Input();
    private Font font = new Font("Verdana", Font.BOLD, 16);
    private Overworld overworld;

    public RogueLike()
    {
        int w = 600, h = w / 5 * 4;
        //setPreferredSize(new Dimension(w + 125, h - 40));
        setPreferredSize(new Dimension(w + 100, h));
        addKeyListener(input);
        Timer timer = new Timer(25, this);
        timer.start();
        setFocusable(true);
        overworld = new Overworld(128);
        // overworld.dump();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Constant.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setFont(font);
        overworld.draw(g);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame(NAME + VERSION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RogueLike());

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        input.update();
        repaint();
    }
}

