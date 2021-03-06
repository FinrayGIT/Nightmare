package com.devgames.game;

import objects.Projectile;
import com.devgames.characters.Player;
import com.devgames.characters.Monster;
import objects.Treasure;
import objects.platform;
import objects.Vector;
import objects.room;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Toolkit;
import objects.ladder;



public class level extends JPanel implements ActionListener
{   
    Game game;
    boolean disablePlayer = false;
    public float GRAVITY = 0.1f;
    Vector spawnPos;
    public Player player;
    public room[] rooms;
    public ladder[] ladder;
    public room currentRoom;
    public int roomIndex = 0;
    public Timer timer;
    private InputController inputController;
    String direction;
    ArrayList<Projectile> Projectiles = new ArrayList<Projectile>();
    
    public void AddProjectile(int x, int y, boolean left, Projectile.eType _type, boolean _movedRightLast)
    {
        Vector pos = new Vector(x,y);
        if (_movedRightLast) {direction = "left";}
        else {direction = "right";}
        Projectile projectile = new Projectile(pos, "/Sprites/Graded/Weapons/Arrow" + direction + ".png");
        projectile.Fire(left, _type);
        Projectiles.add(projectile);
    }
    
    public void UpdateProjectiles()
    {
        for (int i = 0; i < Projectiles.toArray().length; i++)
        {
            Projectiles.get(i).Update();
            Projectile p = Projectiles.get(i);
            
            
            if (p.isAlive)
            {            
                for (int j = 0; j < currentRoom.platformColliders.length; j++)
                {
                    if (p.getBounds().intersects(currentRoom.platformColliders[j].rect.getBounds()))
                    {
                        p.Stop();
                    }
                }

                for (int j = 0; j < currentRoom.Monsters.length; j++)
                {
                    if ( currentRoom.Monsters[j].IsAlive() && p.getBounds().intersects((currentRoom.Monsters[j].hitbox.getBounds())))
                    {   
                        System.out.println("Arrow hit");
                        p.Stop();
                        currentRoom.Monsters[j].TakeDamage(p);
                    }
                }
                
                for (int j =0; j < currentRoom.Breakables.length; j++)
                {
                    if (currentRoom.Breakables[j].health > 0 
                            && p.type == Projectile.eType.FakeMelee
                            && p.getBounds().intersects(currentRoom.Breakables[j].rect.getBounds()))
                    {
                        System.out.println("WUT");
                        p.Stop();
                        p.isVisible = false;
                        currentRoom.Breakables[j].health -= 1;//p.damage/p.damage;
                    }
                }
                if (p.type == Projectile.eType.FakeMelee){
                    if (p.life<95){
                        p.Stop();
                        p.isVisible = false;
                    }
                }
            }
        }
    }
    
    public level (Game _game, Vector _spawnPos, room[] _rooms)
    {   
        //Constructer to create level objects.
        game = _game;
        rooms = _rooms;
        spawnPos = _spawnPos;
        player = new Player(_spawnPos, game);
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TAdapter());
        inputController = new InputController(this, _game);
        timer = new Timer(10, this);   
    }
    
   
    
    public void StartLevel()
    {
        Sound.play(getClass().getResourceAsStream("/Sounds/Music/BGM1.wav"), true);
        setVisible(true);
        requestFocus(true);
        repaint();
        timer.start();
    }
    
    public void EndLevel()
    {
        setVisible(false);
  //      timer.stop();
    }
    
    public void GoToRoom(room _room)
    {
        System.out.println("Go To Room Has Room : " + (_room!=null));
        if(currentRoom != null)
        {
            currentRoom.setVisible(false);
        }
        Projectiles.clear();
        //do previous room here, (previousroom = currentRoom)#todo
        currentRoom = _room;
        
        for (int i = 0; i < rooms.length; i++)
        {
            if (rooms[i] == _room)
            {
                roomIndex = i;
            }
        }
        
        currentRoom.requestFocus();
        currentRoom.setVisible(true);
        if (!disablePlayer && player !=null)
        {
            player.Position = spawnPos;
            player.Position.y = (player.Position.y - player.Sprite.getHeight());
        }
    }
    
    public void GoToRoom(int _index)
    {
        roomIndex = _index;
        GoToRoom(rooms[_index]);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {          
        //This function draws all required graphics in level.
        super.paintComponent(g);
        g.drawImage(currentRoom.Background,0,0,null);
        
        if (currentRoom.doors != null)
        {
            for(Detector d: currentRoom.doors)
            {
                g.drawImage(d.Sprites[0], d.rect.x, d.rect.y, null);
            }
        }
        
        for(Monster m: currentRoom.Monsters)
        {    
            if(m.isVisible)
            {
                g.drawImage(m.GetFrame(), (int)m.Position.x, (int)m.Position.y, null);
                //g.drawImage(m.colSprite, (int)m.hitbox.x, (int)m.hitbox.y, null);
            }
        }
        
        for(Treasure t: currentRoom.treasures)
        {
           if (t.isVisible){
            g.drawImage(t.Sprite, (int)t.Position.x, (int)t.Position.y, null);           
        }
        }
        
//        for(platform p: currentRoom.Platforms)
//        {
//            g.drawImage(p.Sprite, (int)p.Position.x, (int)p.Position.y, null);
//        }
        
        for (int i = 0; i < Projectiles.toArray().length; i++)
        {
            Projectile a = Projectiles.get(i);
            if (a.isVisible && a.type != Projectile.eType.FakeMelee)
            {            
                g.drawImage(a.Sprite, (int)a.Position.x, (int)a.Position.y, null);
            }
        }
        
        if (currentRoom.Breakables !=null)
        {
            for (Detector b: currentRoom.Breakables)
            {
                if (b.health > 0)
                {
                    g.drawImage(b.Sprites[4-b.health], b.rect.x, b.rect.y, null);
                }
            }    
            
        }
    
        //Draw ladders (for testing)
//      for(ladder l: currentRoom.Ladders)
//      {
//          g.drawImage(l.Sprite, (int)l.Position.x, (int)l.Position.y, null);
//      }
        
        if (!disablePlayer && player !=null){player.draw(g);}
        g.dispose();        
        Toolkit.getDefaultToolkit().sync();            
    }
    
    //@Override
    public void actionPerformed(ActionEvent ae)
    {  
        //Once input it detected, updates and redraws scene.        
        if (!disablePlayer && player !=null){player.UpdatePlayer();}
        inputController.updateInput();
        UpdateProjectiles();
        UpdateMonsters();
        Toolkit.getDefaultToolkit().sync();
        repaint();
    }
    
    void UpdateMonsters(){
        
        for(Monster m: currentRoom.Monsters)
        {    
            m.Updatemonster();
        }
    }
    
    
    private class TAdapter extends KeyAdapter
    {
        //This function listens for inputs and performs their respective
        //function once detected in inputController.updateInput() through
        //level.actionPerformed().
        @Override
        public void keyPressed(KeyEvent e)
        {
            inputController.CheckKeyPress(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e)
        {
            inputController.CheckKeyRelease(e);
        }
    }
}
