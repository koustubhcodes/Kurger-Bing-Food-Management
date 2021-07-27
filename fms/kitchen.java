package fms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class kitchen extends JFrame implements ActionListener{
    kitchen(String nname){
        super("kitchen");
        
	JPanel p1 = new JPanel();
	p1.setBackground(new Color(238,64,23));
	p1.setBounds(0, 0, 960, 50);
	p1.setLayout(new BorderLayout());
        JLabel l1 = new JLabel("  Kitchen");
        l1.setFont(new Font("Arial", Font.BOLD, 36));
        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.LEFT);
                                       		
                   
        JPanel p2 = new JPanel();
	p2.setBackground(new Color(243,119,54));
        p2.setBounds(0, 50, 240, 650);
	p2.setLayout(new FlowLayout());
        
        
        ImageIcon fbi1 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/foodadd.png"));
        Image fi11 = fbi1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon fbii1 = new ImageIcon(fi11);
        JButton fb1 = new JButton();
        fb1.setText("View New Orders");
        fb1.setFont(new Font("Arial", Font.BOLD, 16));
        fb1.setIcon(fbii1);
        fb1.setPreferredSize(new Dimension(220, 60));
        fb1.setHorizontalTextPosition(JButton.CENTER);
        fb1.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(fb1);
        fb1.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new ViewNOrders().setVisible(true);             
              }
        });
        
        
        ImageIcon fbi2 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/view.png"));
        Image fi22 = fbi2.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon fbii2 = new ImageIcon(fi22);
        JButton fb2 = new JButton();
        fb2.setText("View All Orders");
        fb2.setFont(new Font("Arial", Font.BOLD, 16));
        fb2.setIcon(fbii2);
        fb2.setPreferredSize(new Dimension(220, 60));
        fb2.setHorizontalTextPosition(JButton.CENTER);
        fb2.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(fb2);
        fb2.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new ViewAOrders().setVisible(true);             
              }
        });
        
        ImageIcon fbi3 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/search.png"));
        Image fi33 = fbi3.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon fbii3 = new ImageIcon(fi33);
        JButton fb3 = new JButton();
        fb3.setText("Update Served Food");
        fb3.setFont(new Font("Arial", Font.BOLD, 16));
        fb3.setIcon(fbii3);
        fb3.setPreferredSize(new Dimension(220, 60));
        fb3.setHorizontalTextPosition(JButton.CENTER);
        fb3.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(fb3);
        fb3.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new SearchOrdersK().setVisible(true);
              }
        });
        
        
        JLabel l2 = new JLabel(nname);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.WHITE);
        l2.setHorizontalAlignment(JLabel.LEFT);
        
        
        
        
        ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/loginlogo.jpg"));
        Image z51 = z5.getImage().getScaledInstance(220, 220,Image.SCALE_DEFAULT);
        ImageIcon z511 = new ImageIcon(z51);
        JLabel lb1 = new JLabel();
        lb1.setIcon(z511);
        p2.add(lb1);
        
        

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/kitchen1.jpg"));
        Image i1 = c1.getImage().getScaledInstance(720, 650, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i1);
	JLabel label5 = new JLabel();
        label5.setIcon(image);	
	JPanel p3 = new JPanel();
        p3.setBackground(Color.LIGHT_GRAY);
	p3.setBounds(240, 50, 720, 650);
	p3.setLayout(new FlowLayout());
		
	JFrame frame = new JFrame("Kitchen - Kurger Bing");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	frame.setSize(960,720);
        frame.setLocation(450, 150);
	frame.setVisible(true);	
        
        p1.add(l1);
        p2.add(l2);
        //p2.add(l3);
	p3.add(label5);
	frame.add(p1);
	frame.add(p2);
        frame.add(p3);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();        
    }
    
    
    public static void main(String[] args){
        new kitchen("KStaff").setVisible(true);
    }
    
}