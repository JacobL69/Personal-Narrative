import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {
  
  // Instance Variables
  private String[][] variable1;
  private ImageFilter[][] variable2;
  private int[][] variable3;
  
  // Constructor
  public MyStory(String[][] variable1, ImageFilter[][] variable2, int[][] variable3) {
    this.variable1 = variable1;
    this.variable2 = variable2;
    this.variable3 = variable3;
  }

  // Calls all the parts of your animation, in order
  public void drawScene() {
    drawFirstScene();
    drawSecondScene();
  }

  public void drawFirstScene() {
    clear("white");

    drawText(variable1[0][0], 50, 100);
    pause(0.5);
    drawText(variable1[0][1], 250, 100);
    pause(0.5);
    drawText(variable1[1][0], 50, 300);
    pause(0.5);
    drawText(variable1[1][1], 250, 300);

    pause(1.0);
  }

  public void drawSecondScene() {
    for (int row = 0; row < variable2.length; row++) {
      for (int col = 0; col < variable2[0].length; col++) {
        clear("white");
        
        ImageFilter image1 = variable2[row][col];
        drawImage(image1, 0, 0, 400);
        drawText(variable1[row][col].toUpperCase(), 100, 300);
        pause(0.5);

        // load the filter
        int filter = variable3[row][col];

        // apply the filter
        if (filter == ImageFilter.FILTER_SATURATE) {
          image1.saturate(1);
        }
        else if (filter == ImageFilter.FILTER_MAKE_NEGATIVE) {
          image1.makeNegative();
        }
        else if (filter == ImageFilter.FILTER_MIRROR_VERTICAL) {
          image1.mirrorVertical();
        }
        
        drawImage(image1, 0, 0, 400);
        pause(1);
      }
    }
  }
}