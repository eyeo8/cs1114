import sofia.micro.lightbot.*;

//-------------------------------------------------------------------------
/**
 *  Level 6, together with its solution using a single Light-Bot.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.08.27
 */
public class Level6Solution extends Level6a
{
    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * This method "solves" Level 6 by placing a Light-Bot at (2, 6)
     * and then commanding it one step at a time to walk through
     * the desired sequence of actions.
     */
    public void myProgram()
    {
        LightBot andy = new LightBot();
        add(andy, 2, 6);
        
        andy.turnLeft();
        andy.move();
        andy.jump();
        andy.jump();
        andy.turnRight();
        andy.jump();
        andy.jump();
        andy.turnLightOn();
        andy.jump();
        andy.turnRight();
        andy.move();
        andy.move();
        andy.move();
        andy.turnLightOn();
        andy.turnLeft();
        andy.turnLeft();
        andy.move();
        andy.move();
        andy.move();
        andy.move();
        andy.move();
        andy.move();
        andy.turnLightOn();
    }

}
