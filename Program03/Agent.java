import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  An agent will move to an empty location where
 *  it will be satisfied. 
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.10.18
 */
public class Agent extends Actor
{
    //~ Fields ................................................................
    private String animal;
    private double threshold;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Agent object.
     */
    public Agent()
    {
        super();
    }
    
    /**
     * Creates a new Agent object and sets its
     * image based on the parameter. The second
     * parameter will set the satisfaction threshold
     * of the Agent.
     * 
     * @param animal           type of animal
     * @param threshold        satisfaction threshold
     */
    public Agent(String animal, double threshold)
    {
        this.animal = animal;
        this.threshold = threshold;
        
        String name = animal + ".png";
        this.setImage(name);
    }
    
    


    //~ Methods ...............................................................
    
    /**
     * A getter method that returns the kind of agent,as a string.
     * 
     * @return a string indicating what animal it is
     */
    public String getKind()
    {
        return this.animal;
    }
    
    /**
     * A getter method that returns the agent's
     * satisfaction threshold, as a double value.
     * 
     * @return a double indicating what the 
     * satisfaction threshold is
     */
    public double getThreshold()
    {
        return this.threshold;
    }
    
    /**
     * A boolean method that returns true if this agent
     * is the same kind of agent as the one provided.
     * 
     * @param agent        type of agent (elephant or monkey)
     * 
     * @return true if it is the same kind, false if not
     */
    public boolean isSameKindAs(Agent agent)
    {
        return this.getKind().equals(agent.getKind());
    }
    
    /**
     * A boolean method that returns true if this agent is
     * satisfied at the specified location.
     * 
     * @param x             x coordinate of the Agent
     * @param y             y coordinate of the Agent
     * 
     * @return true if the Agent is satisfied at the (x, y)
     * location, false if not
     */
    public boolean isSatisfiedAt(int x, int y)
    {
        double numE = 0;
        double numM = 0;
        
        int lowX = Math.max(0, x - 1);
        int highX = Math.min(this.getWorld().getWidth() - 1, x + 1);
        
        int lowY = Math.max(0, y - 1);
        int highY = Math.min(this.getWorld().getHeight() - 1, y + 1);
        
        
        for (int a = lowX; a <= highX; a++)
        {
            for (int b = lowY; b <= highY; b++)
            {
                Agent agent = this.getWorld().getOneObjectAt(a, b, Agent.class);
                if (agent != null
                    && agent.isSameKindAs(new Agent("elephant", threshold)))
                {
                    numE++;
                }
                else if (agent != null)
                {
                    numM++;
                }
            }
        }
        
        Agent agentHere = this.getWorld().getOneObjectAt(x, y, Agent.class);
        if (agentHere != null
            && agentHere.isSameKindAs(new Agent("elephant", threshold)))
        {
            numE--;
        }
        else if (agentHere != null)
        {
            numM--;
        }
        
        double sum = numE + numM;
        
        double percentageE = numE / sum;
        double percentageM = numM / sum;
        
        if (this.isSameKindAs(new Agent("elephant", threshold))
            && percentageE >= this.getThreshold())
        {
            return true;
        }
        return this.isSameKindAs(new Agent("monkey", threshold))
            && percentageM >= this.getThreshold();
    }
    
    /**
     * A boolean method that returns true if this agent is
     * satisfied at its current location.
     * 
     * @return true if the Agent is satisfied at its current
     * location, false if not
     */
    public boolean isSatisfied()
    {
        return isSatisfiedAt(this.getGridX(), this.getGridY());
    }
    
    /**
     * A method that moves the Agent to a new location in the
     * grid where it will be satisfied, if there is one.
     */
    public void relocate()
    {
        if (!this.isSatisfied())
        {
            for (int x = 0; x < this.getWorld().getWidth(); x++)
            {
                for (int y = 0; y < this.getWorld().getHeight(); y++)
                {
                    if (this.getWorld().getOneObjectAt(x, y) == null
                        && this.isSatisfiedAt(x, y))
                    {
                        this.setGridLocation(x, y);
                    }
                }
            }
        }
    }
    
    /**
     * Executes one "turn" for this agent, which means determining if
     * the agent is satisfied, and relocating if it is not.
     */
    public void act()
    {
        this.relocate();
    }


}
