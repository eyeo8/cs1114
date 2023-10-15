// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Turns the rocket 90 degrees to the right.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.21
 */
public class RightCommand implements Command
{
    //~ Fields ................................................................

    private Rocket rocket;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    
    /**
     * Creates a new RightCommand object.
     * 
     * @param rock The rocket object.
     */
    public RightCommand(Rocket rock)
    {
        rocket = rock;
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    
    /**
     * Turns the rocket right.
     */
    public void execute()
    {
        rocket.turn(90);
    }
}
