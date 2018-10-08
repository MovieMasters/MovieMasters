import businessLogic.*;
import view.MainFrame;
import view.ViewName;

import javax.swing.*;
import java.util.HashMap;

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
        HashMap managersMap = mainFrame.getManagersMap();
//        managersMap.put(Manager.ACCOUNT, new AccountManager());
//        managersMap.put(Manager.THEATER, new TheaterManager());
//        managersMap.put(Manager.MOVIE, new MovieManager());
        mainFrame.setView(ViewName.MOVIECOLLECTION, false);
        mainFrame.setVisible(true);
    }
}
