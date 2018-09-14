package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    static MainFrame mainFrame;
    private JPanel currentView;

    public MainFrame() {
        setTitle("MovieMasters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setJMenuBar(new MenuBar());
        setLocationRelativeTo(null);
    }

    public void changeView(JPanel view){
        if(currentView != null)
        {
            getContentPane().remove(currentView);
        }
        getContentPane().add(view);
        pack();
        currentView = view;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        mainFrame = new MainFrame();
        mainFrame.changeView(new Login());
        mainFrame.setVisible(true);
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

    public static MainFrame getMainFrame()
    {
        return mainFrame;
    }
}
