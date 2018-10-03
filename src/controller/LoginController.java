package controller;

import businnesslogic.AccountManager;
import domain.Account;
import view.Login;
import view.MainFrame;
import view.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginController extends Controller {
    private Login loginView;

    public LoginController(Login loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Register":
                MainFrame.getMainFrame().setView(new Register());
                break;
            case "Login":
                AccountManager accountManager = new AccountManager();
                Account account = accountManager.login(loginView.getTfusername().getText(), loginView.getPfPassword().getPassword());

                if (account != null) {
                    JOptionPane.showMessageDialog(MainFrame.getMainFrame(),
                            "Login geslaagd!, welkom " + account.getFirstName() + " " + account.getLastName(), "Berichtje", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MainFrame.getMainFrame(),
                            "Faalhaas, deze gegevens zijn onjuist", "Fout!", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
    }
}
