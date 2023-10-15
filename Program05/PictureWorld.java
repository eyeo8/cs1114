import sofia.micro.*; 

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

/**
 * Class that extends World and holds Pictures that can act
 * @author Cay Horstmann
 * @author Barb Ericson
 */ 
public class PictureWorld
    extends World
{
    /**
     * Constructor that creates a world to show pictures in.
     */
    public PictureWorld()
    {
        super(800, 600, 1);
        TransformablePicture pic = new TransformablePicture("images/The Road.jpg");
        this.add(pic, 320, 240);
    }
}
