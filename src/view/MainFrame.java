package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainFrame extends JFrame {

    private static MainFrame mainFrame;
    private HashMap<ViewName, View> viewMap;
    private View currentView;

    public MainFrame() {
        setTitle("MovieMasters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        centerFrame();
        setJMenuBar(new MenuBar());
        viewMap = new HashMap();
    }

    public static MainFrame getMainFrame() {
        if (mainFrame == null)
            mainFrame = new MainFrame();
        return mainFrame;
    }

    private void centerFrame() {
        Dimension frameDimension = new Dimension(800, 600);
        setSize(frameDimension);
        setPreferredSize(frameDimension);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = getSize().width;
        int height = getSize().height;
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        setLocation(x, y);
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
}
