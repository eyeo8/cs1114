import sofia.micro.*;
import java.util.List;
import java.util.ArrayList;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Creates a marble that will "self-organize".
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.30
 */
public class Marble extends Actor
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Marble object.
     */
    public Marble()
    {
        // Do NOT try to calculate the list of friends here,
        // the marble is not added to a world yet, so it has
        // no neighbors.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Finds the marble at the specified height (which could be
     * at any x-coordinate for that height).
     * @param yPosition The y-coordinate where the marble is located.
     * @return The marble with the specified y-coordinate.
     */
    public Marble getMarbleAtHeight(int yPosition)
    {
        for (int x = 0; x < this.getWorld().getWidth(); x++)
        {
            World world = this.getWorld();
            Marble obj = world.getOneObjectAt(x, yPosition, Marble.class);
            if (obj != null)
            {
                return obj;
            }
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Get a list of the marbles within two rows on either side
     * of this marble, not including this marble itself.
     * @return A list of the marbles with y-coordinates 1 or 2
     *         cells above or below this marble, not including
     *         this marble.
     */
    public List<Marble> getFriends()
    {
        List<Marble> friends = new ArrayList<Marble>();
        
        for (int y = this.getGridY() - 2; y < this.getGridY() + 3; y++)
        {
            if (this.getMarbleAtHeight(y) != null)
            {
                friends.add(this.getMarbleAtHeight(y));
            }
        }
        friends.remove(this);
        
        return friends;
    }


    // ----------------------------------------------------------
    /**
     * Compute the average x-coordinate of a list of marbles.
     * @param marbles The list of marbles to consider.
     * @return The average x-coordinate of all the marbles in
     *         the list, or zero if the list is empty.
     */
    public int averageX(List<Marble> marbles)
    {
        int avg = 0;
        
        if (marbles.size() > 0)
        {
            int sum = 0;
            for (Marble marble : marbles)
            {
                sum += marble.getGridX();
            }
            avg = sum / marbles.size();
        }
        
        return avg;
    }
    

    // ----------------------------------------------------------
    /**
     * Compares the x-coordinate of this marble to the average
     * x-coordinate of its neighbors up to two rows away, and
     * moves either 1 cell to the left (if the average is smaller),
     * 1 cell to the right (if the average is larger), or stays
     * stationary (if the average and the current x-position are
     * the same).
     */
    public void act()
    {
        int avg = this.averageX(this.getFriends());
        
        if (this.getGridX() < avg)
        {
            this.move(1);
        }
        else if (this.getGridX() > avg)
        {
            this.move(-1);
        }
    }
}
