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
import java.util.*;
/**
 *
 * @author uyurucar
 */
public class Arrow{
    public JLayeredPane pane = new JLayeredPane();
    Thread th;
    ImageIcon[] icon = {
    new ImageIcon("arrow0.png"),
    new ImageIcon("arrow1.png"),
    new ImageIcon("arrow2.png"),
    new ImageIcon("arrow3.png"),
    new ImageIcon("arrow4.png")
    };
    public int number;
    public JLabel arrowL = new JLabel();
    public JFrame frame = new JFrame();
    public Arrow(JLayeredPane panel,JFrame fram)
    {
        pane = panel;
        frame = fram;
        arrowL.setIcon(icon[2]);
        number=2;
        arrowL.setBounds(335,100,138,126);
        pane.add(arrowL, new Integer(9));
        
    }
    public void setL()
    {
        if(number==0) return;
        arrowL.setIcon(icon[number-1]);
        number -= 1;
    }
    public void setR()
    {
        if(number==4) return;
        arrowL.setIcon(icon[number+1]);
        number += 1;
    }
    
}

