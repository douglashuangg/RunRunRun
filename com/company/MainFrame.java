package com.company;

import static java.awt.Color.LIGHT_GRAY;

public class MainFrame extends javax.swing.JFrame{
    //what is a JFrame

    public MainFrame(){
        GamePanel panel = new GamePanel();
        //review what this does

        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(LIGHT_GRAY);
        panel.setVisible(true);
        this.add(panel);

        addKeyListener(new KeyChecker(panel));
    }


}