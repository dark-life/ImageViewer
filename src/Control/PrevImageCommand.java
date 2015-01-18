/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author HP
 */
import Swing.ImageViewer;

public class PrevImageCommand implements Command {
    ImageViewer imageViewer;

    public PrevImageCommand(ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
    }

    @Override
    public void execute() {
    imageViewer.setImage(imageViewer.getImage().getPrev());
    }
}
