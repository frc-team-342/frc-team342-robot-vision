package org.first.team342.vision;

/**
 * Interface for all robot vision cameras.
 *
 * @author FIRST Team 342
 */
public interface Camera {
    
    /**
     * Initialize the connection to the camera.
     */
    public abstract void connect();
    
    /**
     * Get the current image from the camera.
     * @return the current image.
     */
    public Image getImage();
}
