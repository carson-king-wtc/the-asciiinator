import java.awt.image.PixelGrabber;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.opencv.opencv_core.IplImage;
import java.awt.Color;
import java.util.LinkedList;

public class Main{
    public static void main(String []args) throws IOException, Exception
    {
        VideoToFrames video = new VideoToFrames();
        int frameNumber=151;
        video.VideoToFrames("bad apple.mp4",frameNumber);
        System.out.println("Done!");
        System.out.println("Ascii time!!!11!1!1");


        for(int i=0;i<frameNumber;i++) {
            BufferedImage image = ImageIO.read(new File("frame-dump/video-frame-" + i + ".png"));
            Java2DFrameConverter converter = new Java2DFrameConverter();
            int[][][] list=new int[image.getWidth()][image.getHeight()][3];
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    //Retrieving contents of a pixel
                    int pixel = image.getRGB(x,y);
                    //Creating a Color object from pixel value
                    Color color = new Color(pixel, true);
                    //Retrieving the R G B values
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    int[] pixelData = {red,blue,green};
                    list[x][y]=pixelData;
                }
            }
            PrintWriter writer = new PrintWriter("frame-ascii/frame"+i+".txt", "UTF-8");
            for (int x = 0; x < image.getHeight(); x++) {
                for (int y = 0; y < image.getWidth(); y++) {
                    if (list[y][x][0] + list[y][x][1] + list[y][x][2] >= 382 * 2) {
                        writer.print("  ");
                    } else {
                        writer.print("[]");
                    }
                }
                writer.println();
            }
            writer.close();
        }
    }
}