package com.devgames.game;

import com.devgames.game.screens.StartGamePanel;
import com.devgames.characters.Monster;
import objects.Treasure;
import objects.Vector;
import objects.platform;
import objects.room;
import objects.ladder;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

public class Game 
{   
    public static final int WINDOW_WIDTH = 1920; 
    public static final int WINDOW_HEIGHT = 1080;
    JFrame gameWindow;    
    StartGamePanel startScreen; 
    //EndGamePanel endScreen;
    
    public level CurrentLevel;
    public int LevelIndex = 0;
    
    public static boolean levelReady = false;

    public Game()
    {   
        initWindow();
        initScreens();        
    }

    // <editor-fold desc="LEVEL ARRAY CONSTRUCTOR">
    
    public level[] levels =  
    {   
        //This constructor creates levels, which have rooms inside them, which
        //have platforms, monsters and treasure inside them. Objects inside 
        //level are created extending the baseLevelObject class.
    
    // <editor-fold desc="LEVEL 0">
        
    //Level 0
    new level
    (
        this,
        new Vector(0,0),
        new room[]
        { 
                
    // <editor-fold desc="ROOM 0">
                
        //Level 0 Room 0
          
            new room("/levels/level0/room0/room0.png",                
//            new platform[]
//            {   
////                new platform(new Vector (0,915), "/levels/level0/room0/room0platform0.png"),
////                new platform(new Vector (986,777), "/levels/level0/room0/room0platform1.png"),
////                new platform(new Vector (1241,661), "/levels/level0/room0/room0platform2.png"), 
////                new platform(new Vector (1477,262), "/levels/level0/room0/room0platform3.png")
//
//            },     

            new Monster[]
            {
                new Monster(new Vector(800, 800), Monster.eElement.earth, Monster.eMonsterType.orc)
            },

            new Treasure[]
            {
                //new Treasure(new Vector(0,0), "")
            },

            new ladder[]
            {
                new ladder(new Vector (1695, 640), "/levels/level0/room1/room1ladder0.png")
            },

            //RoomTransitions
            new Detector[]
            { 
                new Detector 
                (   
                    new Rectangle (1920, 0, 5, 1080),   /*Bounds of trigger*/ 
                    0, 1,                               /*Level & room target*/
                    new Vector(20, 620)                /*Player spawn point*/
                ),
                new Detector(   new Rectangle(800, 1080, 200, 1),  //Bounds of trigger
                                0, 4,                           //Level & Room target
                                new Vector (860, 0)          //Spawn point
                            ),
                new Detector(   new Rectangle(1100, 1080, 200, 1),  //Bounds of trigger
                                0, 4,                           //Level & Room target
                                new Vector (1200, 0)          //Spawn point
                            )

            },
                 
            //PlatformCols
            new Detector[]
            {
                new Detector(new Rectangle(-100, 915, 920, 20)),
                new Detector(new Rectangle(995, 785, 100, 300)),
                new Detector(new Rectangle(1265, 775, 700, 20)),
                new Detector(new Rectangle(1480, 248, 540, 20)),
                new Detector(new Rectangle(-19, -19, 20, 1080))
            },
            
            //Wind
            new Detector[]
            {
                
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
            ),
            
        
                
// </editor-fold> 
    // <editor-fold desc="ROOM 1"> 
                
            //Level 0 Room 1
            new room("/levels/level0/room1/room1.png",
//            new platform[]
//            {
//                new platform(new Vector (0,781), "/levels/level0/room1/room1platform0.png"),
//                new platform(new Vector (368,845), "/levels/level0/room1/room1platform1.png"),
//                new platform(new Vector (1521,633), "/levels/level0/room1/room1platform2.png"),
//            },

            new Monster[]
            {
                //new Monster(new Vector (520, 680), "Earth", "normalorc", 18)
            },

            new Treasure[]
            {

            },

            new ladder[]
            {   
//                new ladder(new Vector (1695, 640), "/levels/level0/room1/room1ladder0.png")
                new ladder(new Vector (1695, 628), "/levels/level0/room1/room1ladder0.png")
            },

            //RoomTransitions
            new Detector[]
            { 
                new Detector(   new Rectangle(1920, 525, 5, 131),  //Bounds of trigger
                                0, 2,                           //Level & Room target
                                new Vector (40, 600)          //Spawn point
                            ),
                new Detector(   new Rectangle(1920, 655, 1, 178),  //Bounds of trigger
                                0, 2,                           //Level & Room target
                                new Vector (40, 800)          //Spawn point
                            )
            },
              
            //Platform Colliders
            new Detector[]
            {
                new Detector((new Rectangle(0, 805, 240, 20))),   
                new Detector((new Rectangle(368, 860, 315, 20))),
                new Detector((new Rectangle(1560, 840, 360, 20))),
                new Detector((new Rectangle(1650, 655, 270, 5))),
            },
                    
            //Wind
            new Detector[]
            {
                new Detector((new Rectangle(960, 680, 370, 400)), 5)                
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }),
                
// </editor-fold> 
    // <editor-fold desc="ROOM 2">
                
            //Level 0 Room 2
            new room("/levels/level0/room2/room2.png",
//            new platform[]
//            {
//                new platform(new Vector (0,640), "/levels/level0/room2/room2platform0.png"),
//                new platform(new Vector (1194,972), "/levels/level0/room2/room2platform1.png"),
//                new platform(new Vector (1530,1038), "/levels/level0/room2/room2platform2.png"),
//                new platform(new Vector (1722,780), "/levels/level0/room2/room2platform3.png")
//            },

            new Monster[]
            {

            },

            new Treasure[]
            {

            },

            new ladder[]
            {
                new ladder(new Vector (1730, 790), "/levels/level0/room2/room2ladder0.png")
            },

            //RoomTransitions
            new Detector[]
            { 
                new Detector(   new Rectangle(0, 780, 1, 287),  //Bounds of trigger
                                0, 1,                           //Level & Room target
                                new Vector (1880, 600)          //Spawn point
                            ),
                new Detector(   new Rectangle(0, 655, 1, 240),  //Bounds of trigger
                                0, 1,                           //Level & Room target
                                new Vector (1880, 800)          //Spawn point
                            ),
                new Detector(   new Rectangle(890, 1080, 640, 1),  //Bounds of trigger
                                0, 6,                           //Level & Room target
                                new Vector (1250, 0)          //Spawn point
                            ),
                new Detector(   new Rectangle(1600, 1080, 320, 1),  //Bounds of trigger
                                0, 6,                           //Level & Room target
                                new Vector (1730, 0)          //Spawn point
                            )
            },
              
            //Platform Colliders
            new Detector[]
            {
                new Detector((new Rectangle(-20, 655, 120, 20))),
                new Detector((new Rectangle(-20, 865, 1040, 20))),
                new Detector((new Rectangle(1195, 1020, 170, 20))),
                new Detector((new Rectangle(1530, 1035, 70, 20))),
                new Detector((new Rectangle(1730, 800, 290, 20))),
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }),
                
// </editor-fold> 
    // <editor-fold desc="ROOM 3">
                
            //Level 0 Room 3
            new room("/levels/level0/room3/room3-np.png",
//            new platform[]
//            {
//                new platform(new Vector (0,737), "/levels/level0/room3/room3platform0.png"),
//                new platform(new Vector (357,881), "/levels/level0/room3/room3platform1.png"),
//                new platform(new Vector (552,995), "/levels/level0/room3/room3platform2.png"),
//                new platform(new Vector (842,948), "/levels/level0/room3/room3platform3.png"),
//                new platform(new Vector (1116,602), "/levels/level0/room3/room3platform4.png"),
//                new platform(new Vector (1238,222), "/levels/level0/room3/room3platform5.png"),
//            },

            new Monster[]
            {

            },

            new Treasure[]
            {

            },

            new ladder[]
            {
                new ladder(new Vector (1607, 165), "/levels/level0/room3/room3ladder0.png"),
                new ladder(new Vector (1733, 475), "/levels/level0/room3/room3ladder1.png")
            },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }),
                
// </editor-fold> 
    // <editor-fold desc="ROOM 4"> 
                
            //Level 0 Room 4
            new room("/levels/level0/room4/room4.png",
//            new platform[]
//            {
//                new platform(new Vector (20,160), "/levels/level0/room4/room4platform0.png"),
//                new platform(new Vector (805,978), "/levels/level0/room4/room4platform1.png"),
//                new platform(new Vector (1860,940), "/levels/level0/room4/room4platform2.png")
//
//            },

            new Monster[]
            {

            },

            new Treasure[]
            {

            },

            new ladder[]
            {
                //new ladder(new Vector (1700, 661), "/rooms/room1/room1ladder.png")
            },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }),
                
// </editor-fold>                 
    // <editor-fold desc="ROOM 5">  
                
            //Level 0 Room 5
            new room("/levels/level0/room5/room5.png",
//            new platform[]
//            {
//                new platform(new Vector (0,939), "/levels/level0/room5/room5platform0.png"),
//                new platform(new Vector (985,858), "/levels/level0/room5/room5platform1.png"),
//
//            },

            new Monster[]
            {

            },

            new Treasure[]
            {

            },

            new ladder[]
            {
               //new ladder(new Vector (1780, 0), "/rooms/room1/room1ladder.png")
            },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }),
                
// </editor-fold> 
    // <editor-fold desc="ROOM 6">
                
            //Level 0 Room 6
            new room("/levels/level0/room6/room6.png",
//            new platform[]
//            {
//                new platform(new Vector (0,852), "/levels/level0/room6/room6platform0.png"),                    
//            },

            new Monster[]
            {

            },

            new Treasure[]
            {

            },

            new ladder[]
            {
                //new ladder(new Vector (1700, 661), "/rooms/room1/room1ladder.png")
            },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
        )}),
        
