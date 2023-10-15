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
 *  Tests the Turtle Actor subclass.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.09
 */
public class TurtleTest extends TestCase
{
    //~ Fields ................................................................
    private Beach beach;
    private Turtle turtle;
    private Marker marker;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new TurtleTest test object.
     */
    public TurtleTest()
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
        beach = new Beach();
        turtle = new Turtle();
        marker = new Marker();
    }


    // ----------------------------------------------------------
    
    /**
     * Tests if the turtle turns right
     * when the random boolean is true.
     */
    public void testRandomTurnRight()
    {
        // Initial conditions
        beach.add(turtle, 1, 1);
        Random.setNextBooleans(true);
        
        // Test method call(s)
        turtle.randomTurn();
        
        // Expected outcomes
        assertEquals(1, turtle.getGridX());
        assertEquals(1, turtle.getGridY());
        assertEquals(90, turtle.getRotation(), 0.01f);
    }
    
    /**
     * Tests if the turtle turns left
     * when the random boolean is false.
     */
    public void testRandomTurnLeft()
    {
        // Initial conditions
        beach.add(turtle, 1, 1);
        Random.setNextBooleans(false);
        
        // Test method call(s)
        turtle.randomTurn();
        
        // Expected outcomes
        assertEquals(1, turtle.getGridX());
        assertEquals(1, turtle.getGridY());
        assertEquals(-90, turtle.getRotation(), 0.01f);
    }
    
    /**
     * Tests if markerHere() returns true when
     * there is a marker at the turtle's postition.
     */
    public void testMarkerHereTrue()
    {
        // Initial conditions
        beach.add(marker, 1, 1);
        beach.add(turtle, 1, 1);
        
        // Expected outcomes
        assertEquals(true, turtle.markerHere());
    }
    
    /**
     * Tests if markerHere() returns false when
     * there isn't a marker at the turtle's postition.
     */
    public void testMarkerHereFalse()
    {
        // Initial conditions
        beach.add(marker, 2, 1);
        beach.add(turtle, 1, 1);
        
        // Expected outcomes
        assertEquals(false, turtle.markerHere());
    }
    
    /**
     * Tests if the turtle moves without dropping
     * a new marker when there is a marker at 
     * the turtle's position.
     */
    public void testMoveMarker()
    {
        // Initial conditions
        beach.add(marker, 1, 1);
        beach.add(turtle, 1, 1);
        
        // Test method call(s)
        turtle.move();
        
        // Expected outcomes
        assertEquals(2, turtle.getGridX());
        assertEquals(1, turtle.getGridY());
        assertEquals(1, beach.getObjects(Marker.class).size());
    }
    
    /**
     * Tests if the turtle moves after dropping
     * a new marker when there is no marker at 
     * the turtle's position.
     */
    public void testMoveNoMarker()
    {
        // Initial conditions
        beach.add(turtle, 1, 1);
        
        // Test method call(s)
        turtle.move();
        
        // Expected outcomes
        assertEquals(2, turtle.getGridX());
        assertEquals(1, turtle.getGridY());
        assertEquals(1, beach.getObjects(Marker.class).size());
    }
    
    /**
     * Tests if the turtle moves dist steps.
     */
    public void testMoveInt()
    {
        // Initial conditions
        beach.add(turtle, 1, 1);
        
        // Test method call(s)
        turtle.move(3);
        
        // Expected outcomes
        assertEquals(4, turtle.getGridX());
        assertEquals(1, turtle.getGridY());
        assertEquals(3, beach.getObjects(Marker.class).size());
    }
    
    /**
     * Tests act() when randomTurn() is true.
     */
    public void testActRight()
    {
        // Initial conditions
        beach.add(turtle, 1, 1);
        Random.setNextInts(3);
        Random.setNextBooleans(true);
        
        // Test method call(s)
        turtle.act();
        
        // Expected outcomes
        assertEquals(5, turtle.getGridX());
        assertEquals(1, turtle.getGridY());
        assertEquals(4, beach.getObjects(Marker.class).size());
        assertEquals(90, turtle.getRotation(), 0.01f);
    }
    
    /**
     * Tests act() when randomTurn() is false.
     */
    public void testActLeft()
    {
        // Initial conditions
        beach.add(turtle, 1, 1);
        Random.setNextInts(3);
        Random.setNextBooleans(false);
        
        // Test method call(s)
        turtle.act();
        
        // Expected outcomes
        assertEquals(5, turtle.getGridX());
        assertEquals(1, turtle.getGridY());
        assertEquals(4, beach.getObjects(Marker.class).size());
        assertEquals(-90, turtle.getRotation(), 0.01f);
    }
    
}
