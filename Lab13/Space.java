import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  A simple world representing outer space--an environment for
 *  the remote-controlled rocket.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.21
 */
public class Space extends World
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Space object.
     */
    public Space()
    {
        super(10, 10, 60);
    }
}
