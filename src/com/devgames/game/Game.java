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
            new platform[]
            {   
                new platform(new Vector (0,872), "/levels/level0/room0/room0platform0.png"),
                new platform(new Vector (986,777), "/levels/level0/room0/room0platform1.png"),
                new platform(new Vector (1241,661), "/levels/level0/room0/room0platform2.png"), 
                new platform(new Vector (1477,262), "/levels/level0/room0/room0platform3.png")

            },     

            new Monster[]
            {
                new Monster(new Vector(800, 800), "/Sprites/Graded/Frost-Brute-Graded-Single.png")
            },

            new Treasure[]
            {
                //new Treasure(new Vector(0,0), "")
            },

            new ladder[]
            {

            },

            //RoomTransitions
            new RoomTransition[]
            { 
                new RoomTransition 
                (   
                    new Rectangle (1920, 0, 5, 1080),   /*Bounds of trigger*/ 
                    0, 1,                               /*Level & room target*/
                    new Vector(100, 780)                /*Player spawn point*/
                ),

            }),
            
        
                
// </editor-fold> 
    // <editor-fold desc="ROOM 1"> 
                
            //Level 0 Room 1
            new room("/levels/level0/room1/room1-np.png",
            new platform[]
            {
                new platform(new Vector (0,781), "/levels/level0/room1/room1platform0.png"),
                new platform(new Vector (368,845), "/levels/level0/room1/room1platform1.png"),
                new platform(new Vector (1521,633), "/levels/level0/room1/room1platform2.png"),
            },

            new Monster[]
            {

            },

            new Treasure[]
            {

            },

            new ladder[]
            {
                //new ladder(new Vector (1695, 628), "/levels/level0/room1/room1ladder0.png")
            },

            //RoomTransitions
            new RoomTransition[]
            { 
//                new RoomTransition ( new Rectangle (1920, 0, 5, 1080), 
//                        0, 1, 
//                        new Vector(100, 780)),
            },
                    
            //Wind
            new RoomTransition[]
            {
                new RoomTransition((new Rectangle(960, 680, 370, 400)), 5)                
            }),
                
// </editor-fold> 
    // <editor-fold desc="ROOM 2">
                
            //Level 0 Room 2
            new room("/levels/level0/room2/room2.png",
            new platform[]
            {
                new platform(new Vector (0,640), "/levels/level0/room2/room2platform0.png"),
                new platform(new Vector (1194,972), "/levels/level0/room2/room2platform1.png"),
                new platform(new Vector (1530,1038), "/levels/level0/room2/room2platform2.png"),
                new platform(new Vector (1722,780), "/levels/level0/room2/room2platform3.png")
            },

            new Monster[]
            {

            },

            new Treasure[]
            {

            },

            new ladder[]
            {
                //new ladder(new Vector (1700, 661), "/rooms/room2/room2ladder0.png")
            },

            new RoomTransition[]
            {                         
            }),
                
// </editor-fold> 
    // <editor-fold desc="ROOM 3">
                
            //Level 0 Room 3
            new room("/levels/level0/room3/room3-np.png",
            new platform[]
            {
                new platform(new Vector (0,737), "/levels/level0/room3/room3platform0.png"),
                new platform(new Vector (357,881), "/levels/level0/room3/room3platform1.png"),
                new platform(new Vector (552,995), "/levels/level0/room3/room3platform2.png"),
                new platform(new Vector (842,948), "/levels/level0/room3/room3platform3.png"),
                new platform(new Vector (1116,602), "/levels/level0/room3/room3platform4.png"),
                new platform(new Vector (1238,222), "/levels/level0/room3/room3platform5.png"),
            },

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
            new RoomTransition[]
            {   
            }),
                
// </editor-fold> 
    // <editor-fold desc="ROOM 4"> 
                
            //Level 0 Room 4
            new room("/levels/level0/room4/room4.png",
            new platform[]
            {
                new platform(new Vector (20,160), "/levels/level0/room4/room4platform0.png"),
                new platform(new Vector (805,978), "/levels/level0/room4/room4platform1.png"),
                new platform(new Vector (1860,940), "/levels/level0/room4/room4platform2.png")

            },

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
                            new RoomTransition[]
            {   
            }),
                
