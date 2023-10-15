import sofia.micro.jeroo.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (906349574)

//-------------------------------------------------------------------------
/**
 *  It plants flowers in squares depending 
 *  on the number the user prompts.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.23
 */
public class SquarePlanter extends Jeroo
{
    //~ Fields ................................................................
    
    private int numSide;



    //~ Constructor ...........................................................
        

    // ----------------------------------------------------------
    /**
     * Creates a new SquarePlanter object with
     * flowers prompted times 4.
     * 
     * @param flowersPerSide       # of flowers planted per side
     */
    public SquarePlanter(int flowersPerSide)
    {
        super(flowersPerSide * 4);
        numSide = flowersPerSide;
    }


    //~ Methods ...............................................................
    
    /**
     * Plants square of flowers depending
     * on numbers prompted.
     */
    public void myProgram()
    {
        this.plantOneSide();
        this.plantOneSide();
        this.plantOneSide();
        this.plantOneSide();
    }
    
    /**
     * Plants one side of the square.
     */
    public void plantOneSide()
    {
        int hopsToTake = numSide;
        while (hopsToTake > 0)
        {
            this.plant();
            this.hop();
            hopsToTake = hopsToTake - 1; // One fewer hops remain now
        }
        this.turn(RIGHT);
    }
    


}
