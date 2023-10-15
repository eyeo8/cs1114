import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the Steel class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class SteelTest extends TestCase
{
    //~ Fields ................................................................
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SteelTest test object.
     */
    public SteelTest()
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
     * Tests if isFalling() always returns false.
     */
    public void testIsFalling()
    {
        Steel steel = new Steel();
        assertFalse(steel.isFalling());
    }
    
    /**
     * Tests if dodge() always returns false.
     */
    public void testDodge()
    {
        Steel steel = new Steel();
        assertFalse(steel.dodge());
    }

}
