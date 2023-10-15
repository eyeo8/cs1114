import sofia.micro.jeroo.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  A jeroo that traverses all locations on an island, and uses
 *  a buddy to make a copy of any pattern of flowers it finds.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.19
 */
public class CopyingJeroo extends Jeroo
{
    //~ Fields ................................................................
    
    private Jeroo copier;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CopyingJeroo object.
     * 
     * @param buddy   Jeroo that will create the pentogram
     */
    public CopyingJeroo(Jeroo buddy)
    {
        super();
        copier = buddy;
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Copier creates a pentogram based on the left island.
     */
    public void myProgram()
    {
        while (this.getGridX() != 1 || this.getGridY() != 8)
        {
            if (this.seesWater(AHEAD) && this.isFacing(EAST))
            {
                this.turnRightCorner();
            }
            else if (this.seesWater(AHEAD) && this.isFacing(WEST))
            {
                this.turnLeftCorner();
            }
            this.hopToWater();
            this.plantFlower();
        }
    }


    // ----------------------------------------------------------
    
    /**
     * Hop forward until we reach the water.
     */
    public void hopToWater()
    {
        while (!this.seesWater(AHEAD))
        {
            this.hop();
        }
    }
    
    /**
     * Override the hop() so the copier moves
     * with the CopyingJeroo.
     */
    @Override
    public void hop()
    {
        this.plantFlower();
        super.hop();
        this.copier.hop();
    }
    
    /**
     * Override the turn() so the copier turns
     * with the CopyingJeroo.
     */
    @Override
    public void turn(RelativeDirection direction)
    {
        super.turn(direction);
        this.copier.turn(direction);
    }
    
    /**
     * Turn around when facing east
     */
    public void turnRightCorner()
    {
        this.turn(RIGHT);
        this.hop();
        this.turn(RIGHT);
    }
    
    /**
     * Turn around when facing west.
     */
    public void turnLeftCorner()
    {
        this.turn(LEFT);
        this.hop();
        this.turn(LEFT);
    }
    
    /**
     * Copier plants if there is a flower at 
     * CopyingJerro's position.
     */
    public void plantFlower()
    {
        int x = copier.getGridX();
        int y = copier.getGridY();
        
        Object check = copier.getWorld().getOneObjectAt(x, y, Flower.class);
        
        if (this.seesFlower(HERE) && check == null)
        {
            copier.plant();
        }
    }
}
