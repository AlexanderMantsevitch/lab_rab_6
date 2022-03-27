package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JPanel {


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


}
