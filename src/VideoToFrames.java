import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.opencv.opencv_core.IplImage;

public class VideoToFrames {
    /**
     * this function converts a video into a bunch of images (one for every frame)
     * @param video the location of the video file
     * @param framesToGet the amount of frames in the video to get, just set to an absurdly high number if you want all of the frames.
     */
    public static void VideoToFrames(String video, int framesToGet){
        //set up a frame grabber
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(video);
        try {
            grabber.start();
        } catch (FFmpegFrameGrabber.Exception e) {
            //throw new RuntimeException(e);
        }

        //setup the converter, this lets us turn frames into image data
        Java2DFrameConverter converter = new Java2DFrameConverter();

        try {
            //too lazy to find out how to get the number of frames, just go a long time instead.
            for (int i = 0; i < framesToGet; i++) {
                System.out.println("got frame #"+i);
                Frame frame = grabber.grabImage(); // It is important to use grabImage() to get a frame that can be turned into a BufferedImage

                BufferedImage bufferedImage = converter.convert(frame); //convert the frame into image data

                //write the file
                try {
                    if(bufferedImage==null)
                    {
                        break;
                    }
                    else {
                        ImageIO.write(bufferedImage, "png", new File("frame-dump/video-frame-" + i + ".png"));
                    }
                } catch (IOException e) {
                    //throw new RuntimeException(e);
                }
            }
        }
        catch (FrameGrabber.Exception e)
        {

        }
        //stop the grabber

        try {
            grabber.stop();
        } catch (FFmpegFrameGrabber.Exception e) {
            //throw new RuntimeException(e);
        }
    }
}
