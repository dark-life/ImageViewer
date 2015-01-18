/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Control.DictionaryCommand;
import Control.NextImageCommand;
import Control.PrevImageCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Model.Image;
import persistance.ImageLoaderFileList;
import Swing.ActionListenerFactory;
import Swing.ApplicationFrame;


/**
 *
 * @author HP
 */
public class Application {
 static  final String Path="C:\\Users\\HP\\Desktop\\NK\\Imagenes";
    public static void main(String[] args) {
        new Application().execute();
    }

    private void execute() {
        final DictionaryCommand commandSet = new DictionaryCommand();
        ImageLoaderFileList imageLoaderFileList=new ImageLoaderFileList(Path);
        List<Image>list = imageLoaderFileList.load();
        ActionListenerFactory actionListenerFactory = new ActionListenerFactory() {
            @Override
            public ActionListener create(final String name) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        commandSet.get(name).execute();
                    }
                };
            }
        };
        ApplicationFrame frame=new ApplicationFrame(actionListenerFactory);
        frame.getImageViewer().setImage(list.get(0));
        commandSet.put("next", new NextImageCommand(frame.getImageViewer()));
        commandSet.put("prev", new PrevImageCommand(frame.getImageViewer()));
        frame.setVisible(true);
    }
}
