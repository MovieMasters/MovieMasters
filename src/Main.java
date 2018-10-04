import businnesslogic.AccountManager;
import businnesslogic.IManager;
import businnesslogic.Manager;
import businnesslogic.TheaterManager;
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
        managersMap.put(Manager.Account, new AccountManager());
        managersMap.put(Manager.THEATER, new TheaterManager());
        mainFrame.setView(ViewName.THEATER, false);
        mainFrame.setVisible(true);
    }
}
