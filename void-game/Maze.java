import java.util.Random;

//maze means target in the game context.
public class Maze {


    public float[] position = {0, 0};
    float[] blocks = new float[]{0.05f, 0.15f, 0.25f, 0.35f, 0.45f, 0.55f, 0.65f, 0.75f, 0.85f, 0.95f}; //defined the possible position points
    Random rand = new Random();

    Maze() { //constructor
        position[0] = blocks[rand.nextInt(1,3)];
        position[1] = blocks[rand.nextInt(7,9)];
    }

    public void Update(int randomMaze) { //update method to update the position of the target
        if (randomMaze == 50) {

            int randomX = rand.nextInt(10);
            int randomY = rand.nextInt(9, 10);

             //by using randomization, it gets two values from the blocks and and uses as coordinates for the updated target position

            if ( !((randomX == 0 && randomY == 0) || (randomX == 9 && randomY == 9 ))  ) {

                position[0] = blocks[randomX];
                position[1] = blocks[randomY];

            }
    }

}
    
}
