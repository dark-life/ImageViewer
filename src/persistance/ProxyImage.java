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
import Model.BitMap;
import Model.Image;
import Model.RealImage;

public class ProxyImage extends Image {

    private ImageLoader imageLoader;
    private RealImage realImage;

    public ProxyImage(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @Override
    public BitMap getBitMap() {
        checkLoader();
        return realImage.getBitMap();
    }

    private void checkLoader() {
        if (realImage!= null)return;
        realImage=imageLoader.load();
    }
}
