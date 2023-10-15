import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  It will go around the island picking up flowers.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.07
 */
public class FlowerPicker extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlowerPicker object facing east with no flowers.
     * 
     * @param x                      The x-coordinate of the Jeroo's location
     * @param y                      The y-coordinate of the Jeroo's location
     * 
     */
    public FlowerPicker(int x, int y)
    {
        super(x, y);
    }


    //~ Methods ...............................................................
    
    /**
     * Goes around the net.
     */
    public void aroundNet()
    {
        this.rightAndHop2();
        this.leftAndHop3();
        this.leftAndHop3();
    }
    
    /**
     * Takes a long walk to next flower's location.
     */
    public void longWalk()
    {
        this.rightAndHop();
        this.rightAndHop8();
    }
    
    /**
     * Goes around water.
     */
    public void aroundWater()
    {
        this.twirlAndHop();
        this.rightAndHop2();
        this.rightAndHop();
    }
    
    /**
     * Takes a long walk to next flower's location.
     */
    public void longWalk2()
    {
        this.leftAndHop7();
        this.leftAndHop();
        this.rightAndHop();
    }
    
    /**
     * Brings Jeroo to the center.
     */
    public void toCenter()
    {
        this.leftAndHop4();
        this.leftAndHop();
    }
    
    /**
     * Turn left and hop seven times.
     */
    public void leftAndHop7()
    {
        this.leftAndHop4();
        this.hop(3);
    }
    
    /**
     * Turn left and hop four times.
     */
    public void leftAndHop4()
    {
        this.leftAndHop3();
        this.hop();
    }
    
    /**
     * Turn left and hop three times.
     */
    public void leftAndHop3()
    {
        this.leftAndHop2();
        this.hop();
    }
    
    /**
     * Turn left and hop twice.
     */
    public void leftAndHop2()
    {
        this.leftAndHop();
        this.hop();
    }
    
    /**
     * Turn left and hop once.
     */
    public void leftAndHop()
    {
        this.turn(LEFT);
        this.hop();
    }
    
    /**
     * Turn right and hop eight times.
     */
    public void rightAndHop8()
    {
        this.rightAndHop2();
        this.hop(6);
    }
    
    /**
     * Turn right and hop twice.
     */
    public void rightAndHop2()
    {
        this.rightAndHop();
        this.hop();
    }
    
    /**
     * Turn right and hop once.
     */
    public void rightAndHop()
    {
        this.turn(RIGHT);
        this.hop();
    }
    
    /**
     * Turns 180 degrees and hops once.
     */
    public void twirlAndHop()
    {
        this.turn(LEFT);
        this.turn(LEFT);
        this.hop();
    }
}
