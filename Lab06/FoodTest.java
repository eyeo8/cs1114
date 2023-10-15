import sofia.micro.*;
import static sofia.micro.jeroo.CompassDirection.*;
import sofia.util.Random;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests for the Food class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.02
 */
public class FoodTest extends TestCase
{
    //~ Fields ................................................................
    private Food pizza;
    private PizzaHut pizzahut;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FoodTest test object.
     */
    public FoodTest()
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
    }


    // ----------------------------------------------------------
    
    
    
    
    
    /**
     * Tests act() when random number is 0
     * and the location is at top left.
     */
    public void testActAtTopLeft0()
    {
        // Initial conditions
        pizzahut.add(pizza, 0, 0);
        Random.setNextInts(0);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(0, pizza.getGridX());
        assertEquals(0, pizza.getGridY());
        assertEquals(NORTH, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 0
     * and the location is at top right.
     */
    public void testActAtTopRight0()
    {
        // Initial conditions
        pizzahut.add(pizza, 11, 0);
        Random.setNextInts(0);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(11, pizza.getGridX());
        assertEquals(0, pizza.getGridY());
        assertEquals(NORTH, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 0
     * and the location is at bottom left.
     */
    public void testActAtBottomLeft0()
    {
        // Initial conditions
        pizzahut.add(pizza, 0, 11);
        Random.setNextInts(0);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(0, pizza.getGridX());
        assertEquals(10, pizza.getGridY());
        assertEquals(NORTH, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 0
     * and the location is at bottom right.
     */
    public void testActAtBottomRight0()
    {
        // Initial conditions
        pizzahut.add(pizza, 11, 11);
        Random.setNextInts(0);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(11, pizza.getGridX());
        assertEquals(10, pizza.getGridY());
        assertEquals(NORTH, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 1
     * and the location is at top left.
     */
    public void testActAtTopLeft1()
    {
        // Initial conditions
        pizzahut.add(pizza, 0, 0);
        Random.setNextInts(1);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(0, pizza.getGridX());
        assertEquals(1, pizza.getGridY());
        assertEquals(SOUTH, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 1
     * and the location is at top right.
     */
    public void testActAtTopRight1()
    {
        // Initial conditions
        pizzahut.add(pizza, 11, 0);
        Random.setNextInts(1);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(11, pizza.getGridX());
        assertEquals(1, pizza.getGridY());
        assertEquals(SOUTH, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 1
     * and the location is at bottom left.
     */
    public void testActAtBottomLeft1()
    {
        // Initial conditions
        pizzahut.add(pizza, 0, 11);
        Random.setNextInts(1);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(0, pizza.getGridX());
        assertEquals(11, pizza.getGridY());
        assertEquals(SOUTH, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 1
     * and the location is at bottom right.
     */
    public void testActAtBottomRight1()
    {
        // Initial conditions
        pizzahut.add(pizza, 11, 11);
        Random.setNextInts(1);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(11, pizza.getGridX());
        assertEquals(11, pizza.getGridY());
        assertEquals(SOUTH, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 2
     * and the location is at top left.
     */
    public void testActAtTopLeft2()
    {
        // Initial conditions
        pizzahut.add(pizza, 0, 0);
        Random.setNextInts(2, 3);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(1, pizza.getGridX());
        assertEquals(0, pizza.getGridY());
        assertEquals(EAST, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 2
     * and the location is at top right.
     */
    public void testActAtTopRight2()
    {
        // Initial conditions
        pizzahut.add(pizza, 11, 0);
        Random.setNextInts(2, 3);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(11, pizza.getGridX());
        assertEquals(0, pizza.getGridY());
        assertEquals(EAST, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 2
     * and the location is at bottom left.
     */
    public void testActAtBottomLeft2()
    {
        // Initial conditions
        pizzahut.add(pizza, 0, 11);
        Random.setNextInts(2, 3);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(1, pizza.getGridX());
        assertEquals(11, pizza.getGridY());
        assertEquals(EAST, pizza.getDirection());
    }
    
    /**
     * Tests act() when random number is 2
     * and the location is at bottom right.
     */
    public void testActAtBottomRight2()
    {
        // Initial conditions
        pizzahut.add(pizza, 11, 11);
        Random.setNextInts(2, 3);
        
        // Test method call(s)
        pizza.act();
        
        // Expected outcomes
        assertEquals(11, pizza.getGridX());
        assertEquals(11, pizza.getGridY());
        assertEquals(EAST, pizza.getDirection());
    }
    
//     /**
//      * Tests act() when random number is 3
//      * and the location is at top left.
//      */
//     public void testActAtTopLeft3()
//     {
//         // Initial conditions
//         pizzahut.add(pizza, 0, 0);
//         Random.setNextInts(3);
//         
//         // Test method call(s)
//         pizza.act();
//         
//         // Expected outcomes
//         assertEquals(1, pizza.getGridX());
//         assertEquals(0, pizza.getGridY());
//         assertEquals(EAST, pizza.getDirection());
//     }
//     
//     /**
//      * Tests act() when random number is 3
//      * and the location is at top right.
//      */
//     public void testActAtTopRight3()
//     {
//         // Initial conditions
//         pizzahut.add(pizza, 11, 0);
//         Random.setNextInts(3);
//         
//         // Test method call(s)
//         pizza.act();
//         
//         // Expected outcomes
//         assertEquals(11, pizza.getGridX());
//         assertEquals(0, pizza.getGridY());
//         assertEquals(EAST, pizza.getDirection());
//     }
//     
//     /**
//      * Tests act() when random number is 3
//      * and the location is at bottom left.
//      */
//     public void testActAtBottomLeft3()
//     {
//         // Initial conditions
//         pizzahut.add(pizza, 0, 11);
//         Random.setNextInts(3);
//         
//         // Test method call(s)
//         pizza.act();
//         
//         // Expected outcomes
//         assertEquals(1, pizza.getGridX());
//         assertEquals(11, pizza.getGridY());
//         assertEquals(EAST, pizza.getDirection());
//     }
//     
//     /**
//      * Tests act() when random number is 3
//      * and the location is at bottom right.
//      */
//     public void testActAtBottomRight3()
//     {
//         // Initial conditions
//         pizzahut.add(pizza, 11, 11);
//         Random.setNextInts(3);
//         
//         // Test method call(s)
//         pizza.act();
//         
//         // Expected outcomes
//         assertEquals(11, pizza.getGridX());
//         assertEquals(11, pizza.getGridY());
//         assertEquals(EAST, pizza.getDirection());
//     }
    
    

}
