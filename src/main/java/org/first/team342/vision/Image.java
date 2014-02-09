package org.first.team342.vision;

import static com.googlecode.javacv.cpp.opencv_core.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for all images. This is an abstract class therefore it cannot be
 * instantiated directly. Instead use one of the following:<br>
 * <ul>
 * <li>{@link ColorImage} - RGB image.</li>
 * <li>{@link GrayscaleImage} - Grayscale image.</li>
 * <li>{@link BinaryImage} - Black and white image.</li>
 * </ul>
 *
 * @author FIRST Team 342
 */
public abstract class Image {

    /**
     * Class logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(Image.class);
    /**
     * Constant value for the X axis flip mode.
     */
    public static final int FLIP_MODE_X_AXIS = 0;
    /**
     * Constant value for the Y axis flip mode.
     */
    public static final int FLIP_MODE_Y_AXIS = 1;
    /**
     * Constant value for the both axis flip mode.
     */
    public static final int FLIP_MODE_BOTH = -1;
    /**
     * The core image object.
     */
    protected IplImage image;

    /**
     * Create a new instance from the provided image.
     *
     * @param image the core image.
     */
    public Image(IplImage image) {
        this.image = image;
    }

    /**
     * Returns a {@link BufferedImage} representation of the image.
     *
     * @return a BufferedImage representation of the image.
     */
    public BufferedImage getBufferedImage() {
        logger.debug("Getting BufferedImage.");
        return this.image.getBufferedImage();
    }

    /**
     * Returns the core image.
     *
     * @return the core image.
     */
    public IplImage getImage() {
        logger.debug("Getting Image.");
        return this.image;
    }

    /**
     * Flip the image according to the specified flip mode.
     *
     * @param flipMode the flip mode that defines how to flip the image.<br>
     * <br>
     * Valid flip modes:<br>
     * <ul>
     *   <li>{@link Image#FLIP_MODE_X_AXIS}</li>
     *   <li>{@link Image#FLIP_MODE_Y_AXIS}</li>
     *   <li>{@link Image#FLIP_MODE_BOTH}</li>
     * </ul>
     */
    public void flip(int flipMode) {
        cvFlip(image, image, flipMode);
    }

    /**
     * Returns the image width.
     *
     * @return the image width.
     */
    public int getWidth() {
        return this.image.width();
    }

    /**
     * Returns the image height.
     *
     * @return the image height.
     */
    public int getHeight() {
        return this.image.height();
    }

    @Override
    public Image clone() {
        return ImageFactory.createImage(this.image.clone());
    }

    /**
     * Release allocated resources.
     */
    public void release() {
        this.image.release();
    }
}
