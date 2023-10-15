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
 *  Initializes the Ground class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.30
 */
public class Ground extends World
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ground object with a marble in each row.
     */
    public Ground()
    {
        this(true);
    }


    // ----------------------------------------------------------
    /**
     * Creates a new Ground object, with or without marbles.
     * This constructor is useful for writing software tests.
     * @param createMarbles If true, the floor will be populated
     *                    with Marbles.
     */
    public Ground(boolean createMarbles)
    {
        super(12, 12, 60);
        if (createMarbles)
        {
            populate();
        }
    }

    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Add one marble for each y coordinate, at a random
     * x position.
     */
    private void populate()
    {
        for (int y = 0; y < this.getHeight(); y++)
        {
            int x = Random.generator().nextInt(0, this.getWidth());
            this.add(new Marble(), x, y);
        }
    }
}
