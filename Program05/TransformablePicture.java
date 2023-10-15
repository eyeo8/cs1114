import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Provides various methods to alter a picture.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.30
 */
public class TransformablePicture extends Picture
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new TransformablePicture object.
     */
    public TransformablePicture()
    {
        // initializes
    }
    
    /**
     * Takes an image file and creates a 
     * new TransformablePicture object.
     * 
     * @param filename    Name of the file to import.
     */
    public TransformablePicture(String filename)
    {
        super(filename);
    }
    
    /**
     * Takes width and height and creates a
     * new blank image of the given size.
     * 
     * @param width      Width of the picture.
     * @param height     Height of the picture.
     */
    public TransformablePicture(int width, int height)
    {
        super(width, height);
    }
    
    /**
     * Creates a duplicate of the image.
     * 
     * @param picture    Picture to duplicate.
     */
    public TransformablePicture(Picture picture)
    {
        super(picture);
    }


    //~ Methods ...............................................................
    
    /**
     * Forces every pixel's red component to the max value.
     */
    public void maxRed()
    {
        for (Pixel pixel : this)
        {
            pixel.setRed(255);
        }
    }
    
    /**
     * Forces every pixel's green component to the max value.
     */
    public void maxGreen()
    {
        for (Pixel pixel : this)
        {
            pixel.setGreen(255);
        }
    }
    
    /**
     * Forces every pixel's blue component to the max value.
     */
    public void maxBlue()
    {
        for (Pixel pixel : this)
        {
            pixel.setBlue(255);
        }
    }
    
    /**
     * Converts each pixel to a grayscale value.
     */
    public void grayscale()
    {
        for (Pixel pixel : this)
        {
            int avg = (int) pixel.getAverage();
            pixel.setRed(avg);
            pixel.setGreen(avg);
            pixel.setBlue(avg);
        }
    }
    
    /**
     * Inverts the color of the picture by transforming
     * each pixel to its inverse color.
     */
    public void invert()
    {
        for (Pixel pixel : this)
        {
            int red = pixel.getRed();
            int green = pixel.getGreen();
            int blue = pixel.getBlue();
            
            pixel.setRed(255 - red);
            pixel.setGreen(255 - green);
            pixel.setBlue(255 - blue);
        }
    }
    
    /**
     * Applies multi-colored vertical stripes to thirds
     * of the image. 
     */
    public void multicolored()
    {
        Pixel[][] pixel = this.getPixels();
        int width = this.getImageWidth();
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < this.getImageHeight(); y++)
            {
                if (x < (width / 3))
                {
                    pixel[x][y].setRed(255);
                }
                else if (x < ((width * 2) / 3))
                {
                    pixel[x][y].setGreen(255);
                }
                else
                {
                    pixel[x][y].setBlue(255);
                }
            }
        }
    }
    
    /**
     * Increases the brightness of the image by 20%.
     */
    public void brighten()
    {
        for (Pixel pixel : this)
        {
            int red = pixel.getRed();
            int green = pixel.getGreen();
            int blue = pixel.getBlue();
            
            pixel.setRed(red * 1.2);
            pixel.setGreen(green * 1.2);
            pixel.setBlue(blue * 1.2);
        }
    }
    
    /**
     * Decreases the brightness of the image by 20%.
     */
    public void dim()
    {
        for (Pixel pixel : this)
        {
            int red = pixel.getRed();
            int green = pixel.getGreen();
            int blue = pixel.getBlue();
            
            pixel.setRed(red * 0.8);
            pixel.setGreen(green * 0.8);
            pixel.setBlue(blue * 0.8);
        }
    }
    
    /**
     * Returns a new TransformablePicture object that represents
     * the mirror image (horizontally) of the picture.
     * 
     * @return    Horizontally flipped image.
     */
    public TransformablePicture flipHorizontal()
    {
        int width = this.getImageWidth();
        int height = this.getImageHeight();
        TransformablePicture flipPic =
            new TransformablePicture(width, height);
        Pixel[][] pixel = this.getPixels();
        Pixel[][] flipPixel = flipPic.getPixels();
        
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                sofia.graphics.Color color = pixel[x][y].getColor();
                flipPixel[width - 1 - x][y].setColor(color);
            }
        }
        
        return flipPic;
    }
    
    /**
     * Returns a new TransformablePicture object that represents
     * the mirror image (vertically) of the picture.
     * 
     * @return    Vertically flipped image.
     */
    public TransformablePicture flipVertical()
    {
        int width = this.getImageWidth();
        int height = this.getImageHeight();
        TransformablePicture flipPic =
            new TransformablePicture(width, height);
        Pixel[][] pixel = this.getPixels();
        Pixel[][] flipPixel = flipPic.getPixels();
        
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                sofia.graphics.Color color = pixel[x][y].getColor();
                flipPixel[x][height - 1 - y].setColor(color);
            }
        }
        
        return flipPic;
    }
    
    /**
     * Takes another Picture object and composes it on top
     * of the current picture using alpha blending.
     * 
     * @param picture   The picture object that will go on top.
     */
    public void alphaBlend(Picture picture)
    {
        Pixel[][] pixel = this.getPixels();
        Pixel[][] topPixel = picture.getPixels();
        
        int width =
            Math.min(this.getImageWidth(), picture.getImageWidth());
        int height =
            Math.min(this.getImageHeight(), picture.getImageHeight());
        
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                int red = pixel[x][y].getRed();
                int green = pixel[x][y].getGreen();
                int blue = pixel[x][y].getBlue();
                
                int topRed = topPixel[x][y].getRed();
                int topGreen = topPixel[x][y].getGreen();
                int topBlue = topPixel[x][y].getBlue();
                int topAlpha = topPixel[x][y].getAlpha();
                
                double combinedRed = topRed * (topAlpha / 255.0)
                    + red * ((255 - topAlpha) / 255.0);
                double combinedGreen = topGreen * (topAlpha / 255.0)
                    + green * ((255 - topAlpha) / 255.0);
                double combinedBlue = topBlue * (topAlpha / 255.0)
                    + blue * ((255 - topAlpha) / 255.0);
                
                pixel[x][y].setRed(combinedRed);
                pixel[x][y].setGreen(combinedGreen);
                pixel[x][y].setBlue(combinedBlue);
            }
        }
    }
}
