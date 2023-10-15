import sofia.micro.*;
import java.util.Scanner;
import student.IOHelper;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Tux is a remotely controllable actor that reads commands
 *  from a scanner and carries out the corresponding actions
 *  one at a time as act() is called.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.13
 */
public class RemoteTux extends Actor
{
    //~ Fields ................................................................

    private Scanner input;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new RemoteTux object that reads commands
     * from a predefined URL (the URL is in the lab assignment).
     */
    public RemoteTux()
    {
        this(IOHelper.createScannerForURL(
            "http://courses.cs.vt.edu/~cs1114/labs/tux-commands.txt"));
    }


    // ----------------------------------------------------------
    /**
     * Creates a new RemoteTux object that reads commands
     * from the given scanner.
     * @param scanner The scanner to read commands from.
     */
    public RemoteTux(Scanner scanner)
    {
        input = scanner;
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
            if (word.equals("forward"))
            {
                this.forward();
            }
            else if (word.equals("left"))
            {
                this.left();
            }
            else if (word.equals("right"))
            {
                this.right();
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Moves the actor forward one square.
     */
    public void forward()
    {
        this.move(1);
    }


    // ----------------------------------------------------------
    /**
     * Turns the actor left 90 degrees.
     */
    public void left()
    {
        this.turn(-90);
    }


    // ----------------------------------------------------------
    /**
     * Turns the actor right 90 degrees.
     */
    public void right()
    {
        this.turn(90);
    }
}
