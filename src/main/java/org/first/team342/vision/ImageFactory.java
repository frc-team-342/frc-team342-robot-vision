/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.vision;

import static com.googlecode.javacv.cpp.opencv_core.*;

/**
 *
 * @author FIRST Team 342
 */
public class ImageFactory {
    
    /**
     * Create a new image.
     * @param image the source image.
     * @return a new {@link Image} instance.
     */
    public static Image createImage(IplImage image) {
        Image newImage = null;
        
        if (image != null) {
            if (image.nChannels() == 1) {
                newImage = new GrayscaleImage(image);
            } else if (image.nChannels() == 3) {
                newImage = new ColorImage(image);
            }
        }
        
        return newImage;
    }
}
