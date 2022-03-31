package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private Field field = new Field ();
    private JMenuItem pauseMenuItem;
    private JMenuItem resumeMenuItem;

    Main()
    {
        super ("Лабораторная работа №6");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();

        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);
        setExtendedState(MAXIMIZED_BOTH);
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        JMenu balls = new JMenu ("Мячи");
        JMenu control = new JMenu("Управление");
        menu.add (balls); menu.add (control);

        Action addBalls = new AbstractAction("Добавить мяч") {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.addBall();
            }
        };
        balls.add(addBalls);
        Action paus = new AbstractAction("Выключить движение мячи") {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.pause();
                pauseMenuItem.setEnabled(false);
                resumeMenuItem.setEnabled(true);

            }
        };
        Action resume = new AbstractAction("Включить движение мячей") {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.resume();
                pauseMenuItem.setEnabled(true);
                resumeMenuItem.setEnabled(false);

            }
        };
        pauseMenuItem = control.add (paus);
        resumeMenuItem = control.add(resume);
        pauseMenuItem.setEnabled(true);
        resumeMenuItem.setEnabled(false);
        getContentPane().add(field, BorderLayout.CENTER);

    }

    public static void main(String[] args) {

        Main frame = new Main ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