// </editor-fold>                 
    // <editor-fold desc="ROOM 5">  
                
            //Level 0 Room 5
            new room("/levels/level0/room5/room5.png",
            new platform[]
            {
                new platform(new Vector (0,939), "/levels/level0/room5/room5platform0.png"),
                new platform(new Vector (985,858), "/levels/level0/room5/room5platform1.png"),

            },

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
            new RoomTransition[]
            {   
            }),
                
// </editor-fold> 
    // <editor-fold desc="ROOM 6">
                
            //Level 0 Room 6
            new room("/levels/level0/room6/room6.png",
            new platform[]
            {
                new platform(new Vector (0,852), "/levels/level0/room6/room6platform0.png"),                    
            },

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

                    new RoomTransition[]
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

                    new platform[]
                    {
                        //new platform(new Vector (735,975), "/levels/level1/room0/room0platform0.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {   
                    }),

    // </editor-fold>                
    // <editor-fold desc="ROOM 1">               

                    //Level 1 Room 1
                    new room("/levels/level1/room1/room1.png",

                    new platform[]
                    {
                        new platform(new Vector (873,852), "/levels/level1/room1/room1platform0.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {   
                    }),

    // </editor-fold>        
    // <editor-fold desc="ROOM 2">

                    //Level 1 Room 2
                    new room("/levels/level1/room2/room2.png",

                    new platform[]
                    {
                        new platform(new Vector (720,993), "/levels/level1/room2/room2platform0.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                   new RoomTransition[]
                    {   
                    }
                    ),
            
    // </editor-fold>
    // <editor-fold desc="ROOM 3">   
    //Level 1 Room 3
                    new room("/levels/level1/room3/room3.png",

                    new platform[]
                    {
                        new platform(new Vector (0,987), "/levels/level1/room3/room3platform0.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 4"> 
    //Level 1 Room 4
                    new room("/levels/level1/room4/room4.png",

                    new platform[]
                    {
                        new platform(new Vector (60,708), "/levels/level1/room4/room4platform0.png"),
                        new platform(new Vector (135,561), "/levels/level1/room4/room4platform1.png"),
                        new platform(new Vector (1398,1008), "/levels/level1/room4/room4platform2.png"),
                        new platform(new Vector (1776,930), "/levels/level1/room4/room4platform3.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 5"> 
    //Level 1 Room 5
                    new room("/levels/level1/room5/room5.png",

                    new platform[]
                    {
                        new platform(new Vector (0,927), "/levels/level1/room5/room5platform0.png"),
                        new platform(new Vector (801,891), "/levels/level1/room5/room5platform1.png"),
                        new platform(new Vector (1110,954), "/levels/level1/room5/room5platform2.png"),
                        new platform(new Vector (1629,975), "/levels/level1/room5/room5platform3.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 6"> 
    //Level 1 Room 6
                    new room("/levels/level1/room6/room6.png",

                    new platform[]
                    {   

                        new platform(new Vector (0,979), "/levels/level1/room6/room6platform0.png"),
                        new platform(new Vector (239,520), "/levels/level1/room6/room6platform1.png"),
                        new platform(new Vector (694,1032), "/levels/level1/room6/room6platform2.png"),
                        new platform(new Vector (1114,1032), "/levels/level1/room6/room6platform3.png"),
                        new platform(new Vector (1533,993), "/levels/level1/room6/room6platform3.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 7"> 
    //Level 1 Room 7
                    new room("/levels/level1/room7/room7.png",

                    new platform[]
                    {
                        new platform(new Vector (0,993), "/levels/level1/room7/room7platform0.png"),
                        new platform(new Vector (663,882), "/levels/level1/room7/room7platform1.png"),
                        new platform(new Vector (777,786), "/levels/level1/room7/room7platform2.png"),
                        new platform(new Vector (1662,993), "/levels/level1/room7/room7platform3.png"),

                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 8"> 
    //Level 1 Room 8
                    new room("/levels/level1/room8/room8.png",

                    new platform[]
                    {
                        new platform(new Vector (0,609), "/levels/level1/room8/room8platform0.png"),
                        new platform(new Vector (213,1044), "/levels/level1/room8/room8platform1.png"),
                        new platform(new Vector (244,774), "/levels/level1/room8/room8platform2.png"),
                        new platform(new Vector (281,402), "/levels/level1/room8/room8platform3.png"),
                        new platform(new Vector (687,447), "/levels/level1/room8/room8platform4.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    //</editor-fold> 
    // <editor-fold desc="ROOM 9"> 
    //Level 1 Room 9
                    new room("/levels/level1/room9/room9.png",

                    new platform[]
                    {
                        new platform(new Vector (0,954), "/levels/level1/room9/room9platform0.png"),
                        new platform(new Vector (606,993), "/levels/level1/room9/room9platform1.png"),
                        new platform(new Vector (1356,993), "/levels/level1/room9/room9platform2.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
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

                    new platform[]
                    {
                        new platform(new Vector (0,644), "/levels/level2/room0/room0platform0.png"),
                        new platform(new Vector (582,923), "/levels/level2/room0/room0platform1.png"),
                        new platform(new Vector (714,670), "/levels/level2/room0/room0platform2.png"),
                        new platform(new Vector (885,760), "/levels/level2/room0/room0platform3.png"),
                        new platform(new Vector (1105,656), "/levels/level2/room0/room0platform4.png"),
                        new platform(new Vector (1274,606), "/levels/level2/room0/room0platform5.png"),

                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 1">                 
    //Level 2 Room 1
                    new room("/levels/level2/room1/room1.png",

                    new platform[]
                    {
                        new platform(new Vector (0,884), "/levels/level2/room1/room1platform0.png"),
                        new platform(new Vector (339,948), "/levels/level2/room1/room1platform1.png"),
                        new platform(new Vector (815,809), "/levels/level2/room1/room1platform2.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 2">                 
    //Level 2 Room 2
                    new room("/levels/level2/room2/room2.png",

                    new platform[]
                    {
                        new platform(new Vector (0,962), "/levels/level2/room2/room2platform0.png"),
                        new platform(new Vector (514,825), "/levels/level2/room2/room2platform1.png"),
                        new platform(new Vector (863,875), "/levels/level2/room2/room2platform2.png"),
                        new platform(new Vector (115,916), "/levels/level2/room2/room2platform3.png"),
                        new platform(new Vector (1455,962), "/levels/level2/room2/room2platform4.png"),
                        new platform(new Vector (1804,962), "/levels/level2/room2/room2platform5.png"),
                        new platform(new Vector (1606,499), "/levels/level2/room2/room2platform6.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 3">                 
    //Level 2 Room 3
                    new room("/levels/level2/room3/room3.png",

                    new platform[]
                    {
                        new platform(new Vector (0,863), "/levels/level2/room3/room3platform0.png"),
                        new platform(new Vector (238,700), "/levels/level2/room3/room3platform1.png"),
                        new platform(new Vector (497,854), "/levels/level2/room3/room3platform2.png"),
                        new platform(new Vector (745,426), "/levels/level2/room3/room3platform3.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 4">                 
    //Level 2 Room 4
                    new room("/levels/level2/room4/room4.png",

                    new platform[]
                    {
                        new platform(new Vector (0,962), "/levels/level2/room4/room4platform0.png"),
                        new platform(new Vector (0,499), "/levels/level2/room4/room4platform1.png"),
                        new platform(new Vector (558,659), "/levels/level2/room4/room4platform2.png"),
                        new platform(new Vector (842,807), "/levels/level2/room4/room4platform3.png"),
                        new platform(new Vector (1524,973), "/levels/level2/room4/room4platform4.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 5">                 
    //Level 2 Room 5

                    new room("/levels/level2/room5/room5.png",

                    new platform[]
                    {
                        new platform(new Vector (0,0), "/levels/level2/room5/room5platform0.png"),
                        new platform(new Vector (581,0), "/levels/level2/room5/room5platform1.png"),
                        new platform(new Vector (1336,0), "/levels/level2/room5/room5platform2.png"),
                        new platform(new Vector (1413,403), "/levels/level2/room5/room5platform3.png"),
                        new platform(new Vector (1658,334), "/levels/level2/room5/room5platform4.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 6">                 
    //Level 2 Room 6
                    new room("/levels/level2/room6/room6.png",

                    new platform[]
                    {
                        new platform(new Vector (0,973), "/levels/level2/room6/room6platform0.png"),
                        new platform(new Vector (585,863), "/levels/level2/room6/room6platform1.png"),
                        new platform(new Vector (837,534), "/levels/level2/room6/room6platform2.png"),
                        new platform(new Vector (1074,914), "/levels/level2/room6/room6platform3.png"),
                        new platform(new Vector (1336,1018), "/levels/level2/room6/room6platform4.png"),
                        new platform(new Vector (1122,262), "/levels/level2/room6/room6platform4.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 7">                 
    //Level 2 Room 7

                    new room("/levels/level2/room7/room7.png",

                    new platform[]
                    {
                        new platform(new Vector (431,936), "/levels/level2/room6/room6platform0.png"),
                        new platform(new Vector (926,337), "/levels/level2/room6/room6platform1.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 8">                 
    //Level 2 Room 8
                    new room("/levels/level2/room8/room8.png",

                    new platform[]
                    {
                        new platform(new Vector (397,747), "/levels/level2/room8/room8platform0.png"),
                        new platform(new Vector (524,470), "/levels/level2/room8/room8platform1.png"),
                        new platform(new Vector (1209,852), "/levels/level2/room8/room8platform2.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    //</editor-fold> 
    //<editor-fold desc="ROOM 9">                 
    //Level 2 Room 9
                    new room("/levels/level2/room9/room9.png",

                    new platform[]
                    {
                        new platform(new Vector (357,1001), "/levels/level2/room9/room9platform0.png"),
                        new platform(new Vector (0,577), "/levels/level2/room9/room9platform1.png"),
                        new platform(new Vector (1420,1052), "/levels/level2/room9/room9platform2.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),

    //</editor-fold>           
    //<editor-fold desc="ROOM 10">         
    //Level 2 Room 10
                    new room("/levels/level2/room10/room10.png",

                    new platform[]
                    {   
                        new platform(new Vector (0,323), "/levels/level2/room10/room10platform0.png"),
                        new platform(new Vector (340,1055), "/levels/level2/room10/room10platform1.png"),
                        new platform(new Vector (527,540), "/levels/level2/room10/room10platform2.png"),
                        new platform(new Vector (638,954), "/levels/level2/room10/room10platform3.png"),
                        new platform(new Vector (637,209), "/levels/level2/room10/room10platform4.png"),
                        new platform(new Vector (738,502), "/levels/level2/room10/room10platform5.png"),
                        new platform(new Vector (765,807), "/levels/level2/room10/room10platform6.png"),
                        new platform(new Vector (1110,163), "/levels/level2/room10/room10platform7.png"),
                        new platform(new Vector (1162,365), "/levels/level2/room10/room10platform8.png"),
                        new platform(new Vector (1162,641), "/levels/level2/room10/room10platform9.png"),
                        new platform(new Vector (1175,954), "/levels/level2/room10/room10platform10.png"),
                        new platform(new Vector (1316,282), "/levels/level2/room10/room10platform11.png"),
                        new platform(new Vector (1627,641), "/levels/level2/room10/room10platform12.png"),
                        new platform(new Vector (1438,743), "/levels/level2/room10/room10platform13.png"),


                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
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

                    new platform[]
                    {
                        new platform(new Vector (0,994), "/levels/level3/room0/room0platform0.png"),
                        new platform(new Vector (1552,994), "/levels/level3/room0/room0platform1.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
// </editor-fold>
    // <editor-fold desc="ROOM 1">                 
                    //Level 3 Room 1
                    new room("/levels/level3/room1/room1.png",

                    new platform[]
                    {
                        new platform(new Vector (0,994), "/levels/level3/room1/room1platform0.png"),
                        new platform(new Vector (543,834), "/levels/level3/room1/room1platform1.png"),
                        new platform(new Vector (1586,966), "/levels/level3/room1/room1platform2.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 2">                 
                    //Level 3 Room 2
                    new room("/levels/level3/room2/room2.png",

                    new platform[]
                    {
                        new platform(new Vector (0,0), "/levels/level3/room2/room2platform0.png"),
                        new platform(new Vector (1329,976), "/levels/level3/room2/room2platform1.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 3">                 
                    //Level 3 Room 3
                    new room("/levels/level3/room3/room3.png",

                    new platform[]
                    {
                        new platform(new Vector (0,0), "/levels/level3/room3/room3platform0.png"),
                        new platform(new Vector (603,986), "/levels/level3/room3/room3platform1.png"),
                        new platform(new Vector (1074,0), "/levels/level3/room3/room3platform2.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 4">                 
                    //Level 3 Room 4
                    new room("/levels/level3/room4/room4.png",

                    new platform[]
                    {
                        new platform(new Vector (0,0), "/levels/level3/room4/room4platform0.png"),
                        new platform(new Vector (585,505), "/levels/level3/room4/room4platform1.png"),
                        new platform(new Vector (567,857), "/levels/level3/room4/room4platform2.png"),
                        new platform(new Vector (867,395), "/levels/level3/room4/room4platform3.png"),
                        new platform(new Vector (1368,0), "/levels/level3/room4/room4platform4.png"),
                        new platform(new Vector (1442,970), "/levels/level3/room4/room4platform5.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 5">                 
                    //Level 3 Room 5
                    new room("/levels/level3/room5/room5.png",

                    new platform[]
                    {
                        new platform(new Vector (364,438), "/levels/level3/room5/room5platform0.png"),
                        new platform(new Vector (795,540), "/levels/level3/room5/room5platform1.png"),
                        new platform(new Vector (654,1022), "/levels/level3/room5/room5platform2.png"),
                        new platform(new Vector (1352,1022), "/levels/level3/room5/room5platform3.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 6">                 
                    //Level 3 Room 6
                    new room("/levels/level3/room6/room6.png",

                    new platform[]
                    {
                        new platform(new Vector (0,1022), "/levels/level3/room6/room6platform0.png"),
                        new platform(new Vector (222,885), "/levels/level3/room6/room6platform1.png"),
                        new platform(new Vector (542,771), "/levels/level3/room6/room6platform2.png"),
                        new platform(new Vector (814,0), "/levels/level3/room6/room6platform3.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 7">                 
                    //Level 3 Room 7
                    new room("/levels/level3/room7/room7.png",

                    new platform[]
                    {
                        new platform(new Vector (520,94), "/levels/level3/room7/room7platform0.png"),


                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 8">                 
                    //Level 3 Room 8
                    new room("/levels/level3/room8/room8.png",

                    new platform[]
                    {
                        new platform(new Vector (0,532), "/levels/level3/room8/room8platform0.png"),
                        new platform(new Vector (960,641), "/levels/level3/room8/room8platform1.png"),
                        new platform(new Vector (1616,0), "/levels/level3/room8/room8platform2.png"),
                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 9">                 
                    //Level 3 Room 9
                    new room("/levels/level3/room9/room9.png",

                    new platform[]
                    {
                        new platform(new Vector (0,760), "/levels/level3/room9/room9platform0.png"),
                        new platform(new Vector (355,605), "/levels/level3/room9/room9platform1.png"),
                        new platform(new Vector (585,501), "/levels/level3/room9/room9platform2.png"),
                        new platform(new Vector (848,384), "/levels/level3/room9/room9platform3.png"),
                        new platform(new Vector (1104,501), "/levels/level3/room9/room9platform4.png"),
                        new platform(new Vector (1356,605), "/levels/level3/room9/room9platform5.png"),
                        new platform(new Vector (1663,532), "/levels/level3/room9/room9platform6.png"),

                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
                    {

                    }                
                    ),
    // </editor-fold> 
    // <editor-fold desc="ROOM 10"> 
                    //Level 3 Room 10
                    new room("/levels/level3/room10/room10.png",

                    new platform[]
                    {
                        new platform(new Vector (0,866), "/levels/level3/room10/room10platform0.png"),
                        new platform(new Vector (26,490), "/levels/level3/room10/room10platform1.png"),
                        new platform(new Vector (189,678), "/levels/level3/room10/room10platform2.png"),
                        new platform(new Vector (432,340), "/levels/level3/room10/room10platform3.png"),
                        new platform(new Vector (751,464), "/levels/level3/room10/room10platform4.png"),
                        new platform(new Vector (1776,760), "/levels/level3/room10/room10platform5.png"),

                    },
                    new Monster[]
                    {

                    },
                    new Treasure[]
                    {

                    },
                    new ladder[]
                    {

                    },
                    new RoomTransition[]
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
        CurrentLevel.GoToRoom(1);
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
