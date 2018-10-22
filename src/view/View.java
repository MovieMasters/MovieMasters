package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class View extends JPanel {

    protected ViewName viewName;

    public ViewName getViewName(){
        return this.viewName;
    }


    public String convertDateToString(Date dateObject){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return dateFormat.format(dateObject);
    }


    public ImageIcon setImageforLabel(String path, int width, int height){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(path));
        } catch(IOException e){
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(dimg);
    }
}
