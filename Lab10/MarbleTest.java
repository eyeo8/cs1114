import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the Marble class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.30
 */
public class MarbleTest extends TestCase
{
    //~ Fields ................................................................

    private Ground ground;
    private Marble marble;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MarbleTest test object.
     */
    public MarbleTest()
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
        ground = new Ground(false);
        marble = new Marble();
        ground.add(marble, 6, 6);
    }


    // ----------------------------------------------------------
    
    /**
     * Tests if getMarbleAtHeight() returns the correct Marble object.
     */
    public void testGetMarbleAtHeight()
    {
        Marble testMarble1 = new Marble();
        Marble testMarble2 = new Marble();
        
        ground.add(testMarble1, 3, 2);
        ground.add(testMarble2, 8, 9);
        
        assertEquals(marble.getMarbleAtHeight(2), testMarble1);
        assertEquals(marble.getMarbleAtHeight(9), testMarble2);
    }
    
    /**
     * Tests getMarbleAtHeight() when there is no Marble
     * on the ground except for the one created in setUp.
     */
    public void testGetMarbleAtHeight2()
    {
        assertEquals(marble.getMarbleAtHeight(2), null);
    }
    
    /**
     * Tests getFriends when the a marble has 2 friends.
     */
    public void testGetFriends2()
    {
        Marble subjectMarble = new Marble();
        Marble friendMarble1 = new Marble();
        Marble friendMarble2 = new Marble();
        
        ground.add(subjectMarble, 2, 0);
        ground.add(friendMarble1, 3, 1);
        ground.add(friendMarble2, 0, 2);
        
        assertEquals(subjectMarble.getFriends().size(), 2);
        assertEquals(subjectMarble.getFriends().get(0), friendMarble1);
        assertEquals(subjectMarble.getFriends().get(1), friendMarble2);
    }
    
    /**
     * Tests getFriends when the a marble has 3 friends.
     */
    public void testGetFriends3()
    {
        Marble subjectMarble = new Marble();
        Marble friendMarble1 = new Marble();
        Marble friendMarble2 = new Marble();
        Marble friendMarble3 = new Marble();
        
        ground.add(subjectMarble, 3, 1);
        ground.add(friendMarble1, 2, 0);
        ground.add(friendMarble2, 10, 2);
        ground.add(friendMarble3, 0, 3);
        
        assertEquals(subjectMarble.getFriends().size(), 3);
        assertEquals(subjectMarble.getFriends().get(0), friendMarble1);
        assertEquals(subjectMarble.getFriends().get(1), friendMarble2);
        assertEquals(subjectMarble.getFriends().get(2), friendMarble3);
    }
    
    /**
     * Tests getFriends when the a marble has 4 friends.
     */
    public void testGetFriends4()
    {
        Marble friendMarble1 = new Marble();
        Marble friendMarble2 = new Marble();
        Marble friendMarble3 = new Marble();
        Marble friendMarble4 = new Marble();
        
        ground.add(friendMarble1, 6, 4);
        ground.add(friendMarble2, 8, 5);
        ground.add(friendMarble3, 10, 7);
        ground.add(friendMarble4, 0, 8);
        
        assertEquals(marble.getFriends().size(), 4);
        assertEquals(marble.getFriends().get(0), friendMarble1);
        assertEquals(marble.getFriends().get(1), friendMarble2);
        assertEquals(marble.getFriends().get(2), friendMarble3);
        assertEquals(marble.getFriends().get(3), friendMarble4);
    }
    
    /**
     * Tests averageX when the a marble has 2 friends.
     */
    public void testAverageX2()
    {
        Marble subjectMarble = new Marble();
        Marble friendMarble1 = new Marble();
        Marble friendMarble2 = new Marble();
        
        ground.add(subjectMarble, 2, 0);
        ground.add(friendMarble1, 4, 1);
        ground.add(friendMarble2, 0, 2);
        
        assertEquals(subjectMarble.averageX(subjectMarble.getFriends()), 2);
    }
    
    /**
     * Tests averageX when the marble has 4 friends.
     */
    public void testAverageX4()
    {
        Marble friendMarble1 = new Marble();
        Marble friendMarble2 = new Marble();
        Marble friendMarble3 = new Marble();
        Marble friendMarble4 = new Marble();
        
        ground.add(friendMarble1, 6, 4);
        ground.add(friendMarble2, 8, 5);
        ground.add(friendMarble3, 10, 7);
        ground.add(friendMarble4, 0, 8);
        
        assertEquals(marble.averageX(marble.getFriends()), 6);
    }
    
    /**
     * Tests act when the x coordinate is less than the averageX.
     */
    public void testAct()
    {
        Marble friendMarble1 = new Marble();
        Marble friendMarble2 = new Marble();
        Marble friendMarble3 = new Marble();
        
        ground.add(friendMarble1, 6, 4);
        ground.add(friendMarble2, 8, 5);
        ground.add(friendMarble3, 10, 7);
        
        marble.act();
        
        assertEquals(marble.getGridX(), 7);
    }
    
    /**
     * Tests act when the x coordinate is larger than the averageX.
     */
    public void testAct2()
    {
        Marble friendMarble1 = new Marble();
        Marble friendMarble2 = new Marble();
        Marble friendMarble3 = new Marble();
        
        ground.add(friendMarble1, 0, 4);
        ground.add(friendMarble2, 2, 5);
        ground.add(friendMarble3, 3, 7);
        
        marble.act();
        
        assertEquals(marble.getGridX(), 5);
    }
    
    /**
     * Tests act when the x coordinate equals the averageX.
     */
    public void testAct3()
    {
        Marble friendMarble1 = new Marble();
        Marble friendMarble2 = new Marble();
        Marble friendMarble3 = new Marble();
        
        ground.add(friendMarble1, 6, 4);
        ground.add(friendMarble2, 7, 5);
        ground.add(friendMarble3, 5, 7);
        
        marble.act();
        
        assertEquals(marble.getGridX(), 6);
    }
    
}
