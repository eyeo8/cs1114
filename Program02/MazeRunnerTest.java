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
 *  Tests the MazeRunner class to see
 *  if it clears the objects and end up
 *  at the desired location.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.20
 */
public class MazeRunnerTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    
    /**
     * Tests myProgram() to see if it clears
     * all objects and end up at (1, 1).
     */
    public void testMyProgram()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 9, 11);

         // Test method call(s)
        jerry.myProgram();

         // Expected outcomes
        assertEquals(0, island.getObjects(Net.class).size());
        assertEquals(0, island.getObjects(Flower.class).size());
        
        assertEquals(1, jerry.getGridX());
        assertEquals(1, jerry.getGridY());
    }
    
    /**
     * Tests clearObj() to see if it clears
     * all the nets and flowers.
     */
    public void testClearObj()
    {
         // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 9, 11);

         // Test method call(s)
        jerry.clearObj();

         // Expected outcomes
        assertEquals(0, island.getObjects(Net.class).size());
        assertEquals(0, island.getObjects(Flower.class).size());
    }
    
    
    /**
     * Tests the first if statement in the 
     * while loop inside clearObj() when it's true
     */
    public void testHugWall()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 5, 7);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(5, jerry.getGridX());
        assertEquals(8, jerry.getGridY());
        
        assertTrue(jerry.isFacing(SOUTH));
    }
    
    /**
     * Tests the first if statement in the 
     * while loop inside clearObj() when it's false.
     */
    public void testHugWall1()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 3, 11);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(4, jerry.getGridX());
        assertEquals(11, jerry.getGridY());
        
        assertTrue(jerry.isFacing(EAST));
    }
    
    /**
     * Tests the first else if statement in the 
     * while loop inside clearObj().
     * All conditions all true.
     */
    public void testHugWall2()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 1, 11);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(2, jerry.getGridX());
        assertEquals(11, jerry.getGridY());
        
        assertTrue(jerry.isFacing(EAST));
    }
    
    /**
     * Tests the first else if statement in the 
     * while loop inside clearObj().
     * All conditions are false.
     */
    public void testHugWall3()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 3, 10);
        jerry.turn(LEFT);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(3, jerry.getGridX());
        assertEquals(9, jerry.getGridY());
        
        assertTrue(jerry.isFacing(NORTH));
    }
    
    /**
     * Tests the first else if statement in the 
     * while loop inside clearObj().
     * The first condition is true, 
     * the second condition is false.
     */
    public void testHugWall4()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 9, 10);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(9, jerry.getGridX());
        assertEquals(11, jerry.getGridY());
        
        assertTrue(jerry.isFacing(SOUTH));
    }
    
    /**
     * Tests the first else if statement in the 
     * while loop inside clearObj().
     * First two conditions are true,
     * last condition is false.
     */
    public void testHugWall5()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 9, 11);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(9, jerry.getGridX());
        assertEquals(10, jerry.getGridY());
        
        assertTrue(jerry.isFacing(NORTH));
    }
    
    /**
     * Tests the second else if statement in the 
     * while loop inside clearObj().
     * All conditions are true.
     */
    public void testHugWall6()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 9, 11);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(9, jerry.getGridX());
        assertEquals(10, jerry.getGridY());
        
        assertTrue(jerry.isFacing(NORTH));
    }
    
    /**
     * Tests the second else if statement in the 
     * while loop inside clearObj().
     * First condition is true,
     * second condition is false.
     */
    public void testHugWall7()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 9, 10);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(9, jerry.getGridX());
        assertEquals(11, jerry.getGridY());
        
        assertTrue(jerry.isFacing(SOUTH));
    }
    
    /**
     * Tests the second else if statement in the 
     * while loop inside clearObj().
     * First condition is false,
     * second condition is true.
     */
    public void testHugWall8()
    {
        // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 4, 11);
        
        // Test method call(s)
        if (!jerry.seesWater(RIGHT))
        {
            jerry.turn(RIGHT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT) && 
            jerry.seesWater(LEFT))
        {
            jerry.turn(LEFT);
            jerry.turn(LEFT);
        }
        
        else if (jerry.seesWater(AHEAD) && 
            jerry.seesWater(RIGHT))
        {
            jerry.turn(LEFT);
        }
        
        while (jerry.seesNet(AHEAD))
        {
            jerry.toss();
        }
        
        while (jerry.seesFlower(HERE))
        {
            jerry.pick();
        }
        
        jerry.hop();
        
        // Expected outcomes
        assertEquals(5, jerry.getGridX());
        assertEquals(11, jerry.getGridY());
        
        assertTrue(jerry.isFacing(EAST));
    }
    
    
    /**
     * Tests go2End() to see if it takes the 
     * MazeRunner to the final location. 
     */
    public void testGo2End()
    {
         // Initial conditions
        Island island = new MazeIsland(65);
        MazeRunner jerry = new MazeRunner();
        island.add(jerry, 9, 11);
        jerry.clearObj();

         // Test method call(s)
        jerry.go2End();

         // Expected outcomes
        assertEquals(1, jerry.getGridX());
        assertEquals(1, jerry.getGridY());
    }
    
    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
