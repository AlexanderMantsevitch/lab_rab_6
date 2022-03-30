package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Balls implements Runnable {

    private Field field;
    private Color color;
    private double Radius;

    private double x;
    private double y;

    private double speed;
    private double speedX;
    private double speedY;
   public void run()
    {
        try {
        while (true)
        {
            field.canMove(this);



        }


        }
         catch (InterruptedException ex) {


    }
    }
    public void paint (Graphics2D field)
    {
        field.setColor(color);
        field.setPaint(color);
        Ellipse2D.Double ball = new Ellipse2D.Double(x, y, 2*Radius, 2*Radius);
        field.draw (ball);
        field.fill (ball);
    }

}
