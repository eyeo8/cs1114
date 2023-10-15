import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  Creates a Jeroo to pick up eight flowers around
 *  the island and end up in the center.
 *
 *  @author Elliot (906349574)
 *  @version 2020.09.07
 */
public class ScavengerHunt extends LongIsland
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ScavengerHunt object.
     */
    public ScavengerHunt()
    {
        // Nothing to initialize, leaving the world a default size
    }


    //~ Methods ...............................................................
    
    /**
     * Uses methods in the Jeroo subclass, FlowerPicker, 
     * to go around the island and pick up flowers.
     */
    public void myProgram()
    {
        //Adds a jeroo at (2, 2) facing east with no flowers
        FlowerPicker jerry = new FlowerPicker(2, 2);
        this.add(jerry);
        //Picks up the first flower
        jerry.aroundNet();
        jerry.pick();
        //Picks up the second flower
        jerry.longWalk();
        jerry.pick();
        //Picks up the third flower
        jerry.aroundWater();
        jerry.pick();
        //Picks uo the fourth flower
        jerry.leftAndHop3();
        jerry.pick();
        //Picks up the fifth flower
        jerry.hop(2);
        jerry.pick();
        //Picks up the sixth flower
        jerry.longWalk2();
        jerry.pick();
        //Picks up the seventh flower
        jerry.leftAndHop4();
        jerry.pick();
        //Picks up the last flower
        jerry.toCenter();
        jerry.pick();
        
        
    }
    
    
}
