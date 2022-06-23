import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.Font;


class Game {

    private static float[] portalPos;
    private static float[] portalPos2;
    private static float[] portalPos3;
    private static float[] portalPos4;
    private static float[] portalPos5;
    private static float[] mazePos;
    private static Player player1;
    private static Player dummy1;
    private static Player dummy2;
    private static Player dummy3;
    private static Portal portal1;
    private static Portal portal2;
    private static Portal portal3;
    private static Portal portal4;
    private static Portal portal5;
    private static Maze maze;
    private static boolean isPlaying = false;
    private static float radius = 0.05f;
    private static Random rand = new Random();
    private static int durationChoice;
    private static Font font= new Font(Font.MONOSPACED, Font.BOLD, 18);
    private static boolean isVeteran = false;
    

    //initialise start position of the players and envinment
    private static void gameSet() {

        //instances of the player class created
        player1 = new Player(0.05f, 0.05f);
        player1.winnerCounter = 0;

        dummy1= new Player(0.05f, 0.05f);
        dummy1.winnerCounter = 0;

        dummy2 = new Player(0.05f, 0.05f);
        dummy2.winnerCounter = 0;

        dummy3 = new Player(0.05f, 0.05f); 
        dummy3.winnerCounter = 0;
        
        
        //instances of the portal class created
        portalPos = new float[2];
        portal1 = new Portal(0.55f, 0.55f);

        portalPos2 = new float[2];
        portal2 = new Portal(0.55f, 0.55f);

        portalPos3 = new float[2];
        portal3 = new Portal(0.55f, 0.55f);

        portalPos4 = new float[2];
        portal4 = new Portal(0.55f, 0.55f);

        portalPos5 = new float[2];
        portal5 = new Portal(0.55f, 0.55f);

        //an instance of the target square class created
        mazePos = new float[3];
        maze = new Maze();


        isPlaying = true; //updated the playing status
    }


    //smart and target oriented randomization for the dummy players
    private static boolean up(float [] dummyPosition) {

        if (dummyPosition[1] > .94) {
            return false;
        } 

        int x = rand.nextInt(5);

        if (x <= 3) {
            return true;
        } 
        return false;
    }

    private static boolean down(float [] dummyPosition) {

        if (dummyPosition[1] > .94) {
            return false;
        } 

        int x = rand.nextInt(10);

        if (x <= 2) {
            return true;
        } 
        return false;
    }

    private static boolean left(float [] dummyPosition, float[] mazePos) {

        int x = rand.nextInt(5);
        int y = rand.nextInt(5);

        if ( x <= 3) {

            if (mazePos[0] < dummyPosition [0]) {
                return true;
            }
                return false;
        }
        
        if (y <= 3) {
            return false;
        }

        return true;
    }

    private static boolean right(float [] dummyPosition, float[] mazePos) {

        int x = rand.nextInt(5);
        int y = rand.nextInt(5);

        if ( x <= 3) {

            if (mazePos[0] > dummyPosition [0]) {
                return true;
            }
    
                return false;

        }
        
        if (y <= 3) {
            return false;
        }

        return true;
    }


    //less smart and less target oriented randomization for the dummy players
    private static boolean dummierLeft(float [] dummyPosition, float[] mazePos) {

        int x = rand.nextInt(20);
        int y = rand.nextInt(5);

        if ( x <= 3) {

            if (mazePos[0] < dummyPosition [0]) {
                return true;
            }
    
                return false;

        }
        
        if (y <= 3) {
            return true;
        }

        return false;
    }

    private static boolean dummierRight(float [] dummyPosition, float[] mazePos) {

        int x = rand.nextInt(20);
        int y = rand.nextInt(5);

        if ( x <= 3) {

            if (mazePos[0] > dummyPosition [0]) {
                return true;
            }
    
                return false;

        }
        
        if (y <= 3) {
            return true;
        }

        return false;
    }


