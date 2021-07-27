package fms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PrintOrder extends JFrame implements ActionListener{
    JLabel l1, l2;
    JTextArea t1;
    JButton b1;
    Choice c2;
    JPanel p1;
    String oid;
    PrintOrder(String oid){
        this.oid = oid;
        setSize(500,600);
        setLayout(new BorderLayout());
        setBackground(new Color(228,142,88));
        
        p1 = new JPanel();
        
        l1 = new JLabel("Printing Bill");
        
        l2 = new JLabel(oid);
        
        
        

        
        t1 = new JTextArea(50,15);
        t1.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill\n\n");
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif",Font.ITALIC,18));
        
        b1 = new JButton("Generate Bill");
        
        p1.add(l1);
        p1.add(l2);
        
        add(p1,"North");
        
        add(jsp,"Center");
        add(b1,"South");
        
        b1.addActionListener(this);
        
        setLocation(690, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            conn c = new conn();
   
            String order = this.oid;
            t1.setText("\tKurger Bing Burgers\n\tBill for the order "+ order +" \n\n\n");
            
            ResultSet rs = c.s.executeQuery("select * from orders where oid="+order);
            
            if(rs.next()){
                t1.append("\n    Order Number:   "+rs.getString("orderno"));
                t1.append("\n    Date:           "+rs.getString("date"));
                t1.append("\n    Time:           "+rs.getString("time"));
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n    Customer Name:  "+rs.getString("name"));
                t1.append("\n    Phone Number    "+rs.getString("phone"));
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n    Primary Food:   "+rs.getString("pfood"));
                t1.append("\n    Drink:          "+rs.getString("drink"));
                t1.append("\n    Secondary Food: "+rs.getString("sfood"));
                t1.append("\n    Calories:       "+rs.getString("cal"));
                t1.append("\n    Total Price:    "+rs.getString("tprice"));
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new PrintOrder("").setVisible(true);
    }
}