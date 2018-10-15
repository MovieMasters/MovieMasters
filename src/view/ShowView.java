package view;

import controller.ShowController;
import domain.Movie;
import domain.Show;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ShowView extends View {
    private ShowController showController;
    private Movie movie;

    public ShowView(){
        super();
        this.showController = new ShowController(this);
        createGUI();
    }

    private void createGUI() {
        Movie movie = showController.getMovie();

        for (Show show : showController.getShows(movie.getId()).values()){
            JLabel label = new JLabel("ShowId: "+show.getId()+" - "+convertDateToString(show.getDate())+" "+show.getTime());
            add(label);

            JButton pickFirst = new JButton("Kies eerste");
            pickFirst.setActionCommand(Integer.toString(show.getId()));
            pickFirst.addActionListener(showController);
            add(pickFirst);
        }
    }
}
