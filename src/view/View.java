package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class View extends JPanel {

    protected ViewName viewName;

    public ViewName getViewName(){
        return this.viewName;
    }

    public String convertDateToString(Date dateObject){
        Date date = dateObject;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String strDate = dateFormat.format(date);

        return strDate;
    }
}
