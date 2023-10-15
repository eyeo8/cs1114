import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  It will harvest most of the flowers grown on 
 *  this island and plant some flowers by the end.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.04
 */
public class Lab02Solution extends PlantationIsland
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Lab02Solution object.
     */
    public Lab02Solution()
    {
        // Nothing to initialize, leaving the world a default size
    }


    //~ Methods ...............................................................
    
    /**
     * Creates a new Jeroo on (2,3) and harvests the first fow of flowers.
     * Creates a new Jeroo on (2,5) and harvests the second row of flowers.
     * Creates a new Jeroo on (2,7) and harvests the third row of flowers
     * and plnating three by the end.
     */
    public void myProgram()
    {
        Harvester jerry = new Harvester(2, 3);
        this.add(jerry);
        jerry.harvestRow();
        SkippingHarvester harry = new SkippingHarvester(2, 5);
        this.add(harry);
        harry.harvestRow();
        PlantingHarvester mary = new PlantingHarvester(2, 7);
        this.add(mary);
        mary.plantRow();
    }


}
