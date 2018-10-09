import view.LoginView;
import view.MainFrame;

import javax.swing.*;

public class Main {

    private Main() {
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

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        MainFrame mainFrame = MainFrame.getMainFrame();
        mainFrame.setView(new LoginView());
        mainFrame.setVisible(true);
    }
}
