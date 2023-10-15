import sofia.micro.*;
import sofia.graphics.Color;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests the TransformablePicture class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.30
 */
public class TransformablePictureTest extends TestCase
{
    //~ Fields ................................................................
    
    private World world;
    private TransformablePicture pic;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new TransformablePictureTest test object.
     */
    public TransformablePictureTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        world = new World(50, 50, 1);
        world.setBackgroundColor(Color.white);
        pic = new TransformablePicture();
    }


    // ----------------------------------------------------------
    
    /**
     * Tests if maxRed sets every pixel's red
     * component to the max value.
     */
    public void testMaxRed()
    {
        pic = new TransformablePicture("images/green2x2.png");
        world.add(pic, 10, 10);
        
        pic.maxRed();
        
        for (Pixel pixel : pic)
        {
            assertEquals(pixel.getRed(), 255);
        }
    }
    
    /**
     * Tests if maxGreen sets every pixel's green
     * component to the max value.
     */
    public void testMaxGreen()
    {
        pic = new TransformablePicture("images/red2x2.png");
        world.add(pic, 10, 10);
        
        pic.maxGreen();
        
        for (Pixel pixel : pic)
        {
            assertEquals(pixel.getGreen(), 255);
        }
    }
    
    /**
     * Tests if maxBlue sets every pixel's blue
     * component to the max value.
     */
    public void testMaxBlue()
    {
        pic = new TransformablePicture("images/red2x2.png");
        world.add(pic, 10, 10);
        
        pic.maxBlue();
        
        for (Pixel pixel : pic)
        {
            assertEquals(pixel.getBlue(), 255);
        }
    }
    
    /**
     * Tests if grayscale converts every pixel to gray.
     */
    public void testGrayscale()
    {
        pic = new TransformablePicture("images/red2x2.png");
        world.add(pic, 10, 10);
        
        pic.grayscale();
        
        for (Pixel pixel : pic)
        {
            assertEquals(pixel.getRed(), 85);
            assertEquals(pixel.getGreen(), 85);
            assertEquals(pixel.getBlue(), 85);
        }
    }
    
    /**
     * Tests if invert inverts the color of each pixel.
     */
    public void testInvert()
    {
        pic = new TransformablePicture("images/green2x2.png");
        world.add(pic, 10, 10);
        
        pic.invert();
        
        for (Pixel pixel : pic)
        {
            assertEquals(pixel.getRed(), 255);
            assertEquals(pixel.getGreen(), 0);
            assertEquals(pixel.getBlue(), 255);
        }
    }
    
    /**
     * Tests if multicolored colors into three segments/stripes.
     */
    public void testMulticolored()
    {
        pic = new TransformablePicture("images/color5x5.png");
        world.add(pic, 10, 10);
        
        pic.multicolored();
        
        Pixel[][] pixel = pic.getPixels();
        int width = pic.getImageWidth();
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < pic.getImageHeight(); y++)
            {
                if (x < (width / 3))
                {
                    assertEquals(pixel[x][y].getRed(), 255);
                }
                else if (x < ((width * 2) / 3))
                {
                    assertEquals(pixel[x][y].getGreen(), 255);
                }
                else
                {
                    assertEquals(pixel[x][y].getBlue(), 255);
                }
            }
        }
    }
    
    /**
     * Tests if the brightness is increased by 20%.
     */
    public void testBrighten()
    {
        pic = new TransformablePicture("images/gray5x5.png");
        world.add(pic, 10, 10);
        
        pic.brighten();
        
        for (Pixel pixel : pic)
        {
            assertEquals(pixel.getRed(), 152);
            assertEquals(pixel.getGreen(), 152);
            assertEquals(pixel.getBlue(), 152);
        }
    }
    
    /**
     * Tests if the brightness is decreased by 20%.
     */
    public void testDim()
    {
        pic = new TransformablePicture("images/gray5x5.png");
        world.add(pic, 10, 10);
        
        pic.dim();
        
        for (Pixel pixel : pic)
        {
            assertEquals(pixel.getRed(), 102);
            assertEquals(pixel.getGreen(), 102);
            assertEquals(pixel.getBlue(), 102);
        }
    }
    
    /**
     * Tests if the image is flipped horizontally.
     */
    public void testFlipHorizonal()
    {
        pic = new TransformablePicture("images/color5x5.png");
        TransformablePicture flipped = pic.flipHorizontal();
        world.add(flipped, 30, 30);
        
        int width = pic.getImageWidth();
        int height = pic.getImageHeight();
        Pixel[][] pixel = pic.getPixels();
        Pixel[][] flipPixel = flipped.getPixels();
        
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color color = pixel[x][y].getColor();
                assertEquals(flipPixel[width - 1 - x][y].getColor(), color);
            }
        }
    }
    
    /**
     * Tests if the image is flipped vertically.
     */
    public void testFlipVertical()
    {
        pic = new TransformablePicture("images/color5x5.png");
        TransformablePicture flipped = pic.flipVertical();
        world.add(flipped, 30, 30);
        
        int width = pic.getImageWidth();
        int height = pic.getImageHeight();
        Pixel[][] pixel = pic.getPixels();
        Pixel[][] flipPixel = flipped.getPixels();
        
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                Color color = pixel[x][y].getColor();
                assertEquals(flipPixel[x][height - 1 - y].getColor(), color);
            }
        }
    }
    
    /**
     * Tests if two pictures are alpha blended.
     */
    public void testAlphaBlend()
    {
        TransformablePicture bottomPic = new TransformablePicture(30, 30);
        for (Pixel pixel : bottomPic)
        {
            pixel.setColor(Color.red);
            pixel.setAlpha(170);
            assertEquals(pixel.getGreen(), 0);
            assertEquals(pixel.getBlue(), 0);
        }
        
        Picture paramPic = new Picture(30, 30);
        for (Pixel pixel : paramPic)
        {
            pixel.setColor(Color.blue);
            pixel.setAlpha(100);
        }
        TransformablePicture topPic = new TransformablePicture(paramPic);
        
        world.add(bottomPic, 25, 25);
        world.add(topPic, 25, 25);
        
        bottomPic.alphaBlend(topPic);
        
        Pixel[][] pixel = bottomPic.getPixels();
        Pixel[][] topPixel = topPic.getPixels();
        
        int width =
            Math.min(bottomPic.getImageWidth(), topPic.getImageWidth());
        int height =
            Math.min(bottomPic.getImageHeight(), topPic.getImageHeight());
        
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                double combinedRed = 0 * (100 / 255.0)
                    + 255 * ((255 - 100) / 255.0);
                double combinedGreen = 0 * (100 / 255.0)
                    + 0 * ((255 - 100) / 255.0);
                double combinedBlue = 255 * (100 / 255.0)
                    + 0 * ((255 - 100) / 255.0);
                
                double doubleRed = pixel[x][y].getRed();
                double doubleGreen = pixel[x][y].getGreen();
                double doubleBlue = pixel[x][y].getBlue();
                
                assertEquals(doubleRed, combinedRed, 1.0);
                assertEquals(doubleGreen, combinedGreen, 1.0);
                assertEquals(doubleBlue, combinedBlue, 1.0);
            }
        }
    }
}
