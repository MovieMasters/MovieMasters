/**
 * <h1>MovieMaster</h1>
 * <p>The MovieMasters program is an application
 * which provides the ability to purchase tickets for
 * a movie show, shown in MovieMaster theaters</p>
 *
 * @author Justin Remijnse
 * @author Jeroen van der Hel
 * @version 1.0
 * @since 2018-10-21
 */

import datastorage.MovieDAO;
import domain.MovieCollection;
import domain.Show;
import view.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
        //MovieDAO movieDAO = new MovieDAO();
        //MovieCollection mcCollection = movieDAO.getActualMovies();
        //mainFrame.setView(new MovieCollectionView(mcCollection));
        mainFrame.setView(new LoginView());
        mainFrame.setVisible(true);

        //ToDo als er geen shows in de database zijn geen nullpointer geven
    }
}
