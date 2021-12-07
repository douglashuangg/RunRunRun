package p1;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics2D;

public class GamePanel extends javax.swing.JPanel implements ActionListener{

    Player player;

    Timer gameTimer; 

    public GamePanel(){
         
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask(){

            @Override
            public void run() {
                
                
            }
            
        }, 0, 17); //gets 60 frames per second 1000/60
    }

    public void paint(Graphics g){

        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
