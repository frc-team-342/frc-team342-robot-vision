package org.first.team342.vision;

import static com.googlecode.javacv.cpp.opencv_core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author FIRST Team 342
 */
public class ColorImage extends Image {

    private static final Logger logger = LoggerFactory.getLogger(ColorImage.class);
    /**
     * Constant value for red channel lookup in channels array.
     */
    public static final int RED_CHANNEL = 0;
    /**
     * Constant value for green channel lookup in channels array.
     */
    public static final int GREEN_CHANNEL = 1;
    /**
     * Constant value for blue channel lookup in channels array.
     */
    public static final int BLUE_CHANNEL = 2;

    /**
     * Create a new instance.
     *
     * @param image the core image.
     */
    public ColorImage(IplImage image) {
        super(image);
    }

    public GrayscaleImage[] getRGBChannels() {
        logger.debug("Getting RGB Channels.");

        IplImage red = IplImage.create(this.image.cvSize(), 8, 1);
        IplImage green = IplImage.create(this.image.cvSize(), 8, 1);
        IplImage blue = IplImage.create(this.image.cvSize(), 8, 1);

        cvSplit(this.image, blue, green, red, null);

        GrayscaleImage[] channels = new GrayscaleImage[]{
            new GrayscaleImage(red),
            new GrayscaleImage(green),
            new GrayscaleImage(blue)};

        return channels;
    }
}
