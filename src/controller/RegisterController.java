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
                view = MainFrame.getMainFrame().getViewMap().get(ViewName.LOGIN);
                if(view == null)
                {
                    view = new LoginView();
                }
                MainFrame.getMainFrame().setView(view);
                break;
        }
    }

    private boolean validateForm() {
        boolean ret = true;
        HashMap<JTextField, String> errorMap = new HashMap<>();
        view.setTextFieldValid(view.getTfusername());
        view.setTextFieldValid(view.getTfEmailaddress());
        view.setTextFieldValid(view.getTfFirstname());
        view.setTextFieldValid(view.getTfMiddleName());
        view.setTextFieldValid(view.getTfLastname());
        view.setTextFieldValid(view.getPfPassword());
        view.setTextFieldValid(view.getPfVerifyPassword());

        if (view.getTfusername().getText().length() < 5) {
            errorMap.put(view.getTfusername(), "Gebruikersnaam moet minimaal 5 karaketers hebben.");
        }

        if (view.getTfFirstname().getText().length() < 5) {
            errorMap.put(view.getTfFirstname(), "Iets fout met voornaam.");
        }

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
