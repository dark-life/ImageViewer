package Swing;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    private ActionListenerFactory actionListenerFactory;
    private ImageViewer imageViewer;
    private JLabel label;

    public ApplicationFrame(ActionListenerFactory actionListenerFactory) {
        super("Image Viewer");
        this.actionListenerFactory = actionListenerFactory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1366, 720));
        createComponent();
    }

    public ActionListenerFactory getActionListenerFactory() {
        return actionListenerFactory;
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }

    private void createComponent() {
        this.add(createPanel());
        this.add(createToolBar(), BorderLayout.SOUTH);
    }

    private JPanel createPanel() {
        imageViewer=new ImageViewerPanel();
        return (JPanel) imageViewer;
    }

    private JPanel createToolBar() {
        JPanel toolbar = new JPanel();
        toolbar.add(createPrev(), BorderLayout.SOUTH);
        toolbar.add(createNext(), BorderLayout.SOUTH);
        return toolbar;
    }

    private JButton createPrev() {
        JButton jButton = new JButton("Prev");
        jButton.addActionListener(actionListenerFactory.create("prev") );
        return jButton;
    }

    private JButton createNext() {
        JButton jButton = new JButton("Next");
        jButton.addActionListener(actionListenerFactory.create("next") );
        return jButton;
    }
}