package view;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        JMenu menu = new JMenu("Account");
        JMenuItem menuItem = new JMenuItem("Login");
        menu.add(menuItem);
        add(menu);
    }
}
