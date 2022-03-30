package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private Field field = new Field ();

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


        getContentPane().add(field, BorderLayout.CENTER);

    }

    public static void main(String[] args) {

        Main frame = new Main ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
