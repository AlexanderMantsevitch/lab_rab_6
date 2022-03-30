package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Balls implements Runnable {

    private Field field;
    private Color color;
    private int Radius;
    private int MaxRadius = 50;
    private int MinRadius = 10;

    private int MaxSpeed = 14;


    private double x;
    private double y;

    private int speed;
    private double speedX;
    private double speedY;

    public Balls (Field fieldOther)
    {
        field = fieldOther;
        Radius = (int)(Math.random()* (MaxRadius - MinRadius )) + MinRadius;
        speed = Math.round(7 * MaxSpeed/Radius);
        if ( speed > MaxSpeed) {speed = MaxSpeed; }
        double ange = Math.random() * 2 * Math.PI;
        speedX = speed * Math.cos(ange);
        speedY = speed * Math.sin(ange);
        color = new Color ( (float) Math.random(), (float)Math.random(),(float)Math.random());

        x =  (Math.random() * (field.getSize().getWidth() - 2 * Radius )) ;
        y =  (Math.random() * (field.getSize().getHeight() - 2 * Radius )) ;

        Thread NewThread = new Thread(this);
        NewThread.start();
    }


   public void run()
    {
        try {
        while (true)
        {
            field.canMove(this);
            if ( (x + speedX) <= 0)
            { speedX = -speedX; x = 0; }
            else if (x + speedX >= field.getWidth()-2*Radius)
            {
                speedX = -speedX;
                x= field.getWidth()-2*Radius;
            }
            else if (y + speedY <= 0)
            {
                speedY = -speedY; y = 0;
            }
            else if (y + speedY >= field.getHeight() - 2*Radius)
            {
                speedY = -speedY;
                y= field.getHeight() - 2*Radius;
            }
            else { x+= speedX; y+= speedY; }
            Thread.sleep(MaxSpeed+ 1 - speed);
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
