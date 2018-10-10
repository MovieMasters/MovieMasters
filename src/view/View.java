package view;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class View extends JPanel {

    protected ViewName viewName;

    public ViewName getViewName(){
        return this.viewName;
    }

    public void setTextFieldInvalid(JTextField field) {
        field.setBorder(BorderFactory.createDashedBorder(Color.RED));
    }

    public void setTextFieldValid(JTextField field) {
        field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void resetErrorLabel(JLabel label) {
        label.setText("");
        label.setVisible(false);
    }

    public void showErrorLabel(JLabel label, String text) {
        label.setText(text);
        label.setVisible(true);
    }

    public String convertDateToString(Date dateObject){
        Date date = dateObject;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String strDate = dateFormat.format(date);

        return strDate;
    }
}
