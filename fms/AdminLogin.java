package fms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener{
    JLabel l1,l2,l3, l4, ll1, ll2;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;
    Choice c1;
    AdminLogin(){
        super("Admin Login - Kurger Bing");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        add(l2);
        
        ll1 = new JLabel("Admin");
        ll1.setBounds(400, 20, 150, 20);
        add(ll1);
        pf2 = new JPasswordField(15);
        pf2.setBounds(400, 60, 150, 20);
        add(pf2);
        
        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 100, 100, 20);
        add(l4);
        
        ll2 = new JLabel("Admin");
        ll2.setBounds(400, 100, 150, 20);
        add(ll2);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        b1.setBounds(330, 160, 100, 20);
        add(b1);
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/back.png"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b2 = new JButton("Back",new ImageIcon(i2));
        b2.setBounds(450, 160, 100, 20);
        add(b2);
       
        
        b1.addActionListener(this);
        b2.addActionListener(this);


        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/loginlogo.jpg"));
        Image i3 = ic3.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(5, 5, 250, 250);
        add(l3);
        
        setLayout(new BorderLayout());
    
     
        setSize(640,300);
        setLocation(600,300);
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{        
                conn c = new conn();
                String b  = pf2.getText();
                String q  = "select * from admin where username = 'admin' and password = '"+b+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    new Admin().setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    pf2.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new AdminLogin().setVisible(true);
    }

    
}