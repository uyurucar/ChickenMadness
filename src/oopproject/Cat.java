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
public class Cat implements Runnable{
    public ImageIcon catimg1 = new ImageIcon("cat1.png");
    public ImageIcon catimg2 = new ImageIcon("cat2.png");
    Thread th;
    public JLayeredPane pane;
    public JLabel catLabel = new JLabel();
    int x,y,w,h;
    public Cat(JLayeredPane panel,int _x,int _y)
    {
        pane = panel;
        x= _x;
        y= _y;
        w=214;
        h=120;
    }
    public void add()
    {
        catLabel.setIcon(catimg1);
        catLabel.setVisible(true);
        catLabel.setBounds(x, y, w, h);
        pane.add(catLabel, new Integer(7));
        catLabel.setVisible(true);
        th = new Thread(this, "th");
        th.start();
    }
    public void set(int _x, int _y)
    {
        x = _x; y=_y;
        catLabel.setBounds(x, y, w, h);
    }
    @Override
    public void run() {
        long a,b;
        int i=1;
        a = System.currentTimeMillis();
        while(true)
        {
            b = System.currentTimeMillis();
            if(i>=5001) i=1;
               if(b-a > 150)
               {
                   if(i%2==0) {catLabel.setIcon(catimg1); i++;}
                   else if(i%2!=0){catLabel.setIcon(catimg2); i++;} 
                   a=b;
               }
        }
    }
}
