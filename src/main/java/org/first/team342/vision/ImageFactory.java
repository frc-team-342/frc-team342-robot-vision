/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.vision;

import static com.googlecode.javacv.cpp.opencv_core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author FIRST Team 342
 */
public class ImageFactory {
    private static final Logger logger = LoggerFactory.getLogger(ImageFactory.class);
    
    /**
     * Create a new image.
     *
     * @param image the source image.
     * @return a new {@link Image} instance.
     */
    public static Image createImage(IplImage image) {
        Image newImage = null;
        
        logger.debug("Creating Image.");

        if (image != null) {
            if (image.nChannels() == 1) {
                newImage = new GrayscaleImage(image);
            } else if (image.nChannels() == 3) {
                newImage = new ColorImage(image);
            }
        }

        logger.debug("Created Image: " + newImage);
        
        return newImage;
    }
}