    //menu method
    private static void menu() {

        //when menu opened, it will clear the canvas to black and show the options for the game
        StdDraw.clear(StdDraw.BLACK );
        StdDraw.setPenColor(StdDraw.WHITE);
        // isPlaying = true;
        Boolean isPressed = false;
 
        //menu options
        while(!isPressed) {
            StdDraw.text(0.5, 0.7, "Avoid the portals and try to go to the square before others by using arrows.");
            StdDraw.text(0.5, 0.5, "(1) 3-rounds ");
            StdDraw.text(0.5, 0.4, "(2) 5-Rounds ");
            StdDraw.text(0.5, 0.3, "(3) 7-Rounds");
    
            StdDraw.text(0.5, 0.1, "Press Q to end game, V or N to change the game mode.");
            StdDraw.show();
            // isPlaying = true;

            //to enter the more challenging version, conditions are set below.
            if (isVeteran == false) {
                StdDraw.clear(StdDraw.BLACK );
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(0.9, 0.95, "Mode: Normal");
            }

            if (isVeteran == true) {

                StdDraw.clear(StdDraw.BLACK );
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(0.9, 0.95, "Mode: Veteran");
            }

            if (isVeteran == false && StdDraw.isKeyPressed(KeyEvent.VK_V)) {
                
                StdDraw.clear(StdDraw.BLACK );
                StdDraw.setPenColor(StdDraw.WHITE);
            
                StdDraw.text(0.9, 0.95, "Mode: Veteran");
                // isVPressed = true;
                isVeteran = true;
            } 

            if (StdDraw.isKeyPressed(KeyEvent.VK_N)) {
                StdDraw.clear(StdDraw.BLACK );
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(0.9, 0.95, "Mode: Normal");
                isVeteran = false; 
            }


            //options to choose the rounds/wins to be played.
            if (StdDraw.isKeyPressed(KeyEvent.VK_1)) {
                durationChoice = 3;
                isPressed = true;
                gameSet();
            }
    
            if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
                durationChoice = 5;
                isPressed = true;
                gameSet();
            }
    
            if (StdDraw.isKeyPressed(KeyEvent.VK_3)) {
                durationChoice = 7;
                isPressed = true;
                gameSet();
            }
        }
    }


    private static void gameOver(int playerCounter, int dummy1Counter, int dummy2Counter, int dummy3Counter) {


        StdDraw.clear(StdDraw.BLACK);
        // StdDraw.setFont(font);
        boolean isPressed = false;

        //2 different finish conditiones stated as whe playerCounter is bigger than other players' counters and when it is lower than the other counters.
        while (!isPressed) {
            StdDraw.setPenColor(StdDraw.WHITE);
            
            if (playerCounter > dummy1Counter && playerCounter > dummy2Counter && playerCounter > dummy3Counter) {

                StdDraw.text(0.5, 0.7, "You win!");

            } else {

                StdDraw.text(0.50, 0.7, "You lose!");
            }

            //shows the game stats
            StdDraw.text(0.50, 0.6, String.format("Player_1 %2d", playerCounter));
            StdDraw.text(0.50, 0.5, String.format("Player_2 %2d", dummy1Counter));
            StdDraw.text(0.50, 0.4, String.format("Player_3 %2d", dummy2Counter));
            StdDraw.text(0.50, 0.3, String.format("Player_4 %2d", dummy3Counter));
    
            StdDraw.text(0.50, 0.1, "Press M to return to menu");

            //player icons
            StdDraw.setPenColor(150, 255, 115); //green
            StdDraw.filledCircle(0.41, 0.603, 0.01);

            StdDraw.setPenColor(21, 96, 100); //teal
            StdDraw.filledCircle(0.41, 0.503, 0.01);
        
            StdDraw.setPenColor(255, 194, 180); //pink
            StdDraw.filledCircle(0.41, 0.403, 0.01);

            StdDraw.setPenColor(251, 143, 103); //coral
            StdDraw.filledCircle(0.41, 0.303, 0.01);

            StdDraw.show();

            //when M key is pressed, it will return to menu at the beginning
            if (StdDraw.isKeyPressed(KeyEvent.VK_M)) {
                menu();
                isPressed = true;
            }
        }       
    }





    public static void main(String[] args) {

        //enabled buffering for animations, set a black canvas and set the font for the rest of the game.
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(920, 920);
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setFont(font);

        
        menu(); //initializes the menu

        while(true) {

            if (isPlaying) {

                //shows the current score of the player
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.text(0.90, 0.05, String.format("Score %2d", player1.winnerCounter));

                //update the positions of the portals and target with the current values
                portalPos[0] = portal1.position[0];
                portalPos[1] = portal1.position[1];

                portalPos2[0] = portal2.position[0];
                portalPos2[1] = portal2.position[1];

                portalPos3[0] = portal3.position[0];
                portalPos3[1] = portal3.position[1];

                portalPos4[0] = portal4.position[0];
                portalPos4[1] = portal4.position[1];

                portalPos5[0] = portal5.position[0];
                portalPos5[1] = portal5.position[1];

                mazePos[0] = maze.position[0];
                mazePos[1] = maze.position[1];


                //When the veteran mode is activated, relocation probability is increased so that, they will appear and disappear faster.
                if (isVeteran == true) {

                    portal1.Update(rand.nextInt(45, 55));
                    portal2.Update(rand.nextInt(45, 55));
                    portal3.Update(rand.nextInt(45, 55));
                    portal4.Update(rand.nextInt(45, 55));
                    portal5.Update(rand.nextInt(45, 55));
                    maze.Update(rand.nextInt(45, 55));


                } else if (isVeteran == false) {

                    portal1.Update(rand.nextInt(60));
                    portal2.Update(rand.nextInt(60));
                    portal3.Update(rand.nextInt(60));
                    portal4.Update(rand.nextInt(60));
                    portal5.Update(rand.nextInt(60));
                    maze.Update(rand.nextInt(60));
                }


                //update the players' position 
                player1.update(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT), StdDraw.isKeyPressed(KeyEvent.VK_LEFT), 
                StdDraw.isKeyPressed(KeyEvent.VK_UP), StdDraw.isKeyPressed(KeyEvent.VK_DOWN), portalPos, portalPos2, portalPos3, portalPos4, portalPos5, mazePos, durationChoice);

                dummy1.update(right(dummy1.position, mazePos), left(dummy1.position, mazePos), up(dummy1.position), down(dummy1.position), portalPos, portalPos2, portalPos3, portalPos4, portalPos5, mazePos, durationChoice);

                dummy2.update(right(dummy2.position, mazePos), left(dummy2.position, mazePos), up(dummy2.position), down(dummy2.position), portalPos, portalPos2, portalPos3, portalPos4, portalPos5, mazePos, durationChoice);

                dummy3.update(dummierRight(dummy3.position, mazePos), dummierLeft(dummy3.position, mazePos), up(dummy3.position), down(dummy3.position), portalPos, portalPos2, portalPos3, portalPos4, portalPos5, mazePos, durationChoice);

                //players placed in canvas
                StdDraw.setPenColor(150, 255, 115); //green
                StdDraw.filledCircle(player1.position[0], player1.position[1], radius);

                StdDraw.setPenColor(21, 96, 100); //teal
                StdDraw.filledCircle(dummy1.position[0], dummy1.position[1], radius);

                StdDraw.setPenColor(255, 194, 180); //pink
                StdDraw.filledCircle(dummy2.position[0], dummy2.position[1], radius);

                StdDraw.setPenColor(251, 143, 103); //coral
                StdDraw.filledCircle(dummy3.position[0], dummy3.position[1], radius);


                //portals placed in the canvas
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.setPenRadius(0.005);

                StdDraw.circle(portal1.position[0], portal1.position[1], radius);
                StdDraw.circle(portal2.position[0], portal2.position[1], radius);
                StdDraw.circle(portal4.position[0], portal4.position[1], radius);
                StdDraw.circle(portal3.position[0], portal3.position[1], radius);
                StdDraw.circle(portal5.position[0], portal5.position[1], radius);


 
                //target point placed in the canvas
                StdDraw.setPenRadius(0.1);
                StdDraw.filledRectangle(maze.position[0], maze.position[1], 0.05, 0.05);


                //updates the isPlaying status according to winning status 
                if (player1.isWinner || dummy1.isWinner || dummy2.isWinner || dummy3.isWinner) {

                    isPlaying = false;
                }

                //updates the isPlaying status according to whether Q is pressed and goes back to menu
                if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
                    isPlaying = false;
                    menu();
                } 

            }

            //if game is not playing
            else {
                gameOver(player1.winnerCounter, dummy1.winnerCounter, dummy2.winnerCounter, dummy3.winnerCounter); //calls the gameOver method with the winnerCounter of the players

            }

            StdDraw.show();
            StdDraw.pause(40);
            StdDraw.clear(StdDraw.BLACK);

        }
    }
}
