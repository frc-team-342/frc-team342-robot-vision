/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.vision;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_features2d.*;
import java.awt.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author abrightwell
 */
public class ImageUtility {

    private static final Logger logger = LoggerFactory.getLogger(ImageUtility.class);

    /**
     * Find contours in a binary image.<br>
     * <br>
     * A binary image can be created using one of the following:<br>
     * <br>
     * <ul>
     * <li>{@link ImageUtility#filter(org.first.team342.vision.Image, java.awt.Color, java.awt.Color)}</li>
     * </ul>
     *
     * @param image an 8-bit single-channel image. Non-zero pixels are treated
     * as 1?s. Zero pixels remain 0?s, so the image is treated as binary.
     * @return
     */
    public static CvContour[] findContours(Image image) {
        cvFindContours(null, null, null, CV_C, CV_C, CV_C);
        return null;
    }

    /**
     * Create a binary image by filtering between lower and upper bounds. If a
     * pixel value is between the boundaries inclusively, then the resulting
     * images corresponding pixel value is set to 255 otherwise it is set to 0.
     *
     * @param image the image to filter.
     * @param lowerBound the inclusive lower bound value.
     * @param upperBound the inclusive upper bound value.
     * @return the resulting binary image.
     */
    public static GrayscaleImage filter(Image image, Color lowerBound, Color upperBound) {
        IplImage resultImage = cvCreateImage(cvGetSize(image.getImage()), IPL_DEPTH_8U, 1);
        cvInRangeS(image.getImage(), toScalar(lowerBound), toScalar(upperBound), resultImage);

        return new GrayscaleImage(resultImage);
    }

    public static GrayscaleImage convertToGrayscale(ColorImage image) {
        IplImage resultImage = cvCreateImage(cvGetSize(image.getImage()), IPL_DEPTH_8U, 1);
        cvCvtColor(image.getImage(), resultImage, CV_BGR2GRAY);
        return new GrayscaleImage(resultImage);
    }

    public static ColorImage convertToColor(GrayscaleImage image) {
        IplImage resultImage = cvCreateImage(cvGetSize(image.getImage()), IPL_DEPTH_8U, 3);
        cvCvtColor(image.getImage(), resultImage, CV_GRAY2BGR);
        return new ColorImage(resultImage);
    }

    /**
     * Draw a point on an image.
     *
     * @param image the target image.
     * @param x the x value of the point.
     * @param y the y value of the point.
     * @param color the color to paint the point.
     * @param thickness the thickness of the point in pixels.
     */
    public void drawPoint(Image image, int x, int y, Color color, int thickness) {
        logger.debug("Drawing Point.");
        cvDrawCircle(image.getImage(), cvPoint(x, y), thickness,
                ImageUtility.toScalar(color), CV_FILLED, 8, 0);
    }
    
    /**
     * Draw a line on an image.
     *
     * @param image the target image.
     * @param x1 the x value of the first point.
     * @param y1 the y value of the first point.
     * @param x2 the x value of the second point.
     * @param y2 the y value of the second point.
     * @param color the color to paint the line.
     * @param thickness the thickness of the line in pixels.
     */
    public void drawLine(Image image, int x1, int y1, int x2, int y2, Color color, int thickness) {
        logger.debug("Drawing Line.");
        cvDrawLine(image.getImage(), cvPoint(x1, y1), cvPoint(x2, y2), ImageUtility.toScalar(color),
                thickness, 8, 0);
    }
    
    /**
     * Draw a circle on an image.
     *
     * @param image the target image.
     * @param x the x value of the center of the circle.
     * @param y the y value of the center of the circle.
     * @param radius the radius of the circle in pixels.
     * @param color the color to paint the circle.
     * @param thickness the thickness of the line in pixels.
     */
    public void drawCircle(Image image, int x, int y, int radius, Color color, int thickness) {
        logger.debug("Drawing Circle.");
        cvDrawCircle(image.getImage(), cvPoint(x, y), radius, ImageUtility.toScalar(color),
                thickness, 8, 0);
    }
    
    /**
     * Draw a rectangle on an image.
     *
     * @param x the x value of the top left of the rectangle.
     * @param y the y value of the top left of the rectangle.
     * @param width the width of the rectangle in pixels.
     * @param height the height of the rectangle in pixels.
     * @param color the color to paint the rectangle.
     * @param thickness the thickness of the line in pixels.
     */
    public void drawRect(Image image, int x, int y, int width, int height, Color color, int thickness) {
        logger.debug("Drawing Rectangle.");
        cvDrawRect(image.getImage(), cvPoint(x, y), cvPoint(x + width, y + height),
                ImageUtility.toScalar(color), thickness, 8, 0);
    }

    
    /**
     * Convert a {@link Color} to a {@link CvScalar}.
     *
     * @param color the color object to convert.
     * @return the converted cvScalar object.
     */
    public static CvScalar toScalar(Color color) {
        logger.debug("Converting color to cvScalar.");
        return CV_RGB(color.getRed(), color.getGreen(), color.getBlue());
    }
}
