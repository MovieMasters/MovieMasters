package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class Login extends View {
    private JTextField tfusername;
    private JPasswordField pfPassword;
    private JLabel lblUsername, lblPassword, lblErrorLogin;
    private JButton btnRegister, btnLogin;

    private LoginController loginController;

    public Login() {
        setLayout(new GridBagLayout());
        loginController = new LoginController(this);
        tfusername = new JTextField(30);
        pfPassword = new JPasswordField(30);
        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");
        lblErrorLogin = new JLabel();
        lblErrorLogin.setForeground(Color.RED);
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
        gbc.gridwidth = 2;
        add(tfusername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(pfPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        add(lblErrorLogin, gbc);

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

    public JTextField getTfusername() {
        return tfusername;
    }

    public JPasswordField getPfPassword() {
        return pfPassword;
    }

    public JLabel getLblErrorLogin() {
        return lblErrorLogin;
    }
}
