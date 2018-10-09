package view;

import javax.swing.*;
import java.awt.*;

public class MovieView extends View {

    public MovieView(){
        setLayout(new GridBagLayout());
        createView();
    }

    private void createView(){
        JPanel pnlTopLeft = new JPanel();
        JPanel pnlTopRight = new JPanel();
        JPanel pnlBottom = new JPanel();

        pnlTopLeft.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlBottom.setBorder(BorderFactory.createLineBorder(Color.RED));

        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(pnlTopLeft, gbc);

        gbc.gridx = 1;
        gbc.weightx = 2.0;
        add(pnlTopRight, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        gbc.gridwidth = 3;
        add(pnlBottom, gbc);

        pnlTopRight.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;

        JLabel lblTitle = new JLabel("Titel", JLabel.CENTER );
        lblTitle.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblDate = new JLabel("Datum:");
        lblDate.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblDate, gbc);

        gbc.gridx = 1;
        JLabel lblDateValue = new JLabel("09-10-2018");
        lblDateValue.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblDateValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lblPlayTime = new JLabel("Speeltijd:");
        lblPlayTime.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblPlayTime, gbc);

        gbc.gridx = 1;
        JLabel lblPlayTimeValue = new JLabel("128 minuten");
        lblPlayTimeValue.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblPlayTimeValue, gbc);

    }
}
