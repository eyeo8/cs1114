import sofia.micro.*;
import java.util.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  A shark that chases and eats minnows.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.23
 */
public class Shark extends Actor
{
    //~ Fields ................................................................
    
    private List<Actor> stomach = new ArrayList<Actor>();



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Shark object.
     */
    public Shark()
    {
        super();
        stomach = new ArrayList<Actor>();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Calculate the distance to another actor.
     * 
     * @param actor The other actor.
     * @return The distance from this shark to the other actor.
     */
    public double distanceTo(Actor actor)
    {
        int xThis = this.getGridX();
        int yThis = this.getGridY();
        
        int xOther = actor.getGridX();
        int yOther = actor.getGridY();
        
        int xDistance = xOther - xThis;
        int yDistance = yOther - yThis;

        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }


    // ----------------------------------------------------------
    /**
     * Find the minnow nearest to this shark.
     * 
     * @return The minnow that is closest, if there is one, or
     *         null if there are no more minnows in the ocean.
     */
    public Minnow nearestMinnow()
    {
        List<Minnow> minnows = this.getWorld().getObjects(Minnow.class);
        Minnow nearest = null;
        
        if (minnows.size() > 0)
        {
            nearest = minnows.get(0);
            for (Minnow minnow : minnows)
            {
                if (this.distanceTo(minnow) < this.distanceTo(nearest))
                {
                    nearest = minnow;
                }
            }
        }
        
        return nearest;
    }
    
    /**
     * Examines the shark's stomach contents.
     * @return      a list of what the shark ate(removed)
     */
    public List<Actor> getStomachContents()
    {
        return stomach;
    }


    // ----------------------------------------------------------
    /**
     * Eat a minnow by removing it from the world and adding it
     * to this shark's stomach contents.
     * 
     * @param minnow The minnow to eat.
     */
    public void eat(Minnow minnow)
    {
        if (this.getOneIntersectingObject(Minnow.class) != null)
        {
            stomach.add(minnow);
            minnow.remove();
        }
        System.out.println(stomach);
    }


    // ----------------------------------------------------------
    /**
     * Sharks move towards the nearest minnow, eating it if they
     * reach it.
     */
    public void act()
    {
        if (this.nearestMinnow() != null)
        {
            this.turnTowards(this.nearestMinnow());
            this.move(1);
        }
    }
}
