package org.first.team342.vision;

import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author FIRST Team 342
 */
public class UsbCamera implements Camera {

    /**
     * Usb Camera logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(UsbCamera.class);
    /**
     * Constant for the default capture device number.
     */
    public static final int DEFAULT_DEVICE = 0;
    /**
     * The frame grabber utilized to access the camera's image.
     */
    private FrameGrabber frameGrabber;
    /**
     * The device number of the capture device.
     */
    private int deviceNumber;

    /**
     * Create a new instance using the default capture device.
     */
    public UsbCamera() {
        this(DEFAULT_DEVICE);
    }

    /**
     * Create a new instance using the capture device number specified.
     *
     * @param deviceNumber the capture device number.
     */
    public UsbCamera(int deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void connect() {
        logger.debug("Connecting to Usb Camera");
        this.frameGrabber = new OpenCVFrameGrabber(this.deviceNumber);
        this.frameGrabber.setFrameRate(DEFAULT_FRAME_RATE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Image getImage() {
        logger.debug("Getting image from Usb Camera.");
        Image image = null;

        try {
            opencv_core.IplImage newImage = this.frameGrabber.grab();
            image = ImageFactory.createImage(newImage);
            newImage.release();
        } catch (FrameGrabber.Exception ex) {
            logger.error("Error occured getting image.", ex);
        }

        return image;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disconnect() {
        logger.debug("Disconnecting Camera.");

        try {
            this.frameGrabber.release();
            this.frameGrabber = null;
        } catch (FrameGrabber.Exception ex) {
            logger.error("Error disconnecting camera.", ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        logger.debug("Starting Usb Camera.");

        try {
            this.frameGrabber.start();
        } catch (FrameGrabber.Exception ex) {
            logger.error("Error occured starting the camera.", ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        logger.debug("Stopping Usb Camera.");

        try {
            this.frameGrabber.stop();
        } catch (FrameGrabber.Exception ex) {
            logger.error("Error occured stopping the camera.", ex);
        }
    }
}
