package net.bjohns.gone;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import net.bjohns.gone.screen.gamestate.GameScreen;
import net.bjohns.gone.screen.gamestate.Screen;
import net.bjohns.gone.util.Input;
import net.bjohns.gone.world.OverWorld;

import static net.bjohns.gone.Constant.NAME;
import static net.bjohns.gone.Constant.VERSION;

/**
 * Created by bjohns on 9/8/16.
 */
public class RogueLike extends JPanel implements ActionListener
{

  public static Input input = new Input();
  private Font font = new Font("Verdana", Font.BOLD, 16);
  private OverWorld overWorld;
  private GameScreen game;

  public RogueLike()
  {
    int w = 600, h = w / 5 * 4;
    //System.out.println(w + " " + h);
    setPreferredSize(new Dimension(w, h));
    addKeyListener(input);
    Timer timer = new Timer(25, this);
    timer.start();
    setFocusable(true);
    overWorld = new OverWorld(128);
    game = new GameScreen(overWorld, Screen.View.GAME);
    // overWorld.dump();
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

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    g.setColor(Constant.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());

    g.setFont(font);

    if (Screen.activeView.equals(Screen.View.GAME))
    {
      game.draw(g);
    }

    // overWorld.draw(g);
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    input.update();
    repaint();
  }
}

