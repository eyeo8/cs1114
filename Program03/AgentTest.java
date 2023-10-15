import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the Agent class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.20
 */
public class AgentTest extends TestCase
{
    //~ Fields ................................................................
    private City city;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AgentTest test object.
     */
    public AgentTest()
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
        city = new City();
    }


    // ----------------------------------------------------------
    
    /**
     * Tests the Agent constructor.
     */
    public void testAgent()
    {
        Agent agent = new Agent();
        city.add(agent, 0, 0);
        
        assertEquals(0, agent.getGridX());
        assertEquals(0, agent.getGridY());
    }
    
    /**
     * Tests if isSatisfiedAt() returns true
     * when its threshold is satisfied when the
     * agent is an elephant.
     */
    public void testIsSatisfiedAtNotCornerE()
    {
        Agent elephant = new Agent("elephant", 0.3);
        city.add(elephant, 5, 5);
        city.add(new Agent("elephant", 0.3), 5, 6);
        city.add(new Agent("elephant", 0.3), 4, 5);
        city.add(new Agent("elephant", 0.3), 6, 5);
        city.add(new Agent("elephant", 0.3), 5, 4);
        
        assertEquals(true, elephant.isSatisfiedAt(5, 5));
    }
    
    /**
     * Tests if isSatisfiedAt() returns true
     * when its threshold is satisfied when the 
     * agent is a monkey.
     */
    public void testIsSatisfiedAtNotCornerM()
    {
        Agent monkey = new Agent("monkey", 0.3);
        city.add(monkey, 5, 5);
        city.add(new Agent("monkey", 0.3), 5, 6);
        city.add(new Agent("monkey", 0.3), 4, 5);
        city.add(new Agent("monkey", 0.3), 6, 5);
        city.add(new Agent("monkey", 0.3), 5, 4);
        
        assertEquals(true, monkey.isSatisfiedAt(5, 5));
    }
    
    /**
     * Tests if isSatisfiedAt() returns true
     * when its threshold is satisfied and is
     * in a corner when the agent is an elephant.
     */
    public void testIsSatisfiedAtCornerE()
    {
        Agent elephant = new Agent("elephant", 0.3);
        city.add(elephant, 0, 0);
        city.add(new Agent("elephant", 0.3), 1, 0);
        city.add(new Agent("elephant", 0.3), 1, 1);
        city.add(new Agent("elephant", 0.3), 0, 1);
        
        assertEquals(true, elephant.isSatisfiedAt(0, 0));
    }
    
    /**
     * Tests if isSatisfiedAt() returns true
     * when its threshold is satisfied and is
     * in a corner when the agent is a monkey
     */
    public void testIsSatisfiedAtCornerM()
    {
        Agent monkey = new Agent("monkey", 0.3);
        city.add(monkey, 0, 0);
        city.add(new Agent("monkey", 0.3), 1, 0);
        city.add(new Agent("monkey", 0.3), 1, 1);
        city.add(new Agent("monkey", 0.3), 0, 1);
        
        assertEquals(true, monkey.isSatisfiedAt(0, 0));
    }
    
    /**
     * Tests if isSatisfiedAt() returns false
     * when its threshold is not satisfied and
     * the agent is an elephant.
     */
    public void testIsSatisfiedAtFalseE()
    {
        Agent elephant = new Agent("elephant", 0.3);
        city.add(elephant, 5, 5);
        
        assertEquals(false, elephant.isSatisfiedAt(5, 5));
    }
    
    /**
     * Tests if isSatisfiedAt() returns false
     * when its threshold is not satisfied and
     * the agent is a monkey
     */
    public void testIsSatisfiedAtFalseM()
    {
        Agent monkey = new Agent("monkey", 0.3);
        city.add(monkey, 5, 5);
        
        assertEquals(false, monkey.isSatisfiedAt(5, 5));
    }
    
    /**
     * Tests if isSatisfiedAt() returns false
     * when its threshold is not satisfied and is
     * in a corner and the agent is an elephant.
     */
    public void testIsSatisfiedAtFalseE2()
    {
        Agent elephant = new Agent("elephant", 0.3);
        city.add(elephant, 0, 0);
        
        assertEquals(false, elephant.isSatisfiedAt(0, 0));
    }
    
    /**
     * Tests if isSatisfiedAt() returns false
     * when its threshold is not satisfied and is
     * in a corner and the agent is a monkey.
     */
    public void testIsSatisfiedAtFalseM2()
    {
        Agent monkey = new Agent("monkey", 0.3);
        city.add(monkey, 0, 0);
        
        assertEquals(false, monkey.isSatisfiedAt(0, 0));
    }
    
    /**
     * Tests if isSatisfied() returns true
     * when the elephant's threshold is satisfied.
     */
    public void testIsSatisfiedE()
    {
        Agent elephant = new Agent("elephant", 0.3);
        city.add(elephant, 5, 5);
        city.add(new Agent("elephant", 0.3), 5, 6);
        city.add(new Agent("elephant", 0.3), 4, 5);
        city.add(new Agent("elephant", 0.3), 6, 5);
        city.add(new Agent("monkey", 0.3), 5, 4);
        
        assertEquals(true, elephant.isSatisfied());
    }
    
    /**
     * Tests if isSatisfied() returns true
     * when the monkey's threshold is satisfied.
     */
    public void testIsSatisfiedM()
    {
        Agent monkey = new Agent("monkey", 0.3);
        city.add(monkey, 5, 5);
        city.add(new Agent("monkey", 0.3), 5, 6);
        city.add(new Agent("monkey", 0.3), 4, 5);
        city.add(new Agent("monkey", 0.3), 6, 5);
        city.add(new Agent("monkey", 0.3), 5, 4);
        
        assertEquals(true, monkey.isSatisfied());
    }
    
    /**
     * Tests relocate() when the agent is dissatisfied.
     */
    public void testRelocate()
    {
        Agent elephant = new Agent("elephant", 0.3);
        city.add(elephant, 5, 5);
        city.add(new Agent("elephant", 0.3), 5, 6);
        city.add(new Agent("elephant", 0.3), 1, 0);
        city.add(new Agent("elephant", 0.3), 1, 1);
        city.add(new Agent("monkey", 0.3), 0, 1);
        city.add(new Agent("monkey", 0.3), 6, 5);
        city.add(new Agent("monkey", 0.3), 6, 6);
        city.add(new Agent("monkey", 0.3), 4, 5);
        
        elephant.relocate();
        
        assertEquals(9, elephant.getGridX());
        assertEquals(9, elephant.getGridY());
    }
    
    /**
     * Tests relocate() when the agent is satisfied.
     */
    public void testRelocate2()
    {
        Agent elephant = new Agent("elephant", 0.3);
        city.add(elephant, 5, 5);
        city.add(new Agent("elephant", 0.3), 5, 6);
        city.add(new Agent("elephant", 0.3), 4, 5);
        city.add(new Agent("elephant", 0.3), 6, 5);
        city.add(new Agent("elephant", 0.3), 5, 4);
        city.add(new Agent("elephant", 0.3), 5, 6);
        city.add(new Agent("elephant", 0.3), 1, 0);
        city.add(new Agent("elephant", 0.3), 1, 1);
        city.add(new Agent("monkey", 0.3), 0, 1);
        
        elephant.relocate();
        
        assertEquals(5, elephant.getGridX());
        assertEquals(5, elephant.getGridY());
    }
    
    /**
     * Tests act().
     */
    public void testAct()
    {
        Agent elephant = new Agent("elephant", 0.3);
        city.add(elephant, 5, 5);
        city.add(new Agent("elephant", 0.3), 5, 6);
        city.add(new Agent("elephant", 0.3), 1, 0);
        city.add(new Agent("elephant", 0.3), 1, 1);
        city.add(new Agent("monkey", 0.3), 0, 1);
        city.add(new Agent("monkey", 0.3), 6, 5);
        city.add(new Agent("monkey", 0.3), 6, 6);
        city.add(new Agent("monkey", 0.3), 4, 5);
        
        elephant.act();
        
        assertEquals(9, elephant.getGridX());
        assertEquals(9, elephant.getGridY());
    }
    
    
    
}
