package org.first.team342.vision;

/**
 *
 * @author FIRST Team 342
 */
public class UsbCamera implements Camera {

    @Override
    public void connect() {
    }
    
    @Override
    public synchronized Image getImage() {
        return null;
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
