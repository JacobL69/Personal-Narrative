import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // 2D Array
    String[][] array1 = {
      {"Stockholm", "Oslo"},
      {"Copenhagen", "Reykjavík"}
    };

    ImageFilter[][] array2 = {
      { new ImageFilter("Stockholm.png"), new ImageFilter("Oslo.png") },
      { new ImageFilter("Copenhagen.png"), new ImageFilter("Reykjav--k.png") },
    };

    int[][] array3 = {
      { ImageFilter.FILTER_SATURATE, ImageFilter. FILTER_MAKE_NEGATIVE },
      { ImageFilter.FILTER_MIRROR_VERTICAL, ImageFilter.FILTER_SATURATE },
    };

    // MyStory object
    MyStory scene = new MyStory(array1, array2, array3);
    
    // Call drawScene
    scene.drawScene();

    // Play scene in Theater
    Theater.playScenes(scene);
  }
}