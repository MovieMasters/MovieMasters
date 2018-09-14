package view;
import controller.RegisterController;

import javax.swing.*;
import java.awt.*;

public class Register extends JPanel {
    private JTextField tfFirstname, tfLastname, tfusername, tfEmailaddress;
    private JPasswordField pfPassword, pfVerifyPassword;
    private JLabel lblTitle, lblFirstname, lblLastname, lblUsername, lblEmailAddress, lblPassword, lblVerifyPassword;
    private JButton btnRegister, btnCancel;

    private RegisterController registerController;
    public Register() {
        super();
        setLayout(new GridBagLayout());

        tfFirstname = new JTextField(15);
        tfLastname = new JTextField(15);
        tfusername = new JTextField(15);
        tfEmailaddress = new JTextField(15);

        pfPassword = new JPasswordField(15);
        pfVerifyPassword = new JPasswordField(15);

        lblTitle = new JLabel("Create account");
        lblFirstname = new JLabel("Firstname");
        lblLastname = new JLabel("Lastname");
        lblUsername = new JLabel("Username");
        lblEmailAddress = new JLabel("E-mailaddress");
        lblPassword = new JLabel("Password");
        lblVerifyPassword = new JLabel("Verify password");

        btnRegister = new JButton("Register");
        btnCancel = new JButton("Cancel");

        registerController = new RegisterController(this);
        btnRegister.addActionListener(registerController);
        btnCancel.addActionListener(registerController);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        //Row 1
        gbc.gridy = 0;

        gbc.gridx = 0;
        add(lblFirstname, gbc);

        gbc.gridx = 1;
        add(tfFirstname, gbc);

        gbc.gridx = 2;
        add(lblLastname, gbc);

        gbc.gridx = 3;
        add(tfLastname, gbc);

        //Row 2
        gbc.gridy = 8;

        gbc.gridx = 0;
        add(lblUsername, gbc);

        gbc.gridx = 1;
        add(tfusername, gbc);

        gbc.gridx = 2;
        add(lblEmailAddress, gbc);

        gbc.gridx = 3;
        add(tfEmailaddress, gbc);

//        //Row 3
        gbc.gridy = 9;

        gbc.gridx = 0;
        add(lblPassword, gbc);

        gbc.gridx = 1;
        add(pfPassword, gbc);

        gbc.gridx = 2;
        add(lblVerifyPassword, gbc);

        gbc.gridx = 3;
        add(pfVerifyPassword, gbc);

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(60);
        JPanel buttonPanel = new JPanel(flowLayout);
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnCancel);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 4;
        add(buttonPanel, gbc);
    }
}
