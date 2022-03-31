package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class block implements KeyListener {


    private boolean isUp;
    private boolean isDown;
    private int x1;
    private  int x2;
    private int y1;
    private int y2;
    private Field field;

    //клавиша нажата, но не отпущена
    public void keyPressed(KeyEvent event){

        if (event.getKeyCode()==KeyEvent.VK_UP) isUp = true;
        if (event.getKeyCode()==KeyEvent.VK_DOWN) isDown = true;

    };

    //клавиша отпущена
    public void keyReleased(KeyEvent event){

        if (event.getKeyCode()==KeyEvent.VK_UP) isUp = false;
        if (event.getKeyCode()==KeyEvent.VK_DOWN) isDown = false;

    };

    //клавиша нажата и отпущена
    public void keyTyped(KeyEvent event){



    };

    public void animation ()
    {

        if (isUp) { if (y1 - 3 > 0) {
            y1 -= 3; y2 -= 3;
        }
        }
        if (isDown) {
            if (y2 + 3 < field.getHeight()) {
                y1 += 3; y2 += 3;
            }
        }
    }





}

private class MoveThread extends Thread{
    block runKeyboard;

    public MoveThread(RunKeyboard runKeyboard) {
        super("MoveThread");
        this.runKeyboard = runKeyboard;
    }

    public void run(){
        while(true) {
            runKeyboard.animate();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

}
