import java.util.Random;

//defined the features of the portals in this class
public class Portal {

    public float[] position = {0, 0};
    Random rand = new Random();

    public float[] randomPositions = {0.05f, 0.15f, 0.25f, 0.35f, 0.45f, 0.55f, 0.65f, 0.75f, 0.85f, 0.95f}; //defined the possible position points

    Portal(float x, float y) { //defined constructor for portals

        position[0] = x;
        position[1] = y;
    }


    public void Update(int randomPortal) { //update method to update the position of the portals

        if (randomPortal == 50) {

            int randomX = rand.nextInt(10);
            int randomY = rand.nextInt(10);

            //by using randomization, it gets two values from the randomPositions and and uses as coordinates for the updated portal position

            if ( !((randomX == 0 && randomY == 0) || (randomX == 9 && randomY == 9 ))  ) {

                position[0] = randomPositions[randomX];
                position[1] = randomPositions[randomY]; 

            }
        }
    }
}
