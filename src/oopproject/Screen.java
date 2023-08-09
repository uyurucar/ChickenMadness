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
public class Screen implements Runnable{
    public JFrame frame = new JFrame("Chicken Madness");
    private Thread th1;
    private String name;
    public ImageIcon bg = new ImageIcon("bg.png");
    public ImageIcon header = new ImageIcon("header.png");
    public JLabel bg1 = new JLabel();
    public JLabel bg2 = new JLabel();
    public JLabel enter = new JLabel("PRESS ENTER");
    public JLayeredPane pane = frame.getLayeredPane();
    public Egg[] eggs = new Egg[5];
    public Chicken chicken;
    public Cat[] cats = new Cat[5];
    CatMove cmove;
    public int lastcat = 4;
    Random rand = new Random();
    int RAND_1=400, RAND_2=100;
    Arrow arrow;
    public long TIME1,TIME2=0;
    int SPEED = 100;
    int SCORE = 0;
    int SPEED2 = SCORE;
    boolean IS_OVER = false;
    public JLabel scoreL = new JLabel("SCORE: "+Integer.toString(SCORE) +" LEVEL: " + Integer.toString(SCORE/10+1));
    Font fond = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
    public Screen(String name)
    {
        this.name = name;
    }
    @Override
    public void run() {
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        bg1.setIcon(bg);
        bg2.setIcon(header);
        bg1.setBounds(0,0,800,2400);
        bg2.setBounds(100,50,600,300);
        pane.add(bg1, new Integer(3));
        pane.add(bg2, new Integer(4));
        enter.setBounds(300,275,200,50);
        enter.setFont(fond);
        pane.add(enter, new Integer(5));
        pane.setVisible(true);
        Move move = new Move();
    }
    public void begin()
    {
        chicken = new Chicken(pane);
        chicken.add();
        StartCats();
        arrow = new Arrow(pane,frame);
        Time time = new Time();
        scoreL.setBounds(15, -5, 350, 50);
        scoreL.setFont(fond);
        pane.add(scoreL, new Integer(20));
        for(int i=0; i<5;i++)
        {
            eggs[i] = new Egg(pane);
        }
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(TIME1-TIME2 < 50) return;
                if(IS_OVER) return;
                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    arrow.setL();
                    //TIME2 = TIME1;
                    
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    arrow.setR();
                    //TIME2 = TIME1;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    if(TIME1-TIME2 < 200-(SPEED2))  return;
                    eggSender();
                    TIME2=TIME1;
                }
                
            }
                
            @Override
            public void keyReleased(KeyEvent e) {
                //
            }
        });
        
        
    }
    public void eggSender()
    {
        Thread egging = new Thread(new Runnable() {
            @Override
            public void run() {
                if(eggs[0].d == -1) {eggs[0].send(arrow.number);}
        else if(eggs[1].d == -1) {eggs[1].send(arrow.number);}
        else if(eggs[2].d == -1) {eggs[2].send(arrow.number);}
        else if(eggs[3].d == -1) {eggs[3].send(arrow.number);}
        else if(eggs[4].d == -1) {eggs[4].send(arrow.number);}
        else ;
                
            }
        });
        egging.start();
    }
    
    public class Time implements Runnable{
        Thread thact;
        public Time()
        {
            thact = new Thread(this,"action");
            thact.start();
        }
        @Override
        public void run() {
            while(!IS_OVER) 
            {
            TIME1=System.currentTimeMillis();
            
            }
        }
    }
    public void StartCats()
    {
        
        int _y=600;
        int _x=rand.nextInt(RAND_1)+RAND_2;
        for(int i=0;i<5;i++)
        {
            cats[i] = new Cat(pane,_x,_y);
            cats[i].add();
            _y += 125;
            _x=rand.nextInt(RAND_1)+RAND_2;
            
        }
        cmove = new CatMove();
    }
    public void start()
    {
        if(th1 == null)
        {
            th1 = new Thread(this, name);
            th1.start();
        }
    }
    public class Move implements Runnable{
        Thread th2 = new Thread(this, "move");    
        @Override
        public void run() {
           int i=0,j=800;
           long a,b;
           a = System.currentTimeMillis();
           while(!IS_OVER)
           {
               b = System.currentTimeMillis();
               if(b-a > (SPEED - SPEED2) )
               {
                   bg1.setBounds(0,i,800,2400);
                   //bg1.setAlignmentX(1f);
                   //bg1.setAlignmentY(1f);
                   i-=10;
                   a=b;
               }
               if(i==-1200)
               {
                   i = -10;
               }
               
           }
        }
        public Move()
        {
           th2.start();
        }
    }
    public void gameOver()
    {
        ImageIcon over = new ImageIcon("endgame.png");
        JLabel overL = new JLabel();
        overL.setIcon(over);
        overL.setBounds(200, -150, 451, 144);
        pane.add(overL, new Integer(13));
        int i=-150;
           long a,b;
           a = System.currentTimeMillis();
           while(true)
           {
               b = System.currentTimeMillis();
               if(b-a > 100)
               {
                   overL.setBounds(160,i+10,451,144);
                   i+=10;
                   a=b;
               }
               if(i>= 200)
               {
                   break;
               }
           }
    }
    public class CatMove implements Runnable{
        Thread thcat;
        int speed=5;
        public CatMove()
        {
            thcat = new Thread(this, "thcat");
            thcat.start();
        }
        public void run() 
        {
            long a,b;
            a = System.currentTimeMillis();
            while(!IS_OVER)
            {
               b = System.currentTimeMillis();
               for(int i=0;i<5;i++)
                   {
                       for(int j=0;j<5;j++)
                       {
                           if(eggs[j] != null && eggs[j].collisionDetector(cats[i]))
                           {
                           cats[i].set(rand.nextInt(RAND_1)+RAND_2,cats[lastcat].y + 125);
                           lastcat = i;
                           SCORE += 1;
                           scoreL.setText("SCORE: "+Integer.toString(SCORE) +" LEVEL: " + Integer.toString(SCORE/10+1));
                           }
                       }
                   }
               if(SCORE <=80 ) SPEED2 = SCORE; else { SPEED2 =80;}
               if(b-a > (SPEED - SPEED2) )
                {
                   for(int i=0;i<5;i++)
                   {
                       if(cats[i].y <= 180)
                       {
                           IS_OVER = true;
                           gameOver();
                           break;
                       }
                       cats[i].set(cats[i].x, cats[i].y-speed);
                   }
                   a=b;
                }
            }
        }  
    }
}
