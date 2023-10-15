import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests for the RemoteTux class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.13
 */
public class RemoteTuxTest extends TestCase
{
    //~ Fields ................................................................

    private World iceField;
    private RemoteTux tux;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new RemoteTuxTest test object.
     */
    public RemoteTuxTest()
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
        iceField = new IceField();
        tux = newTuxWithCommands("");
    }


    // ----------------------------------------------------------
    /**
     * This helper method takes a string of command words as an argument,
     * uses them to set the contents of the built-in scanner in this test
     * case, and then creates a RemoteTux object using that scanner.
     * 
     * @param commands The string of commands to use as the scanner contents.
     * @return a new RemoteTux object created using a scanner connected
     * to the provided string of commands.
     */
    private RemoteTux newTuxWithCommands(String commands)
    {
        // Every test case already has a built-in scanner to use for
        // testing purposes.  This method sets the contents of the
        // built-in scanner using a string.
        setIn(commands);
        
        // The in() method returns the built-in scanner, so use it to
        // create a new actor connected to the built-in scanner, where
        // the scanner's contents were initialized in the previous line.
        return new RemoteTux(in());
    }


    // ----------------------------------------------------------
    /**
     * Test Tux with a scanner containing three "forward" commands.
     */
    public void testForward()
    {
        // Create a new actor connected to a scanner containing
        // the specified sequence of text (could be as manny lines
        // as you want--separate lines using \n's):
        tux = newTuxWithCommands("forward forward forward\n");

        // Add tux to the world:
        iceField.add(tux, 0, 5);

        // Run the world for 10 steps (more than enough, since there
        // are only three commands, which should finish after 3
        // steps.  But we go longer here to ensure that act() works
        // even when there are no more commands left).
        run(iceField, 10);

        // Check ending conditions:
        assertEquals(3, tux.getGridX());
        assertEquals(5, tux.getGridY());
        assertEquals(0.0, tux.getRotation(), 0.1);
    }
    
    /**
     * Test Tux with "forward", "left", and "right".
     */
    public void testMovement()
    {
        tux = newTuxWithCommands("forward left forward right forward left\n");
        
        iceField.add(tux, 0, 5);
        
        run(iceField, 10);
        
        assertEquals(2, tux.getGridX());
        assertEquals(4, tux.getGridY());
        assertEquals(-90.0, tux.getRotation(), 0.1);
    }
    
    /**
     * Test if act takes Tux to the right place.
     */
    public void testAct()
    {
        tux = new RemoteTux();
        
        iceField.add(tux, 5, 5);
        
        run(iceField, 20);
        
        assertEquals(4, tux.getGridX());
        assertEquals(7, tux.getGridY());
        assertEquals(90.0, tux.getRotation(), 0.1);
    }
    
    

}
