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
 *  Models the behavior of sand.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class Steel extends Particle
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Steel object.
     */
    public Steel()
    {
        super(Color.gray, true, 7.87);
    }


    //~ Methods ...............................................................
    
    /**
     * This type of particle is used to form obstacles that we can consider 
     * "attached to the background", so steel particles don't fall.
     * 
     * @return false always.
     */
    @Override
    public boolean isFalling()
    {
        return false;
    }
    
    /**
     * Steel particles don't "fall", and they also don't slide 
     * or flow like other particles.
     * 
     * @return false always.
     */
    @Override
    public boolean dodge()
    {
        return false;
    }


}
