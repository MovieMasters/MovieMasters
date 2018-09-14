package controller;

import view.Login;
import view.MainFrame;
import view.Register;

import java.awt.event.ActionEvent;

public class RegisterController extends Controller {
    private Register registerView;

    public RegisterController(Register registerView) {
        this.registerView = registerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ToDo een constante of enum aanmaken voor case.
        switch (e.getActionCommand())
        {
            case "Register":

                break;
            case "Cancel":
                MainFrame.getMainFrame().changeView(new Login());
                break;
        }
    }
}
