//GamePanel controls the entire game
package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GamePanel extends javax.swing.JPanel implements ActionListener {

    Player player;
    ArrayList<Wall> walls = new ArrayList<>();

    int cameraX;
    int offset;

    Timer gameTimer;


    public GamePanel(){

        player = new Player(400, 300, this); // starts upper left hand corner

        reset();

        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask(){

            @Override
            public void run() {
                if(walls.get(walls.size() - 1).x < 800){

                    offset += 700;
                    makeWalls(offset);
                }

                player.set();
                for(Wall wall: walls) wall.set(cameraX);

                //removes walls when off screen
                for(int i=0; i<walls.size(); i++){
                    if(walls.get(i).x < -800) walls.remove(i);
                }


                repaint();

            }

        }, 0, 17); //gets 60 frames per second 1000/60
    }

    //each time we die, this is called
    public void reset(){
        //resets all the player variables
        player.x = 200;
        player.y = 150;
        cameraX = 150;
        player.xspeed = 0;
        player.yspeed = 0;
        walls.clear();
        offset = -150;
        makeWalls(offset);
    }

    public void makeWalls(int offset){
        int s = 50;
        Random rand = new Random();
        int index = rand.nextInt(4);
        System.out.println(index);

        if(index == 0){
            for(int i=0; i<14; i++) walls.add(new Wall(Color.CYAN, offset + i*50, 600, s, s));

        }

        else if(index == 1){
            for(int i=0; i<6; i++) walls.add(new Wall(Color.PINK, offset + i*50, 450, s ,s));
            for(int i=0; i<14; i++) walls.add(new Wall(Color.PINK,offset + i*50, 600, s, s));
        }

        else if(index == 2){
            for(int i=0; i<5; i++) walls.add(new Wall(Color.orange,offset + i*50, 600, s ,s));
            for(int i=8; i<14; i++) walls.add(new Wall(Color.orange,offset + i*50, 600, s, s));
        }

        else if(index == 3){
            for(int i=0; i<3; i++) walls.add(new Wall(Color.GREEN,offset + i*50, 600, s ,s));
            for(int i=1; i<3; i++) walls.add(new Wall(Color.GREEN,offset + i*50, 550, s ,s));
            for(int i=2; i<3; i++) walls.add(new Wall(Color.GREEN,offset + i*50, 500, s ,s));
            for(int i=7; i<14; i++) walls.add(new Wall(Color.GREEN,offset + i*50, 600, s ,s));
            for(int i=7; i<10; i++) walls.add(new Wall(Color.GREEN,offset + i*50, 550, s, s));
            for(int i=7; i<9; i++) walls.add(new Wall(Color.GREEN,offset + i*50, 500, s ,s));

        }
//        for(int i = 50; i<650; i+=50){
//            walls.add(new Wall(i, 600, 50, 50));
//        }
//        walls.add(new Wall(50, 550, 50, 50 ));
//        walls.add(new Wall(50, 500, 50, 50 ));
//        walls.add(new Wall(50, 450, 50, 50 ));
//        walls.add(new Wall(250, 550, 50, 50 ));
//        walls.add(new Wall(600, 550, 50, 50 ));
    }

    public void paint(Graphics g){

        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);
        for(Wall wall: walls) wall.draw(gtd);


    }


    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') player.keyLeft = true;
        if(e.getKeyChar() == 'w') player.keyUp = true;
        if(e.getKeyChar() == 's') player.keyDown = true;
        if(e.getKeyChar() == 'd') player.keyRight = true;
        if(e.getKeyChar() == 'r') reset();
    }


    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a') player.keyLeft = false;
        if(e.getKeyChar() == 'w') player.keyUp = false;
        if(e.getKeyChar() == 's') player.keyDown = false;
        if(e.getKeyChar() == 'd') player.keyRight = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}