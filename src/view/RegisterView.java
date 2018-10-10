package view;

import com.mysql.cj.xdevapi.Column;
import controller.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegisterView extends View {
    private JTextField tfFirstname, tfMiddleName, tfLastname, tfusername, tfEmailaddress;
    private JPasswordField pfPassword, pfVerifyPassword;
    private JLabel lblTitle, lblMiddleName, lblFirstname, lblLastname, lblUsername, lblEmailAddress, lblPassword, lblVerifyPassword;
    private JButton btnRegister, btnCancel;

    public RegisterView() {
        viewName = ViewName.REGISTER;
        setLayout(new GridBagLayout());
        lblTitle = new JLabel("Account aanmaken", JLabel.CENTER);

        tfusername = new JTextField(15);
        tfEmailaddress = new JTextField(15);
        tfFirstname = new JTextField(15);
        tfMiddleName = new JTextField(15);
        tfLastname = new JTextField(15);
        pfPassword = new JPasswordField(15);
        pfVerifyPassword = new JPasswordField(15);

        lblFirstname = new JLabel("Voornaam");
        lblMiddleName = new JLabel("Tussenvoegsel");
        lblLastname = new JLabel("Achternaam");
        lblUsername = new JLabel("Gebruikersnaam");
        lblEmailAddress = new JLabel("E-mailadres");
        lblPassword = new JLabel("Wachtwoord");
        lblVerifyPassword = new JLabel("Bevestig wachtwoord");

        btnRegister = new JButton("Registreren");
        btnRegister.setActionCommand("Register");
        btnCancel = new JButton("Annuleren");
        btnCancel.setActionCommand("Cancel");

        RegisterController registerController = new RegisterController(this);
        btnRegister.addActionListener(registerController);
        btnCancel.addActionListener(registerController);

        //3 panels to divide the screen into 3 rows
        JPanel pnlTitle = new JPanel(new BorderLayout());
        JPanel pnlRegisterFields = new JPanel(new GridBagLayout());
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 0));

        pnlTitle.add(lblTitle, BorderLayout.CENTER);

        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(pnlTitle, gbc);

        gbc.gridy = 1;
        add(pnlRegisterFields, gbc);

        gbc.gridy = 2;
        add(pnlButtons, gbc);

        //---------------------- Panel met input velden ----------------------
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 10, 4, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;

        //Row 1 username
        gbc.gridy = 0;
        gbc.gridx = 0;
        pnlRegisterFields.add(lblUsername, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(tfusername, gbc);

        //Row 2 email
        gbc.gridy = 1;
        gbc.gridx = 0;
        pnlRegisterFields.add(lblEmailAddress, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(tfEmailaddress, gbc);

        //Row 3 firstname
        gbc.gridy = 2;
        gbc.gridx = 0;
        pnlRegisterFields.add(lblFirstname, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(tfFirstname, gbc);

        //Row 4 middlename
        gbc.gridy = 3;
        gbc.gridx = 0;
        pnlRegisterFields.add(lblMiddleName, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(tfMiddleName, gbc);

        //Row 5 lastname
        gbc.gridy = 4;
        gbc.gridx = 0;
        pnlRegisterFields.add(lblLastname, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(tfLastname, gbc);

        //Row 6 password
        gbc.gridy = 5;
        gbc.gridx = 0;
        pnlRegisterFields.add(lblPassword, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(pfPassword, gbc);

        //Row 7 verify password
        gbc.gridy = 6;
        gbc.gridx = 0;
        pnlRegisterFields.add(lblVerifyPassword, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(pfVerifyPassword, gbc);

        pnlButtons.add(btnRegister);
        pnlButtons.add(btnCancel);
    }

    public JTextField getTfFirstname() {
        return tfFirstname;
    }

    public JTextField getTfLastname() {
        return tfLastname;
    }

    public JTextField getTfusername() {
        return tfusername;
    }

    public JTextField getTfEmailaddress() {
        return tfEmailaddress;
    }

    public JPasswordField getPfPassword() {
        return pfPassword;
    }

    public JPasswordField getPfVerifyPassword() {
        return pfVerifyPassword;
    }

    public JTextField getTfMiddleName() {
        return tfMiddleName;
    }
}
