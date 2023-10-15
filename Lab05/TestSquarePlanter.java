import sofia.micro.*;
import sofia.micro.jeroo.*;
import static sofia.micro.jeroo.CompassDirection.*;
import static sofia.micro.jeroo.RelativeDirection.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (906349574)

// -------------------------------------------------------------------------
/**
 *  Tests the SquarePlanter class to see if 
 *  it plants the right amount of flowers
 *  in squares in the appropriate manner. 
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.23
 */
public class TestSquarePlanter extends TestCase
{
    //~ Fields ................................................................
    private Island island;
    private SquarePlanter jeroo;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new TestSquarePlanter test object.
     */
    public TestSquarePlanter()
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
        island = new Island();
        jeroo = new SquarePlanter(5);
        island.add(jeroo, 1, 1);
    }
    


    // ----------------------------------------------------------
    
    /**
     * Tests plantOneSide() to see if it 
     * plants the right number of flowers.
     */
    public void testPlantOneSide()
    {
         // Test method call(s)
        jeroo.plantOneSide();
         
          // Expected outcomes
        assertEquals(6, jeroo.getGridX());
        assertEquals(1, jeroo.getGridY());
        
        assertTrue(jeroo.isFacing(SOUTH));
        
        assertEquals(5, island.getObjects(Flower.class).size());
    }
    
    /**
     * Tests myProgram() to see if it
     * plants the right number of flowers
     * and returns to its starting location.
     */
    public void testMyProgram()
    {
         // Initial conditions
         // Test method call(s)
        jeroo.myProgram();

         // Expected outcomes
        assertEquals(1, jeroo.getGridX());
        assertEquals(1, jeroo.getGridY());
        
        assertTrue(jeroo.isFacing(EAST));
        
        assertEquals(20, island.getObjects(Flower.class).size());
    }
    
    /**
     * Tests myProgram() with a differnt number
     * of flowers. Also checks if it
     * plants the right number of flowers
     * and returns to its starting location.
     */
    public void testMyProgram2()
    {
         // initial conditions
         // remove the jeroo created by setUp()
        jeroo.remove();
         // create a new jeroo
        jeroo = new SquarePlanter(2);
        island.add(jeroo, 1, 1);
        
         // Method call(s)
         // plant the square
        jeroo.myProgram();
        
         // Expected outcomes
        assertEquals(1, jeroo.getGridX());
        assertEquals(1, jeroo.getGridY());
        
        assertTrue(jeroo.isFacing(EAST));
        
        assertEquals(8, island.getObjects(Flower.class).size());
    }
    

}
