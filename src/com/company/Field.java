package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Field extends JPanel {

    private boolean paused;

    private ArrayList<Balls> balls = new ArrayList<Balls>(3);
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D canvas = (Graphics2D) g;

        for (Balls ball: balls) {
            ball.paint(canvas);
        }
    }


    private Timer repaintTime = new Timer(4, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           repaint();
        }
    });





    public Field ()
    {
        setSize(getToolkit().getScreenSize());
        setBackground(Color.white);
        repaintTime.start();
        balls.add(new Balls(this));
        balls.add(new Balls(this));
        balls.add(new Balls(this));

    }

    public void addBall ()
    {

        balls.add(new Balls(this));

    }

    public synchronized void pause() {
// Включить режим паузы
        paused = true;
    }
    public synchronized void resume() {
// Включить режим паузы
        paused = false;
    }
    public synchronized void canMove(Balls ball) throws
            InterruptedException {
        if (paused) {

            wait();
        }
    }


}
