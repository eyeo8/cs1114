import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  It will create a method to harvest a row of flowers.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.04
 */
public class Harvester extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Harvester object facing east with no flowers.
     * @param x          The x-coordinate of the Jeroo's location
     * @param y          The y-coordinate of the Jeroo's location
     */
    public Harvester(int x, int y)
    {
        super(x, y);
    }


    //~ Methods ...............................................................
    
    /**
     * Hops once and picks a flower.
     */
    public void hopAndPick()
    {
        this.hop();
        this.pick();
    }
    
    /**
     * Invokes hopAndPick twice.
     */
    public void hop2AndPick()
    {
        this.hopAndPick();
        this.hopAndPick();
    }
    
    /**
     * Harvests a row of flowers
     */
    public void harvestRow()
    {
        this.hop2AndPick();
        this.hop2AndPick();
        this.hop2AndPick();
    }


}
