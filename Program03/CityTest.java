import sofia.micro.*;
import sofia.util.Random;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the City class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.20
 */
public class CityTest extends TestCase
{
    //~ Fields ................................................................
    private City city;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CityTest test object.
     */
    public CityTest()
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
        // city size will change for each test methods
    }


    // ----------------------------------------------------------
    
    /**
     * Tests if the width and height are set up
     * correctly when given its parameters. 
     */
    public void testCity()
    {
        city = new City(20, 20);
        
        assertEquals(20, city.getWidth());
        assertEquals(20, city.getHeight());
    }
    
    /**
     * Tests populate to see if it places an elephant
     * when the random value is less than or euqal to the 
     * elephant percentage parameter, e.
     */
    public void testPopulateE()
    {
        city = new City(1, 1);
        Random.setNextDoubles(0.1);
        
        city.populate(0.3, 0.4, 0.3);
        
        Agent obj = city.getOneObjectAt(0, 0, Agent.class);
        
        assertEquals(obj.getKind(), "elephant");
    }
    
    /**
     * Tests populate to see if it places a monkey
     * when the random value is less or equal to the sum
     * of elephant percentage parameter, e and 
     * monkey percentage parameter, m. 
     */
    public void testPopulateM()
    {
        city = new City(1, 1);
        Random.setNextDoubles(0.5);
        
        city.populate(0.3, 0.4, 0.3);
        
        Agent obj = city.getOneObjectAt(0, 0, Agent.class);
        
        assertEquals(obj.getKind(), "monkey");
    }
    
    /**
     * Tests populate to see if it doesn't place
     * an agent when the random value is larger
     * than the sum of e and m.
     */
    public void testPopulateEmpty()
    {
        city = new City(1, 1);
        Random.setNextDoubles(0.9);
        
        city.populate(0.3, 0.4, 0.3);
        
        Agent obj = city.getOneObjectAt(0, 0, Agent.class);
        
        assertEquals(obj, null);
    }
    
    

}
