package controller;


import datastorage.TheaterDAO;
import view.*;

import java.awt.event.ActionEvent;

public class TheaterController extends Controller {
    private TheaterView view;

    public TheaterController(TheaterView view) {
        super();
        this.view = view;
    }

    /**
     * Executed on action event for components that are registered on the corresponding view
     *
     * @param e the ActionEvent created when user click on the component
     */
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

    /**
     * When the form is validated then creates the new theater in the database.
     */
    private void save() {
        if (validateForm()) {
            createTheater();
        }
    }

    /**
     * Validates the form fields
     *
     * @return boolean true when the form is valid, false otherwise
     */
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

    /**
     * When the form is validated then creates the new Theater in the database.
     * @return boolean indication whether the creation is successful
     */
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
