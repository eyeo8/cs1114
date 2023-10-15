import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the Acid class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class AcidTest extends TestCase
{
    //~ Fields ................................................................
    
    private ParticleWorld world;
    private Acid acid;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AcidTest test object.
     */
    public AcidTest()
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
        acid = new Acid();
    }


    // ----------------------------------------------------------
    
    /**
     * Tests if dissolveIfPossible() weakens itself and the object
     * at a specified location when the object will dissolve.
     */
    public void testDissolveIfPossibleSand()
    {
        Sand sand = new Sand();
        
        world.add(sand, 200, 200);
        world.add(acid, 201, 200);
        
        acid.dissolveIfPossible(200, 200);
        
        assertEquals(sand.getStrength(), 99);
        assertEquals(acid.getStrength(), 99);
    }
    
    /**
     * Tests if nothing happens when this acid
     * is not in the world.
     */
    public void testDissolveIfPossibleGone()
    {
        world.add(acid, 201, 200);
        acid.remove();
        
        acid.dissolveIfPossible(200, 200);
        
        assertEquals(acid.getStrength(), 100);
    }
    
    /**
     * Tests if nothing happens when the object
     * at a specified location will not dissolve.
     */
    public void testDissolveIfPossibleWater()
    {
        Water water = new Water();
        
        world.add(water, 200, 200);
        world.add(acid, 201, 200);
        
        acid.dissolveIfPossible(200, 200);
        
        assertEquals(water.getStrength(), 100);
        assertEquals(acid.getStrength(), 100);
    }
    
    /**
     * Tests when the x coordinate is less than 0
     * and y coordinate is within bounds.
     */
    public void testDissolveIfPossibleOut()
    {
        Water water = new Water();
        
        world.add(acid, 200, 200);
        
        acid.dissolveIfPossible(-50, 230);
        
        assertEquals(water.getStrength(), 100);
        assertEquals(acid.getStrength(), 100);
    }
    
    /**
     * Tests when the x coordinate is out of bounds
     * but not the y coordinate.
     */
    public void testDissolveIfPossibleX()
    {
        Water water = new Water();
        
        world.add(water, 260, 210);
        world.add(acid, 200, 200);
        
        acid.dissolveIfPossible(260, 210);
        
        assertEquals(water.getStrength(), 100);
        assertEquals(acid.getStrength(), 100);
    }
    
    /**
     * Tests when the y coordinate is out of bounds
     * but not the x coordinate.
     */
    public void testDissolveIfPossibleY()
    {
        Water water = new Water();
        
        world.add(water, 210, 260);
        world.add(acid, 200, 200);
        
        acid.dissolveIfPossible(210, 260);
        
        assertEquals(water.getStrength(), 100);
        assertEquals(acid.getStrength(), 100);
    }
    
    /**
     * Tests if nothing happens when the object
     * at a specified location is null.
     */
    public void testDissolveIfPossibleNull()
    {
        world.add(acid, 201, 200);
        
        acid.dissolveIfPossible(200, 200);
        
        assertEquals(acid.getStrength(), 100);
    }
    
    /**
     * Tests if act dissolves neighbors correctly.
     */
    public void testAct()
    {
        Sand sand1 = new Sand();
        Sand sand2 = new Sand();
        Sand sand3 = new Sand();
        Sand sand4 = new Sand();
        
        world.add(acid, 200, 200);
        world.add(sand1, 199, 200);
        world.add(sand2, 201, 200);
        world.add(sand3, 200, 199);
        world.add(sand4, 200, 201);
        
        acid.act();
        
        assertEquals(acid.getStrength(), 96);
        assertEquals(sand1.getStrength(), 99);
        assertEquals(sand2.getStrength(), 99);
        assertEquals(sand3.getStrength(), 99);
        assertEquals(sand4.getStrength(), 99);
    }
    

}
