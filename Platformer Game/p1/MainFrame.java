package p1;

import java.awt.Color;

public class MainFrame extends javax.swing.JFrame{ 
    //what is a JFrame
    
    public MainFrame(){
        GamePanel panel = new GamePanel(); 
        //review what this does

        panel.setLocation(0,0);
        panel.setSize(this.getSize());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setVisible(true);
        this.add(panel);
    }
    

}
