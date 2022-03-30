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
// Вызвать версию метода, унаследованную от предка
        super.paintComponent(g);
        Graphics2D canvas = (Graphics2D) g;
// Последовательно запросить прорисовку от всех мячей из списка
        for (Balls ball: balls) {

        }
    }


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
