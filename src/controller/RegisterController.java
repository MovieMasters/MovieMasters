package controller;

import view.*;
import java.awt.event.ActionEvent;

public class RegisterController extends Controller {
    private Register registerView;

    public RegisterController(Register registerView) {
        this.registerView = registerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Register":
                validateRegistration();
                break;
            case "Cancel":
//                MainFrame.getMainFrame().setView(ViewName.LOGIN, true);
                break;
        }
    }

    private boolean validateRegistration() {
        boolean ret = true;
//        if (registerView.getPfPassword().get) {
//            registerView.showErrorLabel(registerView.getLblErrorFirstname(), "");
//            ret = false;
//        }
//        if (ret) {
//            registerView.resetErrors();
//        }
        return ret;
    }
}
