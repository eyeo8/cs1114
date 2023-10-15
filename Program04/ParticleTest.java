import sofia.micro.*;
import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 *  Tests the particle object.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class ParticleTest extends TestCase
{
    //~ Fields ................................................................
    
    private ParticleWorld world;
    private Particle particle;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ParticleTest test object.
     */
    public ParticleTest()
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
        world = new ParticleWorld();
    }


    // ----------------------------------------------------------
    
    /**
     * Tests if weaken reduces the strength by 1.
     */
    public void testWeaken()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 5, 150);
        
        particle.weaken();
        
        assertEquals(particle.getStrength(), 99);
    }
    
    /**
     * Tests if weaken removes the particle when its strength is 0.
     */
    public void testWeakenZero()
    {
        particle = new Particle(Color.aqua, false, 5);
        // 401 particle in the world now
        world.add(particle, 5, 150);
        
        for (int i = 0; i < 100; i++)
        {
            particle.weaken();
        }
        
        assertEquals(particle.getStrength(), 0);
        particle.weaken();
        assertNull(particle.getWorld());
    }
    
    /**
     * Tests if isFalling returns false when there
     * particle called does not exist in the world.
     */
    public void testIsFallingNull()
    {
        particle = new Particle(Color.aqua, false, 5);
        
        assertFalse(particle.isFalling());
    }
    
    /**
     * Tests if isFalling returns true when it is
     * not at the bottom of the world or is on top
     * of another particle.
     */
    public void testFallingEmpty()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 5, 150);
        
        assertTrue(particle.isFalling());
    }
    
    /**
     * Tests if isFalling returns false when it is
     * at the bottom of the world.
     */
    public void testIsFallingBottom()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 5, 249);
        
        assertFalse(particle.isFalling());
    }
    
    /**
     * Tests if isFalling returns false when it is
     * on top of another particle.
     */
    public void testIsFallingOnTop()
    {
        particle = new Particle(Color.aqua, false, 5);
        Particle particle2 = new Particle(Color.red, false, 7);
        world.add(particle, 5, 248);
        world.add(particle2, 5, 249);
        
        assertFalse(particle.isFalling());
    }
    
    /**
     * Tests if fall behaves the way it should.
     */
    public void testFall()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 100, 50);
        
        particle.fall();
        
        assertEquals(particle.getVelocity(), 1.0, 0.0);
        assertEquals(particle.getGridY(), 51);
    }
    
    /**
     * Tests if fall acclerates.
     */
    public void testFallAccelerate()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 100, 100);
        
        particle.fall();
        particle.fall();
        
        assertEquals(particle.getVelocity(), 2.0, 0.0);
        assertEquals(particle.getGridY(), 103);
    }
    
    /**
     * Tests fall when it reaches the bottom.
     */
    public void testFallBottom()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 100, 249);
        
        particle.fall();
        
        assertEquals(particle.getVelocity(), 0.0, 0.0);
        assertEquals(particle.getGridY(), 249);
    }
    
    /**
     * Test fall when it stops when it reaches the end.
     */
    public void testFallStop()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 10, 10);
        
        for (int i = 0; i < 30; i++)
        {
            particle.fall();
        }
        
        assertEquals(particle.getVelocity(), 0.0, 0.0);
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false
     * and stays still when the particle called
     * does not exist in the world.
     */
    public void testSwapIfPossibleNull()
    {
        particle = new Particle(Color.aqua, false, 5);
        
        assertFalse(particle.swapPlacesIfPossible(5, 150));
    }
    
    /**
     * Tests if swapPlacesIfPossible moves the particle to the 
     * specified location and returns true when the specified
     * location is empty.
     */
    public void testSwapPlacesIfPossibleEmpty()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 10, 150);
        
        assertTrue(particle.swapPlacesIfPossible(50, 70));
        assertEquals(particle.getGridX(), 50);
        assertEquals(particle.getGridY(), 70);
    }
    
    /**
     * Tests if swapPlacesIfPossible swaps the particles
     * and returns true when the specified location is occupied.
     * i.e. the other particle has a lower density than this one.
     */
    public void testSwapPlacesIfPossibleLower()
    {
        particle = new Particle(Color.aqua, false, 5);
        Particle particle2 = new Particle(Color.red, false, 3);
        world.add(particle, 10, 150);
        world.add(particle2, 60, 100);
        
        assertTrue(particle.swapPlacesIfPossible(60, 100));
        assertEquals(particle.getGridX(), 60);
        assertEquals(particle.getGridY(), 100);
        assertEquals(particle2.getGridX(), 10);
        assertEquals(particle2.getGridY(), 150);
    }
    
    /**
     * Tests if swapPlacesIfPossible does not swap the particles
     * and returns false when the specified location is occupied.
     * i.e. the other particle has a higher density than this one.
     */
    public void testSwapPlacesIfPossibleHigher()
    {
        particle = new Particle(Color.aqua, false, 5);
        Particle particle2 = new Particle(Color.red, false, 7);
        world.add(particle, 10, 150);
        world.add(particle2, 60, 100);
        
        assertFalse(particle.swapPlacesIfPossible(60, 100));
        assertEquals(particle.getGridX(), 10);
        assertEquals(particle.getGridY(), 150);
        assertEquals(particle2.getGridX(), 60);
        assertEquals(particle2.getGridY(), 100);
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false when the 
     * x coordinate is less than 0, and the y coordinate is
     * within the bounds.
     */
    public void testSwapPlacesIfPossibleOutX()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 200, 200);
        
        assertFalse(particle.swapPlacesIfPossible(-20, 150));
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false when the 
     * y coordinate is less than 0, and the x coordinate is
     * within the bounds.
     */
    public void testSwapPlacesIfPossibleOutY()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 200, 200);
        
        assertFalse(particle.swapPlacesIfPossible(100, -30));
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false when the 
     * x coordinate is above the bounds, and the y coordinate is
     * within the bounds.
     */
    public void testSwapPlacesIfPossibleX()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 200, 200);
        
        assertFalse(particle.swapPlacesIfPossible(270, 150));
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false when the 
     * y coordinate is above the bounds, and the x coordinate is
     * within the bounds.
     */
    public void testSwapPlacesIfPossibleY()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 200, 200);
        
        assertFalse(particle.swapPlacesIfPossible(20, 270));
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false when the 
     * x coordinate and y coordinate are less than 0.
     */
    public void testSwapPlacesIfPossibleXY()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 200, 200);
        
        assertFalse(particle.swapPlacesIfPossible(-20, -70));
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false when the 
     * x coordinate and y coordinate are out of bounds.
     */
    public void testSwapPlacesIfPossibleYX()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 200, 200);
        
        assertFalse(particle.swapPlacesIfPossible(270, 270));
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false when the 
     * x coordinate is less than 0 and y coordinate is 
     * out of bounds.
     */
    public void testSwapPlacesIfPossibleOutXY()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 200, 200);
        
        assertFalse(particle.swapPlacesIfPossible(-20, 270));
    }
    
    /**
     * Tests if swapPlacesIfPossible returns false when the 
     * y coordinate is less than 0 and x coordinate is 
     * out of bounds.
     */
    public void testSwapPlacesIfPossibleOutYX()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 200, 200);
        
        assertFalse(particle.swapPlacesIfPossible(270, -70));
    }
    
    /**
     * Tests dodge when the particle sinks.
     */
    public void testDodgeSink()
    {
        particle = new Particle(Color.aqua, false, 5);
        Particle particle2 = new Particle(Color.red, false, 3);
        world.add(particle, 50, 248);
        world.add(particle2, 50, 249);
        
        assertTrue(particle.dodge());
        assertEquals(particle.getGridY(), 249);
        assertEquals(particle2.getGridY(), 248);
    }
    
    /**
     * Tests dodge when the particle "slides down" to the left.
     */
    public void testDodgeLeft()
    {
        particle = new Particle(Color.aqua, false, 5);
        Particle particle2 = new Particle(Color.red, false, 3);
        Particle particle3 = new Particle(Color.green, false, 7);
        world.add(particle, 50, 248);
        world.add(particle2, 49, 249);
        world.add(particle3, 50, 249);
        
        assertTrue(particle.dodge());
        assertEquals(particle.getGridX(), 49);
        assertEquals(particle.getGridY(), 249);
        assertEquals(particle2.getGridX(), 50);
        assertEquals(particle2.getGridY(), 248);
    }
    
    /**
     * Tests dodge when the particle "slides down" to the right.
     */
    public void testDodgeRight()
    {
        particle = new Particle(Color.aqua, false, 5);
        Particle particle2 = new Particle(Color.red, false, 3);
        Particle particle3 = new Particle(Color.green, false, 7);
        Particle particle4 = new Particle(Color.yellow, false, 9);
        world.add(particle, 50, 248);
        world.add(particle2, 51, 249);
        world.add(particle3, 50, 249);
        world.add(particle4, 49, 249);
        
        assertTrue(particle.dodge());
        assertEquals(particle.getGridX(), 51);
        assertEquals(particle.getGridY(), 249);
        assertEquals(particle2.getGridX(), 50);
        assertEquals(particle2.getGridY(), 248);
    }
    
    /**
     * Tests dodge when the particle does not move.
     */
    public void testDodgeStay()
    {
        particle = new Particle(Color.aqua, false, 5);
        Particle particle2 = new Particle(Color.red, false, 8);
        Particle particle3 = new Particle(Color.green, false, 7);
        Particle particle4 = new Particle(Color.yellow, false, 9);
        world.add(particle, 50, 248);
        world.add(particle2, 51, 249);
        world.add(particle3, 50, 249);
        world.add(particle4, 49, 249);
        
        assertFalse(particle.dodge());
        assertEquals(particle.getGridX(), 50);
        assertEquals(particle.getGridY(), 248);
    }
    
    /**
     * Tests act when the particle is falling.
     */
    public void testActFall()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 50, 150);
        
        particle.act();
        
        assertEquals(particle.getGridY(), 151);
    }
    
    /**
     * Tests act when the particle is dodging.
     */
    public void testActDodge()
    {
        particle = new Particle(Color.aqua, false, 5);
        world.add(particle, 50, 249);
        
        particle.act();
        
        assertEquals(particle.getGridY(), 249);
    }

}
