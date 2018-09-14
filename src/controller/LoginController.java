package controller;
import view.Login;
import view.MainFrame;
import view.Register;
import java.awt.event.ActionEvent;

public class LoginController extends Controller {
    private Login loginView;

    public LoginController(Login loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ToDo een constante of enum aanmaken voor case.
        switch (e.getActionCommand())
        {
            case "Register":
                MainFrame.getMainFrame().changeView(new Register());
                break;
            case "Login":
                System.out.println("Login");
                break;
        }
    }
}
