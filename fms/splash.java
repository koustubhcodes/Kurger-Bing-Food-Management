package fms;

import java.awt.*;
import javax.swing.*;

public class splash {
    public static void main(String[] args)
    {
        frame1 f1 = new frame1();
        f1.setVisible(true);
        f1.setLocation(500,250);
        f1.setSize(800, 600);
    }
}
class frame1 extends JFrame implements Runnable{
    Thread t1;
    frame1(){
        super("Loading Kuger Bing...");
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/splashscreen4.gif"));
        Image i1 = c1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l1 = new JLabel(i2);
        add(l1);
        JLabel l2 = new JLabel("Loading...");
        l2.setBounds(15, 15, 400, 10);
        add(l2);
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            Login l = new Login();
            l.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
