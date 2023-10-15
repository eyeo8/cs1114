import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  A particle object that sets the default behavior
 *  for all the subclasses.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.09
 */
public class Particle extends ParticleBase
{
    //~ Fields ................................................................
    
    private boolean willDissolve;
    private double density;
    private double velocity;
    private double acceleration;
    private int strength;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Particle object.
     * 
     * @param color The color of the particle.
     * @param willDissolve Dissolvability of the particle.
     * @param density The density of the particle.
     */
    public Particle(Color color, boolean willDissolve, double density)
    {
        super(color);
        this.willDissolve = willDissolve;
        this.density = density;
        velocity = 0.0;
        acceleration = 1.0;
        strength = 100;
    }


    //~ Methods ...............................................................
    
    /**
     * A getter method that returns this particle's
     * density (a floating-point value).
     * 
     * @return The density of the particle.
     */
    public double getDensity()
    {
        return density;
    }
    
    /**
     * A getter method that returns this particle's
     * downward velocity (a floating-point value).
     * 
     * @return The velocity of the particle.
     */
    public double getVelocity()
    {
        return velocity;
    }
    
    /**
     * A getter method that returns this particle's
     * downward acceleration (a floating-point value).
     * 
     * @return The acceleration of the particle.
     */
    public double getAcceleration()
    {
        return acceleration;
    }
    
    /**
     * A getter method that returns this particle's
     * strength (an integer value).
     * 
     * @return The strength of the particle.
     */
    public int getStrength()
    {
        return strength;
    }
    
    /**
     * A getter method that returns the boolean value indicating whether
     * this particle can be dissolved (i.e., is it reactive).
     * 
     * @return true if the particle is reactive.
     *         false if the particle is not reactive.
     */
    public boolean willDissolve()
    {
        return willDissolve;
    }
    
    /**
     * Reduces the particle's strength by 1. If the strength
     * becomes zero, remove this particle from the world.
     */
    public void weaken()
    {
        strength -= 1;
        if (strength == 0)
        {
            this.remove();
        }
    }
    
    /**
     * Returns a boolean value indicating whether this particle
     * is in free-fall or not. A particle is falling if it is above
     * the maximum y value and there is nothing in the space
     * immediately underneath it.
     * 
     * @return true if the particle is falling.
     *         false if the particle is not falling.
     */
    public boolean isFalling()
    {
        if (this.getWorld() != null)
        {
            int maxY = this.getWorld().getHeight() - 1;
            int x = this.getGridX();
            int y = this.getGridY();
            
            if (y < maxY)
            {
                World world = this.getWorld();
                Particle obj = world.getOneObjectAt(x, y + 1, Particle.class);
                if (obj == null)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Implements the behavior of falling, using a simple model
     * of Newtonian physics. It adds the particle's current acceleration to
     * its velocity, in order to update its velocity. Once the velocity has
     * been updated, it uses the integer equivalent of the velocity as the
     * distance to fall.
     */
    public void fall()
    {
        if (this.isFalling())
        {
            velocity += this.getAcceleration();
            int newVelocity = (int) velocity;
            for (int i = 0; i < newVelocity; i++)
            {
                if (this.isFalling())
                {
                    int xPos = this.getGridX();
                    int yPos = this.getGridY();
                    this.setGridLocation(xPos, yPos + 1);
                }
            }
            if (!this.isFalling())
            {
                velocity = 0.0;
            }
        }
    }
    
    /**
     * Changes place with another particle at the specified location,
     * if appropriate, and returns a boolean value indicating whether
     * this action succeeded. If the specified location is empty, this
     * particle can move there. If the speicified location is occupied
     * and the other particle has a lower density than this particle,
     * the two particles swap places.
     * 
     * @param x The x coordinate
     * @param y The y coordinate
     * 
     * @return true if they swapped places or this particle moved
     *              to the specified location.
     *         false if they did not swap places.
     */
    public boolean swapPlacesIfPossible(int x, int y)
    {
        if (this.getWorld() != null)
        {
            int xPos = this.getGridX();
            int yPos = this.getGridY();
            int width = this.getWorld().getWidth();
            int height = this.getWorld().getHeight();
            
            if (x >= 0 && x < width && y >= 0 && y < height)
            {
                World world = this.getWorld();
                Particle obj = world.getOneObjectAt(x, y, Particle.class);
                if (obj != null)
                {
                    if (obj.getDensity() >= this.getDensity())
                    {
                        return false;
                    }
                    this.setGridLocation(x, y);
                    obj.setGridLocation(xPos, yPos);
                    return true;
                }
                this.setGridLocation(x, y);
                return true;
            }
        }
        return false;
    }
    
    /**
     * The particle will "sink" by swapping places with what is
     * immediately below it (x + 0, y + 1) if possible. If it can't 
     * sink straight down, the particle will swap places with what is
     * down and to the left one cell (x - 1, y + 1) if possible. If neither
     * of those options are possible, it will swap places with what is down
     * and to the right one cell (x + 1, y + 1) if possible.
     * 
     * @return true if the particle moved.
     *         false if the particle did not move.
     */
    public boolean dodge()
    {
        int x = this.getGridX();
        int y = this.getGridY();
        
        if (this.swapPlacesIfPossible(x, y + 1))
        {
            return true;
        }
        else if (this.swapPlacesIfPossible(x - 1, y + 1))
        {
            return true;
        }
        
        return this.swapPlacesIfPossible(x + 1, y + 1);
    }
    
    /**
     * Implements the particle behavior, falling or dodging.
     */
    public void act()
    {
        if (this.isFalling())
        {
            this.fall();
        }
        else
        {
            this.dodge();
        }
    }
    
    
}
