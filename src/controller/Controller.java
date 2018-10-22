package controller;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class Controller implements ActionListener {
    HashMap<JTextField, String> errorMap = new HashMap<>();;

    /**
     * Used to show the user which field is invalid.
     *
     * @param field the JTextField to set the invalid border
     */
    private void setTextFieldInvalid(JTextField field) {
        BorderUIResource.LineBorderUIResource border = new BorderUIResource.LineBorderUIResource(Color.RED);
        field.setBorder(border);
    }

    /**
     * Resets the given JTextField to its normal state
     *
     * @param field the JTextField to reset
     */
    private void setTextFieldValid(JTextField field) {
        SwingUtilities.updateComponentTreeUI( field );
    }

    /**
     * Resets all the fields saved in the errorMap to there default state.
     */
    public void resetFormErrors(){
        errorMap.forEach((field, error) -> {
            setTextFieldValid(field);
        });
        errorMap.clear();
    }

    /**
     * For every field in the errorMap the accompanying error wil be shown in a JOptionPane
     */
    public void setFormErrors(){
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
