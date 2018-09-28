package view;

import model.Model;
import model.Room;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame mainFrame;
    private View currentView;

    public MainFrame() {
        setTitle("MovieMasters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        centerFrame();
        setJMenuBar(new MenuBar());
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        mainFrame = getMainFrame();
        mainFrame.setView(new Login());
        mainFrame.setVisible(true);
    }

    public static MainFrame getMainFrame() {
        if (mainFrame == null)
            mainFrame = new MainFrame();
        return mainFrame;
    }

    private void centerFrame() {
        Dimension frameDimension = new Dimension(800, 600);
        setSize(frameDimension);
        setPreferredSize(frameDimension);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = getSize().width;
        int height = getSize().height;
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        setLocation(x, y);
    }

    public static void main(String[] args) {
        /*
        Schedule a job for the event-dispatching thread:
        creating and showing this application's GUI.
        */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public void setView(View view) {
        if (currentView != null) {
            getContentPane().remove(currentView);
        }
        getContentPane().add(view);
        pack();
        currentView = view;
    }
}
