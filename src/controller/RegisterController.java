package controller;

import datastorage.AccountDAO;
import domain.Account;
import view.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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

    /**
     * When the form is validated then creates the new Account in the database.
     * @return boolean indication whether the creation is successful
     */
    private boolean validateForm() {
        resetFormErrors();

        if (view.getTfusername().getText().isEmpty()) {
            errorMap.put(view.getTfusername(), "Gebruikersnaam is verplicht.");
        } else if (view.getTfusername().getText().length() < 8) {
            errorMap.put(view.getTfusername(), "Gebruikersnaam moet minimaal 8 karakters lang zijn.");
        } else {
            AccountDAO accountDAO = new AccountDAO();
            Account existingAccount = accountDAO.find(view.getTfusername().getText());
            if (existingAccount != null) {
                errorMap.put(view.getTfusername(), "Deze gebruikersnaam bestaat al.");
            }
        }

        if (view.getTfFirstname().getText().isEmpty()) {
            errorMap.put(view.getTfFirstname(), "Voornaam is verplicht.");
        }

        if (view.getTfLastname().getText().isEmpty()) {
            errorMap.put(view.getTfLastname(), "Achternaam is verplicht.");
        }

        if (view.getTfEmailaddress().getText().isEmpty()) {
            errorMap.put(view.getTfEmailaddress(), "E-mailadres is verplicht.");
        }else{
            try{
               InternetAddress internetAddress = new InternetAddress(view.getTfEmailaddress().getText());
               internetAddress.validate();
            }catch(AddressException e){
                errorMap.put(view.getTfEmailaddress(), "E-mailadres is ongeldig.");
            }
        }

        if (view.getPfPassword().getPassword().length < 8) {
            errorMap.put(view.getPfPassword(), "Wachtwoord moet minimaal 8 karakters lang zijn.");
        }

        if (!view.getPfPassword().getPassword().equals(view.getPfVerifyPassword().getPassword())) {
            errorMap.put(view.getPfVerifyPassword(), "Wachtwoorden komen niet overeen");
        }

        setFormErrors();
        return (errorMap.size() == 0);
    }
}
