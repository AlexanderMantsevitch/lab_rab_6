package com.company;

import java.awt.*;

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

}
