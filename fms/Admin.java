package fms;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener{
    JButton jb1,jb2,jb3,fb1,fb2,fb3;
    Admin(){
        super("Admin 1");
        
	JPanel p1 = new JPanel();
	p1.setBackground(new Color(63,100,126));
	p1.setBounds(0, 0, 960, 50);
	p1.setLayout(new BorderLayout());
        JLabel l1 = new JLabel("   Admin");
        l1.setFont(new Font("Arial", Font.BOLD, 36));
        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.LEFT);
                                		
        
        
        
        JPanel p2 = new JPanel();
	p2.setBackground(new Color(104,143,173));
        p2.setBounds(0, 50, 240, 650);
	p2.setLayout(new FlowLayout());
        
        ImageIcon jbi1 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/add.png"));
        Image i11 = jbi1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon jbii1 = new ImageIcon(i11);
        JButton jb1 = new JButton();
        jb1.setText("Add Employee");
        jb1.setFont(new Font("Arial", Font.BOLD, 16));
        jb1.setIcon(jbii1);
        jb1.setPreferredSize(new Dimension(220, 60));
        jb1.setHorizontalTextPosition(JButton.CENTER);
        jb1.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(jb1);
        jb1.addActionListener(this);
        jb1.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new AddEmp().setVisible(true);             
              }
        });
        
        ImageIcon jbi2 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/edetails.png"));
        Image i22 = jbi2.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon jbii2 = new ImageIcon(i22);
        JButton jb2 = new JButton();
        jb2.setText("View Employees");
        jb2.setFont(new Font("Arial", Font.BOLD, 16));
        jb2.setIcon(jbii2);
        jb2.setPreferredSize(new Dimension(220, 60));
        jb2.setHorizontalTextPosition(JButton.CENTER);
        jb2.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(jb2);
        jb2.addActionListener(this);
        jb2.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new ViewEmp().setVisible(true);             
              }
        });
        
        ImageIcon jbi3 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/search.png"));
        Image i33 = jbi3.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon jbii3 = new ImageIcon(i33);
        JButton jb3 = new JButton();
        jb3.setText("Search Employee");
        jb3.setFont(new Font("Arial", Font.BOLD, 16));
        jb3.setIcon(jbii3);
        jb3.setPreferredSize(new Dimension(220, 60));
        jb3.setHorizontalTextPosition(JButton.CENTER);
        jb3.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(jb3);
        jb3.addActionListener(this);
        jb3.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new SearchEmp().setVisible(true);             
              }
        });
        
        ImageIcon fbi1 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/foodadd.png"));
        Image fi11 = fbi1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon fbii1 = new ImageIcon(fi11);
        JButton fb1 = new JButton();
        fb1.setText("Add Food");
        fb1.setFont(new Font("Arial", Font.BOLD, 16));
        fb1.setIcon(fbii1);
        fb1.setPreferredSize(new Dimension(220, 60));
        fb1.setHorizontalTextPosition(JButton.CENTER);
        fb1.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(fb1);
        fb1.addActionListener(this);
        fb1.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new AddFood().setVisible(true);             
              }
        });
        
        ImageIcon fbi2 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/view.png"));
        Image fi22 = fbi2.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon fbii2 = new ImageIcon(fi22);
        JButton fb2 = new JButton();
        fb2.setText("View Food Menu");
        fb2.setFont(new Font("Arial", Font.BOLD, 16));
        fb2.setIcon(fbii2);
        fb2.setPreferredSize(new Dimension(220, 60));
        fb2.setHorizontalTextPosition(JButton.CENTER);
        fb2.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(fb2);
        fb2.addActionListener(this);
        fb2.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new FoodMenu().setVisible(true);             
              }
        });
        
        ImageIcon fbi3 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/search.png"));
        Image fi33 = fbi3.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ImageIcon fbii3 = new ImageIcon(fi33);
        JButton fb3 = new JButton();
        fb3.setText("Search Food Menu");
        fb3.setFont(new Font("Arial", Font.BOLD, 16));
        fb3.setIcon(fbii3);
        fb3.setPreferredSize(new Dimension(220, 60));
        fb3.setHorizontalTextPosition(JButton.CENTER);
        fb3.setVerticalTextPosition(JButton.BOTTOM);
        p2.add(fb3);
        fb3.addActionListener(this);
        fb3.addActionListener(
            new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new SearchFood().setVisible(true);             
              }
        });
        
        ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/loginlogo.jpg"));
        Image z51 = z5.getImage().getScaledInstance(220, 220,Image.SCALE_DEFAULT);
        ImageIcon z511 = new ImageIcon(z51);
        JLabel lb1 = new JLabel();
        lb1.setIcon(z511);
        p2.add(lb1);

        
        
        

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/admin.png"));
        Image i1 = c1.getImage().getScaledInstance(720, 650, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i1);
	JLabel label5 = new JLabel();
        label5.setIcon(image);
	label5.setVerticalAlignment(JLabel.TOP);
	label5.setHorizontalAlignment(JLabel.LEFT);
	JPanel p3 = new JPanel();
        p3.setBackground(new Color(63,100,126));
	p3.setBounds(240, 50, 720, 650);
	p3.setLayout(new BorderLayout());
		
	JFrame frame = new JFrame("Admin - Kurger Bing");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	frame.setSize(960,720);
        frame.setLocation(450, 150);
	frame.setVisible(true);	
        
        p1.add(l1);
	p3.add(label5);
	frame.add(p1);
	frame.add(p2);
        frame.add(p3);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == jb1){
            new AddEmp().setVisible(true);
        }
        else if(ae.getSource() == jb2){
            new ViewEmp().setVisible(true);
        }
        else if(ae.getSource() == jb3){
            new SearchEmp().setVisible(true);
        }
        else if(ae.getSource() == fb1){
            new AddFood().setVisible(true);
        }
        else if(ae.getSource() == fb2){
            new FoodMenu().setVisible(true);
        }
        else if(ae.getSource() == fb3){
            new SearchFood().setVisible(true);
        }
    }
        
    public static void main(String[] args){
        new Admin().setVisible(true);
    }
    
}