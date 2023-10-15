import sofia.micro.*;
import sofia.util.Random;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  This actor will move around in the world
 *  and drop markers where it has been.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.09
 */
public class Turtle extends Actor
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Turtle object.
     */
    public Turtle()
    {
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    
    /**
     * Turns the turtle left or right randomly.
     */
    public void randomTurn()
    {
        boolean turn = Random.generator().nextBoolean();
        if (turn)
        {
            this.turn(90);
        }
        else
        {
            this.turn(-90);
        }
    }
    
    /**
     * Drops a new marker at the turtle's current location
     * if there is not marker. Then moves the turtle one 
     * square forward.
     */
    public void move()
    {
        int x = this.getGridX();
        int y = this.getGridY();
        
        if (!markerHere())
        {
            Marker marker = new Marker();
            this.getWorld().add(marker, x, y);
            super.move(1);
        }
        else
        {
            super.move(1);
        }
    }
    
    /**
     * Determines whether a marker is placed at
     * the turtle's current position.
     * 
     * @return true if marker is at current position
     *         false if marker is not at current position
     */
    public boolean markerHere()
    {
        int x = this.getGridX();
        int y = this.getGridY();
        
        boolean ans = false;
        if (this.getWorld().getOneObjectAt(x, y, Marker.class) != null)
        {
            ans = true;
        }
        return ans;
    }
    
    /**
     * Moves the turtle dist times. 
     * 
     * @param dist    number of squares the turtle will travel
     */
    @Override
    public void move(int dist)
    { 
        for (int i = 0; i < dist; i++)
        {
            this.move();
        }
    }
    
    /**
     * Picks a random number between 1 and 4
     * and moves that many spaces while dropping
     * markers and then randomly turns left or right.
     */
    public void act()
    {
        int steps = Random.generator().nextInt(4);
        steps++;
        this.move(steps);
        this.randomTurn();
    }


}
