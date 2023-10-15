import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the Sand class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class SandTest extends TestCase
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SandTest test object.
     */
    public SandTest()
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
        //initialize
    }


    // ----------------------------------------------------------
    
    /**
     * Tests the constructor.
     */
    public void testConstructor()
    {
        Sand sand = new Sand();
        
        assertTrue(sand.willDissolve());
    }

}
