package org.first.team342.vision;

import com.googlecode.javacv.FFmpegFrameGrabber;
import com.googlecode.javacv.FrameGrabber;
import static com.googlecode.javacv.cpp.opencv_core.*;
import java.net.InetAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class that provides access to the Axis IP camera.<br>
 * <br>
 * <strong>Example Usage:</strong><br>
 * <pre>
 * AxisCamera camera = new AxisCamera("10.3.42.11");
 * camera.start();
 *
 * while (!cancelled) {
 *     IplImage image = camera.getImage();
 * }
 *
 * camera.stop();
 * </pre>
 *
 * @author FIRST Team 342
 */
public class AxisCamera implements Camera {

    /**
     * Class logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(AxisCamera.class);
    /**
     * The frame grabber utilized to access the camera's image.
     */
    private FFmpegFrameGrabber frameGrabber;
    /**
     * The IP address of the camera.
     */
    private String ipAddress = null;

    /**
     * Create a new instance with the given IP address.
     *
     * @param ipAddress the IP address of the camera.
     */
    public AxisCamera(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * Create a new instance with the given {@link InetAddress}.
     *
     * @param ipAddress the {@link InetAddress} of the camera.
     */
    public AxisCamera(InetAddress ipAddress) {
        this(ipAddress.getHostAddress());
    }

    /**
     * Connect to the camera.  This method will attempt to connect to the axis
     * camera and initialize it for use.
     */
    @Override
    public void connect() {
        logger.debug("Connecting to Axis Camera");
        String connectionString = String.format("http://%s/mjpg/video.mjpg", ipAddress);
        this.frameGrabber = new FFmpegFrameGrabber(connectionString);
        this.frameGrabber.setFrameRate(1.0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Image getImage() {
        logger.debug("Getting image from Axis Camera.");
        Image image = null;

        try {
            IplImage newImage = this.frameGrabber.grab();
            image = ImageFactory.createImage(newImage);
        } catch (FrameGrabber.Exception ex) {
            logger.error("Error occured getting image.", ex);
        }

        return image;
    }

    /**
     * Start the camera.  This method will enable the camera to allow image capturing.<br>
     * <br>
     * <strong>Note:</strong> This method MUST be called prior to calling {@link #getImage()}.
     */
    public void start() {
        logger.debug("Starting Axis Camera.");
        try {
            this.frameGrabber.start();
        } catch (FrameGrabber.Exception ex) {
            logger.error("Error occured starting the camera.", ex);
        }
    }

    /**
     * Stop the camera.  This method will disable the camera.  Images will no longer
     * be able to be captured.
     */
    public void stop() {
        logger.debug("Stopping Axis Camera.");
        try {
            this.frameGrabber.stop();
            this.frameGrabber.release();
        } catch (FrameGrabber.Exception ex) {
            logger.error("Error occured stopping the camera.", ex);
        }
    }
}
