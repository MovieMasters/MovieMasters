import datastorage.MovieDAO;
import domain.MovieCollection;
import view.*;

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
//        MovieDAO movieDAO = new MovieDAO();
//        MovieCollection mcCollection = movieDAO.getActualMovies();
//        mainFrame.setView(new MovieCollectionView(mcCollection));
        mainFrame.setView(new LoginView());
        mainFrame.setVisible(true);
    }
}
