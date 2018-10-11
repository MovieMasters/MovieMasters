package controller;

import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class RegisterController extends Controller {
    private RegisterView view;

    public RegisterController(RegisterView view) {
        this.view = view;
    }

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
                MainFrame.getMainFrame().setView(view);
                break;
        }
    }

    private boolean validateForm() {
        resetFormErrors();

        if (view.getTfusername().getText().length() < 5) {
            errorMap.put(view.getTfusername(), "Gebruikersnaam moet minimaal 5 karaketers hebben.");
        }

        if (view.getTfFirstname().getText().length() < 5) {
            errorMap.put(view.getTfFirstname(), "Iets fout met voornaam.");
        }

        setFormErrors();
        return (errorMap.size() == 0);
    }
}
