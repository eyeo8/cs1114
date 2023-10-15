import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Models the behavior of acid. Corrodes sand and steel.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class Acid extends Fluid
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Acid object.
     */
    public Acid()
    {
        super(Color.green, false, 1.0);
    }


    //~ Methods ...............................................................
    
    /**
     * Dissolves another particle at the specified location,
     * if appropriate. If the specified location is empty, then no action
     * happens. If the specified location is occupied by another particle,
     * and that other particle will dissolve in acid, then this method causes
     * the other particle to weaken and also causes the current acid particle
     * to weaken, too.
     * 
     * @param x The x coordinate of the other particle.
     * @param y The y coordinate of the other particle.
     */
    public void dissolveIfPossible(int x, int y)
    {
        if (this.getWorld() != null)
        {
            int width = this.getWorld().getWidth();
            int height = this.getWorld().getHeight();
            
            if (x >= 0 && x < width && y < height)
            {
                World world = this.getWorld();
                Particle obj = world.getOneObjectAt(x, y, Particle.class);
                if (obj != null && obj.willDissolve())
                {
                    this.weaken();
                    obj.weaken();
                }
            }
        }
    }
    
    /**
     * Dissolves adjacent particles to the left (x - 1, y + 0)
     * to the right (x + 1, y + 0), above (x + 0, y - 1),
     * and below (x + 0, y + 1), before performing the other aspects
     * of acting that it inherits from its superclass.
     */
    @Override
    public void act()
    {
        int x = this.getGridX();
        int y = this.getGridY();
        
        this.dissolveIfPossible(x - 1, y);
        this.dissolveIfPossible(x + 1, y);
        this.dissolveIfPossible(x, y - 1);
        this.dissolveIfPossible(x, y + 1);
        
        super.act();
    }


}
