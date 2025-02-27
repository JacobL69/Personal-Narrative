import org.code.theater.*;
import org.code.media.*;

/*
 * Represents a saturated image
 */
public class ImageFilter extends ImagePlus {

  public static final int FILTER_SATURATE = 0;
  public static final int FILTER_MAKE_NEGATIVE = 1;
  public static final int FILTER_MIRROR_VERTICAL = 2;
  
  /*
   * Calls the superclass constructor to initialize pixels
   */
  public ImageFilter (String filename) {
    super(filename);
  }

  /*
   * Applies a saturation filter to the image
   */
  public void saturate(int factor) {
    /* ----------------------------------- TO DO -----------------------------------
     * ✅ Get the pixels from the image, and traverse the 2D array of Pixel objects.
     * Calculate the average of the red, green, and blue values of each Pixel object,
     * then calculate the adjusted grayscale value. Use this result to determine the
     * value to set the red, green, and blue values. If any of these are over 255, set
     * them to 255. Set the red, green, and blue color values of each Pixel to the result.
     * -----------------------------------------------------------------------------
     */

    Pixel[][] pixels = getImagePixels();

    for (Pixel[] pixelArr : pixels) {
      for (Pixel currentPixel : pixelArr) {
        int avgColor = currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen();
        avgColor /= 3;

        int grayScaleValue = avgColor + (avgColor - 255) * factor;

        int newRed = 2 * grayScaleValue - currentPixel.getRed();
        int newGreen = 2 * grayScaleValue - currentPixel.getGreen();
        int newBlue = 2 * grayScaleValue - currentPixel.getBlue();

        if (newRed > 255) {
          newRed = 255;
        }

        if (newGreen > 255) {
          newGreen = 255;
        }

        if (newBlue > 255) {
          newBlue = 255;
        }

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
  
  public void makeNegative() {
    /* ----------------------------------- TO DO -----------------------------------
     * ✅ Get the pixels from the image, then traverse the 2D array of pixels. Set
     * the red, green, and blue color values of each Pixel object to the result of
     * 255 minus the current values.
     * -----------------------------------------------------------------------------
     */

    Pixel[][] pixels = getImagePixels();

    for (Pixel[] row : pixels) {
      for (Pixel pixel : row) {
        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();
        
        pixel.setRed(255 - red);
        pixel.setGreen(255 - green);
        pixel.setBlue(255 - blue);
      }
    }
  }
  
  public void mirrorVertical() {
    /* ----------------------------------- TO DO -----------------------------------
     * ✅ Get the pixels from the image, then traverse each row of Pixel objects
     * and the left half of the columns. Set the color of the Pixel object on the
     * left side of the image to the color of the Pixel object on the right side.
     * -----------------------------------------------------------------------------
     */

    Pixel[][] pixels = getImagePixels();
    
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length / 2; col++) {
        Pixel leftPixel = pixels[row][col];
        Pixel rightPixel = pixels[row][pixels[0].length - col - 1];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }
}