package view;

import controller.RegisterController;
import controller.TheaterController;

import javax.swing.*;
import java.awt.*;

public class Theater extends View {
    private JTextField tfName, tfStreet, tfHouseNr, tfHouseNrAdd, tfPostcode, tfCity, tfProvince, tfPhoneNr;
    private JLabel lblTitle, lblName, lblStreet, lblHouseNr, lblHouseNrAdd, lblPostcode, lblCity, lblProvince, lblPhoneNr;
    private JButton btnSave, btnCancel;

    private TheaterController theaterController;

    public Theater() {
        setLayout(new GridBagLayout());
        lblTitle = new JLabel("Theater aanmaken", JLabel.CENTER);
        tfName = new JTextField(12);
        tfStreet = new JTextField(12);
        tfHouseNr = new JTextField(12);
        tfHouseNrAdd = new JTextField(12);
        tfPostcode = new JTextField(12);
        tfCity = new JTextField(12);
        tfProvince = new JTextField(12);
        tfPhoneNr = new JTextField(12);

        lblName = new JLabel("Naam");
        lblStreet = new JLabel("Straat");
        lblHouseNr = new JLabel("Huisnummer");
        lblHouseNrAdd = new JLabel("Toevoeging");
        lblPostcode = new JLabel("Postcode");
        lblCity = new JLabel("Plaatsnaam");
        lblProvince = new JLabel("Provincie");
        lblPhoneNr = new JLabel("Telefoonnummer");

        btnSave = new JButton("Opslaan");
        btnSave.setActionCommand("Save");
        btnCancel = new JButton("Annuleren");
        btnCancel.setActionCommand("Cancel");

        theaterController = new TheaterController(this);
        btnSave.addActionListener(theaterController);
        btnCancel.addActionListener(theaterController);

        //3 panels to divide the screen into 3 rows
        JPanel pnlTitle = new JPanel(new BorderLayout());
        JPanel pnlForm = new JPanel(new GridBagLayout());
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
        add(pnlForm, gbc);

        gbc.gridy = 2;
        add(pnlButtons, gbc);

        //---------------------- Form ----------------------
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        //Row 1
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        pnlForm.add(lblName, gbc);

        gbc.gridx = 1;
        pnlForm.add(tfName, gbc);

        gbc.gridx = 2;
        pnlForm.add(lblStreet, gbc);

        gbc.gridx = 3;
        pnlForm.add(tfStreet, gbc);

        //Row 2
        gbc.gridy = 1;

        gbc.gridx = 0;
        pnlForm.add(lblHouseNr, gbc);

        gbc.gridx = 1;
        pnlForm.add(tfHouseNr, gbc);

        gbc.gridx = 2;
        pnlForm.add(lblHouseNrAdd, gbc);

        gbc.gridx = 3;
        pnlForm.add(tfHouseNrAdd, gbc);

        //Row 3
        gbc.gridy = 2;
        gbc.gridx = 0;
        pnlForm.add(lblCity, gbc);

        gbc.gridx = 1;
        pnlForm.add(tfCity, gbc);

        gbc.gridx = 2;
        pnlForm.add(lblPostcode, gbc);

        gbc.gridx = 3;
        pnlForm.add(tfPostcode, gbc);

        //Row 4
        gbc.gridy = 3;

        gbc.gridx = 0;
        pnlForm.add(lblProvince, gbc);

        gbc.gridx = 1;
        pnlForm.add(tfProvince, gbc);

        gbc.gridx = 2;
        pnlForm.add(lblPhoneNr, gbc);

        gbc.gridx = 3;
        pnlForm.add(tfPhoneNr, gbc);

        pnlButtons.add(btnSave);
        pnlButtons.add(btnCancel);
    }

    public JTextField getTfName() {
        return tfName;
    }

    public JTextField getTfStreet() {
        return tfStreet;
    }

    public JTextField getTfHouseNr() {
        return tfHouseNr;
    }

    public JTextField getTfHouseNrAdd() {
        return tfHouseNrAdd;
    }

    public JTextField getTfPostcode() {
        return tfPostcode;
    }

    public JTextField getTfCity() {
        return tfCity;
    }

    public JTextField getTfProvince() {
        return tfProvince;
    }

    public JTextField getTfPhoneNr() {
        return tfPhoneNr;
    }
}
