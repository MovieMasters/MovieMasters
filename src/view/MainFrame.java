package view;

import businessLogic.IManager;
import businessLogic.Manager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainFrame extends JFrame {

    private static MainFrame mainFrame;
    private final HashMap<ViewName, View> viewMap;
    private final HashMap<Manager, IManager> managersMap;
    private View currentView;

    public MainFrame() {
        setTitle("MovieMasters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initFrame();
        setJMenuBar(new MenuBar());
        viewMap = new HashMap();
        managersMap = new HashMap<>();
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

    public void setView(ViewName viewName, boolean useCached) {
        View view = null;
        if (useCached && viewMap.containsKey(viewName)) {
            view = viewMap.get(viewName);
        }

        if (view == null) {
            switch (viewName) {
                case LOGIN:
                    view = new Login();
                    break;
                case REGISTER:
                    view = new Register();
                    break;
                case THEATER:
                    view = new Theater();
                    break;
                case MOVIECOLLECTION:
                    view = new MovieCollection();
                    break;
            }
            viewMap.put(viewName, view);
        }

        if (currentView != null) {
            getContentPane().remove(currentView);
        }
        getContentPane().add(view);
        repaint();
        pack();
        currentView = view;
    }

    public HashMap<Manager, IManager> getManagersMap() {
        return managersMap;
    }
}