// </editor-fold>
        
// </editor-fold>
        
    // <editor-fold desc="LEVEL 1">
        
    //Level 1
    new level(

        this,
        new Vector(0,0),
        new room[]
        {
                
    // <editor-fold desc="ROOM 0"> 

                    //Level 1 Room 0
                    new room("/levels/level1/room0/room0.png",

                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }),

    // </editor-fold>                
    // <editor-fold desc="ROOM 1">               

                    //Level 1 Room 1
                    new room("/levels/level1/room1/room1.png",

                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }),

    // </editor-fold>        
    // <editor-fold desc="ROOM 2">

                    //Level 1 Room 2
                    new room("/levels/level1/room2/room2.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
            
    // </editor-fold>
    // <editor-fold desc="ROOM 3">   
    //Level 1 Room 3
                    new room("/levels/level1/room3/room3.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 4"> 
    //Level 1 Room 4
                    new room("/levels/level1/room4/room4.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 5"> 
    //Level 1 Room 5
                    new room("/levels/level1/room5/room5.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 6"> 
    //Level 1 Room 6
                    new room("/levels/level1/room6/room6.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 7"> 
    //Level 1 Room 7
                    new room("/levels/level1/room7/room7.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 8"> 
    //Level 1 Room 8
                    new room("/levels/level1/room8/room8.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 9"> 
    //Level 1 Room 9
                    new room("/levels/level1/room9/room9.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            })

                }),
    //</editor-fold>
    
//</editor-fold>
    
    //<editor-fold desc="LEVEL 2"> 
                    
    //Level 2
    new level(

        this,
        new Vector(0,0),
        new room[]
        {
                
    //<editor-fold desc="ROOM 0">   
    //Level 2 Room 0
                    new room("/levels/level2/room0/room0.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 1">                 
    //Level 2 Room 1
                    new room("/levels/level2/room1/room1.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 2">                 
    //Level 2 Room 2
                    new room("/levels/level2/room2/room2.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 3">                 
    //Level 2 Room 3
                    new room("/levels/level2/room3/room3.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 4">                 
    //Level 2 Room 4
                    new room("/levels/level2/room4/room4.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 5">                 
    //Level 2 Room 5

                    new room("/levels/level2/room5/room5.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 6">                 
    //Level 2 Room 6
                    new room("/levels/level2/room6/room6.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 7">                 
    //Level 2 Room 7

                    new room("/levels/level2/room7/room7.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 8">                 
    //Level 2 Room 8
                    new room("/levels/level2/room8/room8.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    //</editor-fold> 
    //<editor-fold desc="ROOM 9">                 
    //Level 2 Room 9
                    new room("/levels/level2/room9/room9.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),

    //</editor-fold>           
    //<editor-fold desc="ROOM 10">         
    //Level 2 Room 10
                    new room("/levels/level2/room10/room10.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    )
                }
            ),
    // </editor-fold>
        
// </editor-fold>
        
    //<editor-fold desc="Level 3">                 
    //Level 3
    new level(

        this,
        new Vector(0,0),
        new room[]
        {
                
    // <editor-fold desc="ROOM 0">   
                    //Level 3 Room 0
                    new room("/levels/level3/room0/room0.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
// </editor-fold>
    // <editor-fold desc="ROOM 1">                 
                    //Level 3 Room 1
                    new room("/levels/level3/room1/room1.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 2">                 
                    //Level 3 Room 2
                    new room("/levels/level3/room2/room2.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 3">                 
                    //Level 3 Room 3
                    new room("/levels/level3/room3/room3.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 4">                 
                    //Level 3 Room 4
                    new room("/levels/level3/room4/room4.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 5">                 
                    //Level 3 Room 5
                    new room("/levels/level3/room5/room5.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 6">                 
                    //Level 3 Room 6
                    new room("/levels/level3/room6/room6.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 7">                 
                    //Level 3 Room 7
                    new room("/levels/level3/room7/room7.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 8">                 
                    //Level 3 Room 8
                    new room("/levels/level3/room8/room8.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 9">                 
                    //Level 3 Room 9
                    new room("/levels/level3/room9/room9.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }               
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 10"> 
                    //Level 3 Room 10
                    new room("/levels/level3/room10/room10.png",
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },

            //RoomTransitions
            new Detector[]
            { 
                
            },
              
            //Platform Colliders
            new Detector[]
            {
                
            },
                    
            //Wind
            new Detector[]
            {
                        
            },
            
            //Doors        
            new Detector[]
            {
                
            },
            
            //Spikes        
            new Detector[]
            {
                
            },
                    
            //Breakables        
            new Detector[]
            {
                
            }
                    )})};
    // </editor-fold> 
    
// </editor-fold>

//</editor-fold> 
           
    public void goToLevel(int _levelIndex)
    {
        level PreviousLevel = CurrentLevel;
        CurrentLevel = levels[_levelIndex];
        CurrentLevel.StartLevel();    
        LevelIndex = _levelIndex;
        
        if (PreviousLevel != null)
        {
            PreviousLevel.EndLevel();
        }
    }   
    
    public void startGame()
    {      
        CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        cl.next(gameWindow.getContentPane());
        goToLevel(0);
        CurrentLevel.GoToRoom(0);
        levelReady = true;
    }
    
    public void endGame()
    {   
        // This method will show the "Game Over" screen
        //CardLayout cl = (CardLayout)gameWindow.getContentPane().getLayout();
        //cl.next(gameWindow.getContentPane());
        //endScreen.requestFocus();
        //endScreen.setVisible(true);
    }
    
    public static void main(String[] args) 
    {   
        Game window = new Game();        
        window.startScreen.requestFocus();        
    }
    
    public void showEndScreen()
    {
        //TBD: Add lose condition
        //Brings up death screen
        //endScreen.requestFocus();
    }   
    
    private void initWindow()
    {
        //Creates JFrame to handle window
        gameWindow = new JFrame();
        gameWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setLayout(new CardLayout());
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setTitle("Nightmare");
        gameWindow.setVisible(true);
    }
    
    private void initScreens()
    {   
        //This function draws screens on the gameWindow JFrame
        startScreen = new StartGamePanel(this);
        startScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        gameWindow.getContentPane().add(startScreen, "INTRO");         
        //endScreen = new EndGamePanel(this);
        //endScreen.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        //gameWindow.getContentPane().add(endScreen, "OUTRO");
        
        //This loop sets up the levels on the gameWindow JFrame
        for (int levelLoop = 0; levelLoop < levels.length; levelLoop++)
        {
            levels[levelLoop].setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
            gameWindow.getContentPane().add(levels[levelLoop], "Level " + levelLoop);
            
            //This loop sets up rooms inside levels
            for (int roomLoop = 0; roomLoop < levels[levelLoop].rooms.length; roomLoop++)
            {
                levels[levelLoop].rooms[roomLoop].setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
                gameWindow.getContentPane().add(levels[levelLoop].rooms[roomLoop], "Room " + roomLoop);
            }
        }
    }
}
