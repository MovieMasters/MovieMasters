package view;

import controller.ShowController;
import domain.Movie;
import domain.Show;

import javax.swing.*;
import java.util.ArrayList;

public class ShowView extends View {
    private ArrayList<Show> shows;
    private ShowController showController;
    private Movie movie;

    public ShowView(){
        super();
        this.showController = new ShowController(this);
        this.movie = (Movie) MainFrame.getMainFrame().getModelMap().get("movie");
        this.shows = showController.getShows(movie.getId());
        createGUI();
    }

    private void createGUI() {
        for (Show show : shows){
            JLabel label = new JLabel("ShowId: "+show.getId()+" - "+show.getDate()+" "+show.getTime());
            add(label);

            JButton pickFirst = new JButton("Kies eerste");
            pickFirst.setActionCommand(Integer.toString(show.getId()));
            pickFirst.addActionListener(showController);
        }
    }
}
