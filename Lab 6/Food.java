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
 *  A food object, that predators chase and eat.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.02
 */
public class Food extends SimpleActor
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Food object.
     */
    public Food()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Take one step, either forward or after turning left or right.
     */
    public void act()
    {
        int value = Random.generator().nextInt(4);
        if (value == 0)
        {
            this.turn(LEFT);
            if (!this.isAtBorder())
            {
                this.move();
            }
        }
        else if (value == 1)
        {
            this.turn(RIGHT);
            if (!this.isAtBorder())
            {
                this.move();
            }
        }
        else if (value == 2 || value == 3)
        {
            if (!this.isAtBorder())
            {
                this.move();
            }
        }
    }
    
    /**
     * Checks is the food is at border.
     * @return true or false
     */
    public boolean isAtBorder()
    {
        boolean ans = false;
        if (this.getDirection() == EAST && this.getGridX() + 1 >= 12)
        {
            ans = true;
        }
        else if (this.getDirection() == WEST && this.getGridX() - 1 <= 0)
        {
            return true;
        }
        else if (this.getDirection() == NORTH && this.getGridY() - 1 <= 0)
        {
            return true;
        }
        else if (this.getDirection() == SOUTH && this.getGridY() + 1 >= 12)
        {
            return true;
        }
        return ans;
    }
    
}
