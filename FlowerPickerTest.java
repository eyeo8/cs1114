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
 *  Tests methods to turn around or pick flowers.
 *  Goal is to test pick methods on all flower patches.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.9.17
 */
public class FlowerPickerTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlowerPickerTest test object.
     */
    public FlowerPickerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................
    
    // ----------------------------------------------------------
    /**
     * Test the pickLine() method on flower patch A's northwest corner.
     */
    public void testPickLine()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 2, 2);

         // Test method call(s)
        picker.pickLine();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(6, picker.getGridX());
        assertEquals(2, picker.getGridY());
        
        assertTrue(picker.isFacing(EAST));
        
        assertEquals(37, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test the pickLine() method on flower patch E's southeast corner.
     */
    public void testPickLineE()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 10, 8);
        picker.turn(RIGHT);

         // Test method call(s)
        picker.pickLine();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(10, picker.getGridX());
        assertEquals(10, picker.getGridY());
        
        assertTrue(picker.isFacing(SOUTH));
        
        assertEquals(39, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test the turnAroundRight() method on flower patch A.
     */
    public void testTurnAroundRight()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 6, 2);

         // Test method call(s)
        picker.turnAroundRight();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(6, picker.getGridX());
        assertEquals(3, picker.getGridY());
        
        assertTrue(picker.isFacing(WEST));
        
        assertEquals(42, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test the turnAroundRight() method on flower patch B.
     */
    public void testTurnAroundLeft()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 2, 6);
        picker.turn(LEFT);
        picker.turn(LEFT);

         // Test method call(s)
        picker.turnAroundLeft();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(2, picker.getGridX());
        assertEquals(7, picker.getGridY());
        
        assertTrue(picker.isFacing(EAST));
        
        assertEquals(42, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test the pick2Lines() method on flower patch A.
     */
    public void testPick2LinesA()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 2, 2);

         // Test method call(s)
        picker.pick2Lines();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(2, picker.getGridX());
        assertEquals(3, picker.getGridY());
        
        assertTrue(picker.isFacing(WEST));
        
        assertEquals(32, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test the pick2Lines() method on flower patch E.
     */
    public void testPick2LinesE()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 9, 10);
        picker.turn(LEFT);

         // Test method call(s)
        picker.pick2Lines();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(10, picker.getGridX());
        assertEquals(10, picker.getGridY());
        
        assertTrue(picker.isFacing(SOUTH));
        
        assertEquals(36, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test the pick2Lines() method on flower patch B.
     */
    public void testPick4LinesB()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 2, 5);

         // Test method call(s)
        picker.pick2Lines();
        picker.turnAroundLeft();
        picker.pick2Lines();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(2, picker.getGridX());
        assertEquals(8, picker.getGridY());
        
        assertTrue(picker.isFacing(WEST));
        
        assertEquals(26, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test the pick2Lines() method on flower patch C.
     */
    public void testPick2LinesC()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 6, 9);

         // Test method call(s)
        picker.pick2Lines();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(6, picker.getGridX());
        assertEquals(10, picker.getGridY());
        
        assertTrue(picker.isFacing(WEST));
        
        assertEquals(39, island.getObjects(Flower.class).size());
    }
    
    /**
     * Test the pickLine() method on flower patch D
     */
    public void testPick2LinesD()
    {
         // Initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.add(picker, 9, 5);
        picker.turn(LEFT);

         // Test method call(s)
        picker.pickLine();
        picker.turnAroundLeft();
        picker.pickLine();

         // Expected outcomes
         // The Jeroo should end at (6, 2), so check the x-coordinate
        assertEquals(8, picker.getGridX());
        assertEquals(5, picker.getGridY());
        
        assertTrue(picker.isFacing(SOUTH));
        
        assertEquals(35, island.getObjects(Flower.class).size());
    }

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
