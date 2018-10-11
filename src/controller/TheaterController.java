package controller;


import datastorage.TheaterDAO;
import domain.Theater;
import view.*;

import java.awt.event.ActionEvent;
import java.util.HashMap;

public class TheaterController extends Controller {
    private TheaterView view;

    public TheaterController(TheaterView view) {
        this.view = view;
        errorMap = new HashMap<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View view;
        switch (e.getActionCommand()) {
            case "Save":
                save();
                break;
            case "Cancel":
                view = MainFrame.getMainFrame().getPreviousView();
                if(view == null)
                {
                    view = new LoginView();
                }
                MainFrame.getMainFrame().setView(view);
                break;
        }
    }

    private void save() {
        if (validateForm()) {
            createTheater();
        }
    }

    private boolean validateForm() {
        resetFormErrors();
        if (view.getTfName().getText().length() < 5) {
            errorMap.put(view.getTfName(), "Naam moet minimaal 5 karakters hebben.");
        }

        if (view.getTfPostcode().getText().length() < 5) {
            errorMap.put(view.getTfPostcode(), "Postcode moet minimaal 5 karakters hebben.");
        }
        setFormErrors();
        return (errorMap.size() == 0);
    }

    private boolean createTheater() {
        TheaterDAO theaterDAO = new TheaterDAO();
        return theaterDAO.create(view.getTfName().getText(),
                view.getTfStreet().getText(),
                Integer.parseInt(view.getTfHouseNr().getText()),
                view.getTfHouseNrAdd().getText(),
                view.getTfPostcode().getText(),
                view.getTfCity().getText(),
                view.getTfProvince().getText(),
                Integer.parseInt(view.getTfPhoneNr().getText()));
    }
}
