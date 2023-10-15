import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the Fluid class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class FluidTest extends TestCase
{
    //~ Fields ................................................................
    
    private ParticleWorld world;
    private Fluid fluid;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FluidTest test object.
     */
    public FluidTest()
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
        world = new ParticleWorld();
    }


    // ----------------------------------------------------------
    
    /**
     * Tests if dodge() returns true and "flows" to the left.
     */
    public void testDodgeLeft()
    {
        fluid = new Fluid(Color.aqua, false, 5);
        Particle fluid2 = new Fluid(Color.red, false, 8);
        Particle fluid3 = new Fluid(Color.green, false, 7);
        Particle fluid4 = new Fluid(Color.yellow, false, 9);
        Particle fluid5 = new Fluid(Color.yellow, false, 3);
        Particle fluid6 = new Fluid(Color.yellow, false, 9);
        
        world.add(fluid, 50, 248);
        world.add(fluid2, 51, 249);
        world.add(fluid3, 50, 249);
        world.add(fluid4, 49, 249);
        world.add(fluid5, 49, 248);
        world.add(fluid6, 51, 248);
        
        assertTrue(fluid.dodge());
        assertEquals(fluid.getGridX(), 49);
        assertEquals(fluid.getGridY(), 248);
    }
    
    /**
     * Tests if dodge() returns true and "flows" to the right.
     */
    public void testDodgeRight()
    {
        fluid = new Fluid(Color.aqua, false, 5);
        Particle fluid2 = new Fluid(Color.red, false, 8);
        Particle fluid3 = new Fluid(Color.green, false, 7);
        Particle fluid4 = new Fluid(Color.yellow, false, 9);
        Particle fluid5 = new Fluid(Color.yellow, false, 8);
        Particle fluid6 = new Fluid(Color.yellow, false, 3);
        
        world.add(fluid, 50, 248);
        world.add(fluid2, 51, 249);
        world.add(fluid3, 50, 249);
        world.add(fluid4, 49, 249);
        world.add(fluid5, 49, 248);
        world.add(fluid6, 51, 248);
        
        assertTrue(fluid.dodge());
        assertEquals(fluid.getGridX(), 51);
        assertEquals(fluid.getGridY(), 248);
    }
    
    /**
     * Tests if dodge() returns false and stays
     * still when it's not possible flow left or right.
     */
    public void testDodgeStay()
    {
        fluid = new Fluid(Color.aqua, false, 5);

        assertFalse(fluid.dodge());
    }
    
    /**
     * Tests if dodge() returns false when its superclass'
     * dodge() returns true.
     */
    public void testDodgeSuper()
    {
        fluid = new Fluid(Color.aqua, false, 5);
        Particle fluid2 = new Fluid(Color.red, false, 3);
        Particle fluid3 = new Fluid(Color.green, false, 7);
        Particle fluid4 = new Fluid(Color.yellow, false, 9);
        
        world.add(fluid, 50, 248);
        world.add(fluid2, 50, 249);
        world.add(fluid3, 49, 249);
        world.add(fluid4, 51, 249);
        
        assertTrue(fluid.dodge());
    }

}
