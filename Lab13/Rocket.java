import sofia.micro.*;
import student.IOHelper;
import java.util.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  A remotely controllable rocket ship that reads commands
 *  from a scanner and carries out the corresponding actions
 *  one at a time as act() is called.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.21
 */
public class Rocket extends Actor
{
    //~ Fields ................................................................

    private Scanner input;
    private Map<String, Command> map;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Rocket object that reads commands
     * from a predefined URL (the URL is in the lab assignment).
     */
    public Rocket()
    {
        this(IOHelper.createScannerForURL(
            "http://courses.cs.vt.edu/~cs1114/Fall2012/rocket-commands.txt"));
    }


    // ----------------------------------------------------------
    /**
     * Creates a new Rocket object that reads commands
     * from the given scanner.
     * @param scanner The scanner to read commands from.
     */
    public Rocket(Scanner scanner)
    {
        input = scanner;
        map = new HashMap<String, Command>();
        ForwardCommand forward = new ForwardCommand(this);
        map.put("forward", forward);
        LeftCommand left = new LeftCommand(this);
        map.put("left", left);
        RightCommand right = new RightCommand(this);
        map.put("right", right);
        
        ForwardCommand forwardCap = new ForwardCommand(this);
        map.put("Forward", forwardCap);
        LeftCommand leftCap = new LeftCommand(this);
        map.put("Left", leftCap);
        RightCommand rightCap = new RightCommand(this);
        map.put("Right", rightCap);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Reads one word from the scanner (if there is any), and executes
     * the corresponding command.  If the scanner has no words remaining,
     * then nothing happens.
     */
    public void act()
    {
        if (input.hasNext())
        {
            String word = input.next();
            if (word.equals("forward") || word.equals("Forward"))
            {
                map.get(word).execute();
            }
            else if (word.equals("left") || word.equals("Left"))
            {
                map.get(word).execute();
            }
            else if (word.equals("right") || word.equals("Right"))
            {
                map.get(word).execute();
            }
        }
    }
}
