import sofia.micro.*;
import sofia.micro.jeroo.*;
import static sofia.micro.jeroo.CompassDirection.*;
import static sofia.micro.jeroo.RelativeDirection.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Unit tests for the CopyingJeroo class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.19
 */
public class CopyingJerooTest extends TestCase
{
    //~ Fields ................................................................

    private Island island;
    private CopyingJeroo jeroo;
    private Jeroo copier;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CopyingJerooTest test object.
     */
    public CopyingJerooTest()
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
        island = new DualIsland();
        copier = new Jeroo(1000);
        jeroo = new CopyingJeroo(copier);
        island.add(jeroo, 1, 1);
        island.add(copier, 10, 1);
    }


    // ----------------------------------------------------------
    /**
     * Check hopToWater(), assuming that setUp() places the
     * jeroo at (1, 1) facing east.
     */
    public void testHopToWater()
    {
        jeroo.hopToWater();
        
        assertEquals(8, jeroo.getGridX());
        assertTrue(jeroo.seesWater(AHEAD));
    }
    
    /**
     * Test overriden hop() by checking
     * if both jeroo and copier's positions
     * are the same after hop().
     */
    public void testHop()
    {
        jeroo.hop();
        
        assertEquals(2, jeroo.getGridX());
        assertEquals(11, copier.getGridX());
    }
    
    /**
     * Test overriden turn() by checking
     * the jeroo and copier's orientations.
     */
    public void testTurn()
    {
        jeroo.turn(RIGHT);
        
        assertTrue(jeroo.isFacing(SOUTH));
        assertTrue(copier.isFacing(SOUTH));
    }
    
    /**
     * Test if the jeroo turns 180 degrees when facing east.
     */
    public void testTurnRightCorner()
    {
        jeroo.setGridLocation(8, 1);
        copier.setGridLocation(17, 1);
        jeroo.turnRightCorner();
        
        assertTrue(jeroo.isFacing(WEST));
        assertTrue(copier.isFacing(WEST));
        assertEquals(8, jeroo.getGridX());
        assertEquals(17, copier.getGridX());
        assertEquals(2, jeroo.getGridY());
        assertEquals(2, copier.getGridY());
    }
    
    /**
     * Test if the jeroo turns 180 degrees when facing west.
     */
    public void testTurnLeftCorner()
    {
        jeroo.setGridLocation(1, 2);
        copier.setGridLocation(10, 2);
        jeroo.turn(LEFT);
        jeroo.turn(LEFT);
        
        jeroo.turnLeftCorner();
        
        assertTrue(jeroo.isFacing(EAST));
        assertTrue(copier.isFacing(EAST));
        assertEquals(1, jeroo.getGridX());
        assertEquals(10, copier.getGridX());
        assertEquals(3, jeroo.getGridY());
        assertEquals(3, copier.getGridY());
    }
    
    /**
     * Test if copier plants a flower
     * when there is a flower at CopyingJeroo's
     * location.
     */
    public void testPlantFlower()
    {
        jeroo.setGridLocation(2, 2);
        copier.setGridLocation(11, 2);
        
        jeroo.plantFlower();
        
        assertEquals(16, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test if the copier copies the flower pattern
     * shown on the left island.
     */
    public void testMyProgram1()
    {
        jeroo.setGridLocation(1, 1);
        copier.setGridLocation(10, 1);
        
        jeroo.myProgram();
        
        assertEquals(30, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test if the copier copies the flower pattern
     * shown on the left island when it's at the 
     * top right end of the island.
     */
    public void testMyProgram2()
    {
        jeroo.setGridLocation(8, 1);
        copier.setGridLocation(17, 1);
        
        jeroo.myProgram();
        
        assertEquals(30, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test if the copier copies the flower pattern
     * shown on the left island when it's at the 
     * top left end of the island.
     */
    public void testMyProgram3()
    {
        jeroo.setGridLocation(1, 2);
        copier.setGridLocation(10, 2);
        jeroo.turn(LEFT);
        jeroo.turn(LEFT);
        
        jeroo.myProgram();
        
        assertEquals(29, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test if the copier copies the flower pattern
     * shown on the left island when it doesn't see
     * water ahead but is facing west.
     */
    public void testMyProgram4()
    {
        jeroo.setGridLocation(8, 1);
        copier.setGridLocation(17, 1);
        
        jeroo.myProgram();
        
        assertEquals(30, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test if the jeroo and copier don't move
     * when the jeroo is at (1, 8).
     */
    public void testMyProgram5()
    {
        jeroo.setGridLocation(1, 8);
        copier.setGridLocation(10, 8);
        
        jeroo.myProgram();
        
        assertEquals(1, jeroo.getGridX());
        assertEquals(10, copier.getGridX());
        assertEquals(8, jeroo.getGridY());
        assertEquals(8, copier.getGridY());
    }
    
    
}
