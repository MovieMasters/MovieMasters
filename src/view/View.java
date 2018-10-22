package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class View extends JPanel {

    protected ViewName viewName;

    public ViewName getViewName(){
        return this.viewName;
    }

    /**
     * Creates a string from a LocalDate object and formats it to dd-MM-yyyy
     * @param dateObject LocalDate object to format
     * @param pattern the pattern to use
     * @return String the date as a string
     */
    public String convertDateToString(LocalDate dateObject, String pattern){
        if(pattern.isEmpty()){
            pattern = "dd-MM-yyyy";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String strDate = dateObject.format(formatter);
        return strDate;
    }


    /**
     * Creates an ImageIcon object from the given path and sets its width and height
     * @param path String url to the path
     * @param width int width of the image
     * @param height int height of the image
     * @return ImageIcon the icon to put on the label
     */
    public ImageIcon setImageforLabel(String path, int width, int height){
        ImageIcon imageIcon = null;
        try {
            Path imagePath = Paths.get(path);
            if (Files.exists(imagePath)) {
                BufferedImage img = ImageIO.read(new File(path));
                Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(dimg);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return imageIcon;
    }
}
