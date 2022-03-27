package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;

    Main()
    {
        super ("Лабораторная работа №6");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();

        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);

        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        JMenu balls = new JMenu ("Мячи");
        JMenu control = new JMenu("Управление");
        menu.add (balls); menu.add (control);



    }

    public static void main(String[] args) {

        Main frame = new Main ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
