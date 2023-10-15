
import sofia.micro.jeroo.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (906349574)

//-------------------------------------------------------------------------
/**
 *  It goes through the maze to clear objects
 *  and end up at a specific location.
 *  
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.20
 */
public class MazeRunner extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunner object facing East with 15 flowers.
     */
    public MazeRunner()
    {
        super(15);
    }


    //~ Methods ...............................................................
    
    /**
     * Calls methods to clear the objects
     * on the map and end up at the 
     * desired location.
     */
    public void myProgram()
    {
        this.clearObj();
        this.go2End();
    }
    
    /**
     * Clears the nets and flowers on the island.
     */
    public void clearObj()
    {
        while (this.getWorld().getObjects(Net.class).size() > 0 || 
        this.getWorld().getObjects(Flower.class).size() > 0)
        {
             //hug right wall
            if (!this.seesWater(RIGHT))
            {
                this.turn(RIGHT);
            }
             //turn 180 when faced dead end
            else if (this.seesWater(AHEAD) && 
                this.seesWater(RIGHT) && 
                this.seesWater(LEFT))
            {
                this.turn(LEFT);
                this.turn(LEFT);
            }
             //turn left when there's water ahead and to the right
            else if (this.seesWater(AHEAD) && 
                this.seesWater(RIGHT))
            {
                this.turn(LEFT);
            }
             //disable nets
            while (this.seesNet(AHEAD))
            {
                this.toss();
            }
             //pick flowers
            while (this.seesFlower(HERE))
            {
                this.pick();
            }
             //keeps hopping while clear
            this.hop();
        }
    }
    
    /**
     * Takes the MazeRunner to the final location.
     */
    public void go2End()
    {
        while (this.getGridX() != 1 || this.getGridY() != 1)
        {
             //hug right wall
            if (!this.seesWater(RIGHT))
            {
                this.turn(RIGHT);
            }
             //turn 180 when faced dead end
            else if (this.seesWater(AHEAD) && 
                this.seesWater(RIGHT) && 
                this.seesWater(LEFT))
            {
                this.turn(LEFT);
                this.turn(LEFT);
            }
             //turn left when there's water ahead and to the right
            else if (this.seesWater(AHEAD) && 
                this.seesWater(RIGHT))
            {
                this.turn(LEFT);
            }
            
             //keeps hopping while clear
            this.hop();
        }
    }
    
}
