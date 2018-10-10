package controller;

import datastorage.TheaterDAO;
import domain.Theater;
import view.TheaterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.HashMap;

public class TheaterController extends Controller {
    private TheaterView view;

    public TheaterController(TheaterView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Save":
                save();
                break;
            case "Cancel":
//                MainFrame.getMainFrame().setView(ViewName.LOGIN, true);
                break;
        }
    }

    private void save() {
        if (validateForm()) {
            createTheater();
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
        if(errorMap.size() > 0) {
            ret = false;
            JPanel errorPanel = new JPanel(new GridLayout(errorMap.size(), 1));

            errorMap.forEach((field, error) -> {
                view.setTextFieldInvalid(field);
                errorPanel.add(new JLabel(error));
            });

            JScrollPane scroller = new JScrollPane(errorPanel);
            scroller.setBorder(BorderFactory.createEmptyBorder());
            JOptionPane.showMessageDialog(view, scroller, "Foutmelding", JOptionPane.ERROR_MESSAGE);
        }
        return ret;
    }

    private Theater createTheater(){
        Theater theater = null;
        TheaterDAO theaterDAO = new TheaterDAO();
        try{
            theater = theaterDAO.create(view.getTfName().getText(),
                    view.getTfStreet().getText(),
                    Integer.parseInt(view.getTfHouseNr().getText()),
                    view.getTfHouseNrAdd().getText(),
                    view.getTfPostcode().getText(),
                    view.getTfCity().getText(),
                    view.getTfProvince().getText(),
                    Integer.parseInt(view.getTfPhoneNr().getText()));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return theater;
    }
}
