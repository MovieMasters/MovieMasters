package controller;

import view.*;

import java.awt.event.ActionEvent;

public class RegisterController extends Controller {
    private RegisterView view;

    public RegisterController(RegisterView view) {
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
            case "Register":
                validateForm();
                break;
            case "Cancel":
                view = MainFrame.getMainFrame().getPreviousView();
                if(view == null)
                {
                    view = new LoginView();
                }
                MainFrame.getMainFrame().setTitle("MovieMasters - Inloggen");
                MainFrame.getMainFrame().setView(view);
                break;
        }
    }


    private boolean validateForm() {
        resetFormErrors();

        if (view.getTfusername().getText().length() < 5) {
            errorMap.put(view.getTfusername(), "Gebruikersnaam moet minimaal 5");
        }

        if (view.getTfFirstname().getText().length() < 5) {
            errorMap.put(view.getTfFirstname(), "Iets fout met voornaam.");
        }

        setFormErrors();
        return (errorMap.size() == 0);
    }
}
