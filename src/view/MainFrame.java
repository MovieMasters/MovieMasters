package view;

import domain.Model;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainFrame extends JFrame {

    private static MainFrame mainFrame;
    private final HashMap<ViewName, View> viewMap;
    private final HashMap<String, Model> modelMap;
    private View currentView, previousView;

    public MainFrame() {
        setTitle("MovieMasters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        initFrame();
        setJMenuBar(new MenuBar());
        viewMap = new HashMap();
        modelMap = new HashMap<>();
    }

    public static MainFrame getMainFrame() {
        if (mainFrame == null)
            mainFrame = new MainFrame();
        return mainFrame;
    }

    private void initFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameDimension = new Dimension(800, 600);
        setSize(frameDimension);
        setPreferredSize(frameDimension);
        int width = getSize().width;
        int height = getSize().height;
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        setLocation(x, y);
    }

    public void setView(View view) {
        if (currentView != null) {
            getContentPane().remove(currentView);
        }
        getContentPane().add(view);
        repaint();
        pack();
        previousView = currentView;
        currentView = view;
        viewMap.put(view.getViewName(), view);
    }

    public HashMap<ViewName, View> getViewMap() {
        return viewMap;
    }

    public View getPreviousView() {
        return previousView;
    }

    public HashMap<String, Model> getModelMap() {
        return modelMap;
    }

    public void addModel(String string, Model model){
        modelMap.put(string, model);
    }
}
