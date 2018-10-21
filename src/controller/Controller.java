package controller;

import view.MainFrame;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class Controller implements ActionListener {
    HashMap<JTextField, String> errorMap;

    Controller(){
        errorMap = new HashMap<>();
    }

    private void setTextFieldInvalid(JTextField field) {
        BorderUIResource.LineBorderUIResource border = new BorderUIResource.LineBorderUIResource(Color.RED);
        field.setBorder(border);
    }

    private void setTextFieldValid(JTextField field) {
        SwingUtilities.updateComponentTreeUI( field );
    }

    void resetFormErrors(){
        errorMap.forEach((field, error) -> {
            setTextFieldValid(field);
        });
        errorMap.clear();
    }

    void setFormErrors(){
        if (errorMap.size() > 0) {
            JPanel errorPanel = new JPanel(new GridLayout(errorMap.size(), 1));

            errorMap.forEach((field, error) -> {
                setTextFieldInvalid(field);
                errorPanel.add(new JLabel(error));
            });

            JScrollPane scroller = new JScrollPane(errorPanel);
            scroller.setBorder(BorderFactory.createEmptyBorder());
            JOptionPane.showMessageDialog(null, scroller, "Foutmelding", JOptionPane.ERROR_MESSAGE);
        }
    }

}
