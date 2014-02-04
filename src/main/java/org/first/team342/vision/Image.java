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

    private static final Logger logger = LoggerFactory.getLogger(Image.class);
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
     * Draw a point on the image.
     *
     * @param x the x value of the point.
     * @param y the y value of the point.
     * @param color the color to paint the point.
     * @param thickness the thickness of the point in pixels.
     */
    public void drawPoint(int x, int y, Color color, int thickness) {
        logger.debug("Drawing Point.");
        cvDrawCircle(this.image, cvPoint(x, y), thickness,
                this.toScalar(color), CV_FILLED, 8, 0);
    }

    /**
     * Draw a line on the image.
     *
     * @param x1 the x value of the first point.
     * @param y1 the y value of the first point.
     * @param x2 the x value of the second point.
     * @param y2 the y value of the second point.
     * @param color the color to paint the line.
     * @param thickness the thickness of the line in pixels.
     */
    public void drawLine(int x1, int y1, int x2, int y2, Color color, int thickness) {
        logger.debug("Drawing Line.");
        cvDrawLine(this.image, cvPoint(x1, y1), cvPoint(x2, y2), this.toScalar(color),
                thickness, 8, 0);
    }

    /**
     * Draw a circle on the image.
     *
     * @param x the x value of the center of the circle.
     * @param y the y value of the center of the circle.
     * @param radius the radius of the circle in pixels.
     * @param color the color to paint the circle.
     * @param thickness the thickness of the line in pixels.
     */
    public void drawCircle(int x, int y, int radius, Color color, int thickness) {
        logger.debug("Drawing Circle.");
        cvDrawCircle(this.image, cvPoint(x, y), radius, this.toScalar(color),
                thickness, 8, 0);
    }

    /**
     * Draw a rectangle on the image.
     *
     * @param x the x value of the top left of the rectangle.
     * @param y the y value of the top left of the rectangle.
     * @param width the width of the rectangle in pixels.
     * @param height the height of the rectangle in pixels.
     * @param color the color to paint the rectangle.
     * @param thickness the thickness of the line in pixels.
     */
    public void drawRect(int x, int y, int width, int height, Color color, int thickness) {
        logger.debug("Drawing Rectangle.");
        cvDrawRect(this.image, cvPoint(x, y), cvPoint(x + width, y + height),
                this.toScalar(color), thickness, 8, 0);
    }

    /**
     * Convert a {@link Color} to a {@link CvScalar}.
     *
     * @param color the color object to convert.
     * @return the converted cvScalar object.
     */
    private CvScalar toScalar(Color color) {
        logger.debug("Converting color to cvScalar.");
        return CV_RGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}
