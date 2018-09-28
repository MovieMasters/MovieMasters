package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class Login extends View {
    private JTextField tfusername;
    private JPasswordField pfPassword;
    private JLabel lblUsername, lblPassword;
    private JButton btnRegister, btnLogin;

    private LoginController loginController;

    public Login() {
        super();
        setLayout(new GridBagLayout());

        loginController = new LoginController();
        tfusername = new JTextField(30);
        pfPassword = new JPasswordField(30);
        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");
        btnRegister = new JButton("Register");
        btnLogin = new JButton("Login");

        btnRegister.addActionListener(loginController);
        btnLogin.addActionListener(loginController);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        add(lblUsername, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(tfusername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(pfPassword, gbc);

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(60);
        JPanel buttonPanel = new JPanel(flowLayout);
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnLogin);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add(buttonPanel, gbc);
    }
}
