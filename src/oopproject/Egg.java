/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

/**
 *
 * @author uyurucar
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.*;
import java.util.*;

public class Egg implements Runnable{
    ImageIcon[] icon =
    {
        new ImageIcon("egg0.png"),
        new ImageIcon("egg1.png"),
        new ImageIcon("egg2.png"),
        new ImageIcon("egg3.png"),
        new ImageIcon("egg4.png")
    };
    public int x,y,w,h,d;
    Thread th;
    JLayeredPane pane=new JLayeredPane();
    JLabel eggL = new JLabel();
    public int SPEED;
    public Egg(JLayeredPane panel)
    {
        pane = panel;
        eggL.setIcon(icon[2]);
        d=-1;
        x=390; y = 100; w = 23; h = 27;
        eggL.setBounds(x,y,w,h);
        pane.add(eggL, new Integer(12)); // 7
        SPEED = 20;
    }
    public void send(int a)
    {
        th = new Thread(this, "egg");
        d = a;
        //System.out.print(d);
        th.start();
        
    }
    public boolean collisionDetector(Cat cat)
    {
        if(d== -1){return false;}
        if(x > cat.x + cat.w || cat.x > x+w) return false; 
        if(y > cat.y + cat.h || cat.y > y+h) return false;
        th.stop();
        x=390;
        y = 100;
        eggL.setIcon(icon[2]);
        eggL.setBounds(x,y,w,h);
        d = -1;
        return true;
    }
    public void egg0()
    {
        
        eggL.setBounds(x-5,y+8,w,h);
        x -= 5;
        y += 8;
    }
    public void egg1()
    {
        eggL.setBounds(x-3,y+9,w,h);
         x -= 3;
        y += 9;
    }
    public void egg2()
    {
        eggL.setBounds(x,y+10,w,h);
        y += 10;
        
    }
    public void egg3()
    {
        eggL.setBounds(x+3,y+9,w,h);
        x += 3;
        y += 9;
    }
    public void egg4()
    {
        eggL.setBounds(x+5,y+8,w,h);
        x += 5;
        y += 8;
    }

    @Override
    public void run() {
       long a, b;
       a = System.currentTimeMillis();
       while(y<= 580)
       {
           b=System.currentTimeMillis();
           if(b-a > SPEED)
           {
               switch(d)
               {
                   case 0: eggL.setIcon(icon[0]); egg0(); break;
                   case 1: eggL.setIcon(icon[1]); egg1(); break;
                   case 2: eggL.setIcon(icon[2]); egg2(); break;
                   case 3: eggL.setIcon(icon[3]); egg3(); break;
                   case 4: eggL.setIcon(icon[4]); egg4(); break;
               }
               a=b;
           }
       }
       x=390;
       y = 100;
       eggL.setIcon(icon[2]);
       eggL.setBounds(x,y,w,h);
       d = -1;
    }
    
}
