package org.first.team342.vision;

import static com.googlecode.javacv.cpp.opencv_core.*;

/**
 * This class represents a simple black and white image.
 * 
 * @author FIRST Team 342
 */
public class BinaryImage extends Image {
    
    /**
     * Constant for the minimum pixel value of the binary image.
     */
    public static final int MIN_BINARY_VALUE = 0;
    
    /**
     * Constant for the maximum pixel value of the binary image.
     */
    public static final int MAX_BINARY_VALUE = 255;
    
    /**
     * Create a new instance.<br>
     * <br>
     * <strong>Note:</strong> The <code>image</code> should be a grayscale image,
     * in other words it must have only 1 color channel.
     * 
     * @param image the core image.
     */
    public BinaryImage(IplImage image) {
        super(image);
    }
    
    /**
     * Invert the colors of the image.  The pixels that are currently white will
     * be turned black and the white pixels will be turned black.
     */
    public void invert() {
        cvInv(this.image, this.image);
    }
}
