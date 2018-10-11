package view;

import javax.swing.*;
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
