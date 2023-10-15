import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests for the Rocket and Space classes.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.21
 */
public class RocketTest extends TestCase
{
    //~ Fields ................................................................

    private World space;
    private Rocket rocket;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new RocketTest test object.
     */
    public RocketTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        space = new Space();
        rocket = newRocketWithCommands("");
    }


    // ----------------------------------------------------------
    /**
     * This helper method takes a string of command words as an argument,
     * uses them to set the contents of the built-in scanner in this test
     * case, and then creates a Rocket object using that scanner.
     * 
     * @param commands The string of commands to use as the scanner contents.
     * @return a new Rocket object created using a scanner connected
     * to the provided string of commands.
     */
    private Rocket newRocketWithCommands(String commands)
    {
        setIn(commands);
        return new Rocket(in());
    }


    // ----------------------------------------------------------
    /**
     * Test Rocket with a scanner containing three "forward" commands.
     */
    public void testForward()
    {
        rocket = newRocketWithCommands("forward forward forward\n");
        space.add(rocket, 0, 5);

        run(space, 10);

        // Check ending conditions:
        assertEquals(3, rocket.getGridX());
        assertEquals(5, rocket.getGridY());
        assertEquals(0.0, rocket.getRotation(), 0.1);
    }
    
    /**
     * Test Rocket with a scanner containing three "left" commands.
     */
    public void testLeft()
    {
        rocket = newRocketWithCommands("left forward\n");
        space.add(rocket, 0, 5);

        run(space, 10);

        // Check ending conditions:
        assertEquals(0, rocket.getGridX());
        assertEquals(4, rocket.getGridY());
        assertEquals(-90.0, rocket.getRotation(), 0.1);
    }
    
    /**
     * Test Rocket with a scanner containing three "right" commands.
     */
    public void testRight()
    {
        rocket = newRocketWithCommands("right forward\n");
        space.add(rocket, 0, 5);

        run(space, 10);

        // Check ending conditions:
        assertEquals(0, rocket.getGridX());
        assertEquals(6, rocket.getGridY());
        assertEquals(90.0, rocket.getRotation(), 0.1);
    }
    
    /**
     * Test Rocket with a scanner from a URL.
     */
    public void testRocket()
    {
        rocket = new Rocket();
        space.add(rocket, 4, 5);
        
        run(space, 30);
        
        assertEquals(3, rocket.getGridX());
        assertEquals(7, rocket.getGridY());
        assertEquals(90.0, rocket.getRotation(), 0.1);
    }
    
    /**
     * Test Rocket with a scanner containing three "Forward" commands.
     */
    public void testForwardCap()
    {
        rocket = newRocketWithCommands("Forward Forward Forward\n");
        space.add(rocket, 0, 5);

        run(space, 10);

        // Check ending conditions:
        assertEquals(3, rocket.getGridX());
        assertEquals(5, rocket.getGridY());
        assertEquals(0.0, rocket.getRotation(), 0.1);
    }
    

}
