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
 *  Creates an island subclass 10x10 cells large
 *  and 60 pixels in size for each cell/
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.09
 */
public class Beach extends World
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Beach object.
     */
    public Beach()
    {
        super(10, 10, 60);
    }
    
    /**
     * Adds a number of turtles based on the parameter.
     * @param num           number of turtles to add
     */
    public Beach(int num)
    {
        super(10, 10, 60);
        for (int i = 0; i < num; i++)
        {
            this.addTurtle();
        }
    }


    //~ Methods ...............................................................
    
    /**
     * Adds a turtle at a random x/y location on the Beach.
     */
    public void addTurtle()
    {
        int x = Random.generator().nextInt(10);
        int y = Random.generator().nextInt(10);
        
        Turtle turtle = new Turtle();
        this.add(turtle, x, y);
    }

}
