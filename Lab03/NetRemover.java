import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  It will patrol around the island to 
 *  collect flowers and disable nets.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.9.11
 */
public class NetRemover extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new NetRemover object facing East with no flowers.
     * @param x           The x-coordinate of the Jeroo's location
     * @param y           The y-coordinate of the Jeroo's location
     */
    public NetRemover(int x, int y)
    {
        super(x, y);
    }


    //~ Methods ...............................................................
    
    /**
     * Disables as many nets as possible 
     * from the flowers obtained.
     */
    public void myProgram()
    {
        //collect flowers
        this.turn(RIGHT);
        this.pickFlowers();
        this.turn(LEFT);
        //disable the first anet
        this.pathCheck();
        this.netRemove();
        this.turnClear();
        //disable row of nets if needed
        this.netRemove();
        //turn left in case there are nets below
        this.turn(LEFT);
        //disable row of nets if needed
        this.netRemove();
    }
    
    /**
     * Picks up flowers.
     */
    public void pickFlowers()
    {
        while (this.seesFlower(AHEAD))
        {
            this.hop();
            this.pick();
        }
    }
    
    /**
     * Checks if the path ahead is clear.
     */
    public void pathCheck()
    {
        while (this.isClear(AHEAD))
        {
            this.hop();
        }
    }
    
    /**
     * Removes the net(s).
     */
    public void netRemove()
    {
        while (this.seesNet(AHEAD) && this.hasFlower())
        {
            this.toss();
            this.hop();
        }
    }
    
    /**
     * If the path ahead is clear turn left,
     * if not, check if it sees water and 
     * make the Jeroo patrol around until it 
     * finds a net.
     */
    public void turnClear()
    {
        if (this.isClear(AHEAD))
        {
            this.turn(LEFT);
        }
        else if (this.seesWater(AHEAD))
        {
            this.turn(LEFT);
            this.pathCheck();
            if (this.seesWater(AHEAD))
            {
                this.turn(LEFT);
                this.pathCheck();
            }
        }
    }
    
    
}
