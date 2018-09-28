package view;
import controller.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Register extends View {
    private JTextField tfFirstname, tfLastname, tfusername, tfEmailaddress;
    private JPasswordField pfPassword, pfVerifyPassword;
    private JLabel lblTitle, lblFirstname, lblLastname, lblUsername, lblEmailAddress, lblPassword, lblVerifyPassword, lblErrorFirstname, lblErrorLastname, lblErrorUsername, lblErrorEmail, lblErrorPassword, lblErrorVerifyPassword;
    private JButton btnRegister, btnCancel;
    private ArrayList<JLabel> listErrorLabels;
    private ArrayList<JTextField> listTextFields;

    private RegisterController registerController;
    public Register() {
        setLayout(new GridBagLayout());
        listErrorLabels = new ArrayList<>();
        listTextFields = new ArrayList<>();

        lblTitle = new JLabel("Account aanmaken", JLabel.CENTER);
        tfFirstname = new JTextField(15);
        tfLastname = new JTextField(15);
        tfusername = new JTextField(15);
        tfEmailaddress = new JTextField(15);
        pfPassword = new JPasswordField(15);
        pfVerifyPassword = new JPasswordField(15);

        listTextFields.add(tfFirstname);
        listTextFields.add(tfLastname);
        listTextFields.add(tfusername);
        listTextFields.add(tfEmailaddress);
        listTextFields.add(pfPassword);
        listTextFields.add(pfVerifyPassword);

        lblFirstname = new JLabel("Voornaam");
        lblLastname = new JLabel("Achternaam");
        lblUsername = new JLabel("Gebruikersnaam");
        lblEmailAddress = new JLabel("E-mailadres");
        lblPassword = new JLabel("Wachtwoord");
        lblVerifyPassword = new JLabel("Bevestig wachtwoord");

        lblErrorFirstname = new JLabel();
        lblErrorLastname = new JLabel();
        lblErrorUsername = new JLabel();
        lblErrorEmail = new JLabel();
        lblErrorPassword = new JLabel();
        lblErrorVerifyPassword = new JLabel();

        listErrorLabels.add(lblErrorFirstname);
        listErrorLabels.add(lblErrorLastname);
        listErrorLabels.add(lblErrorUsername);
        listErrorLabels.add(lblErrorEmail);
        listErrorLabels.add(lblErrorPassword);
        listErrorLabels.add(lblErrorVerifyPassword);

        for (JLabel label : listErrorLabels) {
            label.setForeground(Color.red);
        }

        btnRegister = new JButton("Registreren");
        btnRegister.setActionCommand("Register");
        btnCancel = new JButton("Annuleren");
        btnCancel.setActionCommand("Cancel");

        registerController = new RegisterController(this);
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
        gbc.insets = new Insets(5, 10, 5, 10);

        //Row 1 ---- contains input labels and fields
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        pnlRegisterFields.add(lblFirstname, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(tfFirstname, gbc);

        gbc.gridx = 2;
        pnlRegisterFields.add(lblLastname, gbc);

        gbc.gridx = 3;
        pnlRegisterFields.add(tfLastname, gbc);

        //Row 2 ---- contains error labels
        //Error labels have the gridwith of 2, so it has the length of the label and the textfield
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        gbc.gridx = 0;
        pnlRegisterFields.add(lblErrorFirstname, gbc);

        gbc.gridx = 3;
        pnlRegisterFields.add(lblErrorLastname, gbc);

        //Row 3 ---- contains input labels and fields
        gbc.gridwidth = 1;
        gbc.gridy = 2;

        gbc.gridx = 0;
        pnlRegisterFields.add(lblUsername, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(tfusername, gbc);

        gbc.gridx = 2;
        pnlRegisterFields.add(lblEmailAddress, gbc);

        gbc.gridx = 3;
        pnlRegisterFields.add(tfEmailaddress, gbc);

        //Row 4 ---- contains error labels
        //Error labels have the gridwith of 2, so it has the length of the label and the textfield
        gbc.gridwidth = 2;
        gbc.gridy = 3;

        gbc.gridx = 0;
        pnlRegisterFields.add(lblErrorUsername, gbc);

        gbc.gridx = 3;
        pnlRegisterFields.add(lblErrorEmail, gbc);

        //Row 5 ---- contains input labels and fields
        gbc.gridwidth = 1;
        gbc.gridy = 4;

        gbc.gridx = 0;
        pnlRegisterFields.add(lblPassword, gbc);

        gbc.gridx = 1;
        pnlRegisterFields.add(pfPassword, gbc);

        gbc.gridx = 2;
        pnlRegisterFields.add(lblVerifyPassword, gbc);

        gbc.gridx = 3;
        pnlRegisterFields.add(pfVerifyPassword, gbc);

        //Row 6 ---- contains error labels
        //Error labels have the gridwith of 2, so it has the length of the label and the textfield
        gbc.gridwidth = 2;
        gbc.gridy = 5;

        gbc.gridx = 0;
        pnlRegisterFields.add(lblErrorPassword, gbc);

        gbc.gridx = 3;
        pnlRegisterFields.add(lblErrorVerifyPassword, gbc);

        pnlButtons.add(btnRegister);
        pnlButtons.add(btnCancel);
    }

    public void resetErrors() {
        for (JLabel label : listErrorLabels) {
            label.setText("");
            label.setVisible(false);
        }
        for (JTextField field : listTextFields) {
            field.setBorder(BorderFactory.createLineBorder(Color.black));
        }
    }

    public JTextField getTfFirstname() {
        return tfFirstname;
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

    public JLabel getLblErrorFirstname() {
        return lblErrorFirstname;
    }

    public JLabel getLblErrorLastname() {
        return lblErrorLastname;
    }

    public JLabel getLblErrorUsername() {
        return lblErrorUsername;
    }

    public JLabel getLblErrorEmail() {
        return lblErrorEmail;
    }

    public JLabel getLblErrorPassword() {
        return lblErrorPassword;
    }

    public JLabel getLblErrorVerifyPassword() {
        return lblErrorVerifyPassword;
    }

    public ArrayList<JLabel> getListErrorLabels() {
        return listErrorLabels;
    }

    public ArrayList<JTextField> getListTextFields() {
        return listTextFields;
    }
}
