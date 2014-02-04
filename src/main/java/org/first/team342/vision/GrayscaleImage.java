package org.first.team342.vision;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author FIRST Team 342
 */
public class GrayscaleImage extends Image {

    private static final Logger logger = LoggerFactory.getLogger(GrayscaleImage.class);

    /**
     * Create a new instance from the given image.
     *
     * @param image the core image.
     */
    public GrayscaleImage(IplImage image) {
        super(image);
    }

    /**
     * Get an image that has been filtered based on the threshold value. If a
     * pixel is greater than the threshold value, then the result image pixel
     * value will be set to {@link BinaryImage#MAX_BINARY_VALUE}, otherwise the
     * pixel value will be set to {@link BinaryImage#MIN_BINARY_VALUE}.
     *
     * @param threshold the threshold value. Must be between 0-255.
     * @return the resulting binary image.
     */
    public BinaryImage getThreshold(int threshold) {
        logger.debug("Getting Threshold: " + threshold);
        IplImage destination = cvCreateImage(this.image.cvSize(), 8, 1);
        cvThreshold(this.image, destination, threshold, BinaryImage.MAX_BINARY_VALUE, CV_THRESH_BINARY);
        return new BinaryImage(destination);
    }

    /**
     * Get an image that has been filtered based on the threshold value. If a
     * pixel is greater than the threshold value, then the result image pixel
     * value will be set to {@link BinaryImage#MIN_BINARY_VALUE}, otherwise the
     * pixel value will be set to {@link BinaryImage#MAX_BINARY_VALUE}.
     *
     * @param threshold the threshold value. Must be between 0-255.
     * @return the resulting binary image.
     */
    public BinaryImage getInvertedThreshold(int threshold) {
        logger.debug("Getting Inverted Threshold: " + threshold);
        IplImage destination = cvCreateImage(this.image.cvSize(), 8, 1);
        cvThreshold(this.image, destination, threshold, BinaryImage.MAX_BINARY_VALUE, CV_THRESH_BINARY_INV);
        return new BinaryImage(destination);
    }

    /**
     * Get an image that has been filtered based on the threshold value. If a
     * pixel is greater than the threshold value, then the result image pixel
     * value will be set to
     * <code>threshold</code>, otherwise the pixel value will be set to pixel
     * value.
     *
     * @param threshold the threshold value. Must be between 0-255.
     * @return the resulting binary image.
     */
    public BinaryImage getTruncatedThreshold(int threshold) {
        logger.debug("Getting Truncated Threshold: " + threshold);
        IplImage destination = cvCreateImage(this.image.cvSize(), 8, 1);
        cvThreshold(this.image, destination, threshold, threshold, CV_THRESH_TRUNC);
        return new BinaryImage(destination);
    }

    /**
     * Get an image that has been filtered based on the threshold value. If a
     * pixel is greater than the threshold value, then the result image pixel
     * value will be set to the pixel value , otherwise the pixel value will be
     * set to {@link BinaryImage#MIN_BINARY_VALUE}.
     *
     * @param threshold the threshold value. Must be between 0-255.
     * @return the resulting binary image.
     */
    public BinaryImage getToZeroThreshold(int threshold) {
        logger.debug("Getting To Zero Threshold: " + threshold);
        IplImage destination = cvCreateImage(this.image.cvSize(), 8, 1);
        cvThreshold(this.image, destination, threshold, threshold, CV_THRESH_TOZERO);
        return new BinaryImage(destination);
    }

    /**
     * Get an image that has been filtered based on the threshold value. If a
     * pixel is greater than the threshold value, then the result image pixel
     * value will be set to {@link BinaryImage#MIN_BINARY_VALUE}, otherwise the
     * pixel value will be set to pixel value.
     *
     * @param threshold the threshold value. Must be between 0-255.
     * @return the resulting binary image.
     */
    public BinaryImage getToZeroInvertedThreshold(int threshold) {
        logger.debug("Getting To Zero Inverted Threshold: " + threshold);
        IplImage destination = cvCreateImage(this.image.cvSize(), 8, 1);
        cvThreshold(this.image, destination, threshold, threshold, CV_THRESH_TOZERO_INV);
        return new BinaryImage(destination);
    }
}
