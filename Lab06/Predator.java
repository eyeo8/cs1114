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
 *  A predator chases the nearest food object, and eats it if it
 *  can catch it.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.02
 */
public class Predator extends SimpleActor
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Predator object.
     */
    public Predator()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Take one step closer toward the nearest food object, eating
     * it if we land on it.
     */
    public void act()
    {
        if (directionOf(Food.class) == EAST)
        {
            if (!this.isAtBorder())
            {
                this.move();
            }
            this.eatAndAdd();
        }
        else if (directionOf(Food.class) == WEST)
        {
            this.turn(RIGHT);
            this.turn(RIGHT);
            if (!this.isAtBorder())
            {
                this.move();
            }
            this.eatAndAdd();
        }
        else if (directionOf(Food.class) == SOUTH)
        {
            super.turn(RIGHT);
            if (!this.isAtBorder())
            {
                this.move();
            }
            this.eatAndAdd();
        }
        else if (directionOf(Food.class) == NORTH)
        {
            super.turn(LEFT);
            if (!this.isAtBorder())
            {
                this.move();
            }
            this.eatAndAdd();
        }
    }
    
    /**
     * Predator eats the food it
     * it is on top of it. 
     * After removal it creates a 
     * pizza at a random location.
     */
    public void eatAndAdd()
    {
        Food pizza;
        pizza = getOneIntersectingObject(Food.class);
        int x = Random.generator().nextInt(12);
        int y = Random.generator().nextInt(12);
        if (pizza != null)
        {
            pizza.remove();
            this.getWorld().add(pizza, x, y);
        }
    }
    
    /**
     * Checks is the predator is at border.
     * @return true or false
     */
    public boolean isAtBorder()
    {
        boolean ans = false;
        if (this.getDirection() == EAST && this.getGridX() + 1 >= 12)
        {
            return true;
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
