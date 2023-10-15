import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  It will create a method to pick a row of flowers
 *  and plant one on the next tile each time.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.04
 */
public class PlantingHarvester extends Harvester
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PlantingHarvester object facing east with no flowers.
     * @param x                  The x-coordinate of the Jeroo's location
     * @param y                  The y-coordinate of the Jeroo's location
     */
    public PlantingHarvester(int x, int y)
    {
        super(x, y);
    }


    //~ Methods ...............................................................
    
    /**
     * Hops once and picks a flower and hops once and plants a flower.
     */
    public void hop2AndPick()
    {
        super.hopAndPick();
        this.hop();
        this.plant();
    }
    
    /**
     * Picks a row of flowers and plants one on the next tile each time
     */
    public void plantRow()
    {
        this.hop2AndPick();
        this.hop2AndPick();
        this.hop2AndPick();
    }


}
