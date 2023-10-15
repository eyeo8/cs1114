import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  It will create a method to harvest a row of
 *  flowers skipping one tile each time.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.04
 */
public class SkippingHarvester extends Harvester
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SkippingHarvester object facing east with no flowers.
     * @param x                  The x-coordinate of the Jeroo's location
     * @param y                  The y-coordinate of the Jeroo's location
     */
    public SkippingHarvester(int x, int y)
    {
        super(x, y);
    }


    //~ Methods ...............................................................
    
    /**
     * Hops once and picks a flower and hops once.
     */
    public void hop2AndPick()
    {
        super.hopAndPick();
        this.hop();
    }
    
    /**
     * Harvests a row of flowers but skipping one tile each flower picking.
     */
    public void harvestRow()
    {
        this.hop2AndPick();
        this.hop2AndPick();
        this.hop2AndPick();
    }


}
