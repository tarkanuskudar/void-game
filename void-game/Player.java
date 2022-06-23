public class Player{

    public float[] position = { 0, 0 };
    public boolean isWinner = false;
    public int winnerCounter = 0;


    Player(float x, float y) { //constructor
        position[0] = x;
        position[1] = y;
    }

    private void checkPortal(float[] portalPos) { // collusion control method

        //mathematical equation to check if circles instersect
        float distanceSquare = (position[0] - portalPos[0]) * (position[0] - portalPos[0]) +
        (position[1] - portalPos[1]) * (position[1] - portalPos[1]);


        float radiusSumSq = (0.05f + 0.05f) * (0.05f + 0.05f);

        //if they are intersecting, the position will be restarted 
        if (distanceSquare == radiusSumSq ) {
        this.position[0] = 0.05f;
        this.position[1] = 0.5f;

        } else if (distanceSquare < radiusSumSq) {

        this.position[0] = 0.05f;
        this.position[1] = 0.05f; 
        }
    } 


    //method to update player position and check whether players are already in target or colliding with the portals
    public void update(boolean right, boolean left, boolean up, boolean down, float[] portalPos, float[]portalPos2, float[]portalPos3, float[]portalPos4, float[]portalPos5, float[] mazePos, int durationChoice) {

        if (right) {
            this.position[0] += 0.025;
            if (this.position[0] >= .95) 
            {
                this.position[0] = 0.95f;
            }  
        } 

        if (left) {
            this.position[0] -= 0.025;
            if (this.position[0] <= .05) 
            {
                this.position[0] = 0.05f;
            } 
        }

        if (up) {
            this.position[1] += 0.025;
            if (this.position[1] >= .95) 
            {
                this.position[1] = 0.95f;
            } 
        }

        if (down) {
            this.position[1] -= 0.025;
            if (this.position[1] <= .05) 
            {
                this.position[1] = 0.05f;
            } 
        }


        this.checkPortal(portalPos);
        this.checkPortal(portalPos2);
        this.checkPortal(portalPos3);
        this.checkPortal(portalPos4);
        this.checkPortal(portalPos5);


        //equations to check whether a circle is inside the boundries of square
        float Xn = Math.max(mazePos[0], Math.min(this.position[0], mazePos[0]));
        float Yn = Math.max(mazePos[1], Math.min(this.position[1], mazePos[1]));
         
       
        float Dx = Xn - this.position[0];
        float Dy = Yn - this.position[1];

        //if a player goes inside the target area, it will increase the winnerCounter and reset the position.
        if ((Dx * Dx + Dy * Dy) <= 0.05 * 0.05) {
            this.position[0] = 0.05f;
            this.position[1] = 0.05f;
            this.winnerCounter ++;

            //winning condition
            if (this.winnerCounter == durationChoice) {
                isWinner = true;
            }
        }        
    }
}


