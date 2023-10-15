// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Command interface that calls execute() method
 *  to the object.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.21
 */
public interface Command 
{
    /**
     * Executes the command.
     */
    void execute();
}
