/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

/**
 *
 * @author HP
 */
import java.awt.image.BufferedImage;
import Model.BitMap;

public class SwingBitMap implements BitMap {

    BufferedImage bufferdImage;

    public SwingBitMap(BufferedImage bufferdImage) {
        this.bufferdImage = bufferdImage;
    }

    public BufferedImage getBufferdImage() {
        return bufferdImage;
    }
    
    @Override
    public double getWidth() {
        return bufferdImage.getWidth();
    }

    @Override
    public double getHeight() {
        return bufferdImage.getHeight();
    }
}
