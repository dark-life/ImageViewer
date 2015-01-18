/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import Model.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import persistance.SwingBitMap;

/**
 *
 * @author HP
 */
public class ImageViewerPanel extends JPanel implements ImageViewer {

    private Image image;
    private int initialX;
    private int offset;
  

    public ImageViewerPanel() {
        offset = 0;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image2) {
        image = image2;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            return;
        }
        super.paint(graphics);
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        if (image.getBitMap() instanceof SwingBitMap) {
            graphics.drawImage(getBufferedImage((SwingBitMap) image.getBitMap()), offset, 0, null);
            putImage(graphics);
        }

    }

    private java.awt.Image getBufferedImage(SwingBitMap swingBitmap) {
        return swingBitmap.getBufferdImage();
    }

    private void putImage(Graphics graphics) {
        if (offset == 0) {
            return;
        }
        if (offset < 0) {
            graphics.drawImage(getBufferedImage((SwingBitMap) image.getNext().getBitMap()), 
                                                (int) (image.getBitMap().getWidth()+ offset), 
                                                0, null);
        } else {
            graphics.drawImage(getBufferedImage((SwingBitMap) image.getPrev().getBitMap()), 
                              (int) (offset-image.getBitMap().getWidth()), 
                               0, null);
        }
    }
}
