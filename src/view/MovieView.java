package view;

import javax.swing.*;

public class MovieView extends View {
    private JPanel pnlContent;
    private JLabel lblTitle;

    public MovieView(){
        createView();
    }

    private void createView(){
        pnlContent = new JPanel();
        lblTitle = new JLabel();

        pnlContent.add(lblTitle);
        add(pnlContent);
    }

    public void setTitle(String text){
        lblTitle.setText(text);
    }
}
