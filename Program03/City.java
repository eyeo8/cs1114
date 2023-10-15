import sofia.micro.*;
import sofia.util.Random;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Initialize the world/city the two groups will
 *  live in to carry out the Scheling's model simulation.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.18
 */
public class City extends World
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new City object.
     */
    public City()
    {
        this(10, 10);
    }
    
    /**
     * Creates a new City with width and height parameters.
     * 
     * @param width          width of the world
     * @param height         height of the world
     */
    public City(int width, int height)
    {
        super(width, height, 24);
    }
    
    //~ Methods ...............................................................
    
    /**
     * Populates the city with two groups - 
     * sweet tea drinkers (green elephants) and
     * unsweetened tea drinkers (orange monkeys).
     * 
     * @param e                 percentage of elephants
     * @param m                 percentage of monkeys
     * @param threshold         satisfaction threshold
     */
    public void populate(double e, double m, double threshold)
    {
        for (int x = 0; x < this.getWidth(); x++)
        {
            for (int y = 0; y < this.getHeight(); y++)
            {
                double rand = Random.generator().nextDouble(0.0, 1.0);
                Agent elephant = new Agent("elephant", threshold);
                Agent monkey = new Agent("monkey", threshold);
                if (rand <= e)
                {
                    this.add(elephant, x, y);
                }
                else if (rand <= e + m)
                {
                    this.add(monkey, x, y);
                }
                // leave cell empty otherwise
            }
        }
    }
}
