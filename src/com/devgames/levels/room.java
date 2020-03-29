package com.devgames.levels;
import com.devgames.characters.Player;
import com.devgames.characters.Monster;
import com.devgames.characters.Treasure;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


public class room extends JPanel// implements ActionListener
{
    BufferedImage Background;
    public platform[] Platforms;
    public Treasure[] treasures;
    public Monster[] Monsters;
   // private Timer timer;
   // private Player player;
    
    public room (String _backgroundPath, platform[] _platforms, Monster[] _Monsters, Treasure[] _treasures)
    {
        //Constructor for room objects
        Platforms = _platforms;
        Monsters = _Monsters;
        treasures = _treasures;     
        
        try
        {
            Background = ImageIO.read(getClass().getResource(_backgroundPath));
        }   catch (Exception ex) {System.err.println("Error loading level @" + _backgroundPath);}
    }
    
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        // Calls the paintComponent method on the superclass to initalise drawing
//        super.paintComponent(g);       
//        g.drawImage(Background, 0, 0, null);
//        Toolkit.getDefaultToolkit().sync();
//        
//        for(Monster m: Monsters)
//        {            
//            g.drawImage(m.Sprite, m.Position.getX(), m.Position.getY(), null);                    
//        }
//        for(Treasure t: treasures)
//        {
//            g.drawImage(t.Sprite, t.Position.getX(), t.Position.getY(), null);            
//        }
//        for(platform p: Platforms)
//        {
//            g.drawImage(p.Sprite, p.Position.getX(), p.Position.getY(), null);
//        }
//        
//        //g.drawImage(player.Sprite, , WIDTH, WIDTH, this)
//    }  
//    
//    @Override
//    public void actionPerformed(ActionEvent ae)
//    {   
//        //Stub to stop errors due to not having keypress detection set up yet.
//    }
//    
//    
//    private class TAdapter extends KeyAdapter
//    {
//        @Override
//        public void keyPressed(KeyEvent e)
//        {
//            int move = 0;
//            
//            switch (e.getKeyCode())
//            {
//                case KeyEvent.VK_UP:
//                    move = 1;
//                    break;
//                case KeyEvent.VK_DOWN:
//                    move = 2;
//                    break;
//                case KeyEvent.VK_LEFT:
//                    move = 3;
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    move = 4;
//                    break;
//            }
//            player.move(move);
//        }
//        
//        @Override
//        public void keyReleased(KeyEvent e)
//        {
//            player.stop();
//        }
//    }
}
