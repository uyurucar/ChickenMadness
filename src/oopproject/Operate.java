/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.*;
/**
 *
 * @author uyurucar
 */
public class Operate implements Runnable{
    Thread th;
    String st = "operate";
    public Screen sc = new Screen(" ");
    public Operate(Screen s)
    {
        sc = s;
        th = new Thread(this, st);
    }
    public void Button()
    {
        sc.frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_ENTER)
                {
                sc.pane.remove(sc.enter);
                th.start();
                sc.frame.removeKeyListener(this);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
    }
    
    @Override
    public void run() {
        int i=50;
           long a,b;
           a = System.currentTimeMillis();
           while(true)
           {
               b = System.currentTimeMillis();
               if(b-a > 100)
               {
                   sc.bg2.setBounds(100,i,600,300);
                   i-=10;
                   a=b;
               }
               if(i<= -200)
               {
                   sc.pane.remove(sc.bg2);
                   sc.begin();
                   break;
               }
               
           }
         
    }
    
}
