package org.first.team342.vision;

import static com.googlecode.javacv.cpp.opencv_core.*;

/**
 *
 * @author FIRST Team 342
 */
public class ColorImage extends Image {
    
    public static final int RED_CHANNEL = 0;
    public static final int GREEN_CHANNEL = 1;
    public static final int BLUE_CHANNEL = 2;
    
    public ColorImage(IplImage image) {
        super(image);
    }
    
    public GrayscaleImage[] getRGBChannels() {
       IplImage red = IplImage.create(this.image.cvSize(), 8, 1);
       IplImage green = IplImage.create(this.image.cvSize(), 8, 1);
       IplImage blue = IplImage.create(this.image.cvSize(), 8, 1);
    
        cvSplit(this.image, blue, green, red, null); 
        
        GrayscaleImage[] channels = new GrayscaleImage[] {
            new GrayscaleImage(red), 
            new GrayscaleImage(green),
            new GrayscaleImage(blue)};
        
        return channels;
    }
}
