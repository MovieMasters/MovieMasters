package controller;

import view.MainFrame;
import view.Theater;
import view.ViewName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TheaterController extends Controller {
    private Theater view;

    public TheaterController(Theater view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Save":
                save();
                break;
            case "Cancel":
                MainFrame.getMainFrame().setView(ViewName.LOGIN, true);
                break;
        }
    }

    private void save() {
        if (validateForm()) {

        }
    }

    private boolean validateForm() {
        boolean ret = true;
        HashMap<JTextField, String> errorMap = new HashMap<>();
        view.setTextFieldValid(view.getTfName());
        view.setTextFieldValid(view.getTfStreet());
        view.setTextFieldValid(view.getTfCity());
        view.setTextFieldValid(view.getTfHouseNr());
        view.setTextFieldValid(view.getTfHouseNrAdd());
        view.setTextFieldValid(view.getTfPostcode());
        view.setTextFieldValid(view.getTfProvince());

        //Name field
        if (view.getTfName().getText().length() < 5) {
            errorMap.put(view.getTfName(), "Naam moet minimaal 5 karakters hebben.");
        }

        if (view.getTfPostcode().getText().length() < 5) {
            errorMap.put(view.getTfPostcode(), "Postcode moet minimaal 5 karakters hebben.");
        }

        System.out.println("map size = " + errorMap.size());
        JPanel errorPanel = new JPanel(new GridLayout(errorMap.size(), 1));

        errorMap.forEach((field, error) -> {
            view.setTextFieldInvalid(field);
            errorPanel.add(new JLabel(error));
        });

        JScrollPane scroller = new JScrollPane(errorPanel);
        scroller.setBorder(BorderFactory.createEmptyBorder());
        JOptionPane.showMessageDialog(view, scroller, "Foutmelding", JOptionPane.ERROR_MESSAGE);
        return ret;
    }
}
