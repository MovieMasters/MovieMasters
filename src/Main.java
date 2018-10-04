import businnesslogic.AManager;
import businnesslogic.AccountManager;
import businnesslogic.Manager;
import view.Login;
import view.MainFrame;
import view.View;
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

        HashMap<Manager, AManager> managersMap = new HashMap<>();
        managersMap.put(Manager.Account, new AccountManager());
        AManager.setManagersMap(managersMap);

        MainFrame mainFrame = MainFrame.getMainFrame();
        mainFrame.setView(ViewName.LOGIN, false);
        mainFrame.setVisible(true);
    }
}
