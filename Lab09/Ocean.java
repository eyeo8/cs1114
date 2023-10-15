import sofia.micro.*;
import sofia.graphics.*;
import sofia.util.Random;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (pid)

//-------------------------------------------------------------------------
/**
 *  An ocean world for sharks and minnows to swim around in.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.23
 */
public class Ocean extends World
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new, empty Ocean object.
     */
    public Ocean()
    {
        super(400, 400, 1);
        this.setBackgroundColor(Color.blue);
    }


    // ----------------------------------------------------------
    /**
     * Creates a new Ocean object populated with sharks and minnows.
     * @param minnows The number of minnows to create.
     * @param sharks  The number of sharks to create.
     */
    public Ocean(int minnows, int sharks)
    {
        this();
        
        for (int i = 0; i < minnows; i++)
        {
            this.addMinnow();
        }
        
        for (int i = 0; i < sharks; i++)
        {
            this.addShark();
        }
    }


    //~ Methods ...............................................................
    
    /**
     * Adds a minnow to the ocean in a random location.
     */
    public void addMinnow()
    {
        Minnow minnow = new Minnow();
        
        int x = Random.generator().nextInt(0, 401);
        int y = Random.generator().nextInt(0, 401);
        
        this.add(minnow, x, y);
    }
    
    /**
     * Adds a shark to the ocean in a random location.
     */
    public void addShark()
    {
        Shark shark = new Shark();
        
        int x = Random.generator().nextInt(0, 400);
        int y = Random.generator().nextInt(0, 400);
        
        this.add(shark, x, y);
    }


}
