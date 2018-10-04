package view;

import businnesslogic.AManager;
import businnesslogic.Manager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public abstract class View extends JPanel {
    public void setTextFieldInvalid(JTextField field) {
        field.setBorder(BorderFactory.createDashedBorder(Color.RED));
    }

    public void setTextFieldValid(JTextField field) {
        field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void resetErrorLabel(JLabel label) {
        label.setText("");
        label.setVisible(false);
    }

    public void showErrorLabel(JLabel label, String text) {
        label.setText(text);
        label.setVisible(true);
    }
}
