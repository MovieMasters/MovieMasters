package view;

import businessLogic.IManager;
import businessLogic.Manager;
import controller.MovieCollectionController;
import controller.MovieController;
import domain.Movie;
import domain.MovieCollection;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainFrame extends JFrame {

    private static MainFrame mainFrame;
    private final HashMap<ViewName, View> viewMap;
    private View currentView;

    public MainFrame() {
        setTitle("MovieMasters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initFrame();
        setJMenuBar(new MenuBar());
        viewMap = new HashMap();
    }

    public static MainFrame getMainFrame() {
        if (mainFrame == null)
            mainFrame = new MainFrame();
        return mainFrame;
    }

    private void initFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = getSize().width;
        int height = getSize().height;
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        setLocation(x, y);
        Dimension frameDimension = new Dimension(800, 600);
        setSize(frameDimension);
        setPreferredSize(frameDimension);
    }

    public void setView(View view) {
        if (currentView != null) {
            getContentPane().remove(currentView);
        }
        getContentPane().add(view);
        repaint();
        pack();
        currentView = view;
        viewMap.put(view.getViewName(), view);
    }

    public HashMap<ViewName, View> getViewMap() {
        return viewMap;
    }
}
