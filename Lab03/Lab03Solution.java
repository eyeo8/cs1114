import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  Removes as many nets as possible based
 *  on the number of flowers the Jeroo has.
 *
 *  @author Elliot Yeo (906349574)
 *  @version 2020.09.11
 */
public class Lab03Solution extends NetIsland
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................
    

    // ----------------------------------------------------------
    /**
     * Creates a new Lab03Solution object.
     */
    public Lab03Solution()
    {
        // Nothing to initialize, leaving the world a default size
        
        //Adds a Jeroo at (3,1) facing East with n flowers
        NetRemover jerry = new NetRemover(3, 1);
        this.add(jerry);
    }


    //~ Methods ...............................................................
    
    


}
