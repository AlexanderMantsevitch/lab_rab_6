package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JPanel {

    private boolean paused;
    private Timer repaintTime = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           repaint();
        }
    });
    public Field ()
    {
        setBackground(Color.white);
        repaintTime.start();

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
