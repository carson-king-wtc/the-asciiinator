import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.PixelGrabber;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.opencv.opencv_core.IplImage;

import java.util.LinkedList;

public class Main{
    public static void main(String []args) throws IOException, Exception
    {
        VideoToFrames video = new VideoToFrames();
        int frameNumber=1000000;
        video.VideoToFrames("I love gd cologne.mp4",frameNumber);
        System.out.println("Done!");
        System.out.println("Ascii time!!!11!1!1");


        for(int i=0;i<frameNumber;i++) {
            System.out.println("Ascii-ing #"+i);
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
                    if (list[y][x][0] + list[y][x][1] + list[y][x][2] >= 382) {
                        writer.print("  ");
                    } else {
                        writer.print("[]");
                    }
                }
                writer.println();
            }
            writer.close();
        }
        System.out.println("Ascii done");
        /*
        JFrame window = new JFrame();

        BufferedImage image = ImageIO.read(new File("frame-dump/video-frame-" + 0 + ".png"));
        window.setSize(image.getWidth(), image.getHeight());//400 width and 500 height

        window.setLayout(null);//using no layout managers
        window.setVisible(true);//making the frame visible
        JLabel text = new JLabel("", SwingConstants.CENTER);
        text.setLocation(new Point(image.getWidth()/2, image.getHeight()/2));
        window.add(text);
        for(int i=0;i<frameNumber;i++) {
            String everything = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader("frame-ascii/frame"+i+".txt"));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                everything = sb.toString();
            }
            catch (Exception e)
            {

            }


            //change the window size and other stuff

            text.setText("<html>" + everything.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            //System.out.println(text.getX());

            try {
                Thread.sleep(41);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
        */
    }
}