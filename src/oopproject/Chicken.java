/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;
import javax.swing.*;
/**
 *
 * @author uyurucar
 */
public class Chicken {
    
    public int x,y,w,h;
    public ImageIcon chickimg = new ImageIcon("chicken.png");
    public JLayeredPane pane;
    public JLabel chickLabel = new JLabel();
    public Chicken(JLayeredPane panel)
    {
        this.pane = panel;
        x = 350;
        y = -200;
        w = 100;
        h = 200;
    }
    public void add()
    {
        chickLabel.setIcon(chickimg);
        chickLabel.setVisible(true);
        chickLabel.setBounds(x, y, w, h);
        pane.add(chickLabel, new Integer(8));
        chickLabel.setVisible(true);
        long a,b;
        a = System.currentTimeMillis();
        while(y < 30)
        {
            b = System.currentTimeMillis();
               if(b-a > 100)
               {
                   chickLabel.setBounds(x,y,w,h);
                   y+=10;
                   a=b;
               }
        }
    }
}
