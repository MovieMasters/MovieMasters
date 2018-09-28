package controller;
import view.MainFrame;
import view.Register;
import java.awt.event.ActionEvent;

public class LoginController extends Controller {

    public LoginController() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ToDo een constante of enum aanmaken voor case.
        switch (e.getActionCommand())
        {
            case "Register":
//                MainFrame.getMainFrame().changeView(new Register());
                MainFrame.getMainFrame().setView(new Register());
                break;
            case "Login":
                System.out.println("Login");
                break;
        }
    }
}
