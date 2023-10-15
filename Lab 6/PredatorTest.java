import sofia.micro.*;
import static sofia.micro.jeroo.RelativeDirection.*;
import static sofia.micro.jeroo.CompassDirection.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests for the Predator class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.02
 */
public class PredatorTest extends TestCase
{
    //~ Fields ................................................................
    private PizzaHut pizzahut;
    private Food pizza;
    private Predator rabbit;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PredatorTest test object.
     */
    public PredatorTest()
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
        pizzahut = new PizzaHut();
        pizza = new Food();
        rabbit = new Predator();
    }


    // ----------------------------------------------------------
    /**
     * Test act() method of predator when
     * it's facing east.
     */
    public void testActEast()
    {
        // Initial conditions
        pizzahut.add(rabbit, 1, 1);
        pizzahut.add(pizza, 2, 1);
        
        // Test method call(s)
        rabbit.act();
        
        // Expected outcomes
        assertEquals(2, rabbit.getGridX());
        assertEquals(1, rabbit.getGridY());
        assertEquals(EAST, rabbit.getDirection());
    }
    
    /**
     * Tests act() method of predator.
     */
    public void testActWest()
    {
        // Initial conditions
        pizzahut.add(rabbit, 5, 1);
        pizzahut.add(pizza, 4, 1);
        
        // Test method call(s)
        rabbit.act();
        
        // Expected outcomes
        assertEquals(4, rabbit.getGridX());
        assertEquals(1, rabbit.getGridY());
        assertEquals(WEST, rabbit.getDirection());
    }
    
    /**
     * Tests act() method of predator.
     */
    public void testActNORTH()
    {
        // Initial conditions
        pizzahut.add(rabbit, 1, 5);
        pizzahut.add(pizza, 1, 4);
        
        // Test method call(s)
        rabbit.act();
        
        // Expected outcomes
        assertEquals(1, rabbit.getGridX());
        assertEquals(4, rabbit.getGridY());
        assertEquals(NORTH, rabbit.getDirection());
    }
    
    /**
     * Tests act() method of predator.
     */
    public void testActSOUTH()
    {
        // Initial conditions
        pizzahut.add(rabbit, 1, 4);
        pizzahut.add(pizza, 1, 5);
        
        // Test method call(s)
        rabbit.act();
        
        // Expected outcomes
        assertEquals(1, rabbit.getGridX());
        assertEquals(5, rabbit.getGridY());
        assertEquals(SOUTH, rabbit.getDirection());
    }
    

}
