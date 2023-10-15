import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests for the Shark class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.23
 */
public class SharkTest extends TestCase
{
    //~ Fields ................................................................

    private Ocean ocean;
    private Shark shark;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SharkTest test object.
     */
    public SharkTest()
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
        ocean = new Ocean();
        shark = new Shark();
    }


    // ----------------------------------------------------------
    /**
     * Test the second constructor for Ocean, that adds minnows
     * and sharks.
     */
    public void testOceanConstructor()
    {
        ocean = new Ocean(7, 3);
        
        // Make sure 7 minnows were created
        assertEquals(7, ocean.getObjects(Minnow.class).size());

        // Make sure 3 sharks were created
        assertEquals(3, ocean.getObjects(Shark.class).size());
    }


    // ----------------------------------------------------------
    /**
     * Test distanceOf() for a straight horizontal distance.
     */
    public void testDistance1()
    {
        Minnow minnow = new Minnow();
        ocean.add(minnow, 50, 100);
        ocean.add(shark, 50, 50);

        // When comparing floating point numbers, ALWAYS provide
        // a third arg saying how close they are expected to be,
        // since floating point math isn't exact.
        assertEquals(50.0, shark.distanceTo(minnow), 0.1);
    }


    // ----------------------------------------------------------
    /**
     * Test distanceOf() for a diagonal distance.
     */
    public void testDistance2()
    {
        Minnow minnow = new Minnow();
        ocean.add(minnow, 100, 100);
        ocean.add(shark, 50, 50);

        // When comparing floating point numbers, ALWAYS provide
        // a third arg saying how close they are expected to be,
        // since floating point math isn't exact.
        assertEquals(70.7, shark.distanceTo(minnow), 0.1);
    }
    
    /**
     * Test if shark returns null when there is 
     * no minnow in the ocean.
     */
    public void testNearest0()
    {
        ocean.add(shark, 50, 50);
        
        assertEquals(shark.nearestMinnow(), null);
    }
    
    /**
     * Test if shark returns the nearest minnow
     * when there is one minnow in the ocean.
     */
    public void testNearest1()
    {
        Minnow minnow = new Minnow();
        
        ocean.add(minnow, 200, 200);
        
        ocean.add(shark, 50, 50);
        
        assertEquals(shark.nearestMinnow(), minnow);
    }
    
    
    /**
     * Test if shark returns the nearest minnow when
     * there are two minnows at different distances.
     */
    public void testNearest2()
    {
        Minnow minnow = new Minnow();
        Minnow least = new Minnow();
        
        ocean.add(least, 100, 100);
        ocean.add(minnow, 300, 300);
        
        ocean.add(shark, 50, 50);
        
        Minnow nearest = shark.nearestMinnow();
        
        assertEquals(nearest, least);
    }
    
    /**
     * Test if the shark swims towards the minnow.
     */
    public void testAct()
    {
        Minnow minnow = new Minnow();
        
        ocean.add(minnow, 250, 250);
        ocean.add(shark, 100, 100);
        
        shark.act();
        
        assertEquals(shark.getGridX(), 101);
        assertEquals(shark.getGridY(), 101);
    }
    
    /**
     * Test is the shark eats the minnow when they overlap.
     */
    public void testEat()
    {
        Minnow minnow = new Minnow();
        
        ocean.add(minnow, 100, 100);
        ocean.add(shark, 100, 100);
        
        shark.eat(minnow);
        
        //assertEquals(ocean.getObjects(Minnow.class), null);
        assertEquals(shark.getStomachContents().get(0), minnow);
    }
    
}
