package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends View {
    private JTextField tfusername;
    private JPasswordField pfPassword;
    private JLabel lblUsername, lblPassword;
    private JButton btnRegister, btnLogin;

    public LoginView() {
        viewName = ViewName.LOGIN;
        setLayout(new GridBagLayout());
        tfusername = new JTextField(30);
        pfPassword = new JPasswordField(30);
        lblUsername = new JLabel("Gebruikersnaam");
        lblPassword = new JLabel("Wachtwoord");
        btnRegister = new JButton("Registreren");
        btnLogin = new JButton("Login");

        btnRegister.setActionCommand("Register");
        btnLogin.setActionCommand("Login");

        LoginController loginController = new LoginController(this);
        btnRegister.addActionListener(loginController);
        btnLogin.addActionListener(loginController);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;

        add(lblUsername, gbc);

        gbc.gridy = 1;
        add(tfusername, gbc);

        gbc.gridy = 2;
        add(lblPassword, gbc);

        gbc.gridy = 3;
        add(pfPassword, gbc);

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(60);
        JPanel buttonPanel = new JPanel(flowLayout);
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnLogin);
        gbc.gridy = 4;
        add(buttonPanel, gbc);
    }

    public JTextField getTfusername() {
        return tfusername;
    }

    public JPasswordField getPfPassword() {
        return pfPassword;
    }
}
