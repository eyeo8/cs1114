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
 *  Models the behavior of a fluid.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class Fluid extends Particle
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Fluid object.
     * 
     * @param color The color of the fluid.
     * @param willDissolve Dissolvability of the fluid.
     * @param density The density of the fluid.
     */
    public Fluid(Color color, boolean willDissolve, double density)
    {
        super(color, willDissolve, density);
    }


    //~ Methods ...............................................................
    
    /**
     * Overries the dodge in the Particle class. The particle will "flow left"
     * by swapping places with what is immediately to its left (x - 1, y + 0)
     * if possible. If it can't flow left, the particle will "flow right" by
     * swapping places with what is immediately to its right (x + 1, y + 0)
     * if possible.
     * 
     * @return true if the particle flows to the left or right.
     *         false if the particle does not move.
     */
    @Override
    public boolean dodge()
    {
        if (super.dodge())
        {
            return true;
        }
        else
        {
            int x = this.getGridX();
            int y = this.getGridY();
            
            if (super.swapPlacesIfPossible(x - 1, y))
            {
                return true;
            }
            else if (super.swapPlacesIfPossible(x + 1, y))
            {
                return true;
            }
        }
        return false;
    }
    
    
    
    
}
