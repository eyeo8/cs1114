import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the second Beach constructor.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.09
 */
public class BeachTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BeachTest test object.
     */
    public BeachTest()
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
        //inital setup
    }


    // ----------------------------------------------------------
    
    /**
     * Tests the second beach constructor.
     */
    public void testBeach()
    {
        // Initial conditions
        Beach beach = new Beach(3);
        
        // Expected outcomes
        assertEquals(3, beach.getObjects(Turtle.class).size());
    }

}
